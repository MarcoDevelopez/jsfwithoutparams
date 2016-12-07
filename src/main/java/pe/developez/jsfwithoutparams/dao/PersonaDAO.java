package pe.developez.jsfwithoutparams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.developez.jsfwithoutparams.model.Persona;
import pe.developez.jsfwithoutparams.util.DBUtil;

public class PersonaDAO {

  private Connection con;

  public void insertar(Persona p) {
    String sql = "insert into persona(nombres, apellidos, telefono) values(?,?,?)";
    try {
      con = DBUtil.openConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, p.getNombres());
      ps.setString(2, p.getApellidos());
      ps.setString(3, p.getTelefono());
      ps.execute();
    } catch (SQLException ex) {
      Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      DBUtil.closeConnection();
    }
  }

  public void actualizar(Persona p) {
    String sql = "update persona set nombres=?, apellidos=?, telefono=? where id=?";
    try {
      con = DBUtil.openConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, p.getNombres());
      ps.setString(2, p.getApellidos());
      ps.setString(3, p.getTelefono());
      ps.setInt(4, p.getId());
      ps.execute();
    } catch (SQLException ex) {
      Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      DBUtil.closeConnection();
    }
  }

  public void eliminar(Persona p) {
    String sql = "delete from persona where id=?";
    try {
      con = DBUtil.openConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, p.getId());
    } catch (SQLException ex) {
      Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      DBUtil.closeConnection();
    }
  }

  public Persona getById(Integer id) {
    Persona p = null;
    String sql = "select id, nombres, apellidos, telefono from persona where id=?";
    try {
      con = DBUtil.openConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        p = new Persona();
        p.setId(rs.getInt("id"));
        p.setNombres(rs.getString("nombres"));
        p.setApellidos(rs.getString("apellidos"));
        p.setTelefono(rs.getString("telefono"));
      }
    } catch (SQLException ex) {
      Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return p;
  }

  public List<Persona> lista() {
    List<Persona> personas = new ArrayList<Persona>();
    String sql = "select id, nombres, apellidos, telefono from persona order by nombres asc";
    try {
      con = DBUtil.openConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Persona p = new Persona();
        p.setId(rs.getInt("id"));
        p.setNombres(rs.getString("nombres"));
        p.setApellidos(rs.getString("apellidos"));
        p.setTelefono(rs.getString("telefono"));
        personas.add(p);
      }
    } catch (SQLException ex) {
      Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return personas;
  }

}
