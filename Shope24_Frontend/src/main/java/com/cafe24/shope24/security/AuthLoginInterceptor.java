package com.cafe24.shope24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.shope24.service.MemberService;
import com.cafe24.shope24.vo.MemberVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVo memberVo = new MemberVo();
		memberVo.setId(id);
		memberVo.setPassword(password);
		
		MemberVo authUser = memberService.getMember(memberVo);
		if(authUser == null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		// session 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		if("ROLE_USER".equals(authUser.getRole())) {
			response.sendRedirect("/");
		}else if("ROLE_ADMIN".equals(authUser.getRole())) {
			request.getRequestDispatcher("/admin/main").forward(request, response);
		}
		
		return false;
	}
	
}
