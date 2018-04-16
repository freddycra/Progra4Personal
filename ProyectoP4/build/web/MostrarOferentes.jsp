<%-- 
    Document   : MostrarOferentes
    Created on : 14-abr-2018, 2:05:35
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <title>Mostrando Oferentes..</title>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <h1>Oferentes Disponibles</h1>
                <p>
                    <%= modelo.DAO.ConjuntoOferentes.obtenerInstancia().toStringHTML()  %>
                </p>
                <p>
                    <%= modelo.DAO.ConjuntoHabilidades.obtenerInstancia().toStringHTML()  %>
                </p>
                <p>
                    <%= modelo.DAO.ConjuntoSubCategorias.obtenerInstancia().toStringHTML()  %>
                </p>
                
                <section>
                    <a href="Empresa.jsp">Regresar</a>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
