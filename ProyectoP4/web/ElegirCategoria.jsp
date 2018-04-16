<%-- 
    Document   : ElegirCategoria
    Created on : 16-abr-2018, 2:05:05
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Elegir Categoria</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                 <form id="formulario1" action="ServicioAdministrador2" method="GET">
                    <table id="tablaFormulario">
                        <thead>
                            <tr>
                                <th colspan="2">Categorias Existentes</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="etiqueta">Categorias Disponibles</td>
                                <td class="campo">
                                    <select id="categorias" name="categorias" size="1">
                                        <%= modelo.DAO.ConjuntoCategorias.menuCategoriasHTML() %>
                                    </select>
                                </td>
                            </tr>
                             <tr>
                                <td colspan="2" class="controles">
                                    <input type="submit" value="Enviar" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
