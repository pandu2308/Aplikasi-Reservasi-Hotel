package Actors;

public class Pelayan extends Aktor {

    public Pelayan(int idPelayan, String namaPelayan, String alamat, String noHp) {
        super(idPelayan, namaPelayan, alamat, noHp);
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("Menu Pelayan (" + this.nama + "): Input Reservasi, Proses Pembayaran.");
    }
}
