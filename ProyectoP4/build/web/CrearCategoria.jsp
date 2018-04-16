<%-- 
    Document   : CrearCategoria
    Created on : 15-abr-2018, 23:19:07
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Crear Categoria</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="placa">
                <form id="formulario" action="RegistroCategoria" method="GET">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">Registro de nueva Categoria</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="etiqueta">Nombre:</td>
                                <td class="campo">
                                    <input type="text" id="nombreC" name="nombreC" required />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Crear" />
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
