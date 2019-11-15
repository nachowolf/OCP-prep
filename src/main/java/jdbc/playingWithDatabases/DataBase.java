package jdbc.playingWithDatabases;

import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataBase {

    Connection conn;
    final String url = "jdbc:postgresql://localhost/dummy";
    final String user = "coder";
    final String password = "coder";
    Properties props = new Properties();
    final String pw = "pw";

    // ######| CREATE |#####

    final String ADD_PERSON_SQL = "INSERT INTO person (firstname, lastname, age) VALUES(?, ?, ?)";

    PreparedStatement psAddPerson;

    // #####################

    // #######| READ |######

    final String GET_ALL_PERSON = "SELECT * FROM person";
    final String GET_ALL_FIRSTNAMES = "select firstname from person";
    final String GET_ID_OF_PERSON_BY_NAME_AND_SURNAME = "SELECT * from person WHERE firstname = ? AND lastname = ?";

    PreparedStatement psGetAllFromPerson;
    PreparedStatement psGetAllFirstNames;
    PreparedStatement psGetIdOfPersonByNameAndSurname;

    // #####################

    // ######| UPDATE |#####

    final String UPDATE_NAME_BY_ID = "UPDATE person set age = ? where id = ?";
    final String UPDATE_AGE_BY_ID = "UPDATE person set age = ? where id = ?";
    final String UPDATE_SURNAME_BY_ID = "UPDATE person set lastname = ? where id = ?";

    PreparedStatement psUpdateNameById;
    PreparedStatement psUpdateAgeById;
    PreparedStatement psUpdateSurnameById;

    // #####################

    // ######| DELETE |#####
    final String DELETE_PERSON_BY_ID = "DELETE FROM person WHERE id = ?";
    final String TRUNCATE_TABLE = "TRUNCATE table person restart identity";
//    final String RESET_COUNTER = "ALTER sequence id restart with 1";

    PreparedStatement psDeletePersonById;
    PreparedStatement psClearTable;
//    PreparedStatement psCounterReset;

    // #####################


    public DataBase() {
        try {
            props.put("user", "coder");
            props.put("password", "coder");
            conn = DriverManager.getConnection(url, props);

            psAddPerson = conn.prepareStatement(ADD_PERSON_SQL);

            psGetAllFromPerson = conn.prepareStatement(GET_ALL_PERSON);
            psGetAllFirstNames = conn.prepareStatement(GET_ALL_FIRSTNAMES);
            psGetIdOfPersonByNameAndSurname = conn.prepareStatement(GET_ID_OF_PERSON_BY_NAME_AND_SURNAME);

            psUpdateNameById = conn.prepareStatement(UPDATE_NAME_BY_ID);
            psUpdateSurnameById = conn.prepareStatement(UPDATE_SURNAME_BY_ID);
            psUpdateAgeById = conn.prepareStatement(UPDATE_AGE_BY_ID);

            psDeletePersonById = conn.prepareStatement(DELETE_PERSON_BY_ID);
            psClearTable = conn.prepareStatement(TRUNCATE_TABLE);
//            psCounterReset = conn.prepareStatement(RESET_COUNTER);

        } catch (PSQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();

        }
    }

    private int getID(String name, String surname) throws NoSuchPersonException {
        int result = 0;
        try {
            psGetIdOfPersonByNameAndSurname.setString(1, name);
            psGetIdOfPersonByNameAndSurname.setString(2, surname);
            ResultSet rs = psGetIdOfPersonByNameAndSurname.executeQuery();
            if (rs.next()) {
                result = rs.getInt("id");
            } else throw new NoSuchPersonException();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private boolean exists(String name, String surname) {
        boolean result = false;
        try {
            psGetIdOfPersonByNameAndSurname.setString(1, name);
            psGetIdOfPersonByNameAndSurname.setString(2, surname);
            ResultSet rs = psGetIdOfPersonByNameAndSurname.executeQuery();
            result = rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void delete(String name, String surname) {
        int id = getID(name, surname);
        try {
            psDeletePersonById.setInt(1, id);
            psDeletePersonById.execute();
        } catch (RuntimeException | SQLException ex) {
            ex.printStackTrace();
        }

    }

    public boolean addPerson(String name, String surname, int age) {
        if (exists(name, surname)) {
            return false;
        } else {
            try {
                psAddPerson.setString(1, name);
                psAddPerson.setString(2, surname);
                psAddPerson.setInt(3, age);
                psAddPerson.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return true;
        }
    }

    public void changeName(String oldName, String surname, String newName) {
        try {
            int id = getID(oldName, surname);
            psUpdateNameById.setString(1, newName);
            psUpdateNameById.setInt(2, id);
            psUpdateNameById.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void changeSurname(String name, String oldSurname, String newSurname) {
        try {
            int id = getID(name, oldSurname);
            psUpdateNameById.setString(1, newSurname);
            psUpdateNameById.setInt(2, id);
            psUpdateNameById.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void changeAge(String name, String surname, int age) {
        try {
            int id = getID(name, surname);
            psUpdateNameById.setInt(1, age);
            psUpdateNameById.setInt(2, id);
            psUpdateNameById.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List getAllPersons() {
        List<Person> persons = new ArrayList<>();
        try {
            ResultSet rs = psGetAllFromPerson.executeQuery();
            while (rs.next()) {
                persons.add(new Person(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("age")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return persons;
    }

    public void clear(String password) {
        if (pw.equals(password)) {
            try {
                psClearTable.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IncorrectPasswordException();
        }
    }

    public static void main(String[] args) {
        DataBase db = new DataBase();
//        db.clear("pw");
        db.addPerson("John", "Mactyre",  48);
    }
}
