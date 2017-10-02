package de.stephannaegele.demo.bootstrap;

import de.stephannaegele.demo.model.Item;
import de.stephannaegele.demo.model.Session;
import de.stephannaegele.demo.model.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.HashSet;

/**
 * Created by NgS on 01.10.2017.
 */
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
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



        //Base-Session
        Session first = new Session("First", new HashSet<Item>());
        first.addItem(firstI);
        first.addItem(secondItem);


    }
}
