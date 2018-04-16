package modelo;

/**
 *
 * @author krist
 */
public class Habilidades {

    public Habilidades(int oferente, int subCategoria, int nivel) {
        this.oferente = oferente;
        this.subCategoria = subCategoria;
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return String.format("{Oferente: %d, SubCategoria: %d, Nivel: %d}", oferente, subCategoria, nivel);
    }
    
    public int getOferente() {
        return oferente;
    }

    public void setOferente(int oferente) {
        this.oferente = oferente;
    }

    public int getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(int subCategoria) {
        this.subCategoria = subCategoria;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public static String encabezadosHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<th>Id_Oferente</th>");
        r.append("<th>SubCategoria</th>");
        r.append("<th>Nivel de Dominio</th>");
        return r.toString();
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append(String.format("<td>%d</td>", oferente));
        r.append(String.format("<td>%d</td>", subCategoria));
        r.append(String.format("<td>%d</td>", nivel));
        return r.toString();
    }
    
    private int oferente;
    private int subCategoria;
    private int nivel; //Nivel de dominio de la subCategoría
}
