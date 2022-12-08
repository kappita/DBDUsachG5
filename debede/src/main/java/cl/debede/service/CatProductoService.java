package cl.debede.service;

import cl.debede.model.CatProducto;
import cl.debede.repository.CatProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatProductoService {
    @Autowired
    private CatProductoRepository catProductoRepository;

    public CatProducto create(CatProducto catProducto) {
        return catProductoRepository.save(catProducto);
    }
    
    public List<CatProducto> getAll() {
        return catProductoRepository.findAll();
    }
    
    public CatProducto show(Long id) {
        return catProductoRepository.findById(id).get();
    }
    
    public String update(CatProducto catProducto, Long id) {
        CatProducto temp;
        try {
            temp = show(id);
            return "CatProducto Actualizado";
        }
        catch(Exception e){
            return "No existe CatProducto con este ID";
        }
    }
    
    public String delete(Long id) {
        try {
            catProductoRepository.deleteById(id);
            return "CatProducto eliminado";
        } catch (Exception e) {
            return "No existe CatProducto con este ID";
        }
    }
    
}
