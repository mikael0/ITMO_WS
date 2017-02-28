/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikael0.soap.client;

import com.mikael0.soap.client.generated.Person;
import com.mikael0.soap.client.generated.PersonService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebServiceClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/PersonService?wsdl");
        PersonService personService = new PersonService(url);
        Person search = new Person();
        search.setAge(27);
        List<Person> persons = personService.getPersonWebServicePort().getPersons();
        List<Person> searchPersons = personService.getPersonWebServicePort().getPersonsByParameters(search);
        for (Person person : persons) {
            System.out.println("name: " + person.getName()
                    + ", surname: " + person.getSurname() + ", age: " + person.getAge()
                    + ", sex: " + String.valueOf(person.getSex()) + ", birth: " + person.getBirth());
        }
        System.out.println("Total persons: " + persons.size());
        for (Person person : searchPersons) {
            System.out.println("name: " + person.getName()
                    + ", surname: " + person.getSurname() + ", age: " + person.getAge()
                    + ", sex: " + String.valueOf(person.getSex()) + ", birth: " + person.getBirth());
        }
        System.out.println("Total found persons: " + searchPersons.size());
        
    }
}
