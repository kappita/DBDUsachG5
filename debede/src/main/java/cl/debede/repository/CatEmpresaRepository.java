package cl.debede.repository;

import cl.debede.model.CatEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatEmpresaRepository extends JpaRepository<CatEmpresa, Long>{
    
}
