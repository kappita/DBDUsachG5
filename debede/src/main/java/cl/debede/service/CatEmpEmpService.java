package cl.debede.service;

import cl.debede.model.CatEmpEmp;
import cl.debede.repository.CatEmpEmpRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatEmpEmpService {
    @Autowired
    private CatEmpEmpRepository catEmpEmpRepository;

    public CatEmpEmp create(CatEmpEmp catEmpEmp) {
        return catEmpEmpRepository.save(catEmpEmp);
    }
    
    public List<CatEmpEmp> getAll() {
        return catEmpEmpRepository.findAll();
    }
    
    public CatEmpEmp show(Long id) {
        return catEmpEmpRepository.findById(id).get();
    }
    
    // Se deja pendiente
    public String update(CatEmpEmp catEmpEmp, Long id) {
        CatEmpEmp temp;
        try {
            temp = show(id);
            return "CatEmpEmp Actualizada";
        }
        catch(Exception e){
            return "No existe CatEmpEmp con este ID";
        }
    }
    
    public String delete(Long id) {
        try {
            catEmpEmpRepository.deleteById(id);
            return "CatEmpEmp eliminada";
        } catch (Exception e) {
            return "No existe CatEmpEmp con este ID";
        }
    }
    
}
