package com.mikael0.restclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

/**
 * Created by mikael0 on 08.03.17.
 */
public class App {
        private static final String URL = "http://localhost:8080/rest/persons/getByParams";

        public static void main(String[] args) {
            Client client = Client.create();
            printList(getPersons(client, null, null, null, null, null));
            System.out.println();
            printList(getPersons(client, "Mikhail", null, null, null, null));
        }

        private static List<Person> getPersons(Client client,
                                                  String name,
                                                  String surname,
                                                  Integer age,
                                                  String sex,
                                                  Date birth) {
            WebResource webResource = client.resource(URL);
            if (name != null) {
                webResource = webResource.queryParam("name", name);
            }
            if (surname != null) {
                webResource = webResource.queryParam("surname", surname);
            }
            if (age != null) {
                webResource = webResource.queryParam("age", age.toString());
            }
            if (sex != null) {
                webResource = webResource.queryParam("sex", sex);
            }
            if (birth != null) {
                webResource = webResource.queryParam("birth", birth.toString());
            }
            ClientResponse response =
                    webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
            if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
                throw new IllegalStateException("Request failed");
            }
            GenericType<List<Person>> type = new GenericType<List<Person>>() {};
            return response.getEntity(type);
        }

        private static void printList(List<Person> persons) {
            for (Person person : persons) {
                System.out.println(person);
            }
        }
}
