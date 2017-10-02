package de.stephannaegele.ponyVote.model;

import de.stephannaegele.ponyVote.interfaces.PersistableEntity;

import javax.persistence.*;
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

    //TODO: add security

    public Item(String headline, LocalDate date, String summary) {
        this.headline = headline;
        this.date = date;
        this.summary = summary;
    }

    public Item(String headline, LocalDate date, String summary, User createdBy) {
        this.headline = headline;
        this.date = date;
        this.summary = summary;

    }

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

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public LocalDate getCreationDate() {
        return null;
    }

    @Override
    public LocalDate getModifiedDate() {
        return null;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (headline != null ? !headline.equals(item.headline) : item.headline != null) return false;
        if (date != null ? !date.equals(item.date) : item.date != null) return false;
        if (summary != null ? !summary.equals(item.summary) : item.summary != null) return false;
        if (priorization != null ? !priorization.equals(item.priorization) : item.priorization != null) return false;
        if (votes != null ? !votes.equals(item.votes) : item.votes != null) return false;
        if (session != null ? !session.equals(item.session) : item.session != null) return false;
        return votees != null ? votees.equals(item.votees) : item.votees == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (headline != null ? headline.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (priorization != null ? priorization.hashCode() : 0);
        result = 31 * result + (votes != null ? votes.hashCode() : 0);
        result = 31 * result + (session != null ? session.hashCode() : 0);
        result = 31 * result + (votees != null ? votees.hashCode() : 0);
        return result;
    }
}
