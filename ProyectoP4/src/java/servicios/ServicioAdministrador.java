/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author krist
 */
@WebServlet(name = "ServicioAdministrador", urlPatterns = {"/ServicioAdministrador"})
public class ServicioAdministrador extends HttpServlet {

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
        int opcion;
        try{
            opcion = Integer.parseInt(request.getParameter("opcionA"));
        }catch(Exception ex){
            opcion = 0;
        }
        if(opcion==1){
            //Agrega una nueva categoria
            modelo.Elementos.administrador_trabajando=1;
            response.sendRedirect("CrearCategoria.jsp");
        }
        else if(opcion==2){
            response.sendRedirect("ElegirCategoria.jsp");
        }
        else if(opcion==3){
            modelo.Elementos.administrador_autorizando=1;
            response.sendRedirect("AutorizarEmpresa.jsp");
        }
        else if(opcion==4){
            modelo.Elementos.administrador_autorizando=2;
            response.sendRedirect("AutorizarOferente.jsp");
        }
        else{
            response.sendRedirect("Administrador.jsp");
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
