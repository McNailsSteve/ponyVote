package de.stephannaegele.ponyVote.views;

import de.stephannaegele.ponyVote.builders.SessionBuilder;
import de.stephannaegele.ponyVote.domain.Item;
import de.stephannaegele.ponyVote.domain.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionView implements BaseView<Session> {

    private Long id;
    private String headline;
    private LocalDate sessionDate;
    private Set<Item> sessionItems;

    public SessionView(Session session) {
        this.id = session.getId();
        this.headline = session.getHeadline();
        this.sessionDate = session.getSessionDate();
        this.sessionItems = session.getSessionItems();
    }

    @Override
    public Session mapTo() {
        return new SessionBuilder().withId(id)
                                   .withHeadline(headline)
                                   .withSessionDate(sessionDate)
                                   .withItems(sessionItems)
                                    .get();
    }

    @Override
    public void mapFrom(Session session) {
        this.headline = session.getHeadline();
        this.sessionDate = session.getSessionDate();
        this.sessionItems = session.getSessionItems();
    }

    public boolean isNew() {
        return id == null;
    }

    public String getHeadline() {
        return headline;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public Set<Item> getSessionItems() {
        return sessionItems;
    }
}
