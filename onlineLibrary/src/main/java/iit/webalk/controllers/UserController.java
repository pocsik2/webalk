package iit.webalk.controllers;

import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iit.webalk.dao.UserDao;
import iit.webalk.entity.UserEntity;
import iit.webalk.exception.AdminUserNotAllowed;
import iit.webalk.exception.UsernameOrEmailAdressAlreadyExistException;
import iit.webalk.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Value("restricted_username")
	private String restrictidusername;
	private UserService userService;
	private UserDao userDao;
	
	@Autowired
	public UserController(UserService userService, UserDao userDao){
		super();
		this.userService = userService;
		this.userDao = userDao;
		
	}
	
	@GetMapping(path = "", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<UserEntity> list(){
		return userService.listAllUser();
	}
	
	@PostMapping(path = "", consumes=MediaType.APPLICATION_JSON_VALUE)
	void createNew(@RequestBody UserEntity newUser) {
		if (newUser.getFirstName().toUpperCase().equals("ADMIN")){
			throw new AdminUserNotAllowed();
		}
		if (userService.checkForUsernameAndEmail(newUser.getUserName(), newUser.getEmailAddress())){
			throw new UsernameOrEmailAdressAlreadyExistException();
		}
		userService.newUser(newUser);
	}
	
	@DeleteMapping(path = "/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	void deleteExisting(@PathVariable("id")long id) {
		userService.deleteUser(id);
	}
	
	@PutMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	void updateExisting(@PathVariable("id")long id, @RequestBody UserEntity newUser) {
		userService.updateUser(id, newUser);
	}
	@GetMapping(path="/{id}")
	UserEntity one(@PathVariable("id") long id, @RequestBody UserEntity newUser){
		return userService.getOne(id);
	}
	
	@GetMapping(path = "byLastName/{lastName}")
	List<UserEntity> findByLastName(@PathVariable("lastName") String lastName) {
		return userService.findByLastName(lastName);
	}
	
	@GetMapping(path = "/orderByFirstName", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<UserEntity> getUserOrderByFirstName(){
		return userService.getUserOrderByFirstName();
	}
	
	@GetMapping(path = "/firstNameLikeYou")
	Iterable<UserEntity> getUserFirstNameLikeYou(){
		return userService.getUserFirstNameLikeYou();
	}
	
}