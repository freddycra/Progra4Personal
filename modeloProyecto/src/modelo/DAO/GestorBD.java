package modelo.DAO;

import cr.ac.database.managers.DBManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author krist
 */
public class GestorBD {
     private GestorBD() {
        try {
            bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER);
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }

    public static GestorBD obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorBD();
        }
        return instancia;
    }

    public Connection obtenerConexion() throws SQLException {
        return bd.getConnection(BASE_DATOS, USUARIO, CLAVE);
    }

    public void run() {
        try {
            System.out.printf("%s%n", bd);
            System.out.printf("Trying to connect to '%s' database..%n", BASE_DATOS);
            try (Connection cnx = bd.getConnection(BASE_DATOS, USUARIO, CLAVE)) {
                System.out.println("Connection successful..");
            }
        } catch (SQLException ex) {
            System.err.printf("Exception: '%s'%n", ex.getMessage());
        }
    }
    
    private static final String BASE_DATOS = "bancoempleo";
    private static final String USUARIO = "root";
    private static final String CLAVE = "admin";

    private DBManager bd = null;
    private static GestorBD instancia = null;
}
