package cl.debede.rest;

import cl.debede.model.CatProducto;
import cl.debede.service.CatProductoService;
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
@RequestMapping("/catproducto")
public class CatProductoRest {
    @Autowired
    private CatProductoService catProductoService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<CatProducto> crear(@RequestBody CatProducto catProducto){
        CatProducto resultado = catProductoService.create(catProducto);
        try {
            return ResponseEntity.created(new URI("/catproducto"+resultado.getId())).body(resultado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<CatProducto>> getAllCatProducto(){
        return ResponseEntity.ok(catProductoService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CatProducto> getCatProducto(@PathVariable Long id){
        return ResponseEntity.ok(catProductoService.show(id));
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody CatProducto catProducto, @PathVariable Long id){
        return ResponseEntity.ok(catProductoService.update(catProducto, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return ResponseEntity.ok(catProductoService.delete(id));
    }
}
