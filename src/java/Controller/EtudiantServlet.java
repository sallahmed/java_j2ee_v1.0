/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Etudiant;
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
@WebServlet(name = "EtudiantServlet", urlPatterns = {"/EtudiantServlet"})
public class EtudiantServlet extends HttpServlet {

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
        if(request.getParameter("submit_etud") != null) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                Etudiant etud = new Etudiant();
                etud.setNom(request.getParameter("nom_etud"));
                etud.setPrenom(request.getParameter("prenom_etud"));
                etud.setAdresse(request.getParameter("adresse_etud"));
                etud.setUser_id(Integer.parseInt(request.getParameter("user_id_etud")));
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
                        Logger.getLogger(EtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Statement stm = null;
                    try {
                        stm = conn.createStatement();
                    } catch (SQLException ex) {
                        Logger.getLogger(EtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String req = "INSERT INTO etudiant VALUES(null,'"+etud.getNom()+"','"+etud.getPrenom()+"','"+etud.getAdresse()+"','"+etud.getUser_id()+"')";
                    try {
                        stm.executeUpdate(req);
                        HttpSession s = request.getSession();
                        s.setAttribute("message", "Etudiant ajouté avec succès !");
                        response.sendRedirect("Accueil.jsp");
                    } catch (SQLException ex) {
                        Logger.getLogger(EtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("submit_etud") != null) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                Etudiant etud = new Etudiant();
                etud.setNom(request.getParameter("nom_etud"));
                etud.setPrenom(request.getParameter("prenom_etud"));
                etud.setAdresse(request.getParameter("adresse_etud"));
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
                        Logger.getLogger(EtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Statement stm = null;
                    try {
                        stm = conn.createStatement();
                    } catch (SQLException ex) {
                        Logger.getLogger(UtilisateurServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String req = "UPDATE etudiant SET nom='"+etud.getNom()+"', prenom='"+etud.getPrenom()+"',adresse='"+etud.getAdresse()+" WHERE id='"+etud.getId()+"'";
                    try {
                        stm.executeUpdate(req);
                        HttpSession s = request.getSession();
                        s.setAttribute("message", "Etudiant modifié avec succès !");
                        response.sendRedirect("Etudiants.jsp");
                    } catch (SQLException ex) {
                        Logger.getLogger(EtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
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
