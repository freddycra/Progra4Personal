package modelo.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Puesto;

/**
 *
 * @author krist
 */
public class ConjuntoPuestos implements Serializable {

    private ConjuntoPuestos() {
    }

    public static ConjuntoPuestos obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoPuestos();
        }
        return instancia;
    }

    public void agregar(Puesto nuevoPuesto) {
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareCall(CMD_AGREGAR)) {
                stm.clearParameters();
                stm.setInt(1, nuevoPuesto.getId_puesto());
                stm.setString(2, nuevoPuesto.getNombre_puesto());
                stm.setString(3, nuevoPuesto.getDescripcion());
                stm.setDouble(4, nuevoPuesto.getSalario_ofrecido());
                stm.setInt(5, nuevoPuesto.getTipo_publicacion());
                stm.setInt(6, nuevoPuesto.getEstado_publicacion());
                stm.setInt(7, nuevoPuesto.getEmpresa());

                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No puede agregar el resgistro de puesto: (%s)",
                            nuevoPuesto));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }

    public List<Puesto> obtenerPuestos() {
        List<Puesto> puestos = new ArrayList<>();
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

                while (rs.next()) {
                    int id_puesto = rs.getInt("id_puesto");
                    String nombre = rs.getString("nombre_puesto");
                    String descripcion = rs.getString("descripcion");
                    int salario = rs.getInt("salario_ofrecido");
                    int tipo = rs.getInt("tipo_publicacion");
                    int estado = rs.getInt("estado_publicacion");
                    int empresa = rs.getInt("empresa");
                    puestos.add(new Puesto(id_puesto, nombre, descripcion, salario, tipo, estado, empresa));
                }
            }
            return puestos;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return puestos;
    }
    
    public int obtenerMayorId() {
        int puesto = 0;
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareStatement(CMD_ULTIMO_ID)) {
                stm.clearParameters();
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        puesto = rs.getInt("id_puesto");
                    }
                }
            }     
            return puesto;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return puesto;
    }
    

    public List<Puesto> obtenerPuestosDeEmpresa(int num) {
        List<Puesto> puestos = new ArrayList<>();
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareStatement(CMD_LISTAR_POR_EMPRESA)) {
                stm.clearParameters();
                stm.setInt(1, num);
                try (ResultSet rs = stm.executeQuery()) {

                    while (rs.next()) {
                        int id_puesto = rs.getInt("id_puesto");
                        String nombre = rs.getString("nombre_puesto");
                        String descripcion = rs.getString("descripcion");
                        int salario = rs.getInt("salario_ofrecido");
                        int tipo = rs.getInt("tipo_publicacion");
                        int estado = rs.getInt("estado_publicacion");
                        int empresa = rs.getInt("empresa");
                        puestos.add(new Puesto(id_puesto, nombre, descripcion, salario, tipo, estado, empresa));
                    }
                }
            }
            return puestos;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return puestos;
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table>");
        r.append("\n<thead><tr>");
        r.append(Puesto.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Puesto p : obtenerPuestos()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    p.toStringHTML())
            );
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }

    public String toStringHTML_EMPRESA(int num) {
        StringBuilder r = new StringBuilder();
        r.append("\n<table>");
        r.append("\n<thead><tr>");
        r.append(Puesto.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Puesto p : obtenerPuestosDeEmpresa(num)) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    p.toStringHTML())
            );
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }

    private static final String CMD_LISTAR
            = "SELECT id_puesto, nombre_puesto, descripcion, salario_ofrecido, tipo_publicacion, estado_publicacion, empresa "
            + "FROM bancoempleo.puesto ORDER BY id_puesto ASC; ";

    private static final String CMD_LISTAR_POR_EMPRESA
            = "SELECT id_puesto, nombre_puesto, descripcion, salario_ofrecido, tipo_publicacion, estado_publicacion, empresa "
            + "FROM bancoempleo.puesto " + " WHERE empresa=? "
            + "ORDER BY id_puesto ASC; ";

    private static final String CMD_AGREGAR
            = "INSERT INTO bancoempleo.puesto "
            + "(id_puesto, nombre_puesto, descripcion, salario_ofrecido, tipo_publicacion, estado_publicacion, empresa) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?); ";

    private static final String CMD_ULTIMO_ID
            = "SELECT id_puesto "
            + "FROM bancoempleo.puesto " + " where id_puesto = (select max(id_puesto) from puesto); ";
    
    private static ConjuntoPuestos instancia = null;
}
