package actors;

public abstract class Aktor {
    protected int id;
    protected String nama;

    public Aktor(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public abstract void tampilkanMenu();
}
