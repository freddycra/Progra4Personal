<%-- 
    Document   : ElegirSubCategoria
    Created on : 16-abr-2018, 0:04:56
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta  charset=UTF-8">
        <title>Elegir SubCategoria</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <form id="formulario1" action="RegistroRequerimientos3" method="GET">
                    <table id="tablaFormulario">
                        <thead>
                            <tr>
                                <th colspan="2">SubCategorias Existentes</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="etiqueta">Areas de desempeño para la anterior Categoria</td>
                                <td class="campo">
                                    <select id="subcategorias" name="subcategorias" size="1">
                                        <%= modelo.DAO.ConjuntoSubCategorias.menuSubCategoriasHTML(modelo.Elementos.id_Categoria_Requerido) %>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Nivel de Dominio Requerido:</td>
                                <td>
                                    <input type="text" id="conocimiento" name="dominio" />
                                </td>
                            </tr>
                            <tr>
                                <td>Opciones</td>
                                <td>
                                    <input type="radio" id="opcion_00" name="opcionSR" value="1" />
                                    <label for="opcion_00">Elegir Area</label><br />
                                    <input type="radio" id="opcion_01" name="opcionSR" value="2" />
                                    <label for="opcion_01">Crear Nueva Area</label><br />
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
