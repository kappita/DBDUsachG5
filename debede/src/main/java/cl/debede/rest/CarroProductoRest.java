package cl.debede.rest;

import cl.debede.model.CarroProducto;
import cl.debede.service.CarroProductoService;
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
@RequestMapping("/carroproducto")
public class CarroProductoRest {
    @Autowired
    private CarroProductoService carroProductoService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<CarroProducto> crear(@RequestBody CarroProducto carroProducto){
        CarroProducto resultado = carroProductoService.create(carroProducto);
        try {
            return ResponseEntity.created(new URI("/carroproducto"+resultado.getId())).body(resultado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<CarroProducto>> getAllCarrito(){
        return ResponseEntity.ok(carroProductoService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CarroProducto> getCarrito(@PathVariable Long id){
        return ResponseEntity.ok(carroProductoService.show(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return ResponseEntity.ok(carroProductoService.delete(id));
    }
}
