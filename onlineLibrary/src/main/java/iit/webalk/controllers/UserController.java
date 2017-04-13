package iit.webalk.controllers;

import org.springframework.http.MediaType;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iit.webalk.entity.UserEntity;
import iit.webalk.exception.AdminUserNotAllowed;
import iit.webalk.modell.User;
import iit.webalk.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}
	
	@GetMapping(path = "", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<UserEntity> list(){
		return userService.listAllUser();
	}
	
	@PostMapping(path = "", consumes=MediaType.APPLICATION_JSON_VALUE)
	void createNew(@RequestBody UserEntity newUser) {
		if (newUser.getFirstname().toUpperCase().equals("ADMIN")){
			throw new AdminUserNotAllowed();
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
	
	
}