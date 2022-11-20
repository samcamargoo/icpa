package com.devsfree.icpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsfree.icpa.entities.Usuario;

import java.util.List;
import java.util.Optional;

/**
 * @author Paulo Manzano
 *
 */

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String emailUsuario);
    List<Usuario> findByNomeContainingIgnoreCase(String nomeUsuario);
    boolean existsByEmailIgnoreCase(String email);

}
