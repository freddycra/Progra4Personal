<%-- 
    Document   : AgregarPuestos
    Created on : 14-abr-2018, 2:06:07
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Pagina Agregar Puestos</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <form id="formulario" action="RegistroPuesto" method="GET">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">Registro de nuevo puesto</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="etiqueta">Nombre de puesto:</td>
                                <td class="campo">
                                    <input type="text" id="nombreP" name="nombreP" required />
                                </td>
                            </tr>
                        <td class="etiqueta">Descripcion:</td>
                        <td class="campo">
                            <textarea  id="descripcionP" name="descripcionP"
                                       cols="40" rows="8"></textarea>
                        </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Salario ofrecido:</td>
                            <td class="campo">
                                <input type="text" id="salarioP" name="salarioP" required />
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Tipo de Publicacion</td>
                            <td class="campo">
                                <input type="radio" id="opcion_00" name="opcionP1" value="0" />
                                <label for="opcion_00">Pública</label><br />
                                <input type="radio" id="opcion_01" name="opcionP1" value="1" />
                                <label for="opcion_01">Privada</label><br />
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Estado de Puesto</td>
                            <td class="campo">
                                <input type="radio" id="opcion_00" name="opcionP2" value="0" />
                                <label for="opcion_00">Disponible</label><br />
                                <input type="radio" id="opcion_01" name="opcionP2" value="1" />
                                <label for="opcion_01">Ocupado</label><br />
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">Categoria</td>
                            <td class="campo">
                                <%out.print(modelo.DAO.ConjuntoCategorias.obtenerInstancia().toStringHTML());%>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="reset" value="Borrar" />
                                <input type="submit" value="Registrar" />
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
                <section>
                    <a href="Respuesta.jsp">Regresar</a>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
