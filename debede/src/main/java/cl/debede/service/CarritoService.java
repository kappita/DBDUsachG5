package cl.debede.service;

import cl.debede.model.Carrito;
import cl.debede.repository.CarritoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {
    
    @Autowired
    private CarritoRepository carritoRepository;

    public Carrito create(Carrito carrito) {
        return carritoRepository.save(carrito);
    }
    
    public List<Carrito> getAll() {
        return carritoRepository.findAll();
    }
    
    public Carrito show(Long id) {
        return carritoRepository.findById(id).get();
    }
    
    public String update(Carrito carrito, Long id) {
        Carrito temp;
        try {
            temp = show(id);
            if (carrito.getTransaccion()!= null)
                temp.setTransaccion(carrito.getTransaccion());
            carritoRepository.save(temp);
            return "Carrito Actualizado";
        }
        catch(Exception e){
            return "No existe carrito con este ID";
        }
    }
    
    public String delete(Long id) {
        try {
            carritoRepository.deleteById(id);
            return "Carrito eliminado";
        } catch (Exception e) {
            return "No existe carrito con este ID";
        }
    }
}