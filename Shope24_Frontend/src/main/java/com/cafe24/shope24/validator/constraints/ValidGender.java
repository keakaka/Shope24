package com.cafe24.shope24.validator.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cafe24.shope24.validator.GenderValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy=GenderValidator.class)
public @interface ValidGender {
	String message() default "성별 형식이 맞지 않습니다.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
