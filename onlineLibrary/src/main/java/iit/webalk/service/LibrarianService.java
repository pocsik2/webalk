package iit.webalk.service;

import iit.webalk.entity.LibrarianEntity;

public interface LibrarianService {

	Iterable<LibrarianEntity> listAllLibrarian();
	void newLibrarian(LibrarianEntity newLibrarian);
	void deleteLibrarian(Long libId);
}
