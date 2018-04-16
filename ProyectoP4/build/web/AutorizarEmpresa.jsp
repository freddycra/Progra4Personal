<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Autorizar Empresa</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <h1>Bienvenido administrador!</h1>
                <section>
                    <p>
                    <h2>Empresas Disponibles</h2>
                    <%= modelo.DAO.ConjuntoEmpresas.obtenerInstancia().toStringHTMLPendientes()%>
                    <br/><br/>
                    </p>
                </section>
                <form id="formulario1" action="ServicioAdministrador3" method="GET">
                    <table id="tablaFormulario">
                        <thead>
                            <tr>
                                <th colspan="2">Digite el id de la empresa a actualizar...</th>
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
                                <td colspan="2" class="controles">
                                    <input type="submit" value="Enviar" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <section>
                    <a href="Administrador.jsp">Regresar</a>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
