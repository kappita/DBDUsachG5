package cl.debede.rest;

import cl.debede.model.Usuario;
import cl.debede.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioRest {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario){
        Usuario resultado = usuarioService.create(usuario);
        try {
            return ResponseEntity.created(new URI("/usuario"+resultado.getId())).body(resultado);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuario(){
        return ResponseEntity.ok(usuarioService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.show(id));
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody Usuario usuario, @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.update(usuario, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.delete(id));
    }
    
}
