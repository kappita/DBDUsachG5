package cl.debede.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "catempemp")
public class CatEmpEmp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_catempresa")
    private CatEmpresa catEmpresa;
    
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public CatEmpEmp() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Retorna el carrito para Json
    public Long getCatEmpresa() {
        return catEmpresa.getId();
    }

    // Retorna el carrito para trabajo interno
    public CatEmpresa catEmpresaGet() {
        return catEmpresa;
    }
    
    public void setCatEmpresa(CatEmpresa catempresa) {
        this.catEmpresa = catempresa;
    }
    
    // Retorna el carrito para Json
    public Long getEmpresa() {
        return empresa.getId();
    }

    // Retorna el carrito para trabajo interno
    public Empresa empresaGet() {
        return empresa;
    }    
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
