package de.stephannaegele.ponyVote.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * The Entity for Sessions of any kind
 * Created by NgS on 30.09.2017.
 */
@Data
@Entity
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String headline;
    private LocalDate sessionDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    private Set<Item> sessionItems = new HashSet<>();

    public Session(String headline, LocalDate sessionDate, Set<Item> ingredients) {
        this.headline = headline;
        this.sessionDate = sessionDate;
        this.sessionItems = ingredients;
    }

    public Session(String headline, LocalDate sessionDate) {
        this.headline = headline;
        this.sessionDate = sessionDate;
    }

    public Session(String headline) {
        this.headline = headline;
    }

    public Set<Item> getItems() {
        return sessionItems;
    }

    public Session addItem(Item item) {
        item.setSession(this);
        this.sessionItems.add(item);
        return this;
    }
}
