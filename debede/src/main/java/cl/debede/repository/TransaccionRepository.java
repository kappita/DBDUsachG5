package cl.debede.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.debede.model.Transaccion;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
    
}
