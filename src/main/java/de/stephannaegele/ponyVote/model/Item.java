package de.stephannaegele.ponyVote.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;



/**
 * the Entity for all sessionItems of a session
 * Created by NgS on 30.09.2017.
 */
@Data
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String headline;
    private LocalDate date;
    private String summary;
    private Integer priorization;
    private Integer votes;

    @ManyToOne
    private Session session;

    //TODO: add security

    public Item(String headline) {
        this.headline = headline;
        this.summary = new String();
    }

    public Item(String headline, String summary) {
        this.headline = headline;
        this.summary = summary;
    }

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

    public Item(String headline, String summary, Session session) {
        this.headline = headline;
        this.summary = summary;
        this.session = session;
    }
}