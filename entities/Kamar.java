package entities;

public class Kamar {
    private int id;
    private String tipe;
    private int harga;

    public Kamar(int id, String tipe, int harga) {
        this.id = id;
        this.tipe = tipe;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getTipe() {
        return tipe;
    }

    public int getHarga() {
        return harga;
    }

    public void tampilkanInfo() {
        System.out.println("ID Kamar : " + id);
        System.out.println("Tipe     : " + tipe);
        System.out.println("Harga    : " + harga);
    }

    @Override
    public String toString() {
        return id + "," + tipe + "," + harga;
    }
}
