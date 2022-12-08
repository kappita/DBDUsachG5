package cl.debede.model;

import java.util.List;
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
    
    private String tipo_producto;
    
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
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public List<CatEmpEmp> getCatempemp() {
        return catempemp;
    }

    public void setCatempemp(List<CatEmpEmp> catempemp) {
        this.catempemp = catempemp;
    }
    
}
