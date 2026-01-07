package entities;

import actors.*;

public class Reservasi {
    private Pelayan pelayan;
    private Tamu tamu;
    private Kamar kamar;
    private int malam;

    public Reservasi(Pelayan p, Tamu t, Kamar k, int malam) {
        this.pelayan = p;
        this.tamu = t;
        this.kamar = k;
        this.malam = malam;
    }

    public int getSubtotal() {
        return kamar.getHarga() * malam;
    }

    public Pelayan getPelayan() { return pelayan; }
    public Tamu getTamu() { return tamu; }
    public Kamar getKamar() { return kamar; }
}
