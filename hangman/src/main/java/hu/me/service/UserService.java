package hu.me.service;

import java.util.List;

import hu.me.entity.UserEntity;

public interface UserService {
	Iterable<UserEntity> listAllUser();
	void newUser(UserEntity newUser);
	void deleteUser(long id);
	void updateUser(long id, UserEntity newUser);
	UserEntity getOne(long id);
	List<UserEntity>findByLastName(String lastName);
	List<UserEntity>getUserOrderByFirstName();
//	List<UserEntity>getUserOrderByLastName();
	List<UserEntity>getUserFirstNameLikeYou();
}
