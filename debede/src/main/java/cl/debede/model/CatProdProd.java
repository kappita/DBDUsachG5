package cl.debede.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "catprodprod")
public class CatProdProd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "numero_serie")
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "id_catproducto")
    private CatProducto catProducto;

    public CatProdProd() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    // Retorna id para Json
    public Long getProducto() {
        return producto.getId();
    }
    
    // Retorna producto para trabajo interno
    public Producto productoGet() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    // Retorna id para Json
    public Long getCatProducto() {
        return catProducto.getId();
    }
    
    // Retorna producto para trabajo interno
    public CatProducto catProductoGet() {
        return catProducto;
    }

    public void setCatProducto(CatProducto catProducto) {
        this.catProducto = catProducto;
    }
    
}
