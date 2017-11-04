package de.stephannaegele.ponyVote.views;

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

    private String headline;
    private LocalDate sessionDate;
    private Set<Item> sessionItems;

    public SessionView(Session session) {
        this.headline = session.getHeadline();
        this.sessionDate = session.getSessionDate();
        this.sessionItems = session.getSessionItems();
    }

    @Override
    public Session mapTo() {
        Session session = new Session();
        session.setHeadline(headline);
        session.setSessionDate(sessionDate);
        session.setSessionItems(sessionItems);
        return session;
    }

    @Override
    public void mapFrom(Session session) {
        this.headline = session.getHeadline();
        this.sessionDate = session.getSessionDate();
        this.sessionItems = session.getSessionItems();
    }
}
