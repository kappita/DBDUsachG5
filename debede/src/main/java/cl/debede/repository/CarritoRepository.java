package cl.debede.repository;

import cl.debede.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito, Long>{
    
}
