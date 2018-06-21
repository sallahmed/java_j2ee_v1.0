<%-- 
    Document   : Acceuil
    Created on : 5 avr. 2018, 20:25:36
    Author     : SALL
--%>

<%@page import="java.util.List"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Master1 IPD :: Projet J2EE</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="admin/css/style.css" type="text/css" rel="stylesheet" media="all">
        <link href="admin/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/r/bs-3.3.5/jqc-1.11.3,dt-1.10.8/datatables.min.js"></script>
        <script type="text/javascript" src="admin/js/jquery-2.1.4.min.js"></script>
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
                        <a class="button-menu" href="Accueil.jsp">Retour à l'acueil</a>
                    </center>
                    <div class="cbImage active signin agileits" style="width:600px;">
                        <h3>Liste des Utilisateurs</h3>
                        <table id="table_users" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Login</th>
                                    <th>Password</th>
                                    <th>Grant</th>
                                    <th>#</th>
                                    <th>#</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            User user = new User();
                            List<User> listU = user.ListUsers();
                            for(User u : listU) {
                                out.print("<tr>"
                                    + "<td>"+u.getLogin()+"</td>"
                                    + "<td>"+u.getPass()+"</td>"
                                    + "<td>"+u.getGrant()+"</td>"
                                    + "<td><a href=ModifierUtilisateur.jsp?id="+u.getId()+">Modifier</a></td>"
                                    + "<td><a href=SupprimerUtilisateurServlet?id="+u.getId()+">Supprimer</a></td>"
                                + "</tr>");
                            }
                            %>
                            </tbody>
                        </table>
                        <script>
                            $(document).ready(function() {
                                $('#table_users').DataTable();
                            } );
                        </script>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </section>
            <script src="admin/js/jquery-2.1.4.min.js"></script> 
            <script src="admin/coverflow-slideshow.js"></script>
        </div>
        <script type="text/javascript">
            // For demo to fit into DataTables site builder...
            $('#table_users')
		.removeClass( 'display' )
		.addClass('table table-striped table-bordered');
        </script>
        <script src="//code.jquery.com/jquery.min.js"></script>
    <% } %>
    </body>
</html>