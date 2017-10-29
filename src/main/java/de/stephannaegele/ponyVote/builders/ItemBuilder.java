package de.stephannaegele.ponyVote.builders;

import de.stephannaegele.ponyVote.domain.Item;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class ItemBuilder implements BaseBuilder {

    private Item item;

    public ItemBuilder() {
        item = new Item();
    }

    public ItemBuilder(Item item) {
        this.item = item;
    }

    @Override
    public ItemBuilder withRandomId() {
        item.setId(ThreadLocalRandom.current().nextLong());
        return this;
    }

    @Override
    public ItemBuilder withId(Long id) {
        item.setId(id);
        return this;
    }

    public ItemBuilder withHeadline(String headline) {
        item.setHeadline(headline);
        return this;
    }

    public ItemBuilder withRandomTestHeadline() {
        item.setHeadline("Test" + ThreadLocalRandom.current().nextInt());
        return this;
    }

    public ItemBuilder withDate(LocalDate date) {
        item.setDate(date);
        return this;
    }

    public ItemBuilder withDateToday() {
        item.setDate(LocalDate.now());
        return this;
    }

    @Override
    public Item get() {
        return item;
    }
}
