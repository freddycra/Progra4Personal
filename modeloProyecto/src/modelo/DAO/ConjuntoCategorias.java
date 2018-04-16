package modelo.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;


/**
 *
 * @author krist
 */
public class ConjuntoCategorias implements Serializable{
    
     private ConjuntoCategorias() {
    }

    public static ConjuntoCategorias obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoCategorias();
        }    
        return instancia;
    }
    
    public void agregar(Categoria nuevaCategoria) {
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareCall(CMD_AGREGAR)) {
                stm.clearParameters();
                
                stm.setInt(1, nuevaCategoria.getId_categoria());
                stm.setString(2, nuevaCategoria.getNombre_categoria());
                
                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No puede agregar el resgistro de categoria: (%s)",
                            nuevaCategoria));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }
    
    public List<Categoria> obtenerCategorias(){
        List<Categoria> categorias = new ArrayList<>();
        try{
            try(Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)){
                
                while(rs.next()){
                    int id_categoria = rs.getInt("id_categoria");
                    String nombre = rs.getString("nombre_categoria");
                    categorias.add(new Categoria(id_categoria, nombre));
                }
            }
            return categorias;
        }catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return categorias;
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table>");
        r.append("\n<thead><tr>");
        r.append(Categoria.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Categoria c : obtenerCategorias()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    c.toStringHTML())
            );
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }
    
    public static String menuCategoriasHTML() {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < obtenerInstancia().obtenerCategorias().size(); i++) {
            r.append(String.format(
                    "<option value=\"%d\">%s</option>",
                    (obtenerInstancia().obtenerCategorias()).get(i).getId_categoria(),
                    (obtenerInstancia().obtenerCategorias()).get(i).getNombre_categoria()
            ));
        }
        return r.toString();
    }
    
    private static final String CMD_LISTAR
            = "SELECT id_categoria, nombre_categoria "
            + "FROM bancoempleo.categoria ORDER BY id_categoria DESC; ";
    
    private static final String CMD_AGREGAR
            = "INSERT INTO bancoempleo.categoria "
            + "(id_categoria, nombre_categoria) "
            + "VALUES(?, ?); ";
    
    private static ConjuntoCategorias instancia = null;
}