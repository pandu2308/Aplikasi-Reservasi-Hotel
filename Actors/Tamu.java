package Actors;

public class Tamu extends Aktor {

    public Tamu(int idTamu, String namaTamu, String alamat, String noHp) {
        super(idTamu, namaTamu, alamat, noHp);
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("Menu Tamu (" + this.nama + "): Buat Reservasi, Cek Riwayat.");
    }
}
