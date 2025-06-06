package br.com.emersonpessoa01.cadastro_usuario.infraestruture.repository;

import br.com.emersonpessoa01.cadastro_usuario.infraestruture.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para encontrar um usuário pelo email
    //Optional evita NullPointerException caso o usuário não seja encontrado
    Optional<Usuario> findByEmail(String email);
//
//    // Método para verificar se um usuário existe pelo email
//    boolean existsByEmail(String email);
}
