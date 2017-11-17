package de.stephannaegele.ponyVote.views;

import de.stephannaegele.ponyVote.builders.SessionBuilder;
import de.stephannaegele.ponyVote.model.Item;
import de.stephannaegele.ponyVote.model.Session;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode
@Setter
@Getter
@Data
public class SessionView implements BaseView<Session> {

    private Long id;
    @NonNull
    private String headline;
    private LocalDate sessionDate;
    private Set<ItemView> sessionItems;

    public SessionView(Session session) {
        this.id = session.getId();
        this.headline = session.getHeadline();
        this.sessionDate = session.getSessionDate();
        this.sessionItems = session.getItems().stream()
                                                        .map(sessionItem -> new ItemView(sessionItem))
                                                        .collect(Collectors.toSet());
    }

    public SessionView(Long id, String headline, LocalDate sessionDate, Set<ItemView> sessionItems) {
        this.id = id;
        this.headline = headline;
        this.sessionDate = sessionDate;
        this.sessionItems = sessionItems;
    }

    public SessionView(Long id, String headline, String sessionDate, Set<ItemView> sessionItems) {
        this.id = id;
        this.headline = headline;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.sessionDate = LocalDate.parse(sessionDate, formatter);
        this.sessionItems = sessionItems;
    }

    public SessionView() {
    }

    @Override
    public Session mapTo() {
        SessionBuilder sessionBuilder =  new SessionBuilder().withId(id)
                                                             .withHeadline(headline)
                                                             .withSessionDate(sessionDate);
        if (sessionItems != null) {
            sessionBuilder.withItems(
                sessionItems.stream()
                    .filter(Objects::nonNull)
                    .map(itemView -> new Item(Long.valueOf(itemView.getId()),
                            itemView.getHeadline(),
                            itemView.getSummary(),
                            itemView.getDate())).collect(Collectors.toSet()));
        }
        return sessionBuilder.get();
    }

    @Override
    public void mapFrom(Session session) {
        this.headline = session.getHeadline();
        this.sessionDate = session.getSessionDate();
        this.sessionItems = session.getItems().stream()
                                                     .map(item -> new ItemView(item))
                                                     .collect(Collectors.toSet());
    }

    public boolean isNew() {
        return id == null;
    }

}
