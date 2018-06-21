/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Enseignant;
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
@WebServlet(name = "EnseignantServlet", urlPatterns = {"/EnseignantServlet"})
public class EnseignantServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("submit_ens") != null) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                Enseignant ens = new Enseignant();
                ens.setNom(request.getParameter("nom_ens"));
                ens.setPrenom(request.getParameter("prenom_ens"));
                ens.setGrade(request.getParameter("grade_ens"));
                ens.setUser_id(Integer.parseInt(request.getParameter("user_id_ens")));
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
                        Logger.getLogger(EnseignantServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Statement stm = null;
                    try {
                        stm = conn.createStatement();
                    } catch (SQLException ex) {
                        Logger.getLogger(EnseignantServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String req = "INSERT INTO enseignant VALUES(null,'"+ens.getNom()+"','"+ens.getPrenom()+"','"+ens.getGrade()+"','"+ens.getUser_id()+"')";
                    try {
                        stm.executeUpdate(req);
                        HttpSession s = request.getSession();
                        s.setAttribute("message", "Enseignant ajouté avec succès !");
                        response.sendRedirect("Accueil.jsp");
                    } catch (SQLException ex) {
                        Logger.getLogger(EnseignantServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EnseignantServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
