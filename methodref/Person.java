package methodref;

public class Person {

    private String name;

    public Person() {
        this.name = "Unknown";
    }

    public Person(String name) {
        this.name = name;
    }

    public static String greeting() {
        return "Hello";
    }

    public static String greetingWithName(String name) {
        return greeting() + " " + name;
    }

    public String introduce() {
        return "I am " + name;
    }

    public String introduceWithNumber(int number) {
        return introduce() + ", number is " + number;
    }

    public String getName() {
        return name;
    }
}
