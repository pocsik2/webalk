package hu.me.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.dao.UserDao;
import hu.me.entity.UserEntity;
import hu.me.exception.AdminUserNotAllowed;
import hu.me.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Value("restricted_username")
	private String restrictedusername;
	private UserService userService;
	private UserDao userDao;
	
	@Autowired
	public UserController(UserService userService, UserDao userDao){
		super();
		this.userService = userService;
		this.userDao = userDao;
	}
	
	@GetMapping(path="", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<UserEntity> list(){
		return userService.listAllUser();	
	}
	
	@PostMapping(path="", consumes=MediaType.APPLICATION_JSON_VALUE)
	void createNew(@RequestBody UserEntity newUser){
		if (newUser.getFirstname().toUpperCase().equals("ADMIN")){
			throw new AdminUserNotAllowed();
		}
		userService.newUser(newUser);
	}
	
	@DeleteMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	void DeleteExist(@PathVariable("id") long id){
		userService.deleteUser(id);
	}
	
	@PutMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	void updateExisting(@PathVariable("id") long id, @RequestBody UserEntity newUser){
		userService.updateUser(id, newUser);
	}
	
	@GetMapping(path="/{id}")
	UserEntity one(@PathVariable("id") long id){
		return userService.getOne(id);
	}
	
	@GetMapping(path="/orderByFirstName", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<UserEntity> getUserOrderByFirstName(){
		return userService.getUserOrderByFirstName();
	}
	
	@GetMapping(path="/firstNameLikeYou")
	Iterable<UserEntity> getUserFirstNameLikeYou(){
		return userService.getUserFirstNameLikeYou();
	}
}
