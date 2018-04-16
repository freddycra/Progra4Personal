/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAO.ConjuntoOferentes;
import modelo.Oferente;

/**
 *
 * @author freddycra
 */
public class RegistroOferente extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try {
            int identificacion = Integer.parseInt(request.getParameter("identificacion"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String nacionalidad = request.getParameter("Nacionalidad");
            String correo = request.getParameter("correo");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String direccion = request.getParameter("direccion");
            

            Oferente e = new Oferente(identificacion, nombre, apellido, nacionalidad,telefono, correo, direccion, 0, 6);
            ConjuntoOferentes.obtenerInstancia().agregar(e);
        } catch (NumberFormatException ex) {
            //Manejar error
            response.sendRedirect("RegistrarOferente.jsp");
        }
        response.sendRedirect("Oferente.jsp");
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
