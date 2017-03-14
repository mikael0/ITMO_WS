package com.mikael0.restcrud;

import javax.jws.WebMethod;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

/**
 * Created by mikael0 on 08.03.17.
 */
@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    @Path("getByParams")
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

    @GET
    @Path("get")
    public List<Person> getPersons() {
        List<Person> persons = new PostgreSQLDAO().getPersons("");
        return persons;
    }

    @POST
    @Path("create")
    public String createPerson(@QueryParam("name") String name,
                             @QueryParam("surname") String surname,
                             @QueryParam("age") int age,
                             @QueryParam("sex") String sex,
                             @QueryParam("birth") Long millis){
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.createPerson(name, surname, age, sex, new Date(millis)).toString();
    }

    @POST
    @Path("update")
    public String updatePerson(@QueryParam("id") Long id,
                            @QueryParam("name") String name,
                            @QueryParam("surname") String surname,
                            @QueryParam("age") int age,
                            @QueryParam("sex") String sex,
                            @QueryParam("birth") Long millis){
        PostgreSQLDAO dao = new PostgreSQLDAO();
        String ret = dao.updatePerson(id, name, surname, age, sex, millis == null ? null : new Date(millis)).toString();
        return ret;
    }

    @POST
    @Path("delete")
    public String deletePerson(@QueryParam("id") Long id){
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.deletePerson(id).toString();
    }
}
