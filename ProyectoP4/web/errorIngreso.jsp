
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error de ingreso</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="contents">
                <h2>
                    <span style="color: red; font-weight: bold;">Error de ingreso</span>
                </h2>
                <p><strong>No ha iniciado la sesión.</strong><br />
                    Esto puede deberse a que la sesión ha expirado
                    o que los datos
                    de ingreso son incorrectos.</p>
                <p>
                    <span style="color:red">
                        <%
                            int codError = 0;
                            String mensaje = "(Error sin determinar)";
                            try {
                                codError = Integer.parseInt(request.getParameter("error"));
                            } catch (Exception e) {
                            }
                            switch (codError) {
                                case 1:
                                    mensaje = "La sesión ha expirado.";
                                    break;
                                case 2:
                                    mensaje = "El nombre de usuario o la clave son incorrectos.";
                                    break;
                                default:
                                            ;
                            }
                            out.println(mensaje);
                        %>
                    </span>
                </p>
                <p>Haga clic <a href="loginOferente.jsp">aqu&iacute;</a>
                    para ingresar al sitio.<br />
                    Haga clic <a href="Principal.jsp">aqu&iacute;</a>
                    para ir al men&uacute; principal.
                </p>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
