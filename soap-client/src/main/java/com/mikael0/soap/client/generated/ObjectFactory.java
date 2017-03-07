
package com.mikael0.soap.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mikael0.soap.client.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdatePerson_QNAME = new QName("http://standaloneerror.soap.mikael0.com/", "updatePerson");
    private final static QName _NoDataException_QNAME = new QName("http://standaloneerror.soap.mikael0.com/", "NoDataException");
    private final static QName _GetPersonsByParametersResponse_QNAME = new QName("http://standaloneerror.soap.mikael0.com/", "getPersonsByParametersResponse");
    private final static QName _CreatePerson_QNAME = new QName("http://standaloneerror.soap.mikael0.com/", "createPerson");
    private final static QName _GetPersonsByParameters_QNAME = new QName("http://standaloneerror.soap.mikael0.com/", "getPersonsByParameters");
    private final static QName _GetPersonsResponse_QNAME = new QName("http://standaloneerror.soap.mikael0.com/", "getPersonsResponse");
    private final static QName _GetPersons_QNAME = new QName("http://standaloneerror.soap.mikael0.com/", "getPersons");
    private final static QName _DeletePersonResponse_QNAME = new QName("http://standaloneerror.soap.mikael0.com/", "deletePersonResponse");
    private final static QName _CreatePersonResponse_QNAME = new QName("http://standaloneerror.soap.mikael0.com/", "createPersonResponse");
    private final static QName _UpdatePersonResponse_QNAME = new QName("http://standaloneerror.soap.mikael0.com/", "updatePersonResponse");
    private final static QName _DeletePerson_QNAME = new QName("http://standaloneerror.soap.mikael0.com/", "deletePerson");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mikael0.soap.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeletePerson }
     * 
     */
    public DeletePerson createDeletePerson() {
        return new DeletePerson();
    }

    /**
     * Create an instance of {@link CreatePersonResponse }
     * 
     */
    public CreatePersonResponse createCreatePersonResponse() {
        return new CreatePersonResponse();
    }

    /**
     * Create an instance of {@link UpdatePersonResponse }
     * 
     */
    public UpdatePersonResponse createUpdatePersonResponse() {
        return new UpdatePersonResponse();
    }

    /**
     * Create an instance of {@link DeletePersonResponse }
     * 
     */
    public DeletePersonResponse createDeletePersonResponse() {
        return new DeletePersonResponse();
    }

    /**
     * Create an instance of {@link GetPersons }
     * 
     */
    public GetPersons createGetPersons() {
        return new GetPersons();
    }

    /**
     * Create an instance of {@link GetPersonsByParameters }
     * 
     */
    public GetPersonsByParameters createGetPersonsByParameters() {
        return new GetPersonsByParameters();
    }

    /**
     * Create an instance of {@link GetPersonsResponse }
     * 
     */
    public GetPersonsResponse createGetPersonsResponse() {
        return new GetPersonsResponse();
    }

    /**
     * Create an instance of {@link CreatePerson }
     * 
     */
    public CreatePerson createCreatePerson() {
        return new CreatePerson();
    }

    /**
     * Create an instance of {@link PersonServiceFault }
     * 
     */
    public PersonServiceFault createPersonServiceFault() {
        return new PersonServiceFault();
    }

    /**
     * Create an instance of {@link GetPersonsByParametersResponse }
     * 
     */
    public GetPersonsByParametersResponse createGetPersonsByParametersResponse() {
        return new GetPersonsByParametersResponse();
    }

    /**
     * Create an instance of {@link UpdatePerson }
     * 
     */
    public UpdatePerson createUpdatePerson() {
        return new UpdatePerson();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standaloneerror.soap.mikael0.com/", name = "updatePerson")
    public JAXBElement<UpdatePerson> createUpdatePerson(UpdatePerson value) {
        return new JAXBElement<UpdatePerson>(_UpdatePerson_QNAME, UpdatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standaloneerror.soap.mikael0.com/", name = "NoDataException")
    public JAXBElement<PersonServiceFault> createNoDataException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_NoDataException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByParametersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standaloneerror.soap.mikael0.com/", name = "getPersonsByParametersResponse")
    public JAXBElement<GetPersonsByParametersResponse> createGetPersonsByParametersResponse(GetPersonsByParametersResponse value) {
        return new JAXBElement<GetPersonsByParametersResponse>(_GetPersonsByParametersResponse_QNAME, GetPersonsByParametersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standaloneerror.soap.mikael0.com/", name = "createPerson")
    public JAXBElement<CreatePerson> createCreatePerson(CreatePerson value) {
        return new JAXBElement<CreatePerson>(_CreatePerson_QNAME, CreatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standaloneerror.soap.mikael0.com/", name = "getPersonsByParameters")
    public JAXBElement<GetPersonsByParameters> createGetPersonsByParameters(GetPersonsByParameters value) {
        return new JAXBElement<GetPersonsByParameters>(_GetPersonsByParameters_QNAME, GetPersonsByParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standaloneerror.soap.mikael0.com/", name = "getPersonsResponse")
    public JAXBElement<GetPersonsResponse> createGetPersonsResponse(GetPersonsResponse value) {
        return new JAXBElement<GetPersonsResponse>(_GetPersonsResponse_QNAME, GetPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standaloneerror.soap.mikael0.com/", name = "getPersons")
    public JAXBElement<GetPersons> createGetPersons(GetPersons value) {
        return new JAXBElement<GetPersons>(_GetPersons_QNAME, GetPersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standaloneerror.soap.mikael0.com/", name = "deletePersonResponse")
    public JAXBElement<DeletePersonResponse> createDeletePersonResponse(DeletePersonResponse value) {
        return new JAXBElement<DeletePersonResponse>(_DeletePersonResponse_QNAME, DeletePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standaloneerror.soap.mikael0.com/", name = "createPersonResponse")
    public JAXBElement<CreatePersonResponse> createCreatePersonResponse(CreatePersonResponse value) {
        return new JAXBElement<CreatePersonResponse>(_CreatePersonResponse_QNAME, CreatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standaloneerror.soap.mikael0.com/", name = "updatePersonResponse")
    public JAXBElement<UpdatePersonResponse> createUpdatePersonResponse(UpdatePersonResponse value) {
        return new JAXBElement<UpdatePersonResponse>(_UpdatePersonResponse_QNAME, UpdatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://standaloneerror.soap.mikael0.com/", name = "deletePerson")
    public JAXBElement<DeletePerson> createDeletePerson(DeletePerson value) {
        return new JAXBElement<DeletePerson>(_DeletePerson_QNAME, DeletePerson.class, null, value);
    }

}
