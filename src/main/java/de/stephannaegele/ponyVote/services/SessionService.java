package de.stephannaegele.ponyVote.services;

import de.stephannaegele.ponyVote.model.Session;
import de.stephannaegele.ponyVote.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session getSession(Long sessionId) {
        return sessionRepository.findById(sessionId).get();
    }

    public Set<Session> getAllSessions() {
        return (Set<Session>) sessionRepository.findAll();
    }

}
