/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author krist
 */
@WebServlet(name = "RegistroRequerimientos1", urlPatterns = {"/RegistroRequerimientos1"})
public class RegistroRequerimientos1 extends HttpServlet {

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
        modelo.Elementos.administrador_trabajando=0;//Se asegura que el admi no este trabajando
        int opcion, eleccion;
        try {
            opcion = Integer.parseInt(request.getParameter("opcionR"));
        } catch (Exception ex) {
            opcion = 0;
        }
        modelo.Elementos.id_Categoria_Requerido = 0;
        if (opcion == 1) {
            eleccion = Integer.parseInt(request.getParameter("categorias"));//id de categoria elegida
            modelo.Elementos.id_Categoria_Requerido = eleccion;
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/ElegirSubCategoria.jsp");
            request.setAttribute("categoria", eleccion);
            rd.forward(request, response);
        } else if (opcion == 2) {
            response.sendRedirect("CrearCategoria.jsp");
        } else {
            response.sendRedirect("Empresa.jsp");
            //Deberia eliminar el ultimo puesto...
        }

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
