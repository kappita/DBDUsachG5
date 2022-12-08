package cl.debede.repository;

import cl.debede.model.CatProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatProductoRepository extends JpaRepository<CatProducto, Long>{
    
}
