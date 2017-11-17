package de.stephannaegele.ponyVote.commands;

import de.stephannaegele.ponyVote.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemFormView implements FormView {

    private Long id;
    private String headline;
    private String summary;
    private LocalDate date;

    public ItemFormView(Item item) {
        this.id = item.getId();
        this.headline = item.getHeadline();
        this.summary = item.getSummary();
        this.date = item.getDate();
    }

    @Override
    @Nullable
    @Synchronized
    public Item mapTo() {
        if (date == null ) {
            this.date = LocalDate.now();
        }
        return new Item(id, headline, summary, date);
    }
}
