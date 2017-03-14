package com.mikael0.restclient;

import com.sun.istack.NotNull;
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
        private static final String URL = "http://localhost:8085/rest/persons";

        public static void main(String[] args) {
            Client client = Client.create();
            printList(getPersons(client, null, null, null, null, null));
            System.out.println();
            printList(getPersons(client, "Mikhail", null, null, null, null));
            String id = createPerson(client, "MIKHAIL", "BELENKO", 20, "M", new Date(System.currentTimeMillis()));
            printList(getPersons(client, null, null, null, null, null));
            updatePerson(client, Long.parseLong(id), "MIKE", null, null, null, null );
            printList(getPersons(client, null, null, null, null, null));
            deletePerson(client, Long.parseLong(id));
            printList(getPersons(client, null, null, null, null, null));
            try {
                deletePerson(client, null);
            }
            catch (IllegalStateException e){
                System.out.println(e.getMessage());
            }
        }

        private static List<Person> getPersons(Client client,
                                                  String name,
                                                  String surname,
                                                  Integer age,
                                                  String sex,
                                                  Date birth) {
            WebResource webResource = client.resource(URL + "/getByParams");
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

        private static String updatePerson(Client client,
                                               @NotNull Long id,
                                               String name,
                                               String surname,
                                               Integer age,
                                               String sex,
                                               Date birth) {
            WebResource webResource = client.resource(URL + "/update");
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
                webResource = webResource.queryParam("birth",new Long(birth.getTime()).toString());
            }
            if (id != null)
                webResource = webResource.queryParam("id", id.toString());
            ClientResponse response =
                    webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
            System.out.println(response.getStatus());
            if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
                throw new IllegalStateException(response.getEntity(String.class));
            }
            GenericType<String> type = new GenericType<String>() {};
            return response.getEntity(type);
        }

        private static String deletePerson(Client client,
                                                 @NotNull Long id) {
            WebResource webResource = client.resource(URL + "/delete");
            if (id != null)
                webResource = webResource.queryParam("id", id.toString());
            ClientResponse response =
                    webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
            if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
                throw new IllegalStateException(response.getEntity(String.class));
            }
            GenericType<String> type = new GenericType<String>() {};
            return response.getEntity(type);
        }

        private static String createPerson(@NotNull Client client,
                                                 @NotNull String name,
                                                 @NotNull String surname,
                                                 @NotNull Integer age,
                                                 @NotNull String sex,
                                                 @NotNull Date birth) {
            WebResource webResource = client.resource(URL + "/create");
            webResource = webResource.queryParam("name", name);
            webResource = webResource.queryParam("surname", surname);
            webResource = webResource.queryParam("age", age.toString());
            webResource = webResource.queryParam("sex", sex);
            webResource = webResource.queryParam("birth", new Long(birth.getTime()).toString());
            ClientResponse response =
                    webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
            System.out.println(response.getStatus());
            if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
                throw new IllegalStateException("Request failed");
            }
            GenericType<String> type = new GenericType<String>() {};
            return response.getEntity(type);
        }

        private static void printList(List<Person> persons) {
            for (Person person : persons) {
                System.out.println(person);
            }
        }
}
