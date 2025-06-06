package br.com.emersonpessoa01.cadastro_usuario.business;

import br.com.emersonpessoa01.cadastro_usuario.infraestruture.entitys.Usuario;
import br.com.emersonpessoa01.cadastro_usuario.infraestruture.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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

    public Usuario buscarUsuarioPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o email: " + email));
    }


    public void deletarUsuarioPorEmail(String email) {

        repository.deleteByEmail(email);
    }

    //Faça uma breve explicação do que o método abaixo faz
    // O método atualizarUsuarioPorId recebe um ID e um objeto Usuario, busca o usuário existente pelo ID,
    // e atualiza os campos email e nome com os valores do objeto Usuario, se eles não forem nulos.

    public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
        Usuario usuarioEntity = repository.findById(Long.valueOf(id)).orElseThrow((() -> new RuntimeException("Usuário não encontrado com o ID: " + id)));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();
        repository.saveAndFlush(usuarioAtualizado);
    }

}
