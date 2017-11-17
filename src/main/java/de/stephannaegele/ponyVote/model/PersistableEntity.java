package de.stephannaegele.ponyVote.model;

import java.time.LocalDate;
/**
 * PersistableEntity for Entity-Elements
 * Created by NgS on 30.09.2017.
 */
public interface PersistableEntity {
        Long getId();
        LocalDate getCreationDate();
        LocalDate getModifiedDate();

        int hashCode();
        boolean equals(Object o);
}
