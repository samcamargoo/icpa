package com.devsfree.icpa.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devsfree.icpa.dto.UsuarioDto;
import com.devsfree.icpa.dto.UsuarioRetorno;
import com.devsfree.icpa.entities.Usuario;
import com.devsfree.icpa.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

/**
 * @author Paulo Manzano
 *
 */

@Service
@AllArgsConstructor
public class CadastroUsuarioService {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;


    /************ CADASTRO DE USUARIO
     *
     * @param
     * @return
     *
     */
    public ResponseEntity<Object> cadastrarUsuario(UsuarioDto usuarioDto){

        Date in = new Date();
        LocalDateTime cadastro = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());

        var email = usuarioDto.getEmail();
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

        if(usuarioOptional.isEmpty()){
            Usuario usuario = new Usuario();
            BeanUtils.copyProperties(usuarioDto, usuario);
            usuario.setCadastro(cadastro);
            usuario.setSenha(passwordEncoder.encode(usuarioDto.getSenha()));

            usuarioRepository.save(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro " + email + " efetuado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Cadastro " + email + " já existe!");
    }

    /************ LISTA USUARIO PELO E-MAIL
     *
     * @return
     */

    public ResponseEntity<Object> listarUsuarioPorEmail(String emailUsuario){

        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(emailUsuario) ;

        if (usuarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro " + emailUsuario + " inexistente!");
        }
        UsuarioRetorno usuarioRetorno = new UsuarioRetorno();
        BeanUtils.copyProperties(usuarioOptional.get(), usuarioRetorno);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRetorno);
    }

    /************ LISTA USUARIO PELO NOME
     *
     * @return
     */

    public ResponseEntity<Object> listarUsuarioPorNome(String nomeUsuario){
        List<Usuario> usuarios = usuarioRepository.findByNomeContainingIgnoreCase(nomeUsuario);

        if (usuarios.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro " + nomeUsuario + " inexistente!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarios.stream().map(usuario ->
                new UsuarioRetorno(usuario)).collect(Collectors.toList()));
    }

    /****************************
     * Lista geral de clientes
     * @return
     */
    public ResponseEntity<Object> listarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há usuários cadastrados!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarios.stream().map(usuario ->
                new UsuarioRetorno(usuario)).collect(Collectors.toList()));
    }

    /******************************
     * Alteração de usuario
     * @param emailUsuario
      * @return
     */
    public ResponseEntity<Object> alterarUsuarioPorEmail(String emailUsuario, UsuarioDto usuarioDto){
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(emailUsuario) ;

        if (usuarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro " + emailUsuario + " inexistente!");
        }

        BeanUtils.copyProperties(usuarioDto, usuarioOptional);

        usuarioOptional.get().setNome(usuarioDto.getNome());
        usuarioOptional.get().setCelular(usuarioDto.getCelular());
        usuarioOptional.get().setSenha(passwordEncoder.encode(usuarioDto.getSenha()));


        usuarioRepository.save(usuarioOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cadastro " + emailUsuario + " alterado com sucesso!");
    }

     /********************************
     * apager usuario
     * @param emailUsuario
     * @return
     */
   public ResponseEntity<Object> apagarUsuarioPorEmail(String emailUsuario){

      Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(emailUsuario);

       if (usuarioOptional.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro " + emailUsuario + " inexistente!");
       }

       usuarioRepository.deleteById(usuarioOptional.get().getId());
       return ResponseEntity.status(HttpStatus.OK).body("Cadastro " + emailUsuario + " excluído com sucesso!");

    }
}
