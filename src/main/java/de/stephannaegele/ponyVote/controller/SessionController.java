package de.stephannaegele.ponyVote.controller;

import de.stephannaegele.ponyVote.services.SessionService;
import de.stephannaegele.ponyVote.views.SessionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Stephan Nägele
 */
public class SessionController {

    @Autowired
    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @RequestMapping("/sessions")
    public String getSessions(Model model) {

        model.addAttribute("sessions", sessionService.getAllSessions());
        return "sessionsView";

    }

    @RequestMapping("/session/{sessionId}")
    public String getSession(@PathVariable Long sessionId, SessionView sessionView, Model model){

        sessionView = new SessionView(sessionService.getSession(sessionId));
        model.addAttribute("session", sessionView);
        return "session";
    }
}
