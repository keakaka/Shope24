package com.cafe24.shope24.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {

	public enum Role {
		ROLE_USER, ROLE_ADMIN
	}
	
	public Role role() default Role.ROLE_USER;
	
	//	String value() default "USER";
	//	int test() default 1;
	
	
}
