package de.stephannaegele.ponyVote.repository;

import de.stephannaegele.ponyVote.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by NgS on 01.10.2017.
 */
public interface UserRepository extends CrudRepository<User, Long>{
}
