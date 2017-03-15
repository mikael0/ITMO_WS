/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikael0.soap.standaloneerror;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(serviceName = "PersonService")
public class PersonWebService {

    @Resource
    WebServiceContext wsc;

    private boolean authenticate(){
        Map http_headers = (Map) wsc.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");

        String username = "";
        String password = "";

        if(userList!=null){
            //get username
            username = userList.get(0).toString();
        }

        if(passList!=null){
            //get password
            password = passList.get(0).toString();
        }

        return username.equals("mikael0") && password.equals("password");
    }

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

        //Should validate username and password with database
        if (authenticate()){
            PostgreSQLDAO dao = new PostgreSQLDAO();
            return dao.createPerson(name, surname, age, sex, birth);
        }
        return null;
    }

    @WebMethod(operationName = "updatePerson")
    public int updatePerson(Long id, String name, String surname, int age, String sex, Date birth)
    throws NoDataException {
        if (authenticate()) {
            PostgreSQLDAO dao = new PostgreSQLDAO();
            if (dao.updatePerson(id, name, surname, age, sex, birth) != 0) {
                throw new NoDataException(null, PersonServiceFault.defaultInstance());
            }
        }
        return 1;
    }

    @WebMethod(operationName = "deletePerson")
    public int deletePerson(Long id){
        if (authenticate()) {
            PostgreSQLDAO dao = new PostgreSQLDAO();
            return dao.deletePerson(id);
        }
        return 1;
    }
}
