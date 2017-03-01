
package com.mikael0.soap.client.generated.j2ee;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mikael0.soap.client.generated.j2ee package. 
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

    private final static QName _GetPersonsByParametersResponse_QNAME = new QName("http://j2ee.mikael0.com/", "getPersonsByParametersResponse");
    private final static QName _GetPersonsByParameters_QNAME = new QName("http://j2ee.mikael0.com/", "getPersonsByParameters");
    private final static QName _GetPersonsResponse_QNAME = new QName("http://j2ee.mikael0.com/", "getPersonsResponse");
    private final static QName _GetPersons_QNAME = new QName("http://j2ee.mikael0.com/", "getPersons");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mikael0.soap.client.generated.j2ee
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link GetPersonsByParametersResponse }
     * 
     */
    public GetPersonsByParametersResponse createGetPersonsByParametersResponse() {
        return new GetPersonsByParametersResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByParametersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://j2ee.mikael0.com/", name = "getPersonsByParametersResponse")
    public JAXBElement<GetPersonsByParametersResponse> createGetPersonsByParametersResponse(GetPersonsByParametersResponse value) {
        return new JAXBElement<GetPersonsByParametersResponse>(_GetPersonsByParametersResponse_QNAME, GetPersonsByParametersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsByParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://j2ee.mikael0.com/", name = "getPersonsByParameters")
    public JAXBElement<GetPersonsByParameters> createGetPersonsByParameters(GetPersonsByParameters value) {
        return new JAXBElement<GetPersonsByParameters>(_GetPersonsByParameters_QNAME, GetPersonsByParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://j2ee.mikael0.com/", name = "getPersonsResponse")
    public JAXBElement<GetPersonsResponse> createGetPersonsResponse(GetPersonsResponse value) {
        return new JAXBElement<GetPersonsResponse>(_GetPersonsResponse_QNAME, GetPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://j2ee.mikael0.com/", name = "getPersons")
    public JAXBElement<GetPersons> createGetPersons(GetPersons value) {
        return new JAXBElement<GetPersons>(_GetPersons_QNAME, GetPersons.class, null, value);
    }

}
