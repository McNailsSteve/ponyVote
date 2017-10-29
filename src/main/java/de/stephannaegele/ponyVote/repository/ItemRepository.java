package de.stephannaegele.ponyVote.repository;

import de.stephannaegele.ponyVote.domain.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by NgS on 01.10.2017.
 */
public interface ItemRepository extends CrudRepository<Item, Long> {
}
