<%@page import="modelo.Puesto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <title>Página Principal</title>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <h1>Bienvenidos al Banco de Empleo</h1>
                <form id="formulario1" action="Servicio" method="GET">
                    <table id="tablaFormulario">
                        <thead>
                            <tr>
                                <th colspan="2">Elija su tipo de usuario:</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="campo">
                                    <input type="radio" id="opcion_00" name="opcion" value="1" />
                                    <label for="opcion_00">Oferente</label><br />
                                    <input type="radio" id="opcion_01" name="opcion" value="2" />
                                    <label for="opcion_01">Empresa</label><br />
                                    <input type="radio" id="opcion_02" name="opcion" value="3" />
                                    <label for="opcion_02">Administrador</label><br />
                                    <input type="radio" id="opcion_03" name="opcion" value="4" />
                                    <label for="opcion_03">Ir a archivo de Tablas</label><br />
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
            </div>
            <footer></footer>
        </div>
    </body>
</html>
