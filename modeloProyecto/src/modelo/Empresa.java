package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.text.StringEscapeUtils;

/**
 *
 * @author krist
 */
public class Empresa {

    public Empresa(int id_empresa, String nombre_empresa, String localizacion, String correo, int telefono, String descripcion, String clave, Date fecha_registro, int usuario) {
        this.id_empresa = id_empresa;
        this.nombre_empresa = nombre_empresa;
        this.localizacion = localizacion;
        this.correo = correo;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.clave = clave;
        this.fecha_registro = fecha_registro;
        this.usuario = usuario;
    }
    
    @Override
    public String toString() {
        return String.format("\n{Id: %d\nNombre: %s\nLocalizacion: %s\nCorreo: %s\nTelefono: %d\nDescripcion: %s\n"
                + "Clave: %s\nFecha Inscripcion: %s\nUsuario: %d\n", 
                id_empresa, nombre_empresa, localizacion, correo, telefono,descripcion, clave, fecha_registro.toString(), usuario);
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public static String encabezadosHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<th>Id_Empresa</th>");
        r.append("<th>Nombre</th>");
        r.append("<th>Localizacion</th>");
        r.append("<th>Correo</th>");
        r.append("<th>Telefono</th>");
        r.append("<th>Descripcion</th>");
        r.append("<th>Clave</th>");
        r.append("<th>Fecha Registro</th>");
        r.append("<th>Tipo Usuario</th>");
        return r.toString();
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append(String.format("<td>%d</td>", id_empresa));
        r.append(String.format("<td>%s</td>", nombre_empresa));
        r.append(String.format("<td>%s</td>", localizacion));
        r.append(String.format("<td>%s</td>", correo));
        r.append(String.format("<td>%d</td>", telefono));
        r.append(String.format("<td>%s</td>", descripcion));
        r.append(String.format("<td>%s</td>", clave));
        r.append(String.format("<td>%s</td>", df.format(fecha_registro)));
        r.append(String.format("<td>%d</td>", usuario));
        return r.toString();
    }
    
    private int id_empresa;
    private String nombre_empresa;
    private String localizacion;
    private String correo;
    private int telefono;
    private String descripcion;
    private String clave;
    private Date fecha_registro;
    private int usuario;
    
    private static DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm");
}