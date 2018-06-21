<%-- 
    Document   : Acceuil
    Created on : 5 avr. 2018, 20:25:36
    Author     : SALL
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.User"%>
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
                <section style="padding-top:50px;background: rgba('0,0,0,0.1');">
                  <div class="stage">
                    <br />
                    <center>
                        <% if(s.getAttribute("message") != null) {%>
                        <div style="color:green;padding:10px;background-color:#000;color:white;font-weight:bold;"><% out.println(s.getAttribute("message")); %></div><br />
                        <% s.setAttribute("message", null); } %>
                        <a class="button-menu" href="logout.jsp">Logout</a>
                    </center>
                    <div class="cbImage w3">
                        <h3>Ajout Etudiant</h3>
                        <form action="EtudiantServlet" method="post">
                            <input type="text" name="nom_etud" placeholder="Nom" required="">
                            <input type="text" name="prenom_etud" placeholder="Prenom" required="">
                            <input type="text" name="adresse_etud" placeholder="Adresse" required="">
                            <select name="user_id_etud" required="">
                                <option value="">- Compte utilisateur -</option>
                                <%
                                User user = new User();
                                List<User> listU = user.ListUsers();
                                for(User u : listU) {
                                    if(u.getGrant().equals("ETUDIANT")) {
                                        out.print("<option value="+u.getId()+">"+u.getLogin()+"</option>");
                                    }
                                }
                                %>
                            </select>
                            <input type="submit" name="submit_etud" value="Ajouter">
                        </form>
                        <a href="Etudiants.jsp">Liste des étudiants</a>
                    </div>
                    <div class="cbImage active signin agileits">
                        <h3>Ajout Utilisateur</h3>
                        <form action="UtilisateurServlet" method="post">
                            <input type="text" name="login_user" placeholder="Login" required="" />
                            <input type="password" name="pass_user" required="" />
                            <select name="grant_user" required="">
                                <option value="">- Veuillez choisir -</option>
                                <option value="ETUDIANT">Profil Etudiant</option>
                                <option value="ENSEIGNANT">Profil Enseignant</option>
                                <option value="ADMIN">Profil Administrateur</option>
                            </select>
                            <input type="submit" name="submit_user" value="Enregistrer">
                        </form>
                        <a href="Utilisateurs.jsp">Liste des utilisateurs</a>
                    </div>
                    <div class="cbImage agileinfo">
                        <h3>Ajout Professeur</h3>
                        <form action="EnseignantServlet" method="post">
                            <input type="text" name="nom_ens" placeholder="Nom" required="">
                            <input type="text" name="prenom_ens" placeholder="Prenom" required="">
                            <input type="text" name="grade_ens" placeholder="Grade" required="">
                            <select name="user_id_ens" required="">
                                <option value="">- Compte utilisateur -</option>
                                <% for(User u : listU) { 
                                    if(u.getGrant().equals("ENSEIGNANT")) {
                                        out.print("<option value="+u.getId()+">"+u.getLogin()+"</option>");
                                    }
                                } %>
                            </select>
                            <input type="submit" name="submit_ens" value="Ajouter">
                        </form>
                        <a href="Professeurs.jsp">Liste des professeurs</a>
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