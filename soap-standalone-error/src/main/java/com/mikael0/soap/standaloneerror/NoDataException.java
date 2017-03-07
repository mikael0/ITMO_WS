package com.mikael0.soap.standaloneerror;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "com.wishmaster.ifmo.ws.jaxws.errors.PersonServiceFault")
public class NoDataException extends Exception {

    private static final long serialVersionUID = -6647544772732631047L;

    private final PersonServiceFault fault;

    public NoDataException(String message, PersonServiceFault fault) {
        super(message);
        this.fault = fault;
    }
    public NoDataException(String message, PersonServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }
    public PersonServiceFault getFaultInfo() {
        return fault;
    }
}