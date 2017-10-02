package de.stephannaegele.demo.repository;

import de.stephannaegele.demo.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by NgS on 01.10.2017.
 */
public interface UserRepository extends CrudRepository<User, Long>{
}
