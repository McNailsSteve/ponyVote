package de.stephannaegele.ponyVote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

/**
 * The Entity for Sessions of any kind
 * Created by NgS on 30.09.2017.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String headline;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    private Set<Item> items = new HashSet<>();

    private Boolean votingClosed;
    private Boolean concluded;

    private String creator;

    private LocalDate sessionDate;
    private LocalTime sessionStartTime;
    private LocalTime sessionEndTime;

    private LocalDate creationDate;
    private LocalDate modifiedDate;

    public Session(String headline, Set<Item> items) {
        this.headline = headline;
        this.items = items;
    }

    public Session addItem(Item item) {
        item.setSession(this);
        items.add(item);
        return this;
    }

}