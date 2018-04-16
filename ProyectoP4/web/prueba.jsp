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
        <h1 style="text-align: center">Prueba Base de Datos</h1>
        <p>
            <h2>Empresas</h2>
            <%= modelo.DAO.ConjuntoEmpresas.obtenerInstancia().toStringHTML()%>
            <br/><br/>
        </p>
        <p>
            <h2>Administradores</h2>
            <%= modelo.DAO.ConjuntoAdministradores.obtenerInstancia().toStringHTML()%>
            <br/><br/>
        </p>
        <p>
            <h2>Habilidades</h2>
            <%= modelo.DAO.ConjuntoHabilidades.obtenerInstancia().toStringHTML()%>
            <br/><br/>
        </p>
        <p>
            <h2>Oferentes</h2>
            <%= modelo.DAO.ConjuntoOferentes.obtenerInstancia().toStringHTML()%>
            <br/><br/>
        </p>
        <p>
            <h2>Puestos</h2>
            <%= modelo.DAO.ConjuntoPuestos.obtenerInstancia().toStringHTML()%>
            <br/><br/>
        </p>
        <p>
            <h2>Requerimientos</h2>
            <%= modelo.DAO.ConjuntoRequerimientos.obtenerInstancia().toStringHTML()%>
            <br/><br/>
        </p>
        <p>
            <h2>SubCategorias</h2>
            <%= modelo.DAO.ConjuntoSubCategorias.obtenerInstancia().toStringHTML()%>
            <br/><br/>
        </p>
        <p>
            <h2>Categorias</h2>
            <%= modelo.DAO.ConjuntoCategorias.obtenerInstancia().toStringHTML()%>
            <br/><br/>
        </p>
        <p>
            <h2>Usuario</h2>
            <%= modelo.DAO.ConjuntoUsuarios.obtenerInstancia().toStringHTML()%>
            <br/><br/>
        </p>
        <section>
            <a href="Principal.jsp">Regresar</a>
        </section>
</body>
</html>
