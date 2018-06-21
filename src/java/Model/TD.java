package Model;

public class TD {
    private int id, uv_id, ens_id;
    private String salle, horaire;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUv_id() { return uv_id; }
    public void setUv_id(int uv_id) { this.uv_id = uv_id; }
    public int getEns_id() { return ens_id; }
    public void setEns_id(int ens_id) { this.ens_id = ens_id; }
    public String getSalle() { return salle; }
    public void setSalle(String salle) { this.salle = salle; }
    public String getHoraire() { return horaire; }
    public void setHoraire(String horaire) { this.horaire = horaire; }
    public TD() { }
    public TD(int id, int uv_id, int ens_id, String salle, String horaire) {
        this.id = id;
        this.uv_id = uv_id;
        this.ens_id = ens_id;
        this.salle = salle;
        this.horaire = horaire;
    }
}
