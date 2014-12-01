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

    public User getLeader() {
        return leader;
    }

    public String getGoal() {
        return goal;
    }

}
