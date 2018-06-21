package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import Model.User;
import Controller.UtilisateurServlet;

public final class Accueil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <title>Master1 IPD :: Projet J2EE</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"admin/js/jquery-2.1.4.min.js\"></script>\n");
      out.write("        <link href=\"admin/css/style.css\" type=\"text/css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("        <link href=\"admin/css/jquerysctipttop.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

        HttpSession s = request.getSession();
        if(s.getAttribute("connect") == null || s.getAttribute("connect").equals("NOK")) {
            response.sendRedirect("Login.jsp");
        } else { 
      out.write("\n");
      out.write("            <script src=\"admin/js/jquery.vide.min.js\"></script>\n");
      out.write("            <div data-vide-bg=\"video/demo\">\n");
      out.write("                <section style=\"padding-top:50px;\" style=\"background: rgba('0,0,0,0.1');\">\n");
      out.write("                  <div class=\"stage\">\n");
      out.write("                    <br />\n");
      out.write("                    <center>\n");
      out.write("                        ");
 if(s.getAttribute("message") != null) {
      out.write("\n");
      out.write("                        <div style=\"color:green;padding:10px;background-color:#000;\">");
 out.println(s.getAttribute("message")); 
      out.write("</div><br />\n");
      out.write("                        ");
 s.setAttribute("message", null); } 
      out.write("\n");
      out.write("                        <a class=\"button-menu\" href=\"logout.jsp\">Logout</a>\n");
      out.write("                    </center>\n");
      out.write("                    <div class=\"cbImage agileinfo\">\n");
      out.write("                        <h3>Ajout UV</h3>\n");
      out.write("                        <form action=\"#\" method=\"post\">\n");
      out.write("                            <input type=\"text\" class=\"name\" name=\"username\" placeholder=\"Username\" required=\"\">\n");
      out.write("                            <input type=\"password\" class=\"password\" name=\"password\" placeholder=\"Password\" required=\"\">\n");
      out.write("                            <input type=\"password\" class=\"password\" name=\"confirm password\" placeholder=\"Confirm Password\" required=\"\">\n");
      out.write("                            <input type=\"text\" class=\"email\" name=\"email\" placeholder=\"Email\" required=\"\">\n");
      out.write("                            <input type=\"submit\" value=\"Sign Up\">\n");
      out.write("                        </form>\n");
      out.write("                        <a href=\"UV.jsp\">Liste des UV</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"cbImage w3\">\n");
      out.write("                        <h3>Ajout Etudiant</h3>\n");
      out.write("                        <form action=\"EtudiantServlet\" method=\"post\">\n");
      out.write("                            <input type=\"text\" name=\"nom_etud\" placeholder=\"Nom\" required=\"\">\n");
      out.write("                            <input type=\"text\" name=\"prenom_etud\" placeholder=\"Prenom\" required=\"\">\n");
      out.write("                            <input type=\"text\" name=\"adresse_etud\" placeholder=\"Adresse\" required=\"\">\n");
      out.write("                            <select name=\"user_id_etud\" required=\"\">\n");
      out.write("                                <option value=\"\">- Compte utilisateur -</option>\n");
      out.write("                                ");

                                User user = new User();
                                List<User> listU = user.ListUsers();
                                for(User u : listU) {
                                    if(u.getGrant().equals("ETUDIANT")) {
                                        out.print("<option value="+u.getId()+">"+u.getLogin()+"</option>");
                                    }
                                }
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"submit\" name=\"submit_etud\" value=\"Ajouter\">\n");
      out.write("                        </form>\n");
      out.write("                        <a href=\"Etudiants.jsp\">Liste des étudiants</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"cbImage active signin agileits\">\n");
      out.write("                        <h3>Ajout Utilisateur</h3>\n");
      out.write("                        <form action=\"UtilisateurServlet\" method=\"post\">\n");
      out.write("                            <input type=\"text\" name=\"login_user\" placeholder=\"Login\" required=\"\" />\n");
      out.write("                            <input type=\"password\" name=\"pass_user\" required=\"\" />\n");
      out.write("                            <select name=\"grant_user\" required=\"\">\n");
      out.write("                                <option value=\"\">- Veuillez choisir -</option>\n");
      out.write("                                <option value=\"ETUDIANT\">Profil Etudiant</option>\n");
      out.write("                                <option value=\"ENSEIGNANT\">Profil Enseignant</option>\n");
      out.write("                                <option value=\"ADMIN\">Profil Administrateur</option>\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"submit\" name=\"submit_user\" value=\"Enregistrer\">\n");
      out.write("                        </form>\n");
      out.write("                        <a href=\"Utilisateurs.jsp\">Liste des utilisateurs</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"cbImage agileinfo\">\n");
      out.write("                        <h3>Ajout Professeur</h3>\n");
      out.write("                        <form action=\"EnseignantServlet\" method=\"post\">\n");
      out.write("                            <input type=\"text\" name=\"nom_ens\" placeholder=\"Nom\" required=\"\">\n");
      out.write("                            <input type=\"text\" name=\"prenom_ens\" placeholder=\"Prenom\" required=\"\">\n");
      out.write("                            <input type=\"text\" name=\"grade_ens\" placeholder=\"Grade\" required=\"\">\n");
      out.write("                            <select name=\"user_id_ens\" required=\"\">\n");
      out.write("                                <option value=\"\">- Compte utilisateur -</option>\n");
      out.write("                                ");
 for(User u : listU) { 
                                    if(u.getGrant().equals("ENSEIGNANT")) {
                                        out.print("<option value="+u.getId()+">"+u.getLogin()+"</option>");
                                    }
                                } 
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"submit\" name=\"submit_ens\" value=\"Ajouter\">\n");
      out.write("                        </form>\n");
      out.write("                        <a href=\"Professeurs.jsp\">Liste des professeurs</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"cbImage agileinfo\">\n");
      out.write("                        <h3>Ajout TD</h3>\n");
      out.write("                        <form action=\"#\" method=\"post\">\n");
      out.write("                            <input type=\"text\" class=\"name\" name=\"username\" placeholder=\"Username\" required=\"\">\n");
      out.write("                            <input type=\"password\" class=\"password\" name=\"password\" placeholder=\"Password\" required=\"\">\n");
      out.write("                            <input type=\"password\" class=\"password\" name=\"confirm password\" placeholder=\"Confirm Password\" required=\"\">\n");
      out.write("                            <input type=\"text\" class=\"email\" name=\"email\" placeholder=\"Email\" required=\"\">\n");
      out.write("                            <input type=\"submit\" value=\"Sign Up\">\n");
      out.write("                        </form>\n");
      out.write("                        <a href=\"TD.jsp\">Liste des TD</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clear\"></div>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"clear\"></div>\n");
      out.write("                </section>\n");
      out.write("                <script src=\"admin/js/jquery-2.1.4.min.js\"></script> \n");
      out.write("                <script src=\"admin/coverflow-slideshow.js\"></script>\n");
      out.write("            </div>\n");
      out.write("            ");
}
        
      out.write("\n");
      out.write("        <h1></h1>\n");
      out.write("        <script src=\"//code.jquery.com/jquery.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
