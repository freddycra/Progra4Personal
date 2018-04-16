package modelo.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Administrador;

/**
 *
 * @author krist
 */
public class ConjuntoAdministradores implements Serializable {

    private ConjuntoAdministradores() {
    }

    public static ConjuntoAdministradores obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoAdministradores();
        }
        return instancia;
    }

    public void agregar(Administrador nuevoAdministrador) {
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareCall(CMD_AGREGAR)) {
                stm.clearParameters();
                stm.setInt(1, nuevoAdministrador.getId_administrador());
                stm.setString(2, nuevoAdministrador.getNombre_administrador());
                stm.setString(3, nuevoAdministrador.getClave());
                stm.setInt(4, nuevoAdministrador.getUsuario());

                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No puede agregar el resgistro de administrador: (%s)",
                            nuevoAdministrador));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }

    public List<Administrador> obtenerAdministradores() {
        List<Administrador> administradores = new ArrayList<>();
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

                while (rs.next()) {
                    int id_administrador = rs.getInt("id_administrador");
                    String nombre = rs.getString("nombre_administrador");
                    String clave = rs.getString("clave");
                    int usuario = rs.getInt("usuario");
                    administradores.add(new Administrador(id_administrador, nombre, clave, usuario));
                }
            }
            return administradores;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return administradores;
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table>");
        r.append("\n<thead><tr>");
        r.append(Administrador.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Administrador a : obtenerAdministradores()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    a.toStringHTML())
            );
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }

    private static final String CMD_LISTAR
            = "SELECT id_administrador,  nombre_administrador, clave, usuario "
            + "FROM bancoempleo.administrador ORDER BY id_administrador ASC; ";

    private static final String CMD_AGREGAR
            = "INSERT INTO bancoempleo.administrador "
            + "(id_administrador, nombre_administrador, clave, usuario) "
            + "VALUES(?, ?, ?, ?); ";

    private static ConjuntoAdministradores instancia = null;
}
