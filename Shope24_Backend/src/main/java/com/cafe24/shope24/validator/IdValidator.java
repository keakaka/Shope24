package com.cafe24.shope24.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.shope24.validator.constraints.ValidId;

public class IdValidator implements ConstraintValidator<ValidId, String> {

	private Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{5,}$");
	
	@Override
	public void initialize(ValidId constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length() == 0 || "".contentEquals(value)) {
			return false;
		}
		return pattern.matcher( value ).matches();
	}


}