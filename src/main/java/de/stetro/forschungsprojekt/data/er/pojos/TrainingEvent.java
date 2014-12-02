package de.stetro.forschungsprojekt.data.er.pojos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TrainingEvent extends Event {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id")
    private User leader;
    private String goal;

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
