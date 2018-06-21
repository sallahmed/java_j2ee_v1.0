/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SALL
 */
@WebServlet(name = "UtilisateurServlet", urlPatterns = {"/UtilisateurServlet"})
public class UtilisateurServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("submit_user") != null) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                User u = new User();
                u.setLogin(request.getParameter("login_user"));
                u.setPass(request.getParameter("pass_user"));
                u.setGrant(request.getParameter("grant_user"));
                try {
                    // Connexion a la base de donnees
                    String url, user, mdp;
                    url = "jdbc:mysql://localhost:3306/projetweb_j2ee";
                    user = "root";
                    mdp = "mysql";
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = null;
                    try {
                        conn = DriverManager.getConnection(url, user, mdp);
                    } catch (SQLException ex) {
                        Logger.getLogger(UtilisateurServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Statement stm = null;
                    try {
                        stm = conn.createStatement();
                    } catch (SQLException ex) {
                        Logger.getLogger(UtilisateurServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String req = "INSERT INTO user VALUES(null,'"+u.getLogin()+"','"+u.getPass()+"','"+u.getGrant()+"')";
                    try {
                        stm.executeUpdate(req);
                        HttpSession s = request.getSession();
                        s.setAttribute("message", "Utilisateur ajouté avec succès !");
                        response.sendRedirect("Accueil.jsp");
                    } catch (SQLException ex) {
                        Logger.getLogger(UtilisateurServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UtilisateurServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}