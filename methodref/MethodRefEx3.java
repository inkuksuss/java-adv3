package methodref;

import java.util.function.Function;

public class MethodRefEx3 {

    public static void main(String[] args) {

        Person person1 = new Person("1");
        Person person2 = new Person("2");
        Person person3 = new Person("3");

        Function<Person, String> introduce = Person::introduce;
        System.out.println("introduce = " + introduce.apply(person1));
    }
}
