package de.stephannaegele.ponyVote.views;

import de.stephannaegele.ponyVote.model.Item;

public class ItemView {

    private Item item;

    public ItemView(Item item) {
        this.item = item;
    }

    public String getHeadline() {
        return item.getHeadline();
    }
}
