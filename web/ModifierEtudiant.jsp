<%-- 
    Document   : Acceuil
    Created on : 5 avr. 2018, 20:25:36
    Author     : SALL
--%>

<%@page import="Model.Etudiant"%>
<%@page import="Controller.UtilisateurServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Master1 IPD :: Projet J2EE</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="text/javascript" src="admin/js/jquery-2.1.4.min.js"></script>
        <link href="admin/css/style.css" type="text/css" rel="stylesheet" media="all">
        <link href="admin/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <%
        HttpSession s = request.getSession();
        if(s.getAttribute("connect") == null || s.getAttribute("connect").equals("NOK")) {
            response.sendRedirect("Login.jsp");
        } else { %>
            <script src="admin/js/jquery.vide.min.js"></script>
            <div data-vide-bg="video/demo">
                <section style="padding-top:50px;" style="background: rgba('0,0,0,0.1');">
                  <div class="stage">
                    <br />
                    <center>
                        <a class="button-menu" href="Accueil.jsp">Accueil</a>
                        <a class="button-menu" href="Utilisateurs.jsp">Retour à la liste</a>
                    </center>
                    <div class="cbImage active signin agileits">
                        <h3>Modification Etudiant</h3>
                        <%
                            Etudiant etud = new Etudiant(), e;
                            e = etud.getEtudiant(Integer.parseInt(request.getParameter("id")));
                        %>
                        <form action="ModifierEtudiantServlet" method="post">
                            <input type="hidden" name="id" value="<% out.print(e.getId()); %>" />
                            <input type="hidden" name="user_id" value="<% out.print(e.getUser_id()); %>" />
                            <input type="text" name="nom_etud" value="<% out.print(e.getNom()); %>" required="">
                            <input type="text" name="prenom_etud" value="<% out.print(e.getPrenom()); %>" required="">
                            <input type="text" name="adresse_etud" value="<% out.print(e.getAdresse()); %>" required="">
                            <input type="submit" name="modif_etud" value="Ajouter">
                        </form>
                    </div>
                    <div class="clear"></div>
                  </div>
                  <div class="clear"></div>
                </section>
                <script src="admin/js/jquery-2.1.4.min.js"></script> 
                <script src="admin/coverflow-slideshow.js"></script>
            </div>
            <%}
        %>
        <h1></h1>
        <script src="//code.jquery.com/jquery.min.js"></script>
    </body>
</html>