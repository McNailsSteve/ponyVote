package de.stephannaegele.ponyVote.controller;

import de.stephannaegele.ponyVote.repository.SessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Stephan Nägele
 */
public class SessionController {

    private SessionRepository sessionRepository;

    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @RequestMapping("/sessions")
    public String getSessions(Model model) {

        model.addAttribute("sessions", sessionRepository.findAll());

        return "sessions";

    }
}
