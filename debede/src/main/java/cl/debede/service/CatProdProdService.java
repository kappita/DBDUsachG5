package cl.debede.service;

import cl.debede.model.CatProdProd;
import cl.debede.repository.CatProdProdRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatProdProdService {
    @Autowired
    private CatProdProdRepository catProdProdRepository;

    public CatProdProd create(CatProdProd catProdProd) {
        return catProdProdRepository.save(catProdProd);
    }
    
    public List<CatProdProd> getAll() {
        return catProdProdRepository.findAll();
    }
    
    public CatProdProd show(Long id) {
        return catProdProdRepository.findById(id).get();
    }
    
    public String delete(Long id) {
        try {
            catProdProdRepository.deleteById(id);
            return "CatProdProd eliminado";
        } catch (Exception e) {
            return "No existe CatProdProd con este ID";
        }
    }
    
}
