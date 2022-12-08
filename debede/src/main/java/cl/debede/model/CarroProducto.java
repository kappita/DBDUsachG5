package cl.debede.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "carroproducto")
public class CarroProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;
    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public CarroProducto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Retorna el carrito para Json
    public Long getCarrito() {
        return carrito.getId();
    }

    // Retorna el carrito para trabajo interno
    public Carrito carritoGet() {
        return carrito;
    }
    
    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
    
    // Retorna el carrito para Json
    public Long getProducto() {
        return producto.getId();
    }

    // Retorna el carrito para trabajo interno
    public Producto productoGet() {
        return producto;
    }    
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
