package be.project28.spring5webapp.repositories;

import be.project28.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
}
