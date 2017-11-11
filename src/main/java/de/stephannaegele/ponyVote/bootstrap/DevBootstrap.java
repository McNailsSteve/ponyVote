package de.stephannaegele.ponyVote.bootstrap;

import de.stephannaegele.ponyVote.domain.Item;
import de.stephannaegele.ponyVote.domain.Session;
import de.stephannaegele.ponyVote.domain.User;
import de.stephannaegele.ponyVote.repository.ItemRepository;
import de.stephannaegele.ponyVote.repository.SessionRepository;
import de.stephannaegele.ponyVote.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

/**
 * Created by NgS on 01.10.2017.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private ItemRepository itemRepository;
    private SessionRepository sessionRepository;

    public DevBootstrap(UserRepository userRepository, ItemRepository itemRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.sessionRepository = sessionRepository;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // First User
        User stephan = new User("Nägele", "Stephan", "snaegele");
        // Second User
        User darth = new User("Vader", "Darth", "darklord");

        // First Item
        Item firstItem = new Item("wichtiges TOP", LocalDate.now(), "Das bewegt uns alle!");
        // 2nd Item
        Item secondItem = new Item("Make our voices heard!", LocalDate.now().minusDays(1), "Es fehlt eine Abstimmungsapp!");

        Session firstSession = new Session();
        firstSession.setHeadline("erste ETW");

        sessionRepository.save(firstSession);

        firstSession.addItem(firstItem);

        sessionRepository.save(firstSession);


    }
}
