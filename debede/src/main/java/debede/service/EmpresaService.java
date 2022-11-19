package debede.service;

import debede.model.Empresa;
import debede.repository.EmpresaRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
    
    @PostMapping("/empresa")
    @ResponseBody
    public Empresa crear(@RequestBody Empresa empresa){
        Empresa resultado = empresaRepository.crear(empresa);
        return resultado;
    }
    
    @GetMapping("/empresa")
    public List<Empresa> getAllUsuario(){
        return empresaRepository.getAll();
    }
    
    @GetMapping("/empresa/{id}")
    public List<Empresa> getUsuario(@PathVariable int id){
        return empresaRepository.show(id);
    }

    @PutMapping("/empresa/{id}")
    @ResponseBody
    public String updateCategoria(@RequestBody Empresa empresa, @PathVariable int id){
        String retorno = empresaRepository.update(empresa,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/empresa/{id}")
    public void borrar(@PathVariable int id){
        empresaRepository.delete(id);
    }
}