package de.stephannaegele.ponyVote.domain;

import de.stephannaegele.ponyVote.controller.SessionController;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * the Entity for all sessionItems of a session
 * Created by NgS on 30.09.2017.
 */
@Entity
@Data
@NoArgsConstructor
public class Item implements PersistableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String headline;
    private LocalDate date;
    private String summary;
    private Integer priorization;
    private Integer votes;
    @ManyToOne
    private Session session;
    @OneToMany
    private Set<User> votees;

    //TODO: add security

    public Item(String headline, LocalDate date, String summary) {
        this.headline = headline;
        this.date = date;
        this.summary = summary;
    }

    public Item(Long id, String headline, String summary, LocalDate date) {
        this.id = id;
        this.headline = headline;
        this.summary = summary;
        this.date = date;
    }

    public Item(String headline, LocalDate date, String summary, User createdBy) {
        this.headline = headline;
        this.date = date;
        this.summary = summary;

    }

    @Override
    public LocalDate getCreationDate() {
        return null;
    }

    @Override
    public LocalDate getModifiedDate() {
        return null;
    }

}
