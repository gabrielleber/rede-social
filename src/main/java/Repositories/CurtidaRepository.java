package Repositories;

import Entities.Curtidas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidaRepository extends JpaRepository<Curtidas, Integer> {
}
