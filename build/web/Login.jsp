<%-- 
    Document   : connexion
    Created on : 5 avr. 2018, 17:02:14
    Author     : SALL
--%>
<%@page import="java.awt.Window"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Master1 IPD :: Projet J2EE</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="application/x-javascript">addEventListener("load",function(){setTimeout(hideURLbar,0);},false);function hideURLbar(){window.scrollTo(0,1);}</script>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/font-awesome.css" />
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <link href="//fonts.googleapis.com/css?family=Oleo+Script:400,700&amp;subset=latin-ext" rel="stylesheet" />
    </head>
    <body>
        <script src="js/jquery.vide.min.js"></script>
        <div data-vide-bg="video/demo">
            <div class="center-container">
                <div class="header-w3l col-md-12"><h1>&nbsp;</h1></div>
                <div class="main-content-agile">
                    <div class="sub-main-w3 col-md-12">
                        <form class="form-login" action="ConnectServlet" method="post">
                            <% HttpSession s = request.getSession();
                            if(s.getAttribute("connect") == "NOK") { %>
                                <h2>Identifiants incorrects !</h2>
                            <% } else { %>
                                <h1>Formulaire de connexion</h1>
                            <% } %>
                            <input placeholder="Login" name="login" type="text" required="" />
                            <input placeholder="Password" name="pass" type="password" required="" />
                            <input type="submit" name="login_btn" value="Se connecter" />
                        </form>
                    </div>
                </div>
                <div class="footer">&nbsp;</div>
            </div>
        </div>
        <%
        if(request.getParameter("login_btn") != null) {
            String login = request.getParameter("login") ;
            String pass = request.getParameter("pass") ;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url, user, mdp;
                url = "jdbc:mysql://localhost/projetweb_j2ee";
                user = "root";
                mdp = "mysql";
                Connection conn = DriverManager.getConnection(url, user, mdp);
                String sql = " SELECT * FROM user WHERE login=? AND pass=? ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, login);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    s.setAttribute("connect", "OK");
                    s.setAttribute("grant", rs.getString("grant"));
                    response.sendRedirect("Accueil.jsp");
                } else {
                    s.setAttribute("connect", "NOK");
                    response.sendRedirect("Login.jsp");
                }
            } catch(SQLException e) { }
        }
        %>
    </body>
</html>