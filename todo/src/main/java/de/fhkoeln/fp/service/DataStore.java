package de.fhkoeln.fp.service;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.ReadWrite;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.tdb.TDBFactory;
import de.fhkoeln.fp.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataStore {
    private static final String RDF_FILE = "tdb_store";
    private static final String NAMESPACE = "http://fhkoeln.de/todo/";
    private final Dataset dataset;


    public DataStore() {
        dataset = TDBFactory.createDataset(RDF_FILE);
    }

    public void saveTodo(Todo todo) {
        dataset.begin(ReadWrite.WRITE);
        try {
            Model model = dataset.getDefaultModel();

            String uri = NAMESPACE + "todo_" + (int) (Math.random() * Integer.MAX_VALUE);
            Resource s = model.createResource(uri);

            Property p = model.createProperty(NAMESPACE, "created");
            RDFNode o = model.createTypedLiteral(todo.getCreated());
            model.createStatement(s, p, o);


            p = model.createProperty(NAMESPACE, "done");
            o = model.createTypedLiteral(todo.isDone());
            model.createStatement(s, p, o);

            p = model.createProperty(NAMESPACE, "text");
            o = model.createTypedLiteral(todo.getText());
            model.createStatement(s, p, o);

            dataset.commit();
        } finally {
            dataset.end();
        }

    }

    public List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<>();
        dataset.begin(ReadWrite.READ);
        String query = "SELECT * {?s ?p ?o} LIMIT 10" ;
        try {

            Model model = dataset.getDefaultModel();
            Property done = model.getProperty(NAMESPACE, "done");
            ResIterator iterator = model.listSubjectsWithProperty(done);
            iterator.toList();

        } finally {
            dataset.end();
        }
        return todos;
    }
}
