package com.cafe24.shope24.commons;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CommonValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
