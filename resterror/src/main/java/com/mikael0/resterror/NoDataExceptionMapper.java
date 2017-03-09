package com.mikael0.resterror;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by mikael0 on 09.03.17.
 */
@Provider
public class NoDataExceptionMapper implements ExceptionMapper<NoDataException> {
    @Override
    public Response toResponse(NoDataException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
