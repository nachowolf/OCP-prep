package streams.streamer;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Stream;

class Person{
    public enum Sex{
        Male, Female
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.name, this.birthday);
    }
}

public class Streamer {

    static Person genr8Person(){
        Faker faker = new Faker();
        Random random = new Random();
        return new Person(faker.name().firstName(), faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), random.nextInt(1) == 1 ? Person.Sex.Female : Person.Sex.Male, faker.name().lastName());
    }

    public static void main(String[] args) {

        List<Person> roster = new ArrayList<>();
        int count = 0;
        int parameter = new Random().nextInt(20) + 5;
        while(count != parameter){
            roster.add(genr8Person());
            count++;
        }
        roster.add(new Person("John", LocalDate.of(1985, 4, 12), Person.Sex.Male, "John@home.com" ));
        roster.add(new Person("John", LocalDate.of(1984, 4, 12), Person.Sex.Male, "John@home.com" ));

     Person[] rosterArray = roster.toArray(new Person[roster.size()]);

        class PersonAgeComparator implements Comparator<Person>{

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        }

        Arrays.sort(rosterArray, new PersonAgeComparator());
        Arrays.sort(rosterArray, (a,b) -> a.getBirthday().compareTo(b.getBirthday()));
        Arrays.sort(rosterArray, Comparator.comparing(Person::getBirthday));

        Arrays.sort(rosterArray, Comparator.comparing(Person::getName).reversed().thenComparing(Person::getBirthday));
        System.out.println(rosterArray.length);
        Stream.of(rosterArray).forEach(System.out::println);
    }
}
