package de.stetro.forschungsprojekt.data.er.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String mail;

    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }
}
