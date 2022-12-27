package cl.debede.service;

import cl.debede.model.Empresa;
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
    
    public List<Producto> getByEmpresa(Long id) {
        Empresa emp = new Empresa();
        emp.setId(id);
        return productoRepository.findByEmpresa(emp);
    }
    
    public Producto show(Long id) {
        return productoRepository.findById(id).get();
    }
    
    public List<Producto> showName(String nombre) {
        return productoRepository.findByNombre(nombre);
    }
    
    public String update(Producto producto, Long id) {
        Producto temp;
        try{
            temp = show(id);
            if(producto.getNombre() != null)
                temp.setNombre(producto.getNombre());
            if(producto.getPrecio() != null)
                temp.setPrecio(producto.getPrecio());
            if(producto.getStock() != null)
                temp.setStock(producto.getStock());
            if(producto.getUrl() != null)
                temp.setUrl(producto.getUrl());
            productoRepository.save(temp);
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