package hu.me.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST ) //400 ad vissza ha ez dobódik
public class AdminUserNotAllowed extends RuntimeException{

	
	
}
