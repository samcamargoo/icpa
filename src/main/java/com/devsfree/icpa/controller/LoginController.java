package com.devsfree.icpa.controller;

<<<<<<< HEAD
=======
<<<<<<< HEAD
import org.springframework.security.core.AuthenticationException;
=======
>>>>>>> samuel
>>>>>>> paulo-v2
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
<<<<<<< HEAD
import org.springframework.security.core.AuthenticationException;
=======
<<<<<<< HEAD
=======
import org.springframework.security.core.AuthenticationException;
>>>>>>> samuel
>>>>>>> paulo-v2
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.devsfree.icpa.models.Login;
=======
<<<<<<< HEAD
import com.devsfree.icpa.models.LoginForm;
=======
import com.devsfree.icpa.models.Login;
>>>>>>> samuel
>>>>>>> paulo-v2

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/login")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class LoginController {

<<<<<<< HEAD
=======
<<<<<<< HEAD
	
	private AuthenticationManager authManager;

	@PostMapping
	public ResponseEntity<Object> logar(@RequestBody LoginForm loginForm) {
=======
>>>>>>> paulo-v2
	private AuthenticationManager authManager;

	@PostMapping
	public ResponseEntity<Object> logar(@RequestBody Login loginForm) {
<<<<<<< HEAD
=======
>>>>>>> samuel
>>>>>>> paulo-v2

		UsernamePasswordAuthenticationToken login = loginForm.converter();

		try {

			final Authentication authentication = authManager.authenticate(login);

			return ResponseEntity.status(HttpStatus.OK).body("usuario logado");
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario/senha incorreto");
		}
	}
<<<<<<< HEAD
}
=======
<<<<<<< HEAD
}
=======
}
>>>>>>> samuel
>>>>>>> paulo-v2
