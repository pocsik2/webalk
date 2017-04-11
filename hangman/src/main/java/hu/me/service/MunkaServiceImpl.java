package hu.me.service;

import org.springframework.stereotype.Service;

import hu.me.model.GetMunkakModel;

@Service
public class MunkaServiceImpl implements MunkaService {
	
	public String getMessage(GetMunkakModel munkakModel){
		return "hello "+munkakModel.getNev() +": " +munkakModel.getEletkor();
	}
}
