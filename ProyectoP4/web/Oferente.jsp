<%-- 
    Document   : Oferente
    Created on : 14-abr-2018, 0:53:53
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Oferente Pagina Principal</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <h1>Pagina de Oferentes....</h1>
                <form i="FormularioOferente" action="Servicio2" method="GET">
                    <table id="tablaFormulario">
                            <thead>
                                <tr>
                                    <th colspan="2">Transacciones Posibles</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="campo">
                                        <input type="radio" id="opcion_00" name="opcionE" value="1" />
                                        <label for="opcion_00">Registrar Datos</label><br />
                                        <input type="radio" id="opcion_01" name="opcionE" value="2" />
                                        <label for="opcion_01">Ingresar al sistema</label><br />
                                        <input type="radio" id="opcion_02" name="opcionE" value="3" />
                                        <label for="opcion_02">Ver Oferentes</label><br />
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" class="controles">
                                        <input type="reset" value="Borrar" />
                                        <input type="submit" value="Enviar" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                </form>
                <section>
                    <a href="Principal.jsp">Regresar</a>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
