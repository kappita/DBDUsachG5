package cl.debede.rest;

import cl.debede.model.CatEmpresa;
import cl.debede.service.CatEmpresaService;
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
@RequestMapping("/catempresa")
public class CatEmpresaRest {
    @Autowired
    private CatEmpresaService catEmpresaService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<CatEmpresa> crear(@RequestBody CatEmpresa catEmpresa){
        CatEmpresa resultado = catEmpresaService.create(catEmpresa);
        try {
            return ResponseEntity.created(new URI("/catempresa"+resultado.getId())).body(resultado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<CatEmpresa>> getAllCarrito(){
        return ResponseEntity.ok(catEmpresaService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CatEmpresa> getCarrito(@PathVariable Long id){
        return ResponseEntity.ok(catEmpresaService.show(id));
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody CatEmpresa catEmpresa, @PathVariable Long id){
        return ResponseEntity.ok(catEmpresaService.update(catEmpresa, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return ResponseEntity.ok(catEmpresaService.delete(id));
    }
}
