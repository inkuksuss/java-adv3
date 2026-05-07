package methodref;

import java.util.function.Supplier;

public class MethodRefEx1 {

    public static void main(String[] args) {

        Supplier<String> staticM1 = () -> Person.greeting();
        System.out.println("staticM1 = " + staticM1.get());
        Supplier<String> staticM2 = Person::greeting;
        System.out.println("staticM2 = " + staticM2.get());

        Person person = new Person();
        Supplier<String> instanceM1 = person::introduce;
        System.out.println("instanceM1 = " + instanceM1.get());
        Supplier<String> instanceM2 = () -> person.introduce();
        System.out.println("instanceM2 = " + instanceM2.get());

        Supplier<Person> newPerson1 = () -> new Person();
        System.out.println("newPerson1 = " + newPerson1.get());
        Supplier<Person> newPerson2 = Person::new;
        System.out.println("newPerson2 = " + newPerson2.get());



    }
}
