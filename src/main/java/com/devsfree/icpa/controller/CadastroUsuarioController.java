package com.devsfree.icpa.controller;

<<<<<<< HEAD
import com.devsfree.icpa.dto.UsuarioDto;
import com.devsfree.icpa.dto.UsuarioRetorno;
=======
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsfree.icpa.dto.UsuarioDto;
=======
import com.devsfree.icpa.dto.UsuarioDto;
import com.devsfree.icpa.dto.UsuarioRetorno;
>>>>>>> samuel
>>>>>>> paulo-v2
import com.devsfree.icpa.service.CadastroUsuarioService;

import lombok.AllArgsConstructor;

<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
=======
<<<<<<< HEAD
/**
 * @author Paulo Manzano
 *
 */
=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
>>>>>>> samuel
>>>>>>> paulo-v2

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/cadastro")
<<<<<<< HEAD
=======
<<<<<<< HEAD
@CrossOrigin(origins = "*")
=======
>>>>>>> samuel
>>>>>>> paulo-v2
public class CadastroUsuarioController {

    private CadastroUsuarioService cadastroUsuarioService;

    @PostMapping
<<<<<<< HEAD
=======
<<<<<<< HEAD
    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') or hasRole('ROLE_OWNER')")
=======
>>>>>>> samuel
>>>>>>> paulo-v2
    public ResponseEntity<Object> cadastrarUsuario(@RequestBody UsuarioDto usuarioDto){
        return cadastroUsuarioService.cadastrarUsuario(usuarioDto);

    }

    @GetMapping("/email/{emailUsuario}")
    public ResponseEntity<Object> listarUsuarioPorEmail(@PathVariable String emailUsuario){

        return cadastroUsuarioService.listarUsuarioPorEmail(emailUsuario);
    }

    @GetMapping("/nome/{nomeUsuario}")
    public ResponseEntity<Object> listarUsuarioPorNome(@PathVariable String nomeUsuario){

        return cadastroUsuarioService.listarUsuarioPorNome(nomeUsuario);
    }

    @GetMapping
    public ResponseEntity<Object> listarUsuarios(){

        return cadastroUsuarioService.listarUsuarios();
    }
    @PutMapping ("/{emailUsuario}")
    public ResponseEntity<Object> alterarUsuarioPorEmail(@PathVariable String emailUsuario, @RequestBody UsuarioDto usuarioDto){
        return cadastroUsuarioService.alterarUsuarioPorEmail(emailUsuario, usuarioDto);
    }

    @DeleteMapping("/{emailUsuario}")
    public ResponseEntity<Object> apagarUsuarioPorEmail(@PathVariable String emailUsuario){
        cadastroUsuarioService.apagarUsuarioPorEmail(emailUsuario);
        return cadastroUsuarioService.apagarUsuarioPorEmail(emailUsuario);
    }

}
