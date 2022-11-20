package com.devsfree.icpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlterarSenha {
	
	private String senha;
	private String confirmarSenha;

}
