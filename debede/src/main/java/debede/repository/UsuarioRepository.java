/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package debede.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import debede.model.Usuario;
import java.util.List;
import org.sql2o.Connection;

/**
 *
 * @author joaquin
 */
@Repository
public class UsuarioRepository {
    @Autowired
    private Sql2o sql2o;
    
    public Usuario crear(Usuario usuario){
        try(Connection conn = sql2o.open()) {
            String sql = "INSERT INTO usuario (id, nombre, edad, correo, clave, dirreccion, admin) " + 
                    "VALUES (:id, :nombre, :edad, :correo, :clave, :direccion, :admin)";
            conn.createQuery(sql)
                    .addParameter("id", usuario.getId())
                    .addParameter("nombre", usuario.getNombre())
                    .addParameter("edad", usuario.getEdad())
                    .addParameter("correo", usuario.getCorreo())
                    .addParameter("clave", usuario.getClave())
                    .addParameter("direccion", usuario.getDireccion())
                    .addParameter("admin", Boolean.FALSE)
                    .executeUpdate();
            System.out.println("Se creo usuario");
            return usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Usuario> getAll() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM usuario ORDER BY nombre ASC")
                    .executeAndFetch(Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Usuario> show(int id) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM usuario WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(Usuario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void delete(int id) {
        try(Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM usuario WHERE id = :id")
                .addParameter("id", id)
                .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String update(Usuario usuario, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE empresa SET nombre=:nombre, edad=:edad, " + 
                    "correo=:correo, clave:=clave,direccion=:direccion WHERE id=:id";
            conn.createQuery(updateSql)
                .addParameter("id", id)
                .addParameter("nombre", usuario.getNombre())
                .addParameter("edad", usuario.getEdad())
                .addParameter("correo", usuario.getCorreo())
                .addParameter("clave", usuario.getClave())
                .addParameter("direccion", usuario.getDireccion())
                .executeUpdate();
            return "Se actualizo el Usuario";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Usuario";
        }
    }
    
}
