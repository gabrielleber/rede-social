package Controllers;

import Entities.Usuario;
import Repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public Usuario cadastrarNovoUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);


    }

    @GetMapping
    public List<Usuario> listar() {
            return this.usuarioRepository.findAll();
    }

    @GetMapping("/idUsuario")
    public ResponseEntity<Usuario> ExibirDetalhesUsuarioPorId(@PathVariable Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .map(usuario -> ResponseEntity.ok(usuario))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Usuario> atualuzarUsuario(@PathVariable Long idUsuario, @RequestBody Usuario usuario) {
        if (!usuarioRepository.existsById(idUsuario)){
            return ResponseEntity.notFound().build();
        }

        usuario.setId(idUsuario);
        Usuario usarioAtualizado = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usarioAtualizado);
    }

    @DeleteMapping("/{idUsuario}")
    public Usuario removerUsuario(@PathVariable Integer idUsuario) {
        Usuario usuario = this.usuarioRepository.findById(idUsuario).get();

        this.usuarioRepository.deleteAllById(idUsuario);

        return usuario;
    }


}
