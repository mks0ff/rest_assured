package com.jersey.services;


import com.jersey.exceptions.TodoNotFoundException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author SLA
 * @version 1.0
 */
public class TodoService {

    ConcurrentHashMap<String, String> todos = new ConcurrentHashMap<String, String>();

    public List<String> getAllTodos()
    {
        List<String> result = new ArrayList<>();
        Set<Map.Entry<String, String>> entries = todos.entrySet();
        entries.forEach(t -> result.add(t.getValue()));
        return result;
    }

    public void addTodo(String todo)
    {
        todos.put(UUID.randomUUID().toString(), todo);
    }

    public void removeTodo(final String todo)
    {
        Set<String> result = getKeysByValue(todos, todo);
        if (result.isEmpty())
            throw new TodoNotFoundException("Todo '" + todo + "' not found.");
        todos.remove(result.stream().findFirst().get());
    }

    public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(value))
                .map(entry -> entry.getKey())
                .collect(Collectors.toSet());
    }
}
