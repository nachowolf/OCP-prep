package streams.aboutStreams;

import com.github.javafaker.Demographic;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class StreamCollectors {
// ####################| Predicate Filters |####################
    public static Predicate<Person> isMale(){
        return person -> person.getSex().equalsIgnoreCase("male");
    }
    public static Predicate<Person> isFemale(){
        return person -> person.getSex().equalsIgnoreCase("female");
    }
    public static Predicate<Person> isOfLegalAge(){
        return person -> person.getAge() >= 18;
    }
    public static Predicate<Person> isBelowLegalAge(){
        return person -> person.getAge() < 18;
    }
    public static Predicate<Person> isMarried(){
        return person -> person.getMartialStatus().equalsIgnoreCase("married");
    }
    public static Predicate<Person> isSingle(){
        return person -> person.getMartialStatus().equalsIgnoreCase("single");
    }
    public static Predicate<Person> isWidowed(){
        return person -> person.getMartialStatus().equalsIgnoreCase("widowed");
    }
// ##############################################################

//    Person Class Constructor Generates Dummy data using Faker. Just use new Person()
    class Person{
        private String name;
        private String surname;
        private String sex;
        private String martialStatus;
        private String education;
        private int age;

        public Person() {
            Faker faker = new Faker();
            Demographic demographic = faker.demographic();
            Random random = new Random();

            this.name = faker.name().firstName();
            this.surname = faker.name().lastName();
            this.sex = demographic.sex();
            this.age = random.nextInt(60);
            this.martialStatus = demographic.maritalStatus();
            this.education = demographic.educationalAttainment();
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getSex() {
            return sex;
        }

        public String getMartialStatus() {
            return martialStatus;
        }

        public String getEducation() {
            return education;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString(){
            return this.name + " " + this.surname;
        }
    }

//    List of generated Persons
    private List<Person> neighbourhood = new ArrayList<>();

//    default constructor generates a list of 15 Persons
    public StreamCollectors(){
        while(neighbourhood.size() < 15){
            neighbourhood.add(new Person());
        }
    }

//    This Overloaded Constructor lets you specify the size of the list you want
    public StreamCollectors(int size){
        while(neighbourhood.size() < size){
            neighbourhood.add(new Person());
        }
    }

    public static void main(String[] args) {
//       Instance of SteamCollectors using default Constructor
        StreamCollectors sc = new StreamCollectors();

//       Supplier allows you to set aside an instance of a stream that can be reused
        Supplier<Stream<Person>> neighbourhoodDataSupplier = () -> sc.neighbourhood.stream();

//    Map of Persons based on gender
      Map<String, List<Person>> sexMap = neighbourhoodDataSupplier
                  .get()
                  .collect(groupingBy(Person::getSex));

//    Map of Persons based on gender without Supplier Interface
        Map sexMap2 = sc.neighbourhood.stream()
                .collect(groupingBy(Person::getSex));

//        List of legal Aged Persons
      List<Person> legalAged = neighbourhoodDataSupplier.get()
              .filter(isOfLegalAge())
              .collect(Collectors.toList());

//      int of persons below legal age [cast required since count returns long data type]
      int countOfPersonsBelowLegalAge = (int)neighbourhoodDataSupplier.get()
              .filter(isBelowLegalAge())
              .count();

    }
    }

