package cl.debede.service;

import cl.debede.model.Usuario;
import cl.debede.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }
    
    public Usuario show(Long id) {
        return usuarioRepository.findById(id).get();
    }
    
    public List<Usuario> showName(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }
    
    public String update(Usuario usuario, Long id) {
        Usuario temp;
        try {
            temp = show(id);
            if(usuario.getNombre() != null)
                temp.setNombre(usuario.getNombre());
            if(usuario.getEdad() <= 0)
                temp.setEdad(usuario.getEdad());
            if(usuario.getCorreo() != null)
                temp.setCorreo(usuario.getCorreo());
            if(usuario.getClave() != null)
                temp.setClave(usuario.getClave());
            if(usuario.getDireccion() != null)
                temp.setDireccion(usuario.getDireccion());
            usuarioRepository.save(temp);
            return "Usuario actualizado";
        }
        catch(Exception e) {
            return "No existe un usuario con este ID";
        }
    }
    
    public String delete(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return "Usuario Borrado";
        } catch (Exception e){
            return "No existe un usuario con este ID";
        }
    }
    
}