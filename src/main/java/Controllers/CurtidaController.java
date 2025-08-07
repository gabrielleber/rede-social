package Controllers;

import Entities.Curtidas;
import Entities.Usuario;
import Repositories.CurtidaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Curtidas")

public class CurtidaController {
    private final CurtidaRepository curtidaRepository;
    public CurtidaController(CurtidaRepository curtidaRepository){
        this.curtidaRepository = curtidaRepository;
    }

    @PostMapping
    public Curtidas ExecutarNovaCurtida(@RequestBody Curtidas curtidas){
        return curtidaRepository.save(curtidas);


    }

    @GetMapping
    @GetMapping("/postagens/{id}/curtidas")
    public ResponseEntity<List<Usuario>> listarCurtidas(@PathVariable Long id) {
        return curtidaRepository.findById(id)
                .map(postagem -> ResponseEntity.ok(postagem.getUsuariosQueCurtiram()))
                .orElse(ResponseEntity.notFound().build());


}
