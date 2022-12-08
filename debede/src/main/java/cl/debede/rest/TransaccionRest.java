package cl.debede.rest;

import cl.debede.model.Transaccion;
import cl.debede.service.TransaccionService;
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
@RequestMapping("/transaccion")
public class TransaccionRest {
    @Autowired
    private TransaccionService carritoService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<Transaccion> crear(@RequestBody Transaccion transaccion){
        Transaccion resultado = carritoService.create(transaccion);
        try {
            return ResponseEntity.created(new URI("/transaccion"+resultado.getId())).body(resultado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Transaccion>> getAllCarrito(){
        return ResponseEntity.ok(carritoService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> getCarrito(@PathVariable Long id){
        return ResponseEntity.ok(carritoService.show(id));
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody Transaccion transaccion, @PathVariable Long id){
        return ResponseEntity.ok(carritoService.update(transaccion, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return ResponseEntity.ok(carritoService.delete(id));
    }
}
