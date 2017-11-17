package de.stephannaegele.ponyVote.bootstrap;

import de.stephannaegele.ponyVote.model.Item;
import de.stephannaegele.ponyVote.model.Session;
import de.stephannaegele.ponyVote.repository.ItemRepository;
import de.stephannaegele.ponyVote.repository.SessionRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ItemRepository itemRepository;
    private final SessionRepository sessionRepository;

    public DevBootstrap(ItemRepository itemRepository, SessionRepository sessionRepository) {
        this.itemRepository = itemRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        sessionRepository.saveAll(getSessions());

    }

    public List<Session> getSessions() {
        List<Session> sessions = new ArrayList<>(2);


        Session firstSession = new Session();
        firstSession.setHeadline("ETW 1");
        firstSession.addItem(new Item("TOP1", "test"));
        firstSession.addItem(new Item("TOP2", "test2"));

        sessions.add(firstSession);

        //Yummy Tacos
        Session secondSession = new Session("ETW2");
        secondSession.addItem(new Item("TOP2-1", "blah"));
        secondSession.addItem(new Item("TOP2-2", "blah2"));
        secondSession.addItem(new Item("TOP2-3", "blah3"));
        secondSession.addItem(new Item("TOP2-4", "blah4"));
        sessions.add(secondSession);

        return sessions;
    }
}
