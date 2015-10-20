package com.jersey.providers;

import com.jersey.exceptions.TodoNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author SLA
 * @version 1.0
 */
@Provider
public class NotFoundMapper implements ExceptionMapper<TodoNotFoundException> {
    @Override
    public Response toResponse(TodoNotFoundException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity("TodoNotFoundException").build();
    }
}
