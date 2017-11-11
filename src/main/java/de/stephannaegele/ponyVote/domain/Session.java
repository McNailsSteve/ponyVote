package de.stephannaegele.ponyVote.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The Entity for Sessions of any kind
 * Created by NgS on 30.09.2017.
 */
@Entity
@Data
@AllArgsConstructor
public class Session implements PersistableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String headline;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    private Set<Item> sessionItems;

    private Boolean votingClosed;
    private Boolean concluded;

    private String creator;

    private LocalDate sessionDate;
    private LocalTime sessionStartTime;
    private LocalTime sessionEndTime;

    private LocalDate creationDate;
    private LocalDate modifiedDate;

    public Session() {
        sessionItems = new HashSet<>();
    }

    public Session(String headline, Set<Item> sessionItems) {
        this.headline = headline;
        this.sessionItems = sessionItems;
    }

    public void addItem(Item item) {
        if (sessionItems != null) {
            sessionItems.add(item);
        }
    }

}
