package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Create by lh on 10/17/18
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
