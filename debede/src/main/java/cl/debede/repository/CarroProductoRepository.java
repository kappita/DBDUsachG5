package cl.debede.repository;

import cl.debede.model.CarroProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroProductoRepository extends JpaRepository<CarroProducto, Long>{
    
}
