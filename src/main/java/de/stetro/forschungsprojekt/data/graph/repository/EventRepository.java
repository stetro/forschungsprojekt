package de.stetro.forschungsprojekt.data.graph.repository;


import de.stetro.forschungsprojekt.data.graph.pojos.Event;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface EventRepository extends GraphRepository<Event> {
}
