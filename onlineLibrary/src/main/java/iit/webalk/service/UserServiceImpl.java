package iit.webalk.service;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import iit.webalk.modell.User;
import iit.webalk.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private List<User> users = new ArrayList<>();
	
	@PostConstruct
	void initUserList() {
		users.add(new User("Bela", 0));
		users.add(new User("Yuli", 1));
		users.add(new User("Marci", 2));
	}

	@Override
	public List<User> listAllUser() {
		return users;
	}

	@Override
	public void newUser(User newUser) {
		users.add(newUser);
	}

	@Override
	public void deleteUser(long id) {
		for (User user: users) {
			if(user.getId() == id) {
				users.remove(user);
				break;
			}
		}
	}

}