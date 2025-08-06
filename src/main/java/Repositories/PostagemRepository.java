package Repositories;

import Entities.Postagem;
import Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
}
