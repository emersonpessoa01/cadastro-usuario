package br.com.emersonpessoa01.cadastro_usuario.business;

import br.com.emersonpessoa01.cadastro_usuario.infraestruture.entitys.Usuario;
import br.com.emersonpessoa01.cadastro_usuario.infraestruture.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
        return usuario;
    }

//    public Usuario buscarUsuarioPorEmail(String email) {
//        return repository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o email: " + email));
//    }

    // Método que busca todos os usuários cadastrados
    public ResponseEntity<?> buscarTodosUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        System.out.println("Usuários encontrados: " + usuarios.size());
        return ResponseEntity.ok(usuarios);
    }


    // Busca usuário por id, se não encontrar lança uma exceção RuntimeException
    public Usuario buscarUsuarioPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }





//    public void deletarUsuarioPorEmail(String email) {
//
//        repository.deleteByEmail(email);
//    }
    // Método que delta por ID, se não encontrar lança uma exceção RuntimeException

    public void deletarUsuarioPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }


    // O método atualizarUsuarioPorId recebe um ID e um objeto Usuario, busca o usuário existente pelo ID,
    // e atualiza os campos email e nome com os valores do objeto Usuario, se eles não forem nulos.

public void atualizarUsuarioPorId(Long id, Usuario usuario) {
        Usuario usuarioEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));

        usuarioEntity.setEmail(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail());
        usuarioEntity.setNome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome());

        repository.saveAndFlush(usuarioEntity);
    }



}
