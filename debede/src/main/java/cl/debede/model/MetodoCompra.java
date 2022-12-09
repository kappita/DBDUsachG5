package cl.debede.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "metodocompra")
public class MetodoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre_metodo;
    private String tipo_pago;
    private String tipo_cambio;
    
    @OneToMany(mappedBy = "metodoCompra")
    private List<Transaccion> transacciones;

    public MetodoCompra() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_metodo() {
        return nombre_metodo;
    }

    public void setNombre_metodo(String nombre_metodo) {
        this.nombre_metodo = nombre_metodo;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getTipo_cambio() {
        return tipo_cambio;
    }

    public void setTipo_cambio(String tipo_cambio) {
        this.tipo_cambio = tipo_cambio;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
    
}
