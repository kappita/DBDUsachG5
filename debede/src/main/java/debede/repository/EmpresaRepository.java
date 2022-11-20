package debede.repository;

import debede.model.Empresa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class EmpresaRepository {
    @Autowired
    private Sql2o sql2o;
    
    public Empresa crear(Empresa empresa){
        try(Connection conn = sql2o.open()) {
            String sql = "INSERT INTO empresa (id, nombre) " + 
                    "VALUES (:id, :nombre)";
            conn.createQuery(sql)
                    .addParameter("id", empresa.getId())
                    .addParameter("nombre", empresa.getNombre())
                    .executeUpdate();
            System.out.println("Se creo empresa");
            return empresa;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Empresa> getAll() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM empresa ORDER BY nombre ASC")
                    .executeAndFetch(Empresa.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Empresa> show(int id) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM empresa WHERE id=:id")
                    .addParameter("id", id)
                    .executeAndFetch(Empresa.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public String delete(int id) {
        try(Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM empresa WHERE id=:id")
                .addParameter("id", id)
                .executeUpdate();
            return "Se borro la empresa";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Se borro la empresa";
        }
    }
    
    public String update(Empresa empresa, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE empresa SET nombre=:nombre" + 
                    " WHERE id=:id";
            conn.createQuery(updateSql)
                .addParameter("id", id)
                .addParameter("nombre", empresa.getNombre())
                .executeUpdate();
            return "Se actualizo la Empresa";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Empresa";
        }
    }
}
