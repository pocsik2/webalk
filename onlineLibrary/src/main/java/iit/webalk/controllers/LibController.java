package iit.webalk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iit.webalk.entity.LibrarianEntity;
import iit.webalk.exception.AdminUserNotAllowed;
import iit.webalk.service.LibrarianService;

@RestController
@RequestMapping("/librarian")
public class LibController {

	private LibrarianService librarianService;

	@Autowired
	public LibController(LibrarianService librarianService) {
		super();
		this.librarianService = librarianService;
	}
	
	@GetMapping(path = "", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<LibrarianEntity> list(){
		return librarianService.listAllLibrarian();
	}
	
	@PostMapping(path = "", consumes=MediaType.APPLICATION_JSON_VALUE)
	void createNew(@RequestBody LibrarianEntity newLibrarian) {
		if (newLibrarian.getName().toUpperCase().equals("ADMIN")){
			throw new AdminUserNotAllowed();
		}
		librarianService.newLibrarian(newLibrarian);
	}
	
	@DeleteMapping(path = "/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	void deleteExisting(@PathVariable("libId")long libId) {
		librarianService.deleteLibrarian(libId);
	}
	
}
