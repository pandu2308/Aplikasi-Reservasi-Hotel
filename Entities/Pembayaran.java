package Entities;

public class Pembayaran {
    private int idPembayaran;
    private int idTamu;
    private int idPelayan;
    private int total;

    public Pembayaran(int idPembayaran, int idTamu, int idPelayan) {
        this.idPembayaran = idPembayaran;
        this.idTamu = idTamu;
        this.idPelayan = idPelayan;
        this.total = 0;
    }

    // Overloading 1: Tanpa diskon
    public int hitungTotal(int hargaKamar, int jumlahMalam) {
        int subtotal = hargaKamar * jumlahMalam;
        int pajak = subtotal * 10 / 100;
        total = subtotal + pajak;
        return total;
    }

    // Overloading 2: Dengan diskon
    public int hitungTotal(int hargaKamar, int jumlahMalam, int diskonPersen) {
        int subtotal = hargaKamar * jumlahMalam;
        int diskon = subtotal * diskonPersen / 100;
        int bersih = subtotal - diskon;

        int pajak = bersih * 10 / 100;
        total = bersih + pajak;
        return total;
    }

    public int getTotal() {
        return total;
    }
}
