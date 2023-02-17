package com.callawaygolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

public class CallawayGolfApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallawayGolfApplication.class, args);
		 PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        System.out.println(passwordEncoder.encode("admin"));
	}

}
