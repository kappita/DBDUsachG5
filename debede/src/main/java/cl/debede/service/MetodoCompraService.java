package cl.debede.service;

import cl.debede.model.MetodoCompra;
import cl.debede.repository.MetodoCompraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodoCompraService {
    @Autowired
    private MetodoCompraRepository metodoCompraRepository;

    public MetodoCompra create(MetodoCompra metodoCompra) {
        return metodoCompraRepository.save(metodoCompra);
    }
    
    public List<MetodoCompra> getAll() {
        return metodoCompraRepository.findAll();
    }
    
    public MetodoCompra show(Long id) {
        return metodoCompraRepository.findById(id).get();
    }
    
    public String update(MetodoCompra metodoCompra, Long id) {
        MetodoCompra temp;
        try {
            temp = show(id);
            temp.setNombre_metodo(metodoCompra.getNombre_metodo());
            temp.setTipo_cambio(metodoCompra.getTipo_cambio());
            temp.setTipo_pago(metodoCompra.getTipo_pago());
            metodoCompraRepository.save(temp);
            return "MetodoCompra Actualizado";
        }
        catch(Exception e){
            return "No existe MetodoCompra con este ID";
        }
    }
    
    public String delete(Long id) {
        try {
            metodoCompraRepository.deleteById(id);
            return "MetodoCompra eliminado";
        } catch (Exception e) {
            return "No existe MetodoCompra con este ID";
        }
    }
    
}
