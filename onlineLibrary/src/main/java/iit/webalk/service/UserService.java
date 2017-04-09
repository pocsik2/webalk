package iit.webalk.service;

import java.util.*;

import iit.webalk.modell.User;

public interface UserService {
	List<User> listAllUser();
	void newUser(User newUser);
	void deleteUser(long id);
//	User loadUserById(Long userId);

}
