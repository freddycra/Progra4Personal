package modelo.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Oferente;


/**
 *
 * @author krist
 */
public class ConjuntoOferentes implements Serializable{
    
    private ConjuntoOferentes() {
    }

    public static ConjuntoOferentes obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoOferentes();
        }    
        return instancia;
    }
    
    public void agregar(Oferente nuevoOferente) {
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareCall(CMD_AGREGAR)) {
                stm.clearParameters();
                stm.setInt(1, nuevoOferente.getId_oferente());
                stm.setString(2, nuevoOferente.getNombre_oferente());
                stm.setString(3, nuevoOferente.getPrimer_apellido());
                stm.setString(4, nuevoOferente.getNacionalidad());
                stm.setInt(5, nuevoOferente.getTelefono());
                stm.setString(6, nuevoOferente.getCorreo());
                stm.setString(7, nuevoOferente.getResidencia());
                stm.setInt(8, nuevoOferente.getUsuario());
                
                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No puede agregar el resgistro de oferente: (%s)",
                            nuevoOferente));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }
    
    public List<Oferente> obtenerOferentes(){
        List<Oferente> oferentes = new ArrayList<>();
        try{
            try(Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)){
                
                while(rs.next()){
                    int id_oferente = rs.getInt("id_oferente");
                    String nombre = rs.getString("nombre_oferente");
                    String primerApellido = rs.getString("primer_apellido");
                    String nacionalidad = rs.getString("nacionalidad");
                    int telefono = rs.getInt("telefono");
                    String correo = rs.getString("correo");
                    String residencia = rs.getString("residencia");
                    int usuario = rs.getInt("usuario");
                    oferentes.add(new Oferente(id_oferente, nombre, primerApellido, nacionalidad, telefono, correo, residencia, usuario));
                }
            }
            return oferentes;
        }catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return oferentes;
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table>");
        r.append("\n<thead><tr>");
        r.append(Oferente.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Oferente o : obtenerOferentes()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    o.toStringHTML())
            );
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }
    
     private static final String CMD_LISTAR
            = "SELECT id_oferente, nombre_oferente, primer_apellido, nacionalidad, telefono, correo, residencia, usuario "
            + "FROM bancoempleo.oferente ORDER BY id_oferente DESC; ";
     
     private static final String CMD_AGREGAR
            = "INSERT INTO bancoempleo.oferente "
            + "(id_oferente, nombre_oferente, primer_apellido, nacionalidad, telefono, correo, residencia, usuario) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?); ";
     
    private static ConjuntoOferentes instancia = null;
}
