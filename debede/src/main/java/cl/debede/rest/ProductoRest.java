package cl.debede.rest;

import cl.debede.model.Producto;
import cl.debede.service.ProductoService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoRest {
    
    @Autowired
    private ProductoService productoService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<Producto> crear(@RequestBody Producto producto){
        Producto resultado = productoService.create(producto);
        try {
            return ResponseEntity.created(new URI("/producto"+resultado.getId())).body(resultado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducto(){
        return ResponseEntity.ok(productoService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long id){
        return ResponseEntity.ok(productoService.show(id));
    }
    
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Producto>> getProductoName(@PathVariable String nombre){
        return ResponseEntity.ok(productoService.showName(nombre));
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody Producto producto, @PathVariable Long id){
        return ResponseEntity.ok(productoService.update(producto, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return ResponseEntity.ok(productoService.delete(id));
    }
}