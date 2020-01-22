package LogicAndDataTypes;
public class Person {
    public String[] characteristics;
    public String name;

    Person(String name, String... args) {
        this.name = name;
        characteristics = new String[args.length];
        for(int i = 0; i < characteristics.length; i++) {
            characteristics[i] = args[i];
        }
    }

    public String toString() {
        String s = name + " is ";
        for(int i = 0; i < characteristics.length; i++) {
            if(characteristics.length == 2) {
                return "Eric is " + characteristics[0] + " and " + characteristics[1] + ".";
            }
            if(i == characteristics.length - 1) {
                s += "and " + characteristics[i] + ".";
            }
            else {
                s += characteristics[i] + ", ";
            }
        }
        return s;
    }
    public static void main(String[] args) {
        Person eric = new Person("Eric", "cool", "lazy", "awesome", "funny", "smart");
        System.out.println(eric);
    }
}
