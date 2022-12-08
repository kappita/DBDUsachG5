package cl.debede.rest;

import cl.debede.model.CatProdProd;
import cl.debede.service.CatProdProdService;
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
@RequestMapping("/catprodprod")
public class CatProdProdRest {
    @Autowired
    private CatProdProdService catProdProdService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<CatProdProd> crear(@RequestBody CatProdProd catProdProd){
        CatProdProd resultado = catProdProdService.create(catProdProd);
        try {
            return ResponseEntity.created(new URI("/catprodprod"+resultado.getId())).body(resultado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<CatProdProd>> getAllCarrito(){
        return ResponseEntity.ok(catProdProdService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CatProdProd> getCarrito(@PathVariable Long id){
        return ResponseEntity.ok(catProdProdService.show(id));
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody CatProdProd catProdProd, @PathVariable Long id){
        return ResponseEntity.ok(catProdProdService.update(catProdProd, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return ResponseEntity.ok(catProdProdService.delete(id));
    }
}
