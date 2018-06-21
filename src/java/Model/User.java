package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
    private int id;
    private String login, pass, grant;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }
    public String getGrant() { return grant; }
    public void setGrant(String grant) { this.grant = grant; }
    public User() { }
    public User(int id, String login, String pass, String grant) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.grant = grant;
    }
    public List<User> ListUsers() {
        List<User> listU = new ArrayList<User>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/projetweb_j2ee";
            String user = "root";
            String mdp = "mysql";
            Connection conn;
            try {
                conn = DriverManager.getConnection(url, user, mdp);
                String sql = " SELECT * FROM user ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt("id"));
                    u.setLogin(rs.getString("login"));
                    u.setPass(rs.getString("pass"));
                    u.setGrant(rs.getString("grant"));
                    listU.add(u);
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listU;
    }
    
    public User getUser(int id) {
        User u = new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/projetweb_j2ee";
            String user = "root";
            String mdp = "mysql";
            Connection conn;
            try {
                conn = DriverManager.getConnection(url, user, mdp);
                String sql = "SELECT * FROM user WHERE id="+id;
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    u.setId(rs.getInt("id"));
                    u.setLogin(rs.getString("login"));
                    u.setPass(rs.getString("pass"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
}