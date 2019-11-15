package generics_and_collections.aboutCollections.set;

import com.github.javafaker.Faker;
import generics_and_collections.dummy.marbles.Marble;

import java.io.*;
import java.util.*;

class Person {
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person() {
        this.name = new Faker().name().firstName();
        this.surname = new Faker().name().lastName();
        this.age = new Random().nextInt(65) + 5;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d", name, surname, age);
    }
}

class Fakey {
    private static String dummyPath = "src/main/java/mess/dummy_data/fakepeople.txt";

    static void generateDummyData() {
        File file = new File(dummyPath);
        if (file.exists()) {
            System.out.println("This file exists");
        } else {
            try {
                int count = 0;
                file.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                while (count != 20) {
                    Person person = new Person();
                    writer.write(String.format("%s,%s,%d", person.getName(), person.getSurname(), person.getAge()));


                        count++;
                        writer.newLine();

                }
                writer.flush();
                writer.close();
                System.out.println("File has been generated");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static Person[] getDummyData() {
        List<Person> people = new ArrayList<>();
        File file = new File(dummyPath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException("Please generate dummy data");
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    String[] person = reader.readLine().split(",");
                    people.add(new Person(person[0], person[1], Integer.parseInt(person[2])));
                }
                reader.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return people.toArray(new Person[people.size()]);
    }
}

public class Setter {
    public static void main(String[] args) {
       try{
           Person[] people = Fakey.getDummyData();

           Set<Person> hashSet = new HashSet<>(),
                   linkedHashSet = new LinkedHashSet<>(),
                   treeSet = new TreeSet<>(Comparator.comparing(Person::getName));

           Set<String> s = new TreeSet<>();

           for (Person p : people) {
               hashSet.add(p);
               linkedHashSet.add(p);
               treeSet.add(p);
               s.add(p.getName());
           }

           System.out.println("HashSet: ");
           hashSet.forEach(System.out::println);

           System.out.println("\n LinkedHashSet: ");
           linkedHashSet.forEach(System.out::println);

           System.out.println("\n TreeSet: ");
           treeSet.forEach(System.out::println);

           System.out.println("\n TreeSetString: ");
           s.forEach(System.out::println);


       }
       catch (Exception ex){
           ex.printStackTrace();
       }
    }
}
