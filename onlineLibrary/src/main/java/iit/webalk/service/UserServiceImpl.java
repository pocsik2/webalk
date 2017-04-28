package iit.webalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.webalk.repository.UserRepository;
import iit.webalk.dao.UserDao;
import iit.webalk.entity.UserEntity;
import iit.webalk.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	UserRepository userRepository;
	UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserDao userDao){
		super();
		this.userRepository = userRepository;
		this.userDao = userDao;
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
		entity.setFirstName(newUser.getFirstName());
		entity.setFirstName(newUser.getFirstName());
		userRepository.save(entity);
	}
	@Override
	public UserEntity getOne(long id){
		return userRepository.findOne(id);
	}
	
	@Override
	public List<UserEntity> findByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
	}

	@Override
	public List<UserEntity> getUserOrderByFirstName() {
		return userDao.getUserOrderByFirstNameDesc();
	}

	@Override
	public List<UserEntity> getUserFirstNameLikeYou() {
		return userDao.getUserFirstNameLikeYou();
	}

}