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

public class Etudiant {
    private int id, user_id;
    private String nom, prenom, adresse;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public Etudiant() { }
    public Etudiant(int id, int user_id, String nom, String prenom, String adresse) {
        this.id = id;
        this.user_id = user_id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
    
    public List<Etudiant> ListEtudiants() {
        List<Etudiant> listE = new ArrayList<Etudiant>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/projetweb_j2ee";
            String user = "root";
            String mdp = "mysql";
            Connection conn;
            try {
                conn = DriverManager.getConnection(url, user, mdp);
                String sql = " SELECT * FROM etudiant ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    Etudiant e = new Etudiant();
                    e.setId(rs.getInt("id"));
                    e.setNom(rs.getString("nom"));
                    e.setPrenom(rs.getString("prenom"));
                    e.setAdresse(rs.getString("adresse"));
                    listE.add(e);
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listE;
    }
    
    public Etudiant getEtudiant(int id) {
        Etudiant etud = new Etudiant();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/projetweb_j2ee";
            String user = "root";
            String mdp = "mysql";
            Connection conn;
            try {
                conn = DriverManager.getConnection(url, user, mdp);
                String sql = "SELECT * FROM etudiant WHERE id="+id;
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    etud.setId(rs.getInt("id"));
                    etud.setNom(rs.getString("nom"));
                    etud.setPrenom(rs.getString("prenom"));
                    etud.setAdresse(rs.getString("adresse"));
                    etud.setUser_id(Integer.parseInt(rs.getString("user_id")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return etud;
    }
}
