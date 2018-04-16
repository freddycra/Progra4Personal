
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso de usuarios</title>
        <link rel="stylesheet" href="css/default.css" type="text/css">
        <script src="js/scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <div id="contents">
                <h2>
                    Página de ingreso
                </h2>
                <section>
                    <p>
                        <%
                            HttpSession sesionActual;
                            sesionActual = request.getSession(true);
                            sesionActual.invalidate();
                            out.println("Sesión actual:&nbsp;"
                                    + sesionActual.getId() + "<br />");

                            sesionActual = request.getSession(true);

                            out.println("Nueva sesión:&nbsp;"
                                    + sesionActual.getId() + "<br />");
                        %>
                    </p>

                    <form name="loginForm" action="ServicioLogin" method="POST">
                        <table width="65%" cellpadding="8">
                            <tr>
                                <td align="right">
                                    Usuario:&nbsp;
                                </td><td>
                                    <input type="text" size="30"
                                           id="usuario" name="usuario">
                                </td>
                            </tr><tr>
                                <td align="right">
                                    Clave:&nbsp;
                                </td><td>
                                    <input type="password" size="30"
                                           id=password" name="password">
                                </td>
                            </tr><tr>
                                <td align="center" colspan="2">
                                    <input type="submit" value="Verificar">
                                </td>
                            </tr>
                        </table>
                    </form>
                </section>
                <section>
                    <a href="Oferente.jsp">Regresar</a>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
