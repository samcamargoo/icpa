package com.devsfree.icpa.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Samuel
 *
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_senha_token")
public class SenhaToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String token;
	private LocalDateTime criadoEm;
	private LocalDateTime expiraEm;
	private LocalDateTime confirmadoEm;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
}
