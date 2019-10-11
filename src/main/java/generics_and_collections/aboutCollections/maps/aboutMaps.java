package generics_and_collections.aboutCollections.maps;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

enum faculty{
    Teacher,
    Student;
}

class Person {

    private static int ID = 0;
    private String name;

    public Person(String name) {
        this.name = name;
        ID++;
    }

    public static int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class aboutMaps {

    public static void main(String[] args) {
        TreeMap<faculty, ArrayList<Person>> school = new TreeMap<>();
        school.put(faculty.Student, new ArrayList<Person>());
        school.put(faculty.Teacher, new ArrayList<Person>());

        SortedMap<faculty, ArrayList<Person>> students = school.subMap(faculty.Student, true, faculty.Student, true);
        students.get(students.firstKey()).add(new Person("James"));

        SortedMap<faculty, ArrayList<Person>> teachers = school.subMap(faculty.Teacher, true, faculty.Teacher, true);
        teachers.get(teachers.firstKey()).add(new Person("Susan"));

        school.values().stream().forEach(v -> v.forEach(p -> System.out.println(p.getName())));

        school.pollFirstEntry().getValue().forEach(System.out::println);

        System.out.println(school + " " +students);

    }

}
