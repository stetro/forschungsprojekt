package de.stetro.forschungsprojekt.data.graph.pojos;

import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class TrainingEvent extends Event {

    @RelatedTo(elementClass = User.class)
    private User leader;
    private String goal;

    public TrainingEvent() {

    }

    public TrainingEvent(String title, String location, String goal, User leader) {
        super(title, location);
        this.goal = goal;
        this.leader = leader;
    }

    public User getLeader() {
        return leader;
    }

    public String getGoal() {
        return goal;
    }

}
