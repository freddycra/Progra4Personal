package modelo.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empresa;

/**
 *
 * @author krist
 */
public class ConjuntoEmpresas implements Serializable{
    
    private ConjuntoEmpresas() {
    }

    public static ConjuntoEmpresas obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoEmpresas();
        }    
        return instancia;
    }
    
    public void agregar(Empresa nuevaEmpresa) {
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareCall(CMD_AGREGAR)) {
                stm.clearParameters();
                stm.setInt(1, nuevaEmpresa.getId_empresa());
                stm.setString(2, nuevaEmpresa.getNombre_empresa());
                stm.setString(3, nuevaEmpresa.getLocalizacion());
                stm.setString(4, nuevaEmpresa.getCorreo());
                stm.setInt(5, nuevaEmpresa.getTelefono());
                stm.setString(6, nuevaEmpresa.getDescripcion());
                stm.setString(7, nuevaEmpresa.getClave());
                stm.setTimestamp(8, new java.sql.Timestamp(nuevaEmpresa.getFecha_registro().getTime()));
                stm.setInt(9, nuevaEmpresa.getUsuario());
                
                
                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No puede agregar el resgistro de empresa: (%s)",
                            nuevaEmpresa));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }
    
    public List<Empresa> obtenerEmpresas(){
        List<Empresa> empresas = new ArrayList<>();
        try{
            try(Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)){
                
                while(rs.next()){
                    int id_empresa = rs.getInt("id_empresa");
                    String nombre = rs.getString("nombre_empresa");
                    String localizacion = rs.getString("localizacion");
                    String correo = rs.getString("correo");
                    int telefono = rs.getInt("telefono");
                    String descripcion = rs.getString("descripcion");
                    String clave = rs.getString("clave");
                    java.util.Date fecha = new java.util.Date(rs.getTimestamp("fecha_registro").getTime());
                    int estado = rs.getInt("estado");
                    int usuario = rs.getInt("usuario");
                    empresas.add(new Empresa(id_empresa, nombre, localizacion, correo, telefono, descripcion, clave, fecha, estado,usuario));
                }
            }
            return empresas;
        }catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return empresas;
    }

    public List<Empresa> obtenerEmpresasPendientes(){
        List<Empresa> empresas = new ArrayList<>();
        try{
            try(Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR_PENDIENTES)){
                
                while(rs.next()){
                    int id_empresa = rs.getInt("id_empresa");
                    String nombre = rs.getString("nombre_empresa");
                    String localizacion = rs.getString("localizacion");
                    String correo = rs.getString("correo");
                    int telefono = rs.getInt("telefono");
                    String descripcion = rs.getString("descripcion");
                    String clave = rs.getString("clave");
                    java.util.Date fecha = new java.util.Date(rs.getTimestamp("fecha_registro").getTime());
                    int estado = rs.getInt("estado");
                    int usuario = rs.getInt("usuario");
                    empresas.add(new Empresa(id_empresa, nombre, localizacion, correo, telefono, descripcion, clave, fecha, estado,usuario));
                }
            }
            return empresas;
        }catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return empresas;
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table class=\"tabla\">");
        r.append("\n<thead><tr>");
        r.append(Empresa.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Empresa e : obtenerEmpresas()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    e.toStringHTML())
            );
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }
    
    public String toStringHTMLPendientes() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table class=\"tabla\">");
        r.append("\n<thead><tr>");
        r.append(Empresa.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Empresa e : obtenerEmpresasPendientes()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    e.toStringHTML())
            );
        }
        if(obtenerEmpresasPendientes().isEmpty()){
            r.append("\n<tr>");
            r.append("\n<td>No hay Empresas Pendientes</td>");
            r.append("\n</tr>");
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }
    
    
    public boolean autorizar(int id, int estado) {
        boolean exito = false;
        try {  
            try(Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(CMD_ACTUALIZAR)){
                stm.clearParameters();
                stm.setInt(1, estado);
                stm.setInt(2, id);

                int r = stm.executeUpdate();
                exito = (r==1);
            }
           
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
         return exito;
    }
    
    private static final String CMD_LISTAR
            = "SELECT id_empresa, nombre_empresa, localizacion, correo, telefono, descripcion, clave, fecha_registro, estado, usuario "
            + "FROM bancoempleo.empresa ORDER BY id_empresa DESC; ";
    
    private static final String CMD_LISTAR_PENDIENTES
            = "SELECT id_empresa, nombre_empresa, localizacion, correo, telefono, descripcion, clave, fecha_registro, estado, usuario "
            + "FROM bancoempleo.empresa WHERE estado=0 ORDER BY id_empresa DESC; ";
    
    private static final String CMD_AGREGAR
            = "INSERT INTO bancoempleo.empresa "
            + "(id_empresa, nombre_empresa, localizacion, correo, telefono, descripcion, clave, fecha_registro, usuario) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?); ";

    private static final String CMD_ACTUALIZAR
            = "UPDATE empresa SET estado=? WHERE id_empresa=?;";

    private static ConjuntoEmpresas instancia = null;
}