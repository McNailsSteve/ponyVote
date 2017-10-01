package de.stephannaegele.demo.model;

import de.stephannaegele.demo.model.interfaces.PersistableEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

/**
 * the Entity for all items of a session
 * Created by NgS on 30.09.2017.
 */
@Entity
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

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getPriorization() {
        return priorization;
    }

    public void setPriorization(Integer priorization) {
        this.priorization = priorization;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Set<User> getVotees() {
        return votees;
    }

    public void setVotees(Set<User> votees) {
        this.votees = votees;
    }

    public Long getId() {
        return null;
    }

    @Override
    public LocalDate getCreationDate() {
        return null;
    }

    @Override
    public LocalDate getModifiedDate() {
        return null;
    }

    public User getCreator() {
        return null;
    }

    public User getEditor() {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
