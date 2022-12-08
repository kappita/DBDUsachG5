package cl.debede.service;

import cl.debede.model.CatEmpresa;
import cl.debede.repository.CatEmpresaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatEmpresaService {
    @Autowired
    private CatEmpresaRepository catEmpresaRepository;

    public CatEmpresa create(CatEmpresa catEmpresa) {
        return catEmpresaRepository.save(catEmpresa);
    }
    
    public List<CatEmpresa> getAll() {
        return catEmpresaRepository.findAll();
    }
    
    public CatEmpresa show(Long id) {
        return catEmpresaRepository.findById(id).get();
    }
    
    public String update(CatEmpresa catEmpresa ,Long id) {
        CatEmpresa temp;
        try {
            temp = show(id);
            temp.setTipo_producto(catEmpresa.getTipo_producto());
            return "Categoria Empresa Actualizada";
        }
        catch(Exception e){
            return "No existe Categoria Empresa con este ID";
        }
    }
    
    public String delete(Long id) {
        try {
            catEmpresaRepository.deleteById(id);
            return "Categoria Empresa eliminada";
        } catch (Exception e) {
            return "No existe Categoria Empresa con este ID";
        }
    }
    
}
