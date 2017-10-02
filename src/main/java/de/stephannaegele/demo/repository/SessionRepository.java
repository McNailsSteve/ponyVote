package de.stephannaegele.demo.repository;

import de.stephannaegele.demo.model.Session;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by NgS on 01.10.2017.
 */
public interface SessionRepository extends CrudRepository<Session, Long> {
}
