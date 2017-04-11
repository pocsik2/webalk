package hu.me.service;

import hu.me.entity.UserEntity;

public interface UserService {
	Iterable<UserEntity> listAllUser();
	void newUser(UserEntity newUser);
	void deleteUser(long id);
//	void updateUser(long id);
	
}
