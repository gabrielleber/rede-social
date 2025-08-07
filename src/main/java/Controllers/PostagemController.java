package Controllers;

import Entities.Postagem;
import Entities.Usuario;
import Repositories.PostagemRepository;
import Repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagem")

public class PostagemController {

    private final PostagemRepository postagemRepository;
    public PostagemController(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    @PostMapping
    public Postagem cadastrarNovaPostagem(@RequestBody Postagem postagem) {
        return postagemRepository.save(postagem);

    }


    @GetMapping
    public List<Postagem> listar() {
        return this.postagemRepository.findAll();

    }

    @GetMapping("/idPostagem")
    public ResponseEntity<Postagem> ExibirPostagemPorId(@PathVariable Long idPostagem) {
        return postagemRepository.findAllById(idPostagem)
                .map(Postagem -> ResponseEntity.ok(Postagem))
                .orElse(ResponseEntity.notFound().build());


    }

    @GetMapping("/usuarios/{id}/postagens")
    public ResponseEntity<List<Postagem>> listarPostagensPorUsuario(@PathVariable Long id) {
        return postagemRepository.findById(id)
                .map(usuario -> ResponseEntity.ok(usuario.getPostagem()))
                .orElse(ResponseEntity.notFound().build());


    }







}
