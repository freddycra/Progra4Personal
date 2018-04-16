package modelo.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.SubCategoria;

/**
 *
 * @author krist
 */
public class ConjuntoSubCategorias implements Serializable{
    
    private ConjuntoSubCategorias() {
    }

    public static ConjuntoSubCategorias obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoSubCategorias();
        }    
        return instancia;
    }
    
    public void agregar(SubCategoria nuevaSubCategoria) {
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareCall(CMD_AGREGAR)) {
                stm.clearParameters();
                stm.setInt(1, nuevaSubCategoria.getId_subCategoria());
                stm.setString(2, nuevaSubCategoria.getNombre_subCategoria());
                stm.setInt(3, nuevaSubCategoria.getCategoria());
                
                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No puede agregar el resgistro de subCategoria: (%s)",
                            nuevaSubCategoria));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }
    
    public List<SubCategoria> obtenerSubCategorias(){
        List<SubCategoria> subCategorias = new ArrayList<>();
        try{
            try(Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)){
                
                while(rs.next()){
                    int id_subCategoria = rs.getInt("id_subCategoria");
                    String nombre = rs.getString("nombre_subCategoria");
                    int categoria = rs.getInt("categoria");
                    
                    subCategorias.add(new SubCategoria(id_subCategoria, nombre, categoria));
                }
            }
            return subCategorias;
        }catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return subCategorias;
    }
    
    public List<SubCategoria> obtenerSubCategoriasPorCategoria(int cat){
        List<SubCategoria> subCategorias = new ArrayList<>();
        try{
            Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareStatement(CMD_LISTAR_POR_CATEGORIA);
                    stm.setInt(1, cat);
                    ResultSet rs = stm.executeQuery(CMD_LISTAR_POR_CATEGORIA);
                    
                    while(rs.next()){
                        subCategorias.add(new SubCategoria(rs.getInt("id_subCategoria"),
                                rs.getString("nombre_subCategoria"), rs.getInt("categoria")));
                    }
            
            return subCategorias;
            
        }catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return subCategorias;
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table>");
        r.append("\n<thead><tr>");
        r.append(SubCategoria.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (SubCategoria s : obtenerSubCategorias()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    s.toStringHTML())
            );
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }
    
    private static final String CMD_LISTAR
            = "SELECT id_subCategoria, nombre_subCategoria, categoria "
            + "FROM bancoempleo.subCategoria ORDER BY id_subCategoria ASC; ";
    
    private static final String CMD_LISTAR_POR_CATEGORIA
            = "SELECT subCategoria.nombre_subCategoria "
            + "FROM bancoempleo.subCategoria "
            + "WHERE subCategoria.categoria = ? ORDER BY id_subCategoria ASC; ";
    
    private static final String CMD_AGREGAR
            = "INSERT INTO bancoempleo.subCategoria "
            + "(id_subCategoria, nombre_subCategoria, categoria) "
            + "VALUES(?, ?, ?); ";
    
    private static ConjuntoSubCategorias instancia = null;
}
