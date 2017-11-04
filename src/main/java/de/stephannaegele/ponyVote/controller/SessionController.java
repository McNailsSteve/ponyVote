package de.stephannaegele.ponyVote.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import de.stephannaegele.ponyVote.domain.Session;
import de.stephannaegele.ponyVote.services.SessionService;
import de.stephannaegele.ponyVote.views.SessionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.attribute.standard.Severity;
import java.time.LocalDate;

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

}
