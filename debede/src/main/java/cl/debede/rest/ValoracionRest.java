package cl.debede.rest;

import cl.debede.model.Valoracion;
import cl.debede.service.ValoracionService;
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
@RequestMapping("/valoracion")
public class ValoracionRest {
    @Autowired
    private ValoracionService valoracionService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<Valoracion> crear(@RequestBody Valoracion carrito){
        Valoracion resultado = valoracionService.create(carrito);
        try {
            return ResponseEntity.created(new URI("/valoracion"+resultado.getId())).body(resultado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Valoracion>> getAllCarrito(){
        return ResponseEntity.ok(valoracionService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Valoracion> getCarrito(@PathVariable Long id){
        return ResponseEntity.ok(valoracionService.show(id));
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody Valoracion valoracion, @PathVariable Long id){
        return ResponseEntity.ok(valoracionService.update(valoracion, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return ResponseEntity.ok(valoracionService.delete(id));
    }
}
