package de.stephannaegele.ponyVote.views;

import de.stephannaegele.ponyVote.domain.Session;

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
