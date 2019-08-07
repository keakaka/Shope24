package com.cafe24.shope24.validator.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cafe24.shope24.validator.IdValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy=IdValidator.class)
public @interface ValidId {
	
	String message() default "아이디는 6자 이상의 영문과 숫자 조합으로 가입해주세요";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
