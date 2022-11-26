package cl.debede.service;

import cl.debede.model.Empresa;
import cl.debede.repository.EmpresaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa create(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
    
    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }
    
    public Empresa show(Long id) {
        return empresaRepository.findById(id).get();
    }
    
    public String update(Empresa empresa, Long id) {
        Empresa temp;
        try{
            temp = show(id);
            temp.setNombre(empresa.getNombre());
            return "Empresa Actualizada";
        }
        catch(Exception e){
            return "No existe empresa con este ID";
        }
    }
    
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }
}