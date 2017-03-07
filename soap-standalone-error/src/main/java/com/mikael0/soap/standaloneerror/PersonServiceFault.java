package com.mikael0.soap.standaloneerror;

/**
 * Created by mikael0 on 07.03.17.
 */
public class PersonServiceFault {

    private static final String DEFAULT_MESSAGE = "No data with such id";

    protected String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public static PersonServiceFault defaultInstance() {
        PersonServiceFault fault = new PersonServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
