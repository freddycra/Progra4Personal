<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Inicio Sesion Administrador</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <h1>Inicio de Sesion</h1>
                <p>
                    Identificacion predeterminada: 123
                    Clave Predeterminada: 1234
                    <br/>
                </p>
                <form id="formulario" action="VerificarAdmin" method="GET">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">Ingrese sus datos, por favor</th>
                                <th><br/></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="etiqueta">Identificacion:</td>
                                <td class="campo">
                                    <input type="text" id="id_administrador" name="id_administrador" required />
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Clave:</td>
                                <td class="campo">
                                    <input type="password" id="clave" name="clave" required />
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
                    <section>
                        <a href="Principal.jsp">Regresar</a>
                    </section>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
