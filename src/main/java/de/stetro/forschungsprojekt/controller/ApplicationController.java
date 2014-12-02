package de.stetro.forschungsprojekt.controller;

import de.stetro.forschungsprojekt.data.graph.pojos.Event;
import de.stetro.forschungsprojekt.data.graph.pojos.TrainingEvent;
import de.stetro.forschungsprojekt.data.graph.pojos.User;
import de.stetro.forschungsprojekt.data.graph.repository.EventRepository;
import de.stetro.forschungsprojekt.data.graph.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/graph")
@EnableNeo4jRepositories(
        basePackages = "de.stetro.forschungsprojekt.data.graph")
public class ApplicationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(method = RequestMethod.GET)
    @Transactional
    public
    @ResponseBody
    Result<Event> sayHello() {
        User u = new User("Steffen Tröster", "steffen.troester@googlemail.com");
        userRepository.save(u);
        TrainingEvent trainingEvent = new TrainingEvent("Sinphonieprobe", "Köln", "Satzprobe", u);
        eventRepository.save(trainingEvent);

        return eventRepository.findAll();
    }
}
