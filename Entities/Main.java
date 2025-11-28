package Entities;


import Actors.Pelayan;

import Actors.Tamu;
import Entities.Kamar;
import Entities.Reservasi;
import Entities.Pembayaran;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- DEMO APLIKASI RESERVASI HOTEL ---");

        Pelayan pelayan1 = new Pelayan(101, "Aulia", "Jl. Mawar 50", "081234567890");
        Tamu tamu1 = new Tamu(201, "Bambang", "Jl. Melati 10", "089876543210");
        Kamar kamar101 = new Kamar(101, "STD", 300000);

        System.out.println("\n### 1. Demonstrasi Inheritance & Overriding ###");
        pelayan1.tampilkanMenu();
        tamu1.tampilkanMenu();

        System.out.println("\n### 2. Demonstrasi Relasi Reservasi ###");
        Reservasi reservasiBaru = new Reservasi(
                9001,
                101,
                kamar101.getIdKamar(),
                201
        );
        reservasiBaru.buatReservasi(kamar101);

        System.out.println("\n### 3. Demonstrasi Overloading ###");
        Pembayaran pembayaran = new Pembayaran(8001, 201, 101);

        int total1 = pembayaran.hitungTotal(kamar101.getHarga(), 3);
        System.out.println("Total 3 Malam (Tanpa Diskon): " + total1);

        int total2 = pembayaran.hitungTotal(kamar101.getHarga(), 3, 15);
        System.out.println("Total 3 Malam (Diskon 15%): " + total2);
    }
}
