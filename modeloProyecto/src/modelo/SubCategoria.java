package modelo;

/**
 *
 * @author krist
 */
public class SubCategoria {

    public SubCategoria(int id_subCategoria, String nombre_subCategoria, int categoria) {
        this.id_subCategoria = id_subCategoria;
        this.nombre_subCategoria = nombre_subCategoria;
        this.categoria = categoria;
    }
    
    @Override
    public String toString() {
        return String.format("{Id: %d, Nombre: %s, Categoria: %d}", id_subCategoria, nombre_subCategoria, categoria);
    }

    public int getId_subCategoria() {
        return id_subCategoria;
    }

    public void setId_subCategoria(int id_subCategoria) {
        this.id_subCategoria = id_subCategoria;
    }

    public String getNombre_subCategoria() {
        return nombre_subCategoria;
    }

    public void setNombre_subCategoria(String nombre_subCategoria) {
        this.nombre_subCategoria = nombre_subCategoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    public static String encabezadosHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<th>Id_SubCategoria</th>");
        r.append("<th>Nombre</th>");
        r.append("<th>Categoria Perteneciente</th>");
        return r.toString();
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append(String.format("<td>%d</td>", id_subCategoria));
        r.append(String.format("<td>%s</td>", nombre_subCategoria));
        r.append(String.format("<td>%d</td>", categoria));
        return r.toString();
    }
    
    private int id_subCategoria;
    private String nombre_subCategoria;
    private int categoria;
}