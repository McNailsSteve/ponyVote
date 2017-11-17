package de.stephannaegele.ponyVote.bootstrap;

import de.stephannaegele.ponyVote.model.Item;
import de.stephannaegele.ponyVote.model.Session;
import de.stephannaegele.ponyVote.repository.ItemRepository;
import de.stephannaegele.ponyVote.repository.SessionRepository;
import de.stephannaegele.ponyVote.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NgS on 01.10.2017.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final SessionRepository sessionRepository;

    public DevBootstrap(UserRepository userRepository, ItemRepository itemRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.sessionRepository = sessionRepository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        sessionRepository.saveAll(getSessions());
    }

    private List<Session> getSessions() {

        List<Session> sessions = new ArrayList<>(2);

        Session firstSession = new Session();
        firstSession.setHeadline("Erste ETV");
        firstSession.setSessionDate(LocalDate.now());
        firstSession.addItem(new Item("Erster TOP", LocalDate.now(), "Lirum Larum Löffelstiel"));

        Session secondSession = new Session();
        secondSession.setHeadline("Zweite ETV");
        secondSession.addItem(new Item("Neues TOP", "irgendwas"));
        secondSession.addItem(new Item("zweites TOPOP", "sonstwas"));
        secondSession.addItem(new Item("Das bekommt jetzt keiner!", "Weil ich es so will und einfach selbstsüchtig bin"));

        sessions.add(firstSession);
        sessions.add(secondSession);

        return sessions;
    }
}
