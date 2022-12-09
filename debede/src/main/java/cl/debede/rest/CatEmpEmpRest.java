package cl.debede.rest;

import cl.debede.model.CatEmpEmp;
import cl.debede.service.CatEmpEmpService;
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
@RequestMapping("/catempemp")
public class CatEmpEmpRest {
    @Autowired
    private CatEmpEmpService catEmpEmpService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<CatEmpEmp> crear(@RequestBody CatEmpEmp catEmpEmp){
        CatEmpEmp resultado = catEmpEmpService.create(catEmpEmp);
        try {
            return ResponseEntity.created(new URI("/catempemp"+resultado.getId())).body(resultado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<CatEmpEmp>> getAllCatEmpEmp(){
        return ResponseEntity.ok(catEmpEmpService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CatEmpEmp> getCatEmpEmp(@PathVariable Long id){
        return ResponseEntity.ok(catEmpEmpService.show(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return ResponseEntity.ok(catEmpEmpService.delete(id));
    }
}
