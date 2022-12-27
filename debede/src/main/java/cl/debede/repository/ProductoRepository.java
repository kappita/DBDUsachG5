package cl.debede.repository;

import cl.debede.model.Empresa;
import cl.debede.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> findByNombre(String nombre);
    List<Producto> findByEmpresa(Empresa empresa);
}
