package hu.me.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.entity.UserEntity;
import hu.me.exception.AdminUserNotAllowed;
import hu.me.model.User;
import hu.me.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
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
	void updateExisting(@PathVariable("id") long id, @RequestBody User newUser){
		//userService.updateUser(id);
	}
	
	//modifyUser();
//	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public UserEntity showOne(int id){
//	Iterable<UserEntity> list();
//		
//	}
	
}
