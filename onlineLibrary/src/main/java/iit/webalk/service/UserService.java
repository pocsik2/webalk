package iit.webalk.service;

import iit.webalk.entity.UserEntity;

public interface UserService {
	Iterable<UserEntity> listAllUser();
	void newUser(UserEntity newUser);
	void deleteUser(long id);
	void updateUser(long id, UserEntity newUser);
	UserEntity getOne(long id);
//	User loadUserById(Long userId);

}
