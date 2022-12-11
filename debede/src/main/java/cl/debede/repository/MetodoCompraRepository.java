package cl.debede.repository;

import cl.debede.model.MetodoCompra;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoCompraRepository extends JpaRepository<MetodoCompra, Long>{
    Optional<MetodoCompra> findByNombreMetodo(String nombre);
}
