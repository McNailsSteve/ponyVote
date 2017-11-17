package de.stephannaegele.ponyVote.builders;

import de.stephannaegele.ponyVote.model.Item;
import de.stephannaegele.ponyVote.model.Session;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class SessionBuilder implements BaseBuilder {

    private Session session;

    public SessionBuilder() {
        this.session = new Session();
    }

    @Override
    public SessionBuilder withRandomId() {
        session.setId(ThreadLocalRandom.current().nextLong());
        return this;
    }

    @Override
    public SessionBuilder withId(Long id) {
        session.setId(id);
        return this;
    }

    public SessionBuilder withItems(int numberOfItems) {
        for (int i = 0; i < numberOfItems; i++) {
            session.addItem(new ItemBuilder().withRandomId().withRandomTestHeadline().withDateToday().get());
        }
        return this;
    }

    public SessionBuilder withItems(Set<Item> items) {
        session.setItems(items);
        return this;
    }

    @Override
    public Session get() {
        return session;
    }

    public SessionBuilder withHeadline(String headline) {
        session.setHeadline(headline);
        return this;
    }

    public SessionBuilder withSessionDate(LocalDate sessionDate) {
        session.setSessionDate(sessionDate);
        return this;
    }
}
