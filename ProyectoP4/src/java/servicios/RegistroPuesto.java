package servicios;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAO.ConjuntoPuestos;
import modelo.Puesto;

/**
 *
 * @author krist
 */
@WebServlet(name = "RegistroPuesto", urlPatterns = {"/RegistroPuesto"})
public class RegistroPuesto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombreP");
        String descripcion = request.getParameter("descripcionP");
        int salario = Integer.parseInt(request.getParameter("salarioP"));
        int tipo = Integer.parseInt(request.getParameter("opcionP1"));
        int estado = Integer.parseInt(request.getParameter("opcionP2"));
        
        int id_puesto = (ConjuntoPuestos.obtenerInstancia().obtenerMayorId() + 1);
        Puesto p = new Puesto(id_puesto,nombre, descripcion, salario, tipo, estado, 1);//El tipo de empresa se automatiza luego
        ConjuntoPuestos.obtenerInstancia().agregar(p);
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/requerimientos.jsp");
        request.setAttribute("id_puesto", id_puesto);
        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
