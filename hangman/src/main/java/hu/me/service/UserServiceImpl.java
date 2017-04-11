package hu.me.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.me.entity.UserEntity;
import hu.me.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	public Iterable<UserEntity> listAllUser() {
		return userRepository.findAll();
	}
	public void newUser(UserEntity newUser){
		userRepository.save(newUser);
	}
	@Override
	public void deleteUser(long id){
		userRepository.delete(id);
	}
	
//	@Override
//	public void updateUser(long id){
//		userRepository.update(id);
//	}
	
}
