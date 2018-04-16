<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Requerimientos</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <h1>Bienvenido a la página de integración de requerimientos....!</h1>
                <form id="formulario1" action="RegistroRequerimientos1" method="GET">
                    <table id="tablaFormulario">
                        <thead>
                            <tr>
                                <th colspan="2">Categorias Existentes</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="etiqueta">Categorias para requerimiento:</td>
                                <td class="campo">
                                    <select id="categorias" name="categorias" size="1">
                                        <%= modelo.DAO.ConjuntoCategorias.menuCategoriasHTML() %>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Opciones</td>
                                <td>
                                    <input type="radio" id="opcion_00" name="opcionR" value="1" />
                                    <label for="opcion_00">Elegir Categoria</label><br />
                                    <input type="radio" id="opcion_01" name="opcionR" value="2" />
                                    <label for="opcion_01">Crear Nueva Categoria</label><br />
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
                    <a href="prueba.jsp">Regresar</a>

                    <% int variable = modelo.DAO.ConjuntoPuestos.obtenerInstancia().obtenerMayorId();%>
                    <p>
                        Me han pasado el valor <%= variable%>!
                    </p>

                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
