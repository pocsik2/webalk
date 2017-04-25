package hu.me.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.me.dao.UserDao;
import hu.me.entity.UserEntity;
import hu.me.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	UserRepository userRepository;
	UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserDao userDao) {
		super();
		this.userRepository = userRepository;
		this.userDao = userDao;
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
	
	@Override
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
	
	@Override
	public List<UserEntity> findByLastName(String lastName){
		return userRepository.findByLastName(lastName);
	}
	
	@Override
	public List<UserEntity> getUserOrderByFirstName(){
		return userDao.getUserOrderByFirstNameDesc();
	}
	
	@Override
	public List<UserEntity> getUserFirstNameLikeYou() {
		return userDao.getUserFirstNameLikeYou();
	}
	
}