package com.devsfree.icpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsfree.icpa.entities.SenhaToken;

/**
 * @author Samuel
 *
 */

public interface SenhaTokenRepository extends JpaRepository<SenhaToken, Long>{

	Optional<SenhaToken> findByToken(String token);
}
