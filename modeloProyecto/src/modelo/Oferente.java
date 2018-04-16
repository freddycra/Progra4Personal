package modelo;

/**
 *
 * @author krist
 */
public class Oferente {

    public Oferente(int id_oferente, String nombre_oferente, String primer_apellido, String nacionalidad, int telefono, String correo, String residencia, int usuario) {
        this.id_oferente = id_oferente;
        this.nombre_oferente = nombre_oferente;
        this.primer_apellido = primer_apellido;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.correo = correo;
        this.residencia = residencia;
        this.usuario = usuario;
    }
    
    @Override
    public String toString() {
        return String.format("\n{Id: %d\nNombre: %s\nApellido: %s\nNacionalidad: %s\nTelefono: %d\n"
                + "Correo: %s\nResidencia: %s\nUsuario: %d}\n"
                , id_oferente, nombre_oferente, primer_apellido, nacionalidad, telefono, correo, residencia, usuario);
    }
    
    public int getId_oferente() {
        return id_oferente;
    }

    public void setId_oferente(int id_oferente) {
        this.id_oferente = id_oferente;
    }

    public String getNombre_oferente() {
        return nombre_oferente;
    }

    public void setNombre_oferente(String nombre_oferente) {
        this.nombre_oferente = nombre_oferente;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    public static String encabezadosHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<th>Id_Oferente</th>");
        r.append("<th>Nombre</th>");
        r.append("<th>Apellido</th>");
        r.append("<th>Nacionalidad</th>");
        r.append("<th>Telefono</th>");
        r.append("<th>Correo</th>");
        r.append("<th>Residencia</th>");
        r.append("<th>Tipo Usuario</th>");
        return r.toString();
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append(String.format("<td>%d</td>", id_oferente));
        r.append(String.format("<td>%s</td>", nombre_oferente));
        r.append(String.format("<td>%s</td>", primer_apellido));
        r.append(String.format("<td>%s</td>", nacionalidad));
        r.append(String.format("<td>%d</td>", telefono));
        r.append(String.format("<td>%s</td>", correo));
        r.append(String.format("<td>%s</td>", residencia));
        r.append(String.format("<td>%d</td>", usuario));
        return r.toString();
    }

    private int id_oferente;
    private String nombre_oferente;
    private String primer_apellido;
    private String nacionalidad;
    private int telefono;
    private String correo;
    private String residencia;
    private int usuario;
}
