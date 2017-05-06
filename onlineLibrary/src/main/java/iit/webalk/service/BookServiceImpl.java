package iit.webalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.webalk.entity.BookEntity;
import iit.webalk.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	 BookRepository bookRepositroy;

	 @Autowired
	 public BookServiceImpl(BookRepository bookRepositroy) {
	   	super();
		this.bookRepositroy = bookRepositroy;
	 }
	
	 @Override
	 public Iterable<BookEntity> listAllBook(){
		return bookRepositroy.findAll();
	 }
	 
	 public void newBook(BookEntity newBook){
		 bookRepositroy.save(newBook);
	 }

	

}
