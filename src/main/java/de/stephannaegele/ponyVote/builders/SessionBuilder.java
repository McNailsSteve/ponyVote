package de.stephannaegele.ponyVote.builders;

import de.stephannaegele.ponyVote.interfaces.BaseBuilder;
import de.stephannaegele.ponyVote.model.Item;
import de.stephannaegele.ponyVote.model.Session;
import sun.nio.cs.ext.IBM037;

import javax.xml.ws.Service;
import java.util.concurrent.ThreadLocalRandom;

public class SessionBuilder implements BaseBuilder {

    private Session session;

    public SessionBuilder() {
        this.session = new Session();
    }

    @Override
    public BaseBuilder withRandomId() {
        session.setId(ThreadLocalRandom.current().nextLong());
        return this;
    }

    @Override
    public BaseBuilder withId(Long id) {
        session.setId(id);
        return this;
    }

    public BaseBuilder withItems(int numberOfItems) {
        for (int i = 0; i < numberOfItems; i++) {
            session.addItem(new ItemBuilder().withRandomId().withRandomTestHeadline().withDateToday().get());
        }
        return this;
    }

    @Override
    public Session get() {
        return session;
    }
}
