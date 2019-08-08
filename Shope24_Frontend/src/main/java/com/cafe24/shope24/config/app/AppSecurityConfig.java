package com.cafe24.shope24.config.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.cafe24.shope24.security.CustomUrlAuthenticationSuccessHandler;

/*
Security Filter Chain

 1. ChannelProcessingFilter
 2. ★SecurityContextPersistenceFilter		( auto-config default, 필수 )  ==> Deny All 이후 Accept에 관여하는 놈
 3. ConcurrentSessionFilter
 4. ★LogoutFilter				( auto-config default, 필수 )
 5. ★UsernamePasswordAuthenticationFilter	( auto-config default, 필수 )
 6. DefaultLoginPageGeneratingFilter		( auto-config default )
 7. CasAuthenticationFilter
 8. ★BasicAuthenticationFilter			( auto-config default, 필수 )
 9. RequestCacheAwareFilter			( auto-config default )
10. SecurityContextHolderAwareRequestFilter	( auto-config default )
11. JaasApiIntegrationFilter
12. RememberMeAuthenticationFilter
13. AnonymousAuthenticationFilter		( auto-config default )
14. SessionManagementFilter			( auto-config default )
15. ★ExceptionTranslationFilter			( auto-config default, 필수 )
16. ★FilterSecurityInterceptor			( auto-config default, 필수 )
	
*/
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	// 스프링 시큐리티 필터 연결
	// WebSecurity 객체
	// springSecurityFilterChain 이라는 이름의 DelegatingFilterProxy Bean 객체를 생성한다.
	// 다수의 Spring Security Filter chain 역할을 담당한다.
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		// ACL(Access Controll List)에 등록하지 않을 URL 등록.
//		web.ignoring().antMatchers("/assets/**");
//		web.ignoring().antMatchers("/favicon.ico");
		web.ignoring().regexMatchers("\\A/(u|assets|error)/.*\\Z");
		web.ignoring().regexMatchers("\\A/(favicon.ico|googled02306225bbc8cdb.html)\\Z");
		
	}
	
	// Interceptor URL의 요청을 안전하게 보호(보안)하는 방법을 설정
	/*
	= Deny All
	
	/user/update
	/user/logout  ->  (ROLE_USER, ROLE_ADMIN) -> Authenticated
	/board/write
	/board/delete
	/board/modify
	/admin/**     ->  ROLE_ADMIN(Authorized)
	
	allow all
	*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//
		//	1. ACL 설정
		//
		// 모두 거부 deny all
		http.authorizeRequests()
		// 인증이 되어 있을  때( Authenticated?? ) 가능한 것.	
		.antMatchers("/user/update", "/user/logout").authenticated()
		.antMatchers("/board/write", "/board/modify", "/board/delete").authenticated()
		
		// ADMIN Authorizeation(ADMIN 권한, ROLE_ADMIN (Authorized))
		//.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")  -> 스프링 시큐리티 언어
		//.antMatchers("/admin/**").hasRole("ADMIN")	
		.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")  // -> 스프링 시큐리티 언어를 조금 더 간편하게
		.antMatchers("/gallery/upload", "/admin/delete/**").hasAuthority("ROLE_ADMIN")
		// 모두 허용 ( permit all )
		// .antMatchers("/**").permitAll();		// URL 명시.
		.anyRequest().permitAll();
			
		//  Temporary for Testing - CSRF 설정 (테스트를 위해 CSRF Disable)
//		http
//		.csrf().disable();
		
		//
		//	2. 로그인 설정
		//
		http
		.formLogin()
		.loginPage("/user/login")
		.loginProcessingUrl("/user/auth")
		.failureUrl("/user/login?result=fail")
//		.defaultSuccessUrl("/", true)
		.successHandler(authenticationSuccessHandler())
		.usernameParameter("id")
		.passwordParameter("password")
		
		//
		//	3. 로그아웃 설정
		//
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
		.logoutSuccessUrl("/")
		.deleteCookies("JSESSIONID")
		.invalidateHttpSession(true)

		//
		// 4. Access denial handler - Access 거부 됐을 때 처리
		//
		.and()
		.exceptionHandling().accessDeniedPage("/WEB-INF/views/error/access_denied.jsp")
		
		//
		// 5. RememberMe - 쿠키를 이용한 사용자 저장
		//
		.and()
		.rememberMe().key("shope24").rememberMeParameter("remember-me");
		
	}
	
	// UserDetailService를 설정
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.and()
		.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomUrlAuthenticationSuccessHandler();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
