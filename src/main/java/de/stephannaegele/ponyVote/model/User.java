package de.stephannaegele.ponyVote.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * The entity of a user
 * Created by NgS on 01.10.2017.
 */
@Data
@Entity
public class User implements PersistableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String username;
    private LocalDate creationDate;
    private LocalDate modifyDate;

    public User(String name, String surname, String username) {
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    @Override
    public LocalDate getModifiedDate() {
        return null;
    }

}
