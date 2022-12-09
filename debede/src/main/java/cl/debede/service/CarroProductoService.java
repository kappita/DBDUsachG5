package cl.debede.service;

import cl.debede.model.CarroProducto;
import cl.debede.repository.CarroProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroProductoService {
    @Autowired
    private CarroProductoRepository carroProductoRepository;

    public CarroProducto create(CarroProducto carroProducto) {
        return carroProductoRepository.save(carroProducto);
    }
    
    public List<CarroProducto> getAll() {
        return carroProductoRepository.findAll();
    }
    
    public CarroProducto show(Long id) {
        return carroProductoRepository.findById(id).get();
    }
    
    public String delete(Long id) {
        try {
            carroProductoRepository.deleteById(id);
            return "CarroProducto eliminado";
        } catch (Exception e) {
            return "No existe CarroProducto con este ID";
        }
    }
    
}
