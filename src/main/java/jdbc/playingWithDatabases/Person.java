package jdbc.playingWithDatabases;

public class Person {

    private int id;
    private String name;
    private String surname;
    private int age;

    public Person(int id, String name, String surname, int age){
        this.id = id;
        this.name = name;
        this.surname = name;
        this.age = age;
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

    public int getId(){
        return id;
    }
}
