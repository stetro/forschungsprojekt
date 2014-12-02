package de.stetro.forschungsprojekt.data.graph.repository;

import de.stetro.forschungsprojekt.data.graph.pojos.User;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface UserRepository extends GraphRepository<User> {
}
