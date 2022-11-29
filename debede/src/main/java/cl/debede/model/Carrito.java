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
@Table (name = "carrito")
public class Carrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Usuario usuario;
    
    @OneToOne
    @JoinColumn(name = "id_transaccion")
    private Transaccion transaccion;
        
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime fecha;

    public Carrito() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    // Retorna el id para Json
    public Long getUsuario() {
        return usuario.getId();
    }
    
    // Retorna el usuario para trabajo interno
    public Usuario userGet() {
        return usuario;
    }
    
    // Retorna el id para Json
    public Long getTransaccion() {
        return transaccion.getId();
    }
    
    // Retorna la transaccion para trabajo interno
    public Transaccion transaGet() {
        return transaccion;
    }
    
}
