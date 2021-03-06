package de.stephannaegele.ponyVote.services;

import de.stephannaegele.ponyVote.model.Session;
import de.stephannaegele.ponyVote.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class SessionService {

    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session getSession(Long sessionId) {
        Optional<Session> sessionOptional = sessionRepository.findById(sessionId);
        return sessionOptional.isPresent()?sessionOptional.get():new Session();
    }

    public Set<Session> getAllSessions() {
        return (Set<Session>) sessionRepository.findAll();
    }

    public Session save(Session session) {
        return sessionRepository.save(session);
    }
}
