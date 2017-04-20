package iit.webalk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iit.webalk.entity.LibrarianEntity;

@Repository
public interface LibrarianRepository extends CrudRepository<LibrarianEntity, Long>{

}
