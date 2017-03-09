package com.mikael0.resterror;

/**
 * Created by mikael0 on 09.03.17.
 */
public class NoDataException extends Exception {

    private static final long serialVersionUID = -6647544772732631047L;

    public static NoDataException DEFAULT_INSTANCE = new
         NoDataException("no data");

    public NoDataException(String message) {
        super(message);
    }
}

