package com.devsfree.icpa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
=======
>>>>>>> samuel
>>>>>>> paulo-v2
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


/**
 * @author Samuel
 *
 */

@Configuration
<<<<<<< HEAD
=======
<<<<<<< HEAD
@EnableGlobalMethodSecurity(prePostEnabled = true)
=======
>>>>>>> samuel
>>>>>>> paulo-v2
public class WebSecurityConfig {
	
	
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeHttpRequests()
		.antMatchers(HttpMethod.POST, "/api/v1/login/**").permitAll()
<<<<<<< HEAD
=======
<<<<<<< HEAD
		//.antMatchers(HttpMethod.POST, "/api/v1/cadastro/**").permitAll()
=======
>>>>>>> samuel
>>>>>>> paulo-v2
		.antMatchers(HttpMethod.POST, "/api/v1/recuperar-senha/**").permitAll()
		.antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
		.anyRequest().authenticated()
		.and()
		.csrf().disable();
	return http.build();
	}
	
	
<<<<<<< HEAD
=======
<<<<<<< HEAD
	
=======
>>>>>>> paulo-v2
	@Bean
	public UserDetailsService usuario() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("admin@admin.com")
				.password(encoder().encode("123"))
				.roles("ADMIN")
				.build());
		return manager;
	}
<<<<<<< HEAD
=======
>>>>>>> samuel
>>>>>>> paulo-v2
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
<<<<<<< HEAD
=======
<<<<<<< HEAD
	
=======
>>>>>>> samuel
>>>>>>> paulo-v2
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
