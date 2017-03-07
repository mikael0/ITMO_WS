/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikael0.soap.standalonecrud;

import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "PersonService")
public class PersonWebService {

    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Person> persons = dao.getPersons("");
        return persons;
    }
    
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
        System.out.println(condition);
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Person> persons = dao.getPersons(condition);
        return persons;
    }

    @WebMethod(operationName = "createPerson")
    public Long createPerson(String name, String surname, int age, String sex, Date birth){
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.createPerson(name, surname, age, sex, birth);
    }

    @WebMethod(operationName = "updatePerson")
    public int updatePerson(Long id, String name, String surname, int age, String sex, Date birth){
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.updatePerson(id, name, surname, age, sex, birth);
    }

    @WebMethod(operationName = "deletePerson")
    public int deletePerson(Long id){
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.deletePerson(id);
    }
}
