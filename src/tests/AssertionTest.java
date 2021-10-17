package tests;

class AssertionTest {
    public static void main(String args[]) {
        int value = 15;
        try {
            assert value >= 20 : " Underweight";
        } catch (AssertionError ex) {
            System.out.println("value is underweight");
        } finally {
            System.out.println("value is " + value);
        }
    }
}