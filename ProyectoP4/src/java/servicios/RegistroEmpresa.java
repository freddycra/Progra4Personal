package servicios;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAO.ConjuntoEmpresas;
import modelo.Empresa;

/**
 *
 * @author krist
 */
@WebServlet(name = "RegistroEmpresa", urlPatterns = {"/RegistroEmpresa"})
public class RegistroEmpresa extends HttpServlet {

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

        int id_empresa = Integer.parseInt(request.getParameter("id_empresa"));
        String nombre = request.getParameter("nombre");
        String localizacion = request.getParameter("localizacion");
        String correo = request.getParameter("correo");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        String descripcion = request.getParameter("descripcion");
        String clave = request.getParameter("clave");
        java.util.Date fecha = new Date();

        Empresa e = new Empresa(id_empresa, nombre, localizacion, correo, telefono, descripcion, clave, fecha, 0, 2);
        // 0 = Estado en espera, 2 = Tipo de Usuario -> Empresa
        ConjuntoEmpresas.obtenerInstancia().agregar(e);
        response.sendRedirect("Empresa.jsp");
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
