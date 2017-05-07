package iit.webalk.service;

import org.springframework.stereotype.Service;

import iit.webalk.entity.BorrowerEntity;

@Service
public interface BorrowerService {
	Iterable<BorrowerEntity> listAllBorrower();
	void newBorrower(BorrowerEntity newBorrower);

}
