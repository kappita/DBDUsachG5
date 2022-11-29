package cl.debede.rest;

import cl.debede.model.Carrito;
import cl.debede.service.CarritoService;
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
@RequestMapping("/carrito")
public class CarritoRest {
    @Autowired
    private CarritoService carritoService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<Carrito> crear(@RequestBody Carrito carrito){
        Carrito resultado = carritoService.create(carrito);
        try {
            return ResponseEntity.created(new URI("/carrito"+resultado.getId())).body(resultado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Carrito>> getAllCarrito(){
        return ResponseEntity.ok(carritoService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Carrito> getCarrito(@PathVariable Long id){
        return ResponseEntity.ok(carritoService.show(id));
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody Carrito carrito, @PathVariable Long id){
        return ResponseEntity.ok(carritoService.update(carrito, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return ResponseEntity.ok(carritoService.delete(id));
    }
}
