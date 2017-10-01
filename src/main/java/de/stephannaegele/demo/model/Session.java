package de.stephannaegele.demo.model;

import de.stephannaegele.demo.model.interfaces.PersistableEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

/**
 * The Entity for Sessions of any kind
 * Created by NgS on 30.09.2017.
 */
@Entity
public class Session implements PersistableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String headline;
    @OneToMany(mappedBy = "session")
    private Set<Item> items;

    private boolean votingClosed;
    private boolean concluded;

    @OneToOne
    private User creator;

    private LocalDate sessionDate;
    private LocalTime sessionStartTime;
    private LocalTime sessionEndTime;

    private LocalDate creationDate;
    private LocalDate modifiedDate;

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public LocalTime getSessionStartTime() {
        return sessionStartTime;
    }

    public void setSessionStartTime(LocalTime sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }

    public LocalTime getSessionEndTime() {
        return sessionEndTime;
    }

    public void setSessionEndTime(LocalTime sessionEndTime) {
        this.sessionEndTime = sessionEndTime;
    }

    public boolean isVotingClosed() {
        return votingClosed;
    }

    public void setVotingClosed(boolean votingClosed) {
        this.votingClosed = votingClosed;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public void setConcluded(boolean concluded) {
        this.concluded = concluded;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        return id.equals(session.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
