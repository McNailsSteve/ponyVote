package de.stephannaegele.ponyVote.views;

import de.stephannaegele.ponyVote.model.Session;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class SessionView  {
    private Session session;

    public SessionView(Session session) {
        this.session = session;
    }

    public String getHeadline() {
        return session.getHeadline();
    }

    public String getDate() {
        return session.getSessionDate().toString();
    }



}
