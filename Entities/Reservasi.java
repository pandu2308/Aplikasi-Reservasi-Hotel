package Entities;

public class Reservasi {
    private int idReservasi;
    private int idPelayan;
    private int idKamar;
    private int idTamu;

    public Reservasi(int idReservasi, int idPelayan, int idKamar, int idTamu) {
        this.idReservasi = idReservasi;
        this.idPelayan = idPelayan;
        this.idKamar = idKamar;
        this.idTamu = idTamu;
    }

    public void buatReservasi(Kamar kamar) {
        kamar.ubahStatus("Terisi");
        System.out.println("[Reservasi " + idReservasi + "] Berhasil dibuat oleh Pelayan "
                + idPelayan + " untuk Tamu " + idTamu + ".");
    }
}
