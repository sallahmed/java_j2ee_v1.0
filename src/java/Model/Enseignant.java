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

public class Enseignant {
    private int id, user_id;
    private String nom, prenom, grade;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public Enseignant() { }
    public Enseignant(int id, String grade, int user_id, String nom, String prenom) {
        this.id = id;
        this.grade = grade;
        this.user_id = user_id;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public List<Enseignant> ListEnseignants() {
        List<Enseignant> listEns = new ArrayList<Enseignant>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/projetweb_j2ee";
            String user = "root";
            String mdp = "mysql";
            Connection conn;
            try {
                conn = DriverManager.getConnection(url, user, mdp);
                String sql = " SELECT * FROM enseignant ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    Enseignant ens = new Enseignant();
                    ens.setId(rs.getInt("id"));
                    ens.setNom(rs.getString("nom"));
                    ens.setPrenom(rs.getString("prenom"));
                    ens.setGrade(rs.getString("grade"));
                    ens.setUser_id(rs.getInt("user_id"));
                    listEns.add(ens);
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEns;
    }
    
    public Enseignant getEnseignant(int id) {
        Enseignant ens = new Enseignant();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/projetweb_j2ee";
            String user = "root";
            String mdp = "mysql";
            Connection conn;
            try {
                conn = DriverManager.getConnection(url, user, mdp);
                String sql = "SELECT * FROM enseignant WHERE id="+id;
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    ens.setId(rs.getInt("id"));
                    ens.setNom(rs.getString("nom"));
                    ens.setPrenom(rs.getString("prenom"));
                    ens.setGrade(rs.getString("grade"));
                    ens.setUser_id(Integer.parseInt(rs.getString("user_id")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ens;
    }
}