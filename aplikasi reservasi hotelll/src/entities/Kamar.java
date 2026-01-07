package entities;

public class Kamar {
    private String id, tipe;
    private int harga;

    public Kamar(String id, String tipe, int harga) {
        this.id = id;
        this.tipe = tipe;
        this.harga = harga;
    }

    public String getId() { return id; }
    public String getTipe() { return tipe; }
    public int getHarga() { return harga; }
}
