package de.stetro.forschungsprojekt.config;


import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.support.Neo4jTemplate;

@Configuration
@EnableNeo4jRepositories(basePackages = "de.stetro.forschungsprojekt.data.graph.repository")
public class Neo4jConfig extends Neo4jConfiguration {


    public Neo4jConfig() {
        setBasePackage("de.stetro.forschungsprojekt.data.graph.pojos");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("/Users/stetro/Source/forschungsprojekt/neo4j.db");
    }

    @Bean
    public Neo4jTemplate neo4jTemplate() {
        return new Neo4jTemplate(graphDatabaseService());
    }
}
