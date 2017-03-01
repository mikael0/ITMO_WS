/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikael0.j2ee;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(serviceName = "PersonService")
public class PersonWebService {

    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        List<Person> persons = dao.getPersons("");
        return persons;
    }

    @Resource(lookup = "jdbc/persons_data")
    private DataSource dataSource;
    
    @WebMethod(operationName = "getPersonsByParameters")
    public List<Person> getPersonsByParameters(Person params) {
        String condition = "where ";
        if (params.getAge() != null) {
            condition += "age=\'" + params.getAge().toString() + "\' and ";
        }
        if (params.getName() != null) {
            condition += "name=\'" + params.getName().toString() + "\' and ";
        }
        if (params.getSurname()!= null) {
            condition += "surname=\'" + params.getSurname().toString() + "\' and ";
        }
        if (params.getSex() != null) {
            condition += "sex=\'" + params.getSex().toString().toLowerCase() + "\' and ";
        }
        if (params.getBirth() != null) {
            condition += "birth=\'" + params.getBirth() + "\' and ";
        }
        condition = condition.substring(0, condition.length() - 4);
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        List<Person> persons = dao.getPersons(condition);
        return persons;
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
