<%-- 
    Document   : logout
    Created on : 5 avr. 2018, 20:43:17
    Author     : SALL
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
    </head>
    <body>
    <%
        HttpSession s = request.getSession();
        s.setAttribute("connect", null);
        s.setAttribute("message", null);
        response.sendRedirect("Login.jsp");
    %>
    </body>
</html>