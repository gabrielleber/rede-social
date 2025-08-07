package Controllers;

import Entities.Comentario;
import Entities.Postagem;
import Entities.Usuario;
import Repositories.ComentarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")

public class ComentarioController {

    private final ComentarioRepository comentarioRepository;
    public ComentarioController(ComentarioRepository comentarioRepository){
        this.comentarioRepository = comentarioRepository;


    }

    @PostMapping
    public Comentario cadastrarNovoComentario(@RequestBody Comentario comentario) {
        return comentarioRepository.save(comentario);


    }

    @GetMapping("/postagens/{id}/comentarios")
    public ResponseEntity<List<Usuario>> listarComentarios(@PathVariable Long id) {
        return comentarioRepository.findById(id)
                .map(postagem -> ResponseEntity.ok(postagem.getUsuariosQueComentaram()))
                .orElse(ResponseEntity.notFound().build());



