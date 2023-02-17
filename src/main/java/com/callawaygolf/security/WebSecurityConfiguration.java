package com.callawaygolf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration { 

	//Its a default Spring Security Interface uses to do default Authentication
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	

//	@Bean
//	AuthenticationProvider authenticationProvider() {
//		DAO= Data Access Object
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//	provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}
	private static final String[] WHITE_LIST_URLS = {
			"/user/**",
			"/dbp/**",
			"/**"
	};
	private static final String[] USER_LIST_URLS = {
			//"/dbp/**"
	};
	private static final String[] ADMIN_LIST_URLS = {
			
	};

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
		.authorizeRequests()
		.requestMatchers(WHITE_LIST_URLS).permitAll()
		.requestMatchers(USER_LIST_URLS).access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
		.requestMatchers(ADMIN_LIST_URLS).access("hasRole('ROLE_ADMIN')")
		.anyRequest() 
		.authenticated()
		.and()
		.httpBasic();
		//.formLogin();
		return http.build();
	}

}
