package cl.debede.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.debede.model.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
    
}
