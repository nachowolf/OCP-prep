package mess.lombok;

import mess.lombok.Person;
import java.util.Arrays;

public class CapturedDataPerson {
    public static void main(String[] args) {
    Person person = Person.builder().age(50).build();
        System.out.println(person.getAge());
    }

}
