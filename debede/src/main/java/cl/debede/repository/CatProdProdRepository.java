package cl.debede.repository;

import cl.debede.model.CatProdProd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatProdProdRepository extends JpaRepository<CatProdProd, Long>{
    
}
