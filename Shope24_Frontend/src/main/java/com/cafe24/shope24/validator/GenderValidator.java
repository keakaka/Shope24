package com.cafe24.shope24.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.shope24.validator.constraints.ValidGender;

public class GenderValidator implements ConstraintValidator<ValidGender, String> {

	private Pattern pattern = Pattern.compile("M|F|N");
	
	@Override
	public void initialize(ValidGender constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length() == 0 || "".contentEquals(value)) {
			return false;
		}
		return pattern.matcher( value ).matches();
	}


}
