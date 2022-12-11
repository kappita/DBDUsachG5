package cl.debede.rest;

import cl.debede.model.MetodoCompra;
import cl.debede.service.MetodoCompraService;
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
@RequestMapping("/metodocompra")
public class MetodoCompraRest {
    @Autowired
    private MetodoCompraService metodoCompraService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<MetodoCompra> crear(@RequestBody MetodoCompra metodoCompra){
        MetodoCompra resultado = metodoCompraService.create(metodoCompra);
        try {
            return ResponseEntity.created(new URI("/metodocompra"+resultado.getId())).body(resultado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<MetodoCompra>> getAllMetodoCompra(){
        return ResponseEntity.ok(metodoCompraService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MetodoCompra> getMetodoCompra(@PathVariable Long id){
        return ResponseEntity.ok(metodoCompraService.show(id));
    }
    
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<MetodoCompra> getMetodoCompraName(@PathVariable String nombre){
        return ResponseEntity.ok(metodoCompraService.showName(nombre));
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody MetodoCompra metodoCompra, @PathVariable Long id){
        return ResponseEntity.ok(metodoCompraService.update(metodoCompra, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return ResponseEntity.ok(metodoCompraService.delete(id));
    }
}
