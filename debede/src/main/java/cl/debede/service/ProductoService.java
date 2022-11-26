package cl.debede.service;

import cl.debede.model.Producto;
import cl.debede.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }
    
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }
    
    public Producto show(Long id) {
        return productoRepository.findById(id).get();
    }
    
    public String update(Producto producto, Long id) {
        Producto temp;
        try{
            temp = show(id);
            temp.setNombre(producto.getNombre());
            temp.setPrecio(producto.getPrecio());
            temp.setStock(producto.getStock());
            temp.setUrl(producto.getUrl());
            return "Producto actualizado";
        }
        catch(Exception e){
            return "No existe producto con este ID";
        }
    }
    
    public String delete(Long id) {
        try{
            productoRepository.deleteById(id);
            return "Producto eliminado";
        } catch (Exception e) {
            return "No existe producto con este ID";
        }
    }
}