package com.jersey.providers;

import com.jersey.services.TodoService;
import com.sun.jersey.spi.inject.SingletonTypeInjectableProvider;

import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

/**
 * @author SLA
 * @version 1.0
 */
@Provider
public class TodoServiceProvider extends SingletonTypeInjectableProvider<Context, TodoService>
{
    public TodoServiceProvider() {
        super(TodoService.class, new TodoService());
    }
}
