package actors;

public class Pelayan extends Aktor {

    public Pelayan(int id, String nama) {
        super(id, nama);
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("Menu Pelayan: Input Reservasi, Proses Pembayaran");
    }
}
