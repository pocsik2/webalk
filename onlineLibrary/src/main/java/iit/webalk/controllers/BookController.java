package iit.webalk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iit.webalk.entity.BookEntity;
import iit.webalk.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping(path = "", produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<BookEntity> list(){
		return bookService.listAllBook();
	}
	
	@PostMapping(path = "", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody BookEntity newBook){
		bookService.newBook(newBook);
	}
}
