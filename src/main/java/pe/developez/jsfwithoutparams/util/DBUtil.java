package pe.developez.jsfwithoutparams.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {

  private static Connection connection = null;

  public static Connection openConnection() {
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prueba", "postgres", "123456789");
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
    }
    return connection;
  }

  public static void closeConnection() {
    try {
      connection.close();
    } catch (SQLException ex) {
      Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
