package modelo;

/**
 *
 * @author krist
 */
public class Categoria {

    public Categoria(int id_categoria, String nombre_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
    }
    
    @Override
    public String toString() {
        return String.format("{%d, %s}", id_categoria, nombre_categoria);
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
    
    public static String encabezadosHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<th>Nombre Categoria</th>");
        return r.toString();
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append(String.format("<td>%s</td>", nombre_categoria));
        return r.toString();
    }
    
    
    private int id_categoria;
    private String nombre_categoria;
}
