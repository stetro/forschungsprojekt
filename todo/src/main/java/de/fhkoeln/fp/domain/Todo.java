package de.fhkoeln.fp.domain;


import java.util.Date;

public class Todo {
    private Date created;
    private String text;
    private Boolean done;

    public Todo() {
    }

    public Todo(Date created, String text, Boolean done) {
        this.created = created;
        this.text = text;
        this.done = done;
    }

    public Date getCreated() {
        return created;
    }

    public String getText() {
        return text;
    }

    public Boolean isDone() {
        return done;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
