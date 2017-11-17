package de.stephannaegele.ponyVote.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;



/**
 * the Entity for all sessionItems of a session
 * Created by NgS on 30.09.2017.
 */
@Data
@EqualsAndHashCode(exclude = {"session"})
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String headline;
    private String summary;
    private LocalDate date;


    @ManyToOne
    private Session session;

    public Item() {
    }

    public Item(Long id, String headline, String summary, LocalDate date, Session session) {
        this.id = id;
        this.headline = headline;
        this.summary = summary;
        this.date = date;
        this.session = session;
    }

    public Item(String headline, String summary, Session session) {
        this.headline = headline;
        this.summary = summary;
        this.session = session;
    }

    public Item(String headline, String summary) {
        this.headline = headline;
        this.summary = summary;
    }

    public Item(String headline) {
        this.headline = headline;
    }

    public Item(Long id, String headline, String summary, LocalDate date) {
        this.id = id;
        this.headline = headline;
        this.summary = summary;
        this.date = date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

