package cl.debede.repository;

import cl.debede.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    List<Usuario> findByNombre(String nombre);
    Usuario findByCorreo(String correo);
}
