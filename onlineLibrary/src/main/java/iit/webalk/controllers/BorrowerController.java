package iit.webalk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iit.webalk.entity.BorrowerEntity;
import iit.webalk.service.BorrowerService;

@RestController
@RequestMapping("/borrower")
public class BorrowerController {
	
	private BorrowerService borrowerService;

	@Autowired
	public BorrowerController(BorrowerService borrowerService) {
		super();
		this.borrowerService = borrowerService;
	}
	
	@GetMapping(path = "", produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<BorrowerEntity> list(){
		return borrowerService.listAllBorrower();
	}
	
	@PostMapping(path = "", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody BorrowerEntity newBorrower){
		borrowerService.newBorrower(newBorrower);
	}

}
