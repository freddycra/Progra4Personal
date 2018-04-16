<%-- 
    Document   : RegistrarOferente
    Created on : Apr 15, 2018, 5:39:38 PM
    Author     : freddycra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Oferente</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <form id="formulario" action="RegistroOferente" method="GET">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">Registro Oferente</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="etiqueta">Identificacion:</td>
                                <td class="campo">
                                    <input type="text" id="identificacion" name="identificacion" required />
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Nombre:</td>
                                <td class="campo">
                                    <input type="text" id="nombre" name="nombre" required />
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Apellido:</td>
                                <td class="campo">
                                    <input type="text" id="apellido" name="apellido" required />
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Nacionalidad:</td>
                                <td class="campo">
                                    <input type="text" id="correo" name="correo" required />
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Telefono:</td>
                                <td class="campo">
                                    <input type="text" id="telefono" name="telefono" required />
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Correo:</td>
                                <td class="campo">
                                    <input type="text" id="correo" name="correo" required />
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Direccion:</td>
                                <td class="campo">
                                    <textarea  id="descripcion" name="direccion"
                                               cols="40" rows="8"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="reset" value="Borrar" />
                                    <input type="submit" value="Enviar" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <section>
                    <a href="Oferente.jsp">Regresar</a>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
