package iit.webalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.webalk.entity.LibrarianEntity;

import iit.webalk.repository.LibrarianRepository;

@Service
public class LibrarianServiceImpl implements LibrarianService{
	
	LibrarianRepository librarianRepository;

	@Autowired
	public LibrarianServiceImpl(LibrarianRepository librarianRepository) {
		super();
		this.librarianRepository = librarianRepository;
	}
	
	public Iterable<LibrarianEntity> listAllLibrarian() {
		return librarianRepository.findAll();
	}
	
	public void newLibrarian(LibrarianEntity newLibrarian){
		librarianRepository.save(newLibrarian);
	}
	
	public void deleteLibrarian(Long libId){
		librarianRepository.delete(libId);
	}

}
