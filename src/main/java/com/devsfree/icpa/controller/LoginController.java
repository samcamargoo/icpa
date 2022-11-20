package com.devsfree.icpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsfree.icpa.models.LoginForm;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/login")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class LoginController {

	
	private AuthenticationManager authManager;

	@PostMapping
	public ResponseEntity<Object> logar(@RequestBody LoginForm loginForm) {

		UsernamePasswordAuthenticationToken login = loginForm.converter();

		try {

			final Authentication authentication = authManager.authenticate(login);

			return ResponseEntity.status(HttpStatus.OK).body("usuario logado");
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario/senha incorreto");
		}
	}
}