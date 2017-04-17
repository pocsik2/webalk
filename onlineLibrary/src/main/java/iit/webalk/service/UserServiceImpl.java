package iit.webalk.service;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.webalk.repository.UserRepository;
import iit.webalk.entity.UserEntity;
import iit.webalk.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	iit.webalk.repository.UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		super();
		this.userRepository = userRepository;
	}

	public Iterable<UserEntity> listAllUser() {
		return userRepository.findAll();
	}

	public void newUser(UserEntity newUser) {
		userRepository.save(newUser);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.delete(id);
	}
	public void updateUser(long id, UserEntity newUser){
		UserEntity entity = userRepository.findOne(id);
		entity.setFirstname(newUser.getFirstname());
		entity.setLastname(newUser.getLastname());
		userRepository.save(entity);
	}
	@Override
	public UserEntity getOne(long id){
		return userRepository.findOne(id);
	}

}