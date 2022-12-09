package cl.debede.service;

import cl.debede.model.Transaccion;
import cl.debede.repository.TransaccionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {
    
    @Autowired
    private TransaccionRepository transaccionRepository;

    public Transaccion create(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }
    
    public List<Transaccion> getAll() {
        return transaccionRepository.findAll();
    }
    
    public Transaccion show(Long id) {
        return transaccionRepository.findById(id).get();
    }
    
    public String update(Transaccion transaccion, Long id) {
        Transaccion temp;
        try{
            temp = show(id);
            temp.setFecha(transaccion.getFecha());
            temp.setMonto(transaccion.getMonto());
            transaccionRepository.save(temp);
            return "Transaccion actualizada";
        }
        catch(Exception e){
            return "No existe Transaccion con este ID";
        }
    }
    
    public String delete(Long id) {
        try{
            transaccionRepository.deleteById(id);
            return "Transaccion eliminada";
        } catch (Exception e) {
            return "No existe Transaccion con este ID";
        }
    }
}