package de.stephannaegele.ponyVote.controller;

import de.stephannaegele.ponyVote.domain.Session;
import de.stephannaegele.ponyVote.services.SessionService;
import de.stephannaegele.ponyVote.views.SessionView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Stephan Nägele
 */
@Controller
public class SessionController {

    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @RequestMapping("/sessions")
    @GetMapping
    public String getSessions(Model model) {

        model.addAttribute("sessions", sessionService.getAllSessions());
        return "sessionsView";

    }

    @RequestMapping("/session/{sessionId}")
    @GetMapping
    public String getSession(@PathVariable Long sessionId,Model model){

        SessionView sessionView = new SessionView(sessionService.getSession(sessionId));
        model.addAttribute("session", sessionView);
        return "session";
    }

    @RequestMapping("/session/new")
    @GetMapping
    public String showNewSession(Model model) {
        SessionView view = new SessionView();
        model.addAttribute("session", view );

        return "session/addEditSession";
    }

    @RequestMapping("/session/")
    @PutMapping
    public String addSession(Model model, SessionView view) {
        Session newSession = view.mapTo();
        Session savedSession = sessionService.save(newSession);
        view.mapFrom(savedSession);
        model.addAttribute("session", view);
        return "session/" + savedSession.getId().toString();
    }

}
