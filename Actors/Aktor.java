package Actors;

public abstract class Aktor {
    protected int idAktor;
    protected String nama;
    protected String alamat;
    protected String noHp;

    public Aktor(int idAktor, String nama, String alamat, String noHp) {
        this.idAktor = idAktor;
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
    }

    public abstract void tampilkanMenu();
}
