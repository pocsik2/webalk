package iit.webalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.webalk.entity.BorrowerEntity;
import iit.webalk.repository.BorrowerRepository;

@Service
public class BorrowerServiceImpl implements BorrowerService{
	BorrowerRepository borrowerRepository;
	
	@Autowired
	public BorrowerServiceImpl(BorrowerRepository borrowerRepository) {
		super();
		this.borrowerRepository = borrowerRepository;
	}

	public Iterable<BorrowerEntity> listAllBorrower(){
		return borrowerRepository.findAll();
	}
	
	public void newBorrower(BorrowerEntity newBorrower){
		borrowerRepository.save(newBorrower);
	}

}
