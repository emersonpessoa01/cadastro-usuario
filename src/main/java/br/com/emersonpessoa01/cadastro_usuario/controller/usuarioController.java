package br.com.emersonpessoa01.cadastro_usuario.controller;

import br.com.emersonpessoa01.cadastro_usuario.business.UsuarioService;
import br.com.emersonpessoa01.cadastro_usuario.infraestruture.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class usuarioController {
    private final UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Usuario> bucarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }
}
