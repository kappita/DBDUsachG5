package cl.debede.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "carrito")
public class Carrito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "id_user")
    private Usuario user;
    
    @OneToOne
    @JoinColumn(name = "id_transaccion")
    private Transaccion transaccion;
    
    @JsonFormat(pattern = "DD-MM-YYYY", shape = Shape.STRING)
    private Date fecha;

    public Carrito() {
    }
    
}
