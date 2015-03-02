package com.jersey.resources;

import com.jersey.services.TodoService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;

import static org.apache.commons.lang3.StringUtils.join;

/**
 * @author SLA
 * @version 1.0
 */
@Path("/todo")
public class TodoResource {

    @Context
    private TodoService todoService;

    @GET
    @Produces("application/json")
    public String getTodos() {
        return join(todoService.getAllTodos(), ",");
    }

    @POST
    @Consumes("application/json")
    public void addTodo(String newTodo) {
        todoService.addTodo(newTodo);
    }

    @DELETE
    @Path("/{todo}")
    public void removeTodo(@PathParam("todo") String todoToRemove) {
        todoService.removeTodo(todoToRemove);
    }

}
