package com.devsfree.icpa.dto;

import com.devsfree.icpa.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

<<<<<<< HEAD
=======
<<<<<<< HEAD
/**
 * @author Paulo Manzano
 *
 */

=======
>>>>>>> samuel
>>>>>>> paulo-v2
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto{

    private Long id;

    @Size(min = 3, max= 200)
    @NotNull
    private String nome;

    @Email
    @NotNull
    private String email;

    @Size(min=10, max=11)
    @NotNull
    private String celular;

    @Size(min=8)
    @NotNull
    private String senha;

    @NotNull

    @DateTimeFormat(pattern = "dd/MM/yyyy" )
    private LocalDateTime cadastro;

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.celular = usuario.getCelular();
        this.senha = usuario.getSenha();
        this.cadastro = usuario.getCadastro();
    }
}
