package de.fhkoeln.fp.repository;


import de.fhkoeln.fp.domain.Todo;

import java.util.Collection;

public interface TodoRepository {
    Collection<Todo> getTodos();

    Todo createTodo(Todo todo);

    Todo deleteTodo(Long id);

    Todo updateTodo(Todo todo);
}
