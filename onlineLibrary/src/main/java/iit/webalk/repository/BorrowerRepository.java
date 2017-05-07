package iit.webalk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iit.webalk.entity.BorrowerEntity;

@Repository
public interface BorrowerRepository extends CrudRepository<BorrowerEntity, Long>{

}
