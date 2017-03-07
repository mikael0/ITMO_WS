/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikael0.soap.standalonecrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    public List<Person> getPersons(String condition) {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            Statement stmt = connection.createStatement();
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

    public Long createPerson(String name, String surname, int age, String sex, Date birth){
        Long ret = null;
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO persons(name, surname, age, sex, birth) values (?, ?, ?, ?, ? )", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setInt(3, age);
            stmt.setString(4, sex);
            stmt.setDate(5, new java.sql.Date(birth.getTime()));
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    ret = generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public int updatePerson(Long id, String name, String surname, int age, String sex, Date birth){
        try (Connection connection = ConnectionUtil.getConnection()) {
            StringBuilder query = new StringBuilder("UPDATE persons SET ");
            if (name!= null)
                query.append("name = " + name + ", ");
            if (surname != null)
                query.append("surname = " + surname + ", ");
            if (age != 0)
                query.append("age = " + age + ", ");
            if (sex != null)
                query.append("sex = " + sex + ", ");
            if (birth != null)
                query.append("birth = " + birth + ", ");
            query.replace(query.lastIndexOf(","), query.lastIndexOf(",") + 1, "");
            query.append("WHERE id = "+ id);
            System.out.println(query);
            PreparedStatement stmt = connection.prepareStatement(query.toString());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("Creating user failed, no rows affected.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        return 0;
    }


    public int deletePerson(Long id){
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM persons WHERE id = ?");
            stmt.setLong(1, id);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("Creating user failed, no rows affected.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        return 0;
    }
}
