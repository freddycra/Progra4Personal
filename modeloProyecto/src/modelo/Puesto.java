package modelo;

/**
 *
 * @author krist
 */
public class Puesto {

    public Puesto(int id_p, String nombre_puesto, String descripcion, int salario_ofrecido, int tipo_publicacion, int estado_publicacion, int empresa) {
        this.id_puesto = id_p;
        this.nombre_puesto = nombre_puesto;
        this.descripcion = descripcion;
        this.salario_ofrecido = salario_ofrecido;
        this.tipo_publicacion = tipo_publicacion; 
        this.estado_publicacion = estado_publicacion; 
        this.empresa = empresa;     
    }
    
    public Puesto(String nombre_puesto, String descripcion, int salario_ofrecido, int tipo_publicacion, int estado_publicacion, int empresa) {
        this.id_puesto = ++consecutivo;
        this.nombre_puesto = nombre_puesto;
        this.descripcion = descripcion;
        this.salario_ofrecido = salario_ofrecido;
        this.tipo_publicacion = tipo_publicacion; //0 -> Público, 1->Privada (dar dos opciones con radio)
        this.estado_publicacion = estado_publicacion; //0->disponible, 1->Ocupado (Opciones con radio)
        this.empresa = empresa; //Hay que implementarla para que al entrar a sesion el atributo quede guardado, no se pide
        /*
            Hay también que proponerle a la empresa categorias para el puesto,
        elige una o crea una nueva -> el valor de esto lo va a heredar la pag siguiente
        Luego hay que ofrecerle las subcategorias que hay disponibles, si ninguna de esas concuerda con los requerimientos
        la empresa puede crear una nueva, este valor también lo hereda la pag siguiente
        
        Así se crean las habilidades luego, cuando muestra la subcategoria pedida y se le pone el dominio de la misma
        y se relaciona con la informacion dada anteriormente acerca del puesto, se debe heredar el id de puesto
        para poder hacer la clase requerimientos con la subcategoría y el nivel deseado.
        
        Yo creo entonces que a la hora de estar haciendo el puesto haya una opcion de -> agregar requerimiento
        que lo reenvíe a la pag donde estan las categorias, subcategorías y el nivel deseado.
        
        Algo parecido a esto va a suceder a la hora de agregar un nuevo oferente, él ingresa los datos y después de ingresar los
        datos básicos va a una página en donde tiene que agregar las habilidades que posee.
        */
        
    }

    @Override
    public String toString() {
        return String.format("{Id: %d\nNombre: %s\nDescripcion: %s\nSalario: %f\n"
                + "Tipo_Publicacion: %d\nEstado_publicacion: %s\nEmpresa: %d}"
                , id_puesto, nombre_puesto, descripcion, salario_ofrecido, tipo_publicacion, estado_publicacion, empresa);
    }
    
    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getNombre_puesto() {
        return nombre_puesto;
    }

    public void setNombre_puesto(String nombre_puesto) {
        this.nombre_puesto = nombre_puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSalario_ofrecido() {
        return salario_ofrecido;
    }

    public void setSalario_ofrecido(int salario_ofrecido) {
        this.salario_ofrecido = salario_ofrecido;
    }

    public int getTipo_publicacion() {
        return tipo_publicacion;
    }

    public void setTipo_publicacion(int tipo_publicacion) {
        this.tipo_publicacion = tipo_publicacion;
    }

    public int getEstado_publicacion() {
        return estado_publicacion;
    }

    public void setEstado_publicacion(int estado_publicacion) {
        this.estado_publicacion = estado_publicacion;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }
    
    public static String encabezadosHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<th>Id_Puesto</th>");
        r.append("<th>Nombre Puesto</th>");
        r.append("<th>Descripcion</th>");
        r.append("<th>Salario Ofrecido</th>");
        r.append("<th>Tipo Publicacion</th>");
        r.append("<th>Estado de Publicacion</th>");
        r.append("<th>Id de Empresa</th>");
        return r.toString();
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append(String.format("<td>%d</td>", id_puesto));
        r.append(String.format("<td>%s</td>", nombre_puesto));
        r.append(String.format("<td>%s</td>", descripcion));
        r.append(String.format("<td>%d</td>", salario_ofrecido));
        r.append(String.format("<td>%d</td>", tipo_publicacion));
        r.append(String.format("<td>%d</td>", estado_publicacion));
        r.append(String.format("<td>%d</td>", empresa));
        return r.toString();
    }
    
    private int id_puesto; //El id del puesto va a ser un consecutivo
    
    private String nombre_puesto;
    private String descripcion;
    private int salario_ofrecido;
    private int tipo_publicacion;//Radio
    private int estado_publicacion;//Radio
    
    private int empresa;//Later
    public static int consecutivo = 40;
}