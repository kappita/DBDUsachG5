package cl.debede.repository;

import cl.debede.model.Empresa;
import cl.debede.model.Usuario;
import cl.debede.model.Valoracion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Long>{
    Optional<Valoracion> findByUsuarioAndEmpresa(Usuario user, Empresa empress);
}
