package de.fhkoeln.fp.rest;

import de.fhkoeln.fp.domain.Todo;
import de.fhkoeln.fp.repository.LocalTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/todo/local")
public class LocalTodoController {

    @Autowired
    private LocalTodoRepository localTodoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    Collection<Todo> getTodos() {
        return localTodoRepository.getTodos();
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    Todo createTodo(@RequestBody Todo todo) {
        return localTodoRepository.createTodo(todo);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public
    @ResponseBody
    Todo updateTodo(@RequestBody Todo todo) {
        return localTodoRepository.updateTodo(todo);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    Todo deleteTodo(@PathVariable("id") Long id) {
        return localTodoRepository.deleteTodo(id);
    }

}
