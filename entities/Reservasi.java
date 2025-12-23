package entities;

public class Reservasi {
    private int idReservasi;
    private int idKamar;
    private int idTamu;

    public Reservasi(int idReservasi, int idKamar, int idTamu) {
        this.idReservasi = idReservasi;
        this.idKamar = idKamar;
        this.idTamu = idTamu;
    }
}
