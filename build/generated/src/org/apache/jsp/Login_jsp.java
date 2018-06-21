package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.awt.Window;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"fr\">\n");
      out.write("    <head>\n");
      out.write("        <title>Master1 IPD :: Projet J2EE</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <script type=\"application/x-javascript\">addEventListener(\"load\",function(){setTimeout(hideURLbar,0);},false);function hideURLbar(){window.scrollTo(0,1);}</script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-2.1.4.min.js\"></script>\n");
      out.write("        <link href=\"//fonts.googleapis.com/css?family=Oleo+Script:400,700&amp;subset=latin-ext\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script src=\"js/jquery.vide.min.js\"></script>\n");
      out.write("        <div data-vide-bg=\"video/demo\">\n");
      out.write("            <div class=\"center-container\">\n");
      out.write("                <div class=\"header-w3l col-md-12\"><h1>&nbsp;</h1></div>\n");
      out.write("                <div class=\"main-content-agile\">\n");
      out.write("                    <div class=\"sub-main-w3 col-md-12\">\n");
      out.write("                        <form class=\"form-login\" action=\"ConnectServlet\" method=\"post\">\n");
      out.write("                            ");
 HttpSession s = request.getSession();
                            if(s.getAttribute("connect") == "NOK") { 
      out.write("\n");
      out.write("                                <h2>Identifiants incorrects !</h2>\n");
      out.write("                            ");
 } else { 
      out.write("\n");
      out.write("                                <h1>Formulaire de connexion</h1>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                            <input placeholder=\"Login\" name=\"login\" type=\"text\" required=\"\" />\n");
      out.write("                            <input placeholder=\"Password\" name=\"pass\" type=\"password\" required=\"\" />\n");
      out.write("                            <input type=\"submit\" name=\"login_btn\" value=\"Se connecter\" />\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer\">&nbsp;</div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

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
        
      out.write("\n");
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
