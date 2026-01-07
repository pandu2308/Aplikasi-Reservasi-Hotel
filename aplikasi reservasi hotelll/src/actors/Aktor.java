package actors;

public abstract class Aktor {
    protected String id, nama, alamat, noHp;

    public Aktor(String id, String nama, String alamat, String noHp) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
}
