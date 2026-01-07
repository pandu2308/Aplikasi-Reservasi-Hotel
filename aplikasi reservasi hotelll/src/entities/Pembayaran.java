package entities;

public class Pembayaran {
    public static int hitungTotal(Reservasi r, int diskon) {
        int sub = r.getSubtotal();
        return sub - (sub * diskon / 100);
    }
}
