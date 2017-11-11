package de.stephannaegele.ponyVote.views;

import de.stephannaegele.ponyVote.builders.ItemBuilder;
import de.stephannaegele.ponyVote.domain.Item;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@EqualsAndHashCode
@Setter
@Getter
public class ItemView implements BaseView<Item> {

    private Long id;
    private String headline;
    private LocalDate date;
    private String summary;

    public ItemView(Item item) {
        id = item.getId();
        headline = item.getHeadline();
        date = item.getDate();
        summary = item.getSummary();
    }


    @Override
    public Item mapTo() {
        return new ItemBuilder().withId(id)
                .withHeadline(getHeadline())
                .withDate(getDate())
                .get();
    }

    @Override
    public void mapFrom(Item item) {
        this.id = item.getId();
        this.headline = item.getHeadline();
        this.date = item.getDate();
    }
}
