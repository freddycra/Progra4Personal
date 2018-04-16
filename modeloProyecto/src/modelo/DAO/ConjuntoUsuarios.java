package modelo.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;


/**
 *
 * @author krist
 */
public class ConjuntoUsuarios implements Serializable{
    
    private ConjuntoUsuarios() {
    }

    public static ConjuntoUsuarios obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoUsuarios();
        }    
        return instancia;
    }
    
    public List<Usuario> obtenerUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        try{
            try(Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)){
                
                while(rs.next()){
                    int id_usuario = rs.getInt("id_usuario");
                    int tipo = rs.getInt("tipo");
                    usuarios.add(new Usuario(id_usuario, tipo));
                }
            }
            return usuarios;
        }catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return usuarios;
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table>");
        r.append("\n<thead><tr>");
        r.append(Usuario.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Usuario u : obtenerUsuarios()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    u.toStringHTML())
            );
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }
    
    private static final String CMD_LISTAR
            = "SELECT id_usuario, tipo "
            + "FROM bancoempleo.usuario ORDER BY id_usuario ASC; ";
    
    private static ConjuntoUsuarios instancia = null;
}
