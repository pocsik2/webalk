package iit.webalk.service;

import java.util.List;

import iit.webalk.entity.UserEntity;

public interface UserService {
	Iterable<UserEntity> listAllUser();
	void newUser(UserEntity newUser);
	void deleteUser(long id);
	void updateUser(long id, UserEntity newUser);
	UserEntity getOne(long id);
	List<UserEntity>findByLastName(String lastName);
	List<UserEntity>getUserOrderByFirstName();
	List<UserEntity>getUserFirstNameLikeYou();
	

}
