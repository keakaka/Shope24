package com.cafe24.shope24.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cafe24.shope24.service.MemberService;
import com.cafe24.shope24.vo.MemberVo;

@Component
public class UserDetailsServiceImpl  implements UserDetailsService{
	
	@Autowired
	private MemberService memberService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVo userVo = memberService.getMember(username);
		
		SecurityUser securityUser = new SecurityUser();
		if( userVo != null ) {
			securityUser.setNo(userVo.getNo());
			securityUser.setName(userVo.getName());			// Service data || Biz Data
			securityUser.setUsername(userVo.getEmail());	// Principal
			securityUser.setPassword(userVo.getPassword()); // Credential
			securityUser.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userVo.getRole())));// => Role을 이용해 Authority를 만드는 방법.
		}
		
		return securityUser;
	}
}
