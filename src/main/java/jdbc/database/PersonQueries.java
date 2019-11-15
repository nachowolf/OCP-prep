package jdbc.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import jdbc.database.*;

public class PersonQueries {

    Connection conn = DataBase.getInstance().getConnection();


    //    ##########|CREATE|##########
    private final String ADD_NEW_PERSON_SQL = "Insert into person (firstname, lastname, age) values(?,?,?)";

    private PreparedStatement psAddNewPerson;
//    ############################


    //    ###########|READ|###########
    private final String GET_ID_OF_PERSON_SQL = "Select id from person where firstname = ? and lastname = ?";
    private final String TOTAL_PERSONS_SQL = " select count(*) from person";
    private final String GET_ALL_PERSONS_SQL = "select * from person";

    private PreparedStatement psGetID;
    private PreparedStatement psTotalPersons;
    private PreparedStatement psGetAllPersons;
//    ############################


    //    ##########|UPDATE|##########
    private final String CHANGE_NAME_OF_PERSON_SQL = "update person set firstname = ? where id = ?";
    private final String CHANGE_SURNAME_OF_PERSON_SQL = "update person set lastname = ? where id = ?";
    private final String CHANGE_AGE_OF_PERSON_SQL = "update person set age = ? where id = ?";


    private PreparedStatement psUpdateName;
    private PreparedStatement psUpdateSurname;
    private PreparedStatement psUpdateAge;
//    ############################


    //    ##########|DELETE|##########
    private final String WIPE_PERSONS_SQL = "truncate table person restart identity";

    private PreparedStatement psReset;
//    ############################

    public PersonQueries() {
        try {
            psAddNewPerson = conn.prepareStatement(ADD_NEW_PERSON_SQL);

            psGetID = conn.prepareStatement(GET_ID_OF_PERSON_SQL);
            psTotalPersons = conn.prepareStatement(TOTAL_PERSONS_SQL);
            psGetAllPersons = conn.prepareStatement(GET_ALL_PERSONS_SQL);

            psUpdateName = conn.prepareStatement(CHANGE_NAME_OF_PERSON_SQL);
            psUpdateSurname = conn.prepareStatement(CHANGE_SURNAME_OF_PERSON_SQL);
            psUpdateAge = conn.prepareStatement(CHANGE_AGE_OF_PERSON_SQL);

            psReset = conn.prepareStatement(WIPE_PERSONS_SQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addPerson(String name, String surname, int age) throws SQLException {
        psAddNewPerson.setString(1, name);
        psAddNewPerson.setString(2, surname);
        psAddNewPerson.setInt(3, age);
        psAddNewPerson.execute();
        ResultSet rs = psTotalPersons.executeQuery();
        rs.next();
        System.out.println(rs.getInt(1));
    }

    public void reset() throws SQLException {
        psReset.execute();
        ResultSet rs = psTotalPersons.executeQuery();
        rs.next();
        System.out.println(rs.getInt(1));
    }

    public List getAllPerson() throws SQLException {
        List<Person> persons = new ArrayList<>();
        ResultSet rs = psGetAllPersons.executeQuery();
        while (rs.next()) {
            persons.add(new Person(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)
            ));
        }

        return persons;
    }

    public static void main(String[] args) throws SQLException {
        PersonQueries pq = new PersonQueries();
        pq.addPerson("nathri", "jacobs", 22);
        pq.addPerson("tom", "bean", 44);
        System.out.println(pq.getAllPerson().size());

        pq.reset();
    }

}
