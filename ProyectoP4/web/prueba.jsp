<%-- 
    Document   : index
    Created on : 13-abr-2018, 22:43:18
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Pagina de Tablas</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <h1>Prueba</h1>
        <p>
        <%= modelo.DAO.ConjuntoEmpresas.obtenerInstancia().toStringHTML()  %>
        </p>
        <p>
        <%= modelo.DAO.ConjuntoAdministradores.obtenerInstancia().toStringHTML()  %>
        </p>
        <p>
        <%= modelo.DAO.ConjuntoCategorias.obtenerInstancia().toStringHTML()  %>
        </p>
        <p>
        <%= modelo.DAO.ConjuntoHabilidades.obtenerInstancia().toStringHTML()  %>
        </p>
        <p>
        <%= modelo.DAO.ConjuntoOferentes.obtenerInstancia().toStringHTML()  %>
        </p>
        <p>
        <%= modelo.DAO.ConjuntoPuestos.obtenerInstancia().toStringHTML()  %>
        </p>
        <p>
        <%= modelo.DAO.ConjuntoRequerimientos.obtenerInstancia().toStringHTML()  %>
        </p>
        <p>
        <%= modelo.DAO.ConjuntoSubCategorias.obtenerInstancia().toStringHTML()  %>
        </p>
        <p>
        <%= modelo.DAO.ConjuntoUsuarios.obtenerInstancia().toStringHTML()  %>
        </p>
        <section>
            <a href="Principal.jsp">Regresar</a>
        </section>
    </body>
</html>
