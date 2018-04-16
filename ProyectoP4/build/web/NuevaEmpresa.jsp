<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Agregar nueva empresa</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <form id="formulario" action="RegistroEmpresa" method="GET">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">Registro de nueva empresa</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="etiqueta">Identificacion:</td>
                                <td class="campo">
                                    <input type="text" id="id_empresa" name="id_empresa" required />
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Nombre:</td>
                                <td class="campo">
                                    <input type="text" id="nombre" name="nombre" required />
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Localizacion:</td>
                                <td class="campo">
                                    <input type="text" id="localizacion" name="localizacion" required />
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Correo:</td>
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
                                <td class="etiqueta">Descripcion:</td>
                                <td class="campo">
                                    <textarea  id="descripcion" name="descripcion"
                                               cols="40" rows="8"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Nueva Clave de aceeso:</td>
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
                </form>
                <section>
                    <a href="Empresa.jsp">Regresar</a>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
