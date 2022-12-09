package cl.debede.model;

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
    
    @OneToOne(mappedBy = "carrito")
    private Transaccion transaccion;

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

    // Retorna el id para Json
    public Long getUsuario() {
        return usuario.getId();
    }
    
    // Retorna el usuario para trabajo interno
    public Usuario userGet() {
        return usuario;
    }
    
    // Retorna la transaccion para trabajo interno
    public Transaccion getTransaccion() {
        return transaccion;
    }
    
}
