package prueba2;

import java.util.List;
import modelo.Administrador;
import modelo.Categoria;
import modelo.DAO.ConjuntoAdministradores;
import modelo.DAO.ConjuntoCategorias;
import modelo.DAO.ConjuntoEmpresas;
import modelo.DAO.ConjuntoHabilidades;
import modelo.DAO.ConjuntoOferentes;
import modelo.DAO.ConjuntoPuestos;
import modelo.DAO.ConjuntoRequerimientos;
import modelo.DAO.ConjuntoSubCategorias;
import modelo.DAO.ConjuntoUsuarios;
import modelo.DAO.GestorBD;
import modelo.Empresa;
import modelo.Habilidades;
import modelo.Puesto;
import modelo.Requerimientos;
import modelo.SubCategoria;
import modelo.Usuario;

/**
 *
 * @author krist
 */
public class Prueba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorBD nuevo = GestorBD.obtenerInstancia();
        nuevo.run();
        ConjuntoEmpresas empresas = ConjuntoEmpresas.obtenerInstancia();
        ConjuntoOferentes oferentes = ConjuntoOferentes.obtenerInstancia();
        ConjuntoPuestos puestos = ConjuntoPuestos.obtenerInstancia();
        ConjuntoCategorias categorias = ConjuntoCategorias.obtenerInstancia();
        ConjuntoUsuarios usuarios = ConjuntoUsuarios.obtenerInstancia();
        ConjuntoAdministradores administradores = ConjuntoAdministradores.obtenerInstancia();
        ConjuntoSubCategorias subCategorias = ConjuntoSubCategorias.obtenerInstancia();
        ConjuntoHabilidades habilidades = ConjuntoHabilidades.obtenerInstancia();
        ConjuntoRequerimientos requerimientos = ConjuntoRequerimientos.obtenerInstancia();
        
        
        List<Empresa> lista = empresas.obtenerEmpresas();
        //List<Oferente> lista2 = oferentes.obtenerOferentes();
        List<Puesto> lista3 = puestos.obtenerPuestos();
        List<Categoria> lista4 = categorias.obtenerCategorias();
        List<Usuario> lista5 = usuarios.obtenerUsuarios();
        List<Administrador> lista6 = administradores.obtenerAdministradores();
        List<SubCategoria> lista7 = subCategorias.obtenerSubCategorias();
        List<Habilidades> lista8 = habilidades.obtenerHabilidades();
        List<Requerimientos> lista9 = requerimientos.obtenerRequerimientos();
        
        
        System.out.println(modelo.DAO.ConjuntoEmpresas.obtenerInstancia().toStringHTML());
        
        //System.out.println(lista2);
        //System.out.println(lista3);
        //System.out.println(lista4);
        //System.out.println(lista5);
        //System.out.println(lista6);
        //System.out.println(lista7);
        //System.out.println(lista8);
        //System.out.println(lista9);
        //(id_empresa, nombre_empresa, localizacion, correo, telefono, descripcion, clave, fecha_registro, usuario) "
        //java.util.Date date = new java.util.Date();
        //Empresa e = new Empresa(11718, "Alcelsa", "Bijagua, Upala", "alcelsa@gmail.cr", 222344, "Tienda de Dulces", "7893", date, 2);
       //empresas.agregar(e);
       
      //Oferente oferente1 = new Oferente(45678, "Olga", "Rodriguez", "Mexicana", 24903048, "olga@outlook.com", "Ciudad Mexico", 3);
      //oferentes.agregar(oferente1);
      
      //Puesto puesto1 = new Puesto(92, "Tecnico en Redes", "Mantenimiento a redes", 800000, 0, 0, 11718);
      //puestos.agregar(puesto1);
      
      //Categoria categoria1 = new Categoria(2, "Redes");
      //categorias.agregar(categoria1);
      
      //Administrador administrado1 = new Administrador(3213, "Fabian", "78792", 1);
      //administradores.agregar(administrado1);
      
      //SubCategoria subCategoria1 = new SubCategoria(87, "Ruby", 1);
      //subCategorias.agregar(subCategoria1);
      
      //Habilidades habilidad1 = new Habilidades(117180070, 87, 100);
      //habilidades.agregar(habilidad1);
      
      //Requerimientos requerimiento1 = new Requerimientos(92, 87, 90);
      //requerimientos.agregar(requerimiento1);
    }
    
}
