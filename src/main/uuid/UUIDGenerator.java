package main.uuid;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public final class UUIDGenerator {

    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    private UUIDGenerator() {
    }

    public static void main(String[] args) {
        // Generate V1 UUID
        System.out.println("UUID V1: " + UUIDGenerator.generateType1UUID());

        // Generate V4 UUID
        System.out.println("UUID V4: " + UUIDGenerator.generateType4UUID());

        // Generate V5 UUID
        System.out.println("UUID V5: " + UUIDGenerator.generateType5UUID("01234567-89ab-cdef-fedc-ba9876543210", "Hello World!"));
    }

    /**
     * Type 1 UUID Generation
     */
    public static UUID generateType1UUID() {

        final long most64SigBits = get64MostSignificantBitsForVersion1();
        final long least64SigBits = get64LeastSignificantBitsForVersion1();

        return new UUID(most64SigBits, least64SigBits);
    }

    private static long get64LeastSignificantBitsForVersion1() {
        final long random63BitLong = new Random().nextLong() & 0x3FFFFFFFFFFFFFFFL;
        final long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong + variant3BitFlag;
    }

    private static long get64MostSignificantBitsForVersion1() {
        final LocalDateTime start = LocalDateTime.of(1582, 10, 15, 0, 0, 0);
        final Duration duration = Duration.between(start, LocalDateTime.now());
        final long seconds = duration.getSeconds();
        final long nanos = duration.getNano();
        final long timeForUuidIn100Nanos = seconds * 10000000 + nanos * 100;
        final long least12SignificantBitOfTime = (timeForUuidIn100Nanos & 0x000000000000FFFFL) >> 4;
        final long version = 1 << 12;
        return (timeForUuidIn100Nanos & 0xFFFFFFFFFFFF0000L) + version + least12SignificantBitOfTime;
    }

    /**
     * Type 3 UUID Generation
     */
    public static UUID generateType3UUID(String namespace, String name) {

        final byte[] nameSpaceBytes = bytesFromUUID(namespace);
        final byte[] nameBytes = name.getBytes(StandardCharsets.UTF_8);
        final byte[] result = joinBytes(nameSpaceBytes, nameBytes);

        return UUID.nameUUIDFromBytes(result);
    }

    /**
     * Type 4 UUID Generation
     */
    public static UUID generateType4UUID() {
        return UUID.randomUUID();
    }

    /**
     * Type 5 UUID Generation
     */
    public static UUID generateType5UUID(String namespace, String name) {
        final byte[] nameSpaceBytes = bytesFromUUID(namespace);
        final byte[] nameBytes = name.getBytes(StandardCharsets.UTF_8);
        final byte[] result = joinBytes(nameSpaceBytes, nameBytes);

        return type5UUIDFromBytes(result);
    }

    public static UUID type5UUIDFromBytes(byte[] name) {
        final MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException exception) {
            throw new InternalError("SHA-1 not supported", exception);
        }
        final byte[] bytes = Arrays.copyOfRange(md.digest(name), 0, 16);
        bytes[6] &= 0x0f; /* clear version */
        bytes[6] |= 0x50; /* set to version 5 */
        bytes[8] &= 0x3f; /* clear variant */
        bytes[8] |= 0x80; /* set to IETF variant */
        return constructType5UUID(bytes);
    }

    private static UUID constructType5UUID(byte[] data) {
        long msb = 0;
        long lsb = 0;
        assert data.length == 16 : "data must be 16 bytes in length";

        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | (data[i] & 0xff);
        }

        for (int i = 8; i < 16; i++) {
            lsb = (lsb << 8) | (data[i] & 0xff);
        }
        return new UUID(msb, lsb);
    }

    /**
     * Unique Keys Generation Using Message Digest and Type 4 UUID
     * 
     * @throws NoSuchAlgorithmException
     */
    public static String generateUniqueKeysWithUUIDAndMessageDigest() throws NoSuchAlgorithmException {
        final MessageDigest salt = MessageDigest.getInstance("SHA-256");
        salt.update(UUID.randomUUID()
                .toString()
                .getBytes(StandardCharsets.UTF_8));
        return bytesToHex(salt.digest());
    }

    private static String bytesToHex(byte[] bytes) {
        final char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            final int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static byte[] bytesFromUUID(String uuidHexString) {
        final String normalizedUUIDHexString = uuidHexString.replace("-", "");

        assert normalizedUUIDHexString.length() == 32;

        final byte[] bytes = new byte[16];
        for (int i = 0; i < 16; i++) {
            final byte b = hexToByte(normalizedUUIDHexString.substring(i * 2, i * 2 + 2));
            bytes[i] = b;
        }
        return bytes;
    }

    public static byte hexToByte(String hexString) {
        final int firstDigit = Character.digit(hexString.charAt(0), 16);
        final int secondDigit = Character.digit(hexString.charAt(1), 16);
        return (byte) ((firstDigit << 4) + secondDigit);
    }

    public static byte[] joinBytes(byte[] byteArray1, byte[] byteArray2) {
        final int finalLength = byteArray1.length + byteArray2.length;
        final byte[] result = new byte[finalLength];

        System.arraycopy(byteArray1, 0, result, 0, byteArray1.length);
        System.arraycopy(byteArray2, 0, result, byteArray1.length, byteArray2.length);
        return result;
    }

    public static UUID generateType5UUID(String name) {
        try {
            final byte[] bytes = name.getBytes(StandardCharsets.UTF_8);
            final MessageDigest md = MessageDigest.getInstance("SHA-1");

            final byte[] hash = md.digest(bytes);

            long msb = getLeastAndMostSignificantBitsVersion5(hash, 0);
            long lsb = getLeastAndMostSignificantBitsVersion5(hash, 8);
            // Set the version field
            msb &= ~(0xfL << 12);
            msb |= 5L << 12;
            // Set the variant field to 2
            lsb &= ~(0x3L << 62);
            lsb |= 2L << 62;
            return new UUID(msb, lsb);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private static long getLeastAndMostSignificantBitsVersion5(final byte[] src, final int offset) {
        long ans = 0;
        for (int i = offset + 7; i >= offset; i -= 1) {
            ans <<= 8;
            ans |= src[i] & 0xffL;
        }
        return ans;
    }
}