package streams.dual;

import java.util.Arrays;
import java.util.*;

class Person{

    private String firstName;
    private String lastName;

    Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{" + firstName + ", " + lastName +
                "}";
    }
}

public class DualStreamer {



    public static void main(String[] args) {
List<Person> list = Arrays.asList(
        new Person("Tom", "Riddle"),
        new Person("Tom", "Hanks"),
        new Person("Yusuf", "Pathan"));

        list.stream().sorted (
                Comparator.comparing (Person::getFirstName)
                        .reversed() .thenComparing (Person::getLastName))
                .forEach (System.out::println);
    }
}
