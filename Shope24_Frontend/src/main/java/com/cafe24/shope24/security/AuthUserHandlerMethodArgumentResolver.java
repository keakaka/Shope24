package com.cafe24.shope24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.cafe24.shope24.vo.MemberVo;

public class AuthUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		
		AuthUser authUser = parameter.getParameterAnnotation(AuthUser.class);
		
		// @AuthUser가 안붙어있음
		if( authUser == null) {
			return false;
		}
		
		// 파라미터 타입이 UserVo가 아닐 때
		if(!parameter.getParameterType().equals(MemberVo.class)) {
			return false;
		}
		
		
		return true;
	}

	@Override
	public Object resolveArgument(
			MethodParameter parameter, 
			ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, 
			WebDataBinderFactory binderFactory) throws Exception {
		
		if(supportsParameter(parameter) == false) {
			return WebArgumentResolver.UNRESOLVED;
		}
		
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		
		HttpSession session = request.getSession();
		if(session == null) {
			
		}
		
		return session.getAttribute("authUser");
	}

}
