package de.stetro.forschungsprojekt.data.graph.pojos;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

    @NodeEntity
    public abstract class Event {
        @GraphId
        private Long id;
        private String title;
        private String location;

    public Event(String title, String location) {
        this.title = title;
        this.location = location;
    }

    public Event() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }
}
