
package cl.debede.controller;

import cl.debede.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UsuariosController {
    private final UsuarioRepository usuarioRepository;
    
    public UsuariosController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    
    
    @RequestMapping("/usuarios")
    public String getUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios";
    }
}
