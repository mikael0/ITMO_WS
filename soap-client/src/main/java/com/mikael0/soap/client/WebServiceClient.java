/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikael0.soap.client;

import com.mikael0.soap.client.generated.NoDataException;
import com.mikael0.soap.client.generated.Person;
import com.mikael0.soap.client.generated.PersonService;
import com.mikael0.soap.client.generated.PersonWebService;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WebServiceClient {

    public static void setupCredentials(String url, PersonWebService port){
        Map<String, Object> req_ctx = ((BindingProvider)port).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("mikael0"));
        headers.put("Password", Collections.singletonList("password"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
    }

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8090/PersonService?wsdl");
        PersonService personService = new PersonService(url);
        PersonWebService port = personService.getPersonWebServicePort();
        setupCredentials("http://localhost:8090/PersonService?wsdl", port);
        Person search = new Person();
        search.setAge(27);
        List<Person> persons = port.getPersons();
        List<Person> searchPersons = port.getPersonsByParameters(search);
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

        Date birth = new Date();
        try {
            birth = new SimpleDateFormat("ddMMyyyy").parse("04061996");
        } catch (ParseException e) {

        }
        GregorianCalendar gcal = new GregorianCalendar();
        gcal.setTime(birth);
        XMLGregorianCalendar xmlgcal = null;
        try {
            xmlgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (Exception e) {
        }
        Long id = port.createPerson("Mikhail", "Belenko", 20, "M", xmlgcal);

        persons = port.getPersons();
        for (Person person : persons) {
            System.out.println("name: " + person.getName()
                    + ", surname: " + person.getSurname() + ", age: " + person.getAge()
                    + ", sex: " + String.valueOf(person.getSex()) + ", birth: " + person.getBirth());
        }
        try {
            port.updatePerson(id, null, null, 42, null, null);
        }
        catch (NoDataException e){
            e.printStackTrace();
        }
        persons = port.getPersons();
        for (Person person : persons) {
            System.out.println("name: " + person.getName()
                    + ", surname: " + person.getSurname() + ", age: " + person.getAge()
                    + ", sex: " + String.valueOf(person.getSex()) + ", birth: " + person.getBirth());
        }
        port.deletePerson(id);
        persons = port.getPersons();
        for (Person person : persons) {
            System.out.println("name: " + person.getName()
                    + ", surname: " + person.getSurname() + ", age: " + person.getAge()
                    + ", sex: " + String.valueOf(person.getSex()) + ", birth: " + person.getBirth());
        }
        try {
            port.updatePerson(666l, null, null, 42, null, null);
        }
        catch (NoDataException e){
            e.printStackTrace();
        }
    }

}
