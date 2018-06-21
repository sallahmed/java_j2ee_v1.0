package Model;

public class Inscription {
    private int id, uv_id, etud_id, td_id;
    private String dateins;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUv_id() { return uv_id; }
    public void setUv_id(int uv_id) { this.uv_id = uv_id; }
    public int getEtud_id() { return etud_id; }
    public void setEtud_id(int etud_id) { this.etud_id = etud_id; }
    public int getTd_id() { return td_id; }
    public void setTd_id(int td_id) { this.td_id = td_id; }
    public String getDateins() { return dateins; }
    public void setDateins(String dateins) { this.dateins = dateins; }
    public Inscription() { }
    public Inscription(int id, int uv_id, int etud_id, int td_id, String dateins) {
        this.id = id;
        this.uv_id = uv_id;
        this.etud_id = etud_id;
        this.td_id = td_id;
        this.dateins = dateins;
    }
}
