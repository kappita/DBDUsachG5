package cl.debede.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "catempresa")
public class CatEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tipo_producto")
    private String tipoProducto;
    
    @OneToMany(mappedBy = "catEmpresa")
    private List<CatEmpEmp> catempemp;

    public CatEmpresa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_producto() {
        return tipoProducto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipoProducto = tipo_producto;
    }

    public List<CatEmpEmp> getCatempemp() {
        return catempemp;
    }

    public void setCatempemp(List<CatEmpEmp> catempemp) {
        this.catempemp = catempemp;
    }
    
}
