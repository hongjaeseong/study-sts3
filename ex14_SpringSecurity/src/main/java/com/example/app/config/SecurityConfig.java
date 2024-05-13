package com.example.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.app.config.auth.PrincipalDetailsService;
import com.example.app.config.auth.loginHandler.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PrincipalDetailsService principalDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//웹요청 처리 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//CSRF TOKEN 비활성화
		http.csrf().disable();
		
		//CSRF TOKEN을 쿠키로 전달(개발자도구(F12) 확인)
		//http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		
		http.authorizeRequests()
			.antMatchers("/","/join").permitAll()
			.antMatchers("/user").hasRole("USER") 		//ROLE_USER
			.antMatchers("/member").hasRole("MEMBER") 	//ROLE_MEMBER
			.antMatchers("/admin").hasRole("ADMIN") 	//ROLE_ADMIN
			.anyRequest().authenticated();
					
//		//로그인
		http.formLogin()
			.loginPage("/login")
			.permitAll()
			.successHandler(new CustomLoginSuccessHandler());
		
//		
//		//로그아웃
		http.logout()
			.logoutUrl("/logout")
			.permitAll();
	}

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		auth.inMemoryAuthentication()
//			.withUser("user")
//			.password(passwordEncoder.encode("1234"))
//			.roles("USER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("member")
//			.password(passwordEncoder.encode("1234"))
//			.roles("MEMBER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password(passwordEncoder.encode("1234"))
//			.roles("ADMIN");
		
		auth.userDetailsService(principalDetailsService)
			.passwordEncoder(passwordEncoder);
		
	}
	
	
	

	
		
}
