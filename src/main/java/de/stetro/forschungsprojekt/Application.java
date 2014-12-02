package de.stetro.forschungsprojekt;

import de.stetro.forschungsprojekt.data.graph.pojos.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@SpringApplicationConfiguration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        User u = new User("Steffen", "steffen.troester@googlemail.com");
    }
}
