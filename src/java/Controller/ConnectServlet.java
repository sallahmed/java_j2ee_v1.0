/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "ConnectServlet", urlPatterns = {"/ConnectServlet"})
public class ConnectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("login_btn") != null) {
            try {
                HttpSession s = request.getSession();
                String login = request.getParameter("login") ;
                String pass = request.getParameter("pass") ;
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost/projetweb_j2ee";
                String user = "root";
                String mdp = "mysql";
                try {
                    Connection conn = DriverManager.getConnection(url, user, mdp);
                    String sql = " SELECT * FROM user WHERE login=? AND pass=? ";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, login);
                    ps.setString(2, pass);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()) {
                        s.setAttribute("connect", "OK");
                        s.setAttribute("grant", rs.getString("grant"));
                        s.setAttribute("username", rs.getString("login"));
                        response.sendRedirect("Accueil.jsp");
                    } else {
                        s.setAttribute("connect", "NOK");
                        response.sendRedirect("Login.jsp");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ConnectServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
