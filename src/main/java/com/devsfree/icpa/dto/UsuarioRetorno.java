package com.devsfree.icpa.dto;

import com.devsfree.icpa.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


/**
 * @author Paulo Manzano
 *
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRetorno {

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

   @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime cadastro;

    public UsuarioRetorno(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.celular = usuario.getCelular();
        this.cadastro = usuario.getCadastro();
    }
}
