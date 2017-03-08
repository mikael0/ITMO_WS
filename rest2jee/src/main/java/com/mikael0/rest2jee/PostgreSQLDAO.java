package com.mikael0.rest2jee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    private Connection mConnection;

    public PostgreSQLDAO(Connection connection){
        mConnection = connection;
    }

    public List<Person> getPersons(String condition) {
        List<Person> persons = new ArrayList<>();
        try {
            Statement stmt = mConnection.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("select * from persons %s", condition));
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                Date birth = rs.getDate("birth");

                Person person = new Person(name, surname, age, sex, birth);
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return persons;
    }
}
