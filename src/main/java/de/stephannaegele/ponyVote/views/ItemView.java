package de.stephannaegele.ponyVote.views;

import de.stephannaegele.ponyVote.domain.Item;

public class ItemView {

    private Item item;

    public ItemView(Item item) {
        this.item = item;
    }

    public String getHeadline() {
        return item.getHeadline();
    }

    public String getId() {
        return item.getId().toString();
    }
}
