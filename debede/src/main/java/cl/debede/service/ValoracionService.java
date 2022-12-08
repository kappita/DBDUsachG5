package cl.debede.service;

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
        return valoracionRepository.save(valoracion);
    }
    
    public List<Valoracion> getAll() {
        return valoracionRepository.findAll();
    }
    
    public Valoracion show(Long id) {
        return valoracionRepository.findById(id).get();
    }
    
    public String update(Valoracion valoracion, Long id) {
        Valoracion temp;
        try {
            temp = show(id);
            temp.setFavorito(valoracion.isFavorito());
            temp.setComentario(valoracion.getComentario());
            temp.setPuntuacion(valoracion.getPuntuacion());
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
