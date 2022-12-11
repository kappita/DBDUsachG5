package cl.debede.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer monto;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime fecha;
    
    @OneToOne
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;
    
    @ManyToOne
    @JoinColumn(name = "id_metodo")
    private MetodoCompra metodoCompra;
    
    public Transaccion() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    public Long getCarrito() {
        return carrito.getId();
    }

    public Carrito carritoGet(){
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    // Para retornar en Json
    public Long getMetodoCompra() {
        return metodoCompra.getId();
    }
    
    // Para trabajo interno
    public MetodoCompra metodoCompraGet() {
        return metodoCompra;
    }

    public void setMetodoCompra(MetodoCompra metodoCompra) {
        this.metodoCompra = metodoCompra;
    }
    
}
