package modelo.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Habilidades;

/**
 *
 * @author krist
 */
public class ConjuntoHabilidades implements Serializable{
    
    private ConjuntoHabilidades() {
    }

    public static ConjuntoHabilidades obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoHabilidades();
        }    
        return instancia;
    }
    
    public void agregar(Habilidades nuevasHabilidades) {
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareCall(CMD_AGREGAR)) {
                stm.clearParameters();
                stm.setInt(1, nuevasHabilidades.getOferente());
                stm.setInt(2, nuevasHabilidades.getSubCategoria());
                stm.setInt(3, nuevasHabilidades.getNivel());
                
                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No puede agregar el resgistro de las habilidades: (%s)",
                            nuevasHabilidades));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }
    
    public List<Habilidades> obtenerHabilidades(){
        List<Habilidades> habilidades= new ArrayList<>();
        try{
            try(Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)){
                
                while(rs.next()){
                    int oferente = rs.getInt("oferente");
                    int subCategoria = rs.getInt("subCategoria");
                    int nivel = rs.getInt("nivel");
                    habilidades.add(new Habilidades(oferente, subCategoria, nivel));
                }
            }
            return habilidades;
        }catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return habilidades;
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table>");
        r.append("\n<thead><tr>");
        r.append(Habilidades.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Habilidades a : obtenerHabilidades()) {
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
            = "SELECT oferente, subCategoria, nivel "
            + "FROM bancoempleo.habilidades ORDER BY oferente ASC; ";
    
    private static final String CMD_AGREGAR
            = "INSERT INTO bancoempleo.habilidades "
            + "(oferente, subCategoria, nivel) "
            + "VALUES(?, ?, ?); ";
    
    private static ConjuntoHabilidades instancia = null;
}