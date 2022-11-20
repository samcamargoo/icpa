package com.devsfree.icpa.security;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsfree.icpa.entities.Usuario;
import com.devsfree.icpa.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
<<<<<<< HEAD
=======
<<<<<<< HEAD
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário inválido"));
		return new User(usuario.getEmail(), usuario.getSenha(), true, true, true, true, usuario.getAuthorities());
=======
>>>>>>> paulo-v2
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		return new User(usuario.getEmail(), usuario.getSenha(), true, true, true, usuario.getAuthorities());
<<<<<<< HEAD
=======
>>>>>>> samuel
>>>>>>> paulo-v2
	}

}
