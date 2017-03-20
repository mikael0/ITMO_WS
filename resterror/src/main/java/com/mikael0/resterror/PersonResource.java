package com.mikael0.resterror;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.handler.MessageContext;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mikael0 on 08.03.17.
 */
@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private boolean authenticate(String username, String password){
        return username.equals("mikael0") && password.equals("password");
    }

    @GET
    public List<Person> getPersonsByParams(@QueryParam("name") String name,
                                   @QueryParam("surname") String surname,
                                   @QueryParam("age") Integer age,
                                   @QueryParam("sex") String sex,
                                   @QueryParam("birth") Date birth ) {
        String condition = "where ";
        if (age != null) {
            condition += "age=\'" + age.toString() + "\' and ";
        }
        if (name != null) {
            condition += "name=\'" + name.toString() + "\' and ";
        }
        if (surname!= null) {
            condition += "surname=\'" + surname.toString() + "\' and ";
        }
        if (sex != null) {
            condition += "sex=\'" +sex.toString().toLowerCase() + "\' and ";
        }
        if (birth != null) {
            condition += "birth=\'" + birth + "\' and ";
        }
        condition = condition.substring(0, condition.length() - 4);
        List<Person> persons = new PostgreSQLDAO().getPersons(condition);
        return persons;
    }

    @PUT
    public String createPerson(@QueryParam("name") String name,
                               @QueryParam("surname") String surname,
                               @QueryParam("age") int age,
                               @QueryParam("sex") String sex,
                               @QueryParam("birth") Long millis,
                               @HeaderParam("Username") String username,
                               @HeaderParam("Password") String password) {
        if (authenticate(username, password)) {
            PostgreSQLDAO dao = new PostgreSQLDAO();
            return dao.createPerson(name, surname, age, sex, new Date(millis)).toString();
        }
        return null;
    }

    @POST
    public String updatePerson(@QueryParam("id") Long id,
                            @QueryParam("name") String name,
                            @QueryParam("surname") String surname,
                            @QueryParam("age") int age,
                            @QueryParam("sex") String sex,
                            @QueryParam("birth") Long millis,
                            @HeaderParam("Username") String username,
                            @HeaderParam("Password") String password)
                            throws NoDataException {
        if (id == null)
            throw NoDataException.DEFAULT_INSTANCE;
        if (authenticate(username, password)) {
            PostgreSQLDAO dao = new PostgreSQLDAO();
            String ret = dao.updatePerson(id, name, surname, age, sex, millis == null ? null : new Date(millis)).toString();
            return ret;
        }
        return new Integer(1).toString();
    }

    @DELETE
    public String deletePerson(@QueryParam("id") Long id,
                               @HeaderParam("Username") String username,
                               @HeaderParam("Password") String password) throws NoDataException{
        if (id == null)
            throw NoDataException.DEFAULT_INSTANCE;
        if (authenticate(username, password)) {
            PostgreSQLDAO dao = new PostgreSQLDAO();
            return dao.deletePerson(id).toString();
        }
        return new Integer(1).toString();
    }
}
