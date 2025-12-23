package actors;

public class Tamu extends Aktor {

    public Tamu(int id, String nama) {
        super(id, nama);
    }

    @Override
    public void tampilkanMenu() {
        System.out.println("Menu Tamu: Buat Reservasi, Cari Kamar");
    }
}
