package de.stephannaegele.ponyVote.model;

import de.stephannaegele.ponyVote.interfaces.PersistableEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * The entity of a user
 * Created by NgS on 01.10.2017.
 */
@Entity
public class User implements PersistableEntity{

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
    public Long getId() {
        return id;
    }

    @Override
    public LocalDate getCreationDate() {
        return null;
    }

    @Override
    public LocalDate getModifiedDate() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }
}
