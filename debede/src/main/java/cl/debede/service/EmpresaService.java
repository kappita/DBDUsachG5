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
    
    public List<Empresa> showName(String nombre) {
        return empresaRepository.findByNombre(nombre);
    }
    
    public String update(Empresa empresa, Long id) {
        Empresa temp;
        try{
            temp = show(id);
            if(empresa.getNombre() != null)
                temp.setNombre(empresa.getNombre());
            if(empresa.getCorreo()!= null)
                temp.setCorreo(empresa.getCorreo());
            if(empresa.getClave()!= null)
                temp.setClave(empresa.getClave());
            if(empresa.getDireccion()!= null)
                temp.setDireccion(empresa.getDireccion());
            if(empresa.isRestriccion_edad() != temp.isRestriccion_edad())
                temp.setRestriccion_edad(empresa.isRestriccion_edad());
            empresaRepository.save(temp);
            return "Empresa Actualizada";
        }
        catch(Exception e){
            return "No existe empresa con este ID";
        }
    }
    
    public String delete(Long id) {
        try{
            empresaRepository.deleteById(id);
            return "Empresa eliminada";
        } catch (Exception e) {
            return "No existe empresa con este ID";
        }
    }
}