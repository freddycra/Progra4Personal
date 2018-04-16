package modelo;

/**
 *
 * @author krist
 */
public class Oferente {

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Oferente(int id_oferente, String nombre_oferente, String primer_apellido, String nacionalidad, int telefono, String correo, String residencia, int estado, int usuario) {
        this.id_oferente = id_oferente;
        this.nombre_oferente = nombre_oferente;
        this.primer_apellido = primer_apellido;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.correo = correo;
        this.residencia = residencia;
        this.estado = estado;
        this.usuario = usuario;
        this.clave = null;
    }
    
    @Override
    public String toString() {
        return String.format("\n{Id: %d\nNombre: %s\nApellido: %s\nNacionalidad: %s\nTelefono: %d\n"
                + "Correo: %s\nResidencia: %s\nEstado: %d\nUsuario: %d}\n"
                , id_oferente, nombre_oferente, primer_apellido, nacionalidad, telefono, correo, residencia,estado, usuario);
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public String convertirEstado() {
        String e = "";
        if (estado == 0) {
            e = "En Espera";
        } else if (estado == 1) {
            e = "Rechazado";
        } else if (estado == 2) {
            e = "Aprobado";
        }
        return e;
    }
    
    public String tipoUsuario(){
        if(usuario==3){
        return "Oferente";
        }else{
            return "Desconocido";
        }
    }
    
    public static String encabezadosHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<th class=\"encabezado\">Id_Oferente</th>");
        r.append("<th class=\"encabezado\">Nombre</th>");
        r.append("<th class=\"encabezado\">Apellido</th>");
        r.append("<th class=\"encabezado\">Nacionalidad</th>");
        r.append("<th class=\"encabezado\">Telefono</th>");
        r.append("<th class=\"encabezado\">Correo</th>");
        r.append("<th class=\"encabezado\">Residencia</th>");
        r.append("<th class=\"encabezado\">Estado</th>");
        r.append("<th class=\"encabezado\">Tipo Usuario</th>");
        return r.toString();
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append(String.format("<td class=\"campo\">%d</td>", id_oferente));
        r.append(String.format("<td class=\"campo\">%s</td>", nombre_oferente));
        r.append(String.format("<td class=\"campo\">%s</td>", primer_apellido));
        r.append(String.format("<td class=\"campo\">%s</td>", nacionalidad));
        r.append(String.format("<td class=\"campo\">%d</td>", telefono));
        r.append(String.format("<td class=\"campo\">%s</td>", correo));
        r.append(String.format("<td class=\"campo\">%s</td>", residencia));
        r.append(String.format("<td class=\"campo\">%s</td>", convertirEstado()));
        r.append(String.format("<td class=\"campo\">%s</td>", tipoUsuario()));
        return r.toString();
    }

    private int id_oferente;
    private String nombre_oferente;
    private String primer_apellido;
    private String nacionalidad;
    private int telefono;
    private String correo;
    private String residencia;
    private String clave;
    private int estado;
    private int usuario;
}
