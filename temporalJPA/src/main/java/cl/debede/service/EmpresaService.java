package cl.debede.service;

import cl.debede.model.Empresa;
import cl.debede.repository.EmpresaRepository;
import java.util.List;
import java.util.Optional;
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
    
    public String update(Empresa empresa) {
        empresaRepository.save(empresa);
        return "Empresa Actualizada";
    }
    
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }
    
}