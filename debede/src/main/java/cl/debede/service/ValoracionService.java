package cl.debede.service;

import cl.debede.model.Empresa;
import cl.debede.model.Usuario;
import cl.debede.model.Valoracion;
import cl.debede.repository.ValoracionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValoracionService {
    @Autowired
    private ValoracionRepository valoracionRepository;

    public Valoracion create(Valoracion valoracion) {
        try { // se verifica que exista anteriormente para actualizarla
            Valoracion temp = showUserAndEmpress(valoracion.usuarioGet(), valoracion.empresaGet());
            temp.setComentario(valoracion.getComentario());
            temp.setFavorito(valoracion.isFavorito());
            temp.setPuntuacion(valoracion.getPuntuacion());
            return valoracionRepository.save(temp);
        } catch (Exception e) {
            return valoracionRepository.save(valoracion);
        }
    }
    
    public List<Valoracion> getAll() {
        return valoracionRepository.findAll();
    }
    
    public Valoracion show(Long id) {
        return valoracionRepository.findById(id).get();
    }
    
    public Valoracion showUserAndEmpress(Usuario user, Empresa empress) {
        return valoracionRepository.findByUsuarioAndEmpresa(user, empress).get();
    }
    
    public String update(Valoracion valoracion, Long id) {
        Valoracion temp;
        try {
            temp = show(id);
            if(valoracion.isFavorito()!= null)
                temp.setFavorito(valoracion.isFavorito());
            if(valoracion.getComentario() != null)
                temp.setComentario(valoracion.getComentario());
            if(valoracion.getPuntuacion()<= 0)
                temp.setPuntuacion(valoracion.getPuntuacion());
            valoracionRepository.save(temp);
            return "Valoracion Actualizada";
        }
        catch(Exception e){
            return "No existe Valoracion con este ID";
        }
    }
    
    public String delete(Long id) {
        try {
            valoracionRepository.deleteById(id);
            return "Valoracion eliminada";
        } catch (Exception e) {
            return "No existe Valoracion con este ID";
        }
    }
    
}
