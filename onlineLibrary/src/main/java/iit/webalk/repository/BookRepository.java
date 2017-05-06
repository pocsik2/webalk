package iit.webalk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iit.webalk.entity.*;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long>{

}
