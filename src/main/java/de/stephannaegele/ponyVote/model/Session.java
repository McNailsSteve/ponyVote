package de.stephannaegele.ponyVote.model;

import de.stephannaegele.ponyVote.interfaces.PersistableEntity;
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
public class Session implements PersistableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String headline;

    @OneToMany(mappedBy = "session")
    private Set<Item> items;

    private Boolean votingClosed;
    private Boolean concluded;

    private String creator;

    private LocalDate sessionDate;
    private LocalTime sessionStartTime;
    private LocalTime sessionEndTime;

    private LocalDate creationDate;
    private LocalDate modifiedDate;

    public Session() {
        items = new HashSet<>();
    }

    public Session(String headline, Set<Item> items) {
        this.headline = headline;
        this.items = items;
    }


    public void addItem(Item item) {
        items.add(item);
    }



}
