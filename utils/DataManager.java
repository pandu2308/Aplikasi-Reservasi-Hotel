package utils;

import entities.Kamar;
import java.util.ArrayList;

public class DataManager {
    public static ArrayList<Kamar> listKamar = new ArrayList<>();

    static {
        listKamar.add(new Kamar(101, "Standard", 300000));
        listKamar.add(new Kamar(102, "Deluxe", 450000));
        listKamar.add(new Kamar(103, "Suite", 700000));
    }

    public static Kamar cariKamar(int id) {
        for (Kamar k : listKamar) {
            if (k.getId() == id) {
                return k;
            }
        }
        return null;
    }
}
