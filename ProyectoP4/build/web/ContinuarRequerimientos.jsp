<%-- 
    Document   : ContinuarRequerimientos
    Created on : 15-abr-2018, 23:54:49
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Continuar Requerimientos</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="placa">
                <form id="formulario1" action="RegistroRequerimientosFinal" method="GET">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">Desea agregar mas requerimientos?</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <input type="radio" id="opcion_00" name="opcionCR" value="1" />
                                    <label for="opcion_00">Agregar nuevo requerimiento</label><br />
                                    <input type="radio" id="opcion_01" name="opcionCR" value="2" />
                                    <label for="opcion_01">Terminar</label><br />
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
