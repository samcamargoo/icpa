package com.devsfree.icpa.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devsfree.icpa.entities.SenhaToken;
import com.devsfree.icpa.entities.Usuario;
import com.devsfree.icpa.models.AlterarSenha;
import com.devsfree.icpa.repository.SenhaTokenRepository;
import com.devsfree.icpa.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

/**
 * @author Samuel
 *
 */

@Service
@AllArgsConstructor
public class SenhaService {

	private final UsuarioRepository usuarioRepository;
	private final EmailSenderService emailSenderService;
	private final SenhaTokenRepository senhaTokenRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Transactional
	public ResponseEntity<Object> gerarLinkParaAtualizarSenha(String email) {
		
		if(!usuarioRepository.existsByEmailIgnoreCase(email)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email não existe");
		}
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
		gerarToken(usuarioOptional.get());
		
		
		return ResponseEntity.status(HttpStatus.OK).body("Email enviado");
		
		
	}
	
	public void gerarToken(Usuario usuario) {
		
		var token = new SenhaToken();
		
		token.setToken(UUID.randomUUID().toString());
		token.setCriadoEm(LocalDateTime.now());
		token.setExpiraEm(LocalDateTime.now().plusMinutes(15));
		token.setUsuario(usuario);
		
		String link = "https://icpa-16543.web.app/RecuperarSenha.html?confirmar=1&token=" + token.getToken();
		
		emailSenderService.enviarEmailParaAlterarSenha(usuario.getEmail(), link);
		senhaTokenRepository.save(token);
		
	}
	
	public ResponseEntity<Object> atualizarSenha(String token, AlterarSenha alterarSenha) {
		
		if(!alterarSenha.getSenha().equals(alterarSenha.getConfirmarSenha())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("As senhas não coicidem");
		}
		
		Optional<SenhaToken> tokenOptional = senhaTokenRepository.findByToken(token);
		
		if(tokenOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Token inválido");
		}
		
		if(tokenOptional.get().getConfirmadoEm() != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Token já foi utilizado, solicite novamente alteração de senha");
		}
		
		if(tokenOptional.get().getExpiraEm().isBefore(LocalDateTime.now())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Token expirado, solicite novamente alteração de senha");
		}
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(tokenOptional.get().getUsuario().getId());
		
		usuarioOptional.get().setSenha(passwordEncoder.encode(alterarSenha.getSenha()));
		
		usuarioRepository.save(usuarioOptional.get());
		
		/*Salvar dados do token*/
		tokenOptional.get().setConfirmadoEm(LocalDateTime.now());
		senhaTokenRepository.save(tokenOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Senha atualizada com sucesso!");
		
		
	}
}
