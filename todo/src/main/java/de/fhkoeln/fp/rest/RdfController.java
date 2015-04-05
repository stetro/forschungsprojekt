package de.fhkoeln.fp.rest;

import de.fhkoeln.fp.domain.Todo;
import de.fhkoeln.fp.service.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class RdfController {

    @Autowired
    private DataStore dataStore;

    @RequestMapping("/save_new")
    @ResponseBody
    Todo home() {
        Todo todo = new Todo(new Date(), "Irgendwas machen ...", false);
        dataStore.saveTodo(todo);
        return todo;
    }

    @RequestMapping("/get")
    @ResponseBody
    List<Todo> get() {
        return dataStore.getTodos();
    }

}
