package methodref;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefEx2 {

    public static void main(String[] args) {

        Function<String, String> staticM1 = (n) -> Person.greetingWithName(n);
        System.out.println("staticM1 = " + staticM1.apply("1"));
        Function<String, String> staticM2 = Person::greetingWithName;
        System.out.println("staticM2 = " + staticM2.apply("1"));

        Person person = new Person("Kim");
        Function<Integer, String> instanceM2 = (n) -> person.introduceWithNumber(n);
        System.out.println("instanceM2 = " + instanceM2.apply(1));
        Function<Integer, String> instanceM1 = person::introduceWithNumber;
        System.out.println("instanceM1 = " + instanceM1.apply(1));

        Function<String, Person> newPerson1 = (s) -> new Person(s);
        System.out.println("newPerson1 = " + newPerson1.apply("3").getName());
        Function<String, Person> newPerson2 = Person::new;
        System.out.println("newPerson2 = " + newPerson2.apply("3").getName());
    }
}
