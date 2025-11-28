package Entities;

public class Kamar {
    private int idKamar;
    private String tipeKamar;
    private int harga;
    private String status;

    public Kamar(int idKamar, String tipeKamar, int harga) {
        this.idKamar = idKamar;
        this.tipeKamar = tipeKamar;
        this.harga = harga;
        this.status = "Tersedia";
    }

    public int getIdKamar() {
        return idKamar;
    }

    public int getHarga() {
        return harga;
    }

    public void ubahStatus(String statusBaru) {
        this.status = statusBaru;
        System.out.println("[Kamar " + idKamar + "] Status diubah menjadi: " + statusBaru);
    }
}
