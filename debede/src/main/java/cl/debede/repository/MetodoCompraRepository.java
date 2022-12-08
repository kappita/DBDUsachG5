package cl.debede.repository;

import cl.debede.model.MetodoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoCompraRepository extends JpaRepository<MetodoCompra, Long>{
    
}
