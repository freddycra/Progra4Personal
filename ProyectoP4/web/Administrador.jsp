<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Administradores Pagina Principal</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <h1>Bienvenido administrador!</h1>
                <section>
                    <p>
                    <h2>Empresas</h2>
                    <%= modelo.DAO.ConjuntoEmpresas.obtenerInstancia().toStringHTML()%>
                    <br/><br/>
                    </p>
                    <p>
                    <h2>Oferentes</h2>
                    <%= modelo.DAO.ConjuntoOferentes.obtenerInstancia().toStringHTML()%>
                    <br/><br/>
                    </p>
                    <p>
                    <h2>Categorias</h2>
                    <%= modelo.DAO.ConjuntoCategorias.obtenerInstancia().toStringHTML()%>
                    <br/><br/>
                    </p>
                    <p>
                    <h2>SubCategorias</h2>
                    <%= modelo.DAO.ConjuntoSubCategorias.obtenerInstancia().toStringHTML()%>
                    <br/><br/>
                    </p>
                </section>
                <form id="formulario1" action="ServicioAdministrador" method="GET">
                    <table id="tablaFormulario">
                        <thead>
                            <tr>
                                <th colspan="2">Acciones Posibles</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="campo">
                                    <input type="radio" id="opcion_00" name="opcionA" value="1" />
                                    <label for="opcion_00">Agregar nueva Categoría</label><br />
                                    <input type="radio" id="opcion_01" name="opcionA" value="2" />
                                    <label for="opcion_01">Agregar nueva SubCategoría</label><br />
                                    <input type="radio" id="opcion_02" name="opcionA" value="3" />
                                    <label for="opcion_02">Autorizar Empresa</label><br />
                                    <input type="radio" id="opcion_03" name="opcionA" value="4" />
                                    <label for="opcion_03">Autorizar Oferente</label><br />
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
                    <a href="Principal.jsp">Regresar</a>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
