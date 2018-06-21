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
@WebServlet(name = "ModifierEtudiantServlet", urlPatterns = {"/ModifierEtudiantServlet"})
public class ModifierEtudiantServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("modif_etud") != null) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                Etudiant etud = new Etudiant();
                etud.setId(Integer.parseInt(request.getParameter("id")));
                etud.setNom(request.getParameter("nom_etud"));
                etud.setPrenom(request.getParameter("prenom_etud"));
                etud.setAdresse(request.getParameter("adresse_etud"));
                etud.setUser_id(Integer.parseInt(request.getParameter("user_id")));
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
                        Logger.getLogger(ModifierEtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Statement stm = null;
                    try {
                        stm = conn.createStatement();
                    } catch (SQLException ex) {
                        Logger.getLogger(UtilisateurServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String req = "UPDATE etudiant SET nom='"+etud.getNom()+"', prenom='"+etud.getPrenom()+"', adresse='"+etud.getAdresse()+"' WHERE id="+etud.getId();
                    try {
                        stm.executeUpdate(req);
                        HttpSession s = request.getSession();
                        s.setAttribute("message", "Etudiant modifié avec succès !");
                        response.sendRedirect("Etudiants.jsp");
                    } catch (SQLException ex) {
                        Logger.getLogger(ModifierEtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ModifierEtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
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