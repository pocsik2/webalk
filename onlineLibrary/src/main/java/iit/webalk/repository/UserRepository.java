package iit.webalk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iit.webalk.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{

}
