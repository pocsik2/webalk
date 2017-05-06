package iit.webalk.service;

import org.springframework.stereotype.Service;

import iit.webalk.entity.BookEntity;

@Service
public interface BookService {
	Iterable<BookEntity> listAllBook();
	void newBook(BookEntity newBook);
	

}
