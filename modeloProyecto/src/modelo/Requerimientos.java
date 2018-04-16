package modelo;

/**
 *
 * @author krist
 */
public class Requerimientos {

    public Requerimientos(int puesto, int subCategoria, int nivel) {
        this.puesto = puesto;
        this.subCategoria = subCategoria;
        this.nivel = nivel;
    }
    
    @Override
    public String toString() {
        return String.format("{Puesto: %d, SubCategoria: %d, Nivel: %d}", puesto, subCategoria, nivel);
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
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
        r.append("<th>Id_Puesto</th>");
        r.append("<th>SubCategoria</th>");
        r.append("<th>Nivel de Dominio</th>");
        return r.toString();
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append(String.format("<td>%d</td>", puesto));
        r.append(String.format("<td>%d</td>", subCategoria));
        r.append(String.format("<td>%d</td>", nivel));
        return r.toString();
    }
    
    private int puesto;
    private int subCategoria;
    private int nivel; //Nivel aceptado de la subCategoria
}