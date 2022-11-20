package com.devsfree.icpa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsfree.icpa.models.AlterarSenha;
import com.devsfree.icpa.service.SenhaService;

import lombok.AllArgsConstructor;




/**
 * @author Samuel
 *
 */
@RestController
@RequestMapping("api/v1/recuperar-senha")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RecuperarSenhaController {

	private final SenhaService senhaService;
	
	@PostMapping
	public ResponseEntity<Object> alterarSenha(@RequestParam(value = "email") String email) {
		return senhaService.gerarLinkParaAtualizarSenha(email);
	}
	
	@PostMapping("atualizar-senha")
	public ResponseEntity<Object> atualizarSenha(@RequestParam (value = "token") String token, AlterarSenha senhas) {
		return senhaService.atualizarSenha(token, senhas);
	}
	
}
