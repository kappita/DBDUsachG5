package cl.debede.repository;

import cl.debede.model.CatEmpEmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatEmpEmpRepository extends JpaRepository<CatEmpEmp, Long>{
    
}
