package modelo.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Requerimientos;

/**
 *
 * @author krist
 */
public class ConjuntoRequerimientos implements Serializable{
    
    private ConjuntoRequerimientos() {
    }

    public static ConjuntoRequerimientos obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoRequerimientos();
        }    
        return instancia;
    }
    
    public void agregar(Requerimientos nuevosRequerimientos) {
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareCall(CMD_AGREGAR)) {
                stm.clearParameters();
                stm.setInt(1, nuevosRequerimientos.getPuesto());
                stm.setInt(2, nuevosRequerimientos.getSubCategoria());
                stm.setInt(3, nuevosRequerimientos.getNivel());
                
                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No puede agregar el resgistro del requerimiento: (%s)",
                            nuevosRequerimientos));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }
    
    public List<Requerimientos> obtenerRequerimientos(){
        List<Requerimientos> requerimientos = new ArrayList<>();
        try{
            try(Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)){
                
                while(rs.next()){
                    int puesto = rs.getInt("puesto");
                    int subCategoria = rs.getInt("subCategoria");
                    int nivel = rs.getInt("nivel");
                    requerimientos.add(new Requerimientos(puesto, subCategoria, nivel));
                }
            }
            return requerimientos;
        }catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return requerimientos;
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table>");
        r.append("\n<thead><tr>");
        r.append(Requerimientos.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Requerimientos q : obtenerRequerimientos()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    q.toStringHTML())
            );
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }
    
     private static final String CMD_LISTAR
            = "SELECT puesto, subCategoria, nivel "
            + "FROM bancoempleo.requerimientos ORDER BY puesto ASC; ";
     
     private static final String CMD_AGREGAR
            = "INSERT INTO bancoempleo.requerimientos "
            + "(puesto, subCategoria, nivel) "
            + "VALUES(?, ?, ?); ";
    
    private static ConjuntoRequerimientos instancia = null;
}
