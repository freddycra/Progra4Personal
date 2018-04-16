/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAO.ConjuntoCategorias;
import modelo.DAO.ConjuntoPuestos;
import modelo.DAO.ConjuntoRequerimientos;
import modelo.DAO.ConjuntoSubCategorias;
import modelo.Requerimientos;
import modelo.SubCategoria;

/**
 *
 * @author krist
 */
@WebServlet(name = "RegistroRequerimientos2", urlPatterns = {"/RegistroRequerimientos2"})
public class RegistroRequerimientos2 extends HttpServlet {

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
        String nombre = request.getParameter("nombreS");
        int id_subCategoria = (ConjuntoSubCategorias.obtenerInstancia().obtenerMayorId() + 1);

        if (modelo.Elementos.administrador_trabajando == 0) {
            int dominio = Integer.parseInt(request.getParameter("dominioS"));
            int categoria;
            if (modelo.Elementos.id_Categoria_Requerido == 0) {//Se creo una nueva Categoria
                categoria = (ConjuntoCategorias.obtenerInstancia().obtenerMayorId());
            } else {
                categoria = modelo.Elementos.id_Categoria_Requerido;//Se eligio una de las categorias existentes
            }

            int puesto = (ConjuntoPuestos.obtenerInstancia().obtenerMayorId());

            SubCategoria c = new SubCategoria(id_subCategoria, nombre, categoria);
            ConjuntoSubCategorias.obtenerInstancia().agregar(c);

            //Ahora se crea el nuevo requerimientol
            Requerimientos r = new Requerimientos(puesto, id_subCategoria, dominio);
            ConjuntoRequerimientos.obtenerInstancia().agregar(r);

            response.sendRedirect("ContinuarRequerimientos.jsp");
        }else{
            SubCategoria c = new SubCategoria(id_subCategoria, nombre, modelo.Elementos.id_Categoria_Requerido);
            ConjuntoSubCategorias.obtenerInstancia().agregar(c);
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
