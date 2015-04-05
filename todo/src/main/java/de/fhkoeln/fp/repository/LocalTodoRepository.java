package de.fhkoeln.fp.repository;

import de.fhkoeln.fp.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LocalTodoRepository implements TodoRepository {

    private Map<Long, Todo> todos = new HashMap<>();

    public Collection<Todo> getTodos() {
        return todos.values();
    }

    @Override
    public Todo createTodo(Todo todo) {
        todo.setCreated(new Date());
        return todos.put(todo.getCreated().getTime(), todo);
    }

    @Override
    public Todo deleteTodo(Long id) {
        return todos.remove(id);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return todos.put(todo.getCreated().getTime(), todo);
    }
}
