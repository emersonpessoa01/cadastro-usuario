package br.com.emersonpessoa01.cadastro_usuario.business;

import br.com.emersonpessoa01.cadastro_usuario.infraestruture.entitys.Usuario;
import br.com.emersonpessoa01.cadastro_usuario.infraestruture.repository.UsuarioRepository;
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

}
