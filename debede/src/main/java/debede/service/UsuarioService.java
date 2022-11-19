package debede.service;

import debede.model.Usuario;
import debede.repository.UsuarioRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    @PostMapping("/usuario")
    @ResponseBody
    public Usuario crear(@RequestBody Usuario usuario){
        Usuario resultado = usuarioRepository.crear(usuario);
        return resultado;
    }
    
    @GetMapping("/usuario")
    public List<Usuario> getAllUsuario(){
        return usuarioRepository.getAll();
    }
    
    @GetMapping("/usuario/{id}")
    public List<Usuario> getUsuario(@PathVariable int id){
        return usuarioRepository.show(id);
    }

    @PutMapping("/usuario/{id}")
    @ResponseBody
    public String updateCategoria(@RequestBody Usuario usuario, @PathVariable int id){
        String retorno = usuarioRepository.update(usuario,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/usuario/{id}")
    public void borrar(@PathVariable int id){
        usuarioRepository.delete(id);
    }
    
}
