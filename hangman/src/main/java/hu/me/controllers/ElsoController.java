package hu.me.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.me.model.GetMunkakModel;
import hu.me.service.MunkaService;


@Controller
public class ElsoController {
	private MunkaService munkaService;
	
	//public ElsoController(MunkaService munkaService) {
	//	this.munkaService = munkaService;
	//}
	
	@Autowired
	public void setMunkaService(MunkaService munkaService) {
		this.munkaService = munkaService;
	}

	@PostMapping("/posttest")
	@ResponseBody
	public String getMunkaString(){
		return "POST valassz";
	}
	
	@GetMapping("/")
	@ResponseBody
	public String getMunkaString(@Valid GetMunkakModel munkakModel, BindingResult bindingResult){
		String rv;
		if (bindingResult.hasErrors()){
			rv ="TILOS";
		}
		else {
		rv=munkaService.getMessage(munkakModel);
		}
		return rv;
	}
}
