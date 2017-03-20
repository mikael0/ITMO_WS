package com.mikael0.reststandalone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    public List<Person> getPersonsByParams(@QueryParam("name") String name,
                                   @QueryParam("surname") String surname,
                                   @QueryParam("age") Integer age,
                                   @QueryParam("sex") String sex,
                                   @QueryParam("date") Date birth ) {
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
}
