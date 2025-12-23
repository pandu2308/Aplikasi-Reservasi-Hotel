import entities.*;
import utils.*;
import gui.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\n=== MENU HOTEL ===");
            System.out.println("1. Tambah Kamar");
            System.out.println("2. Cari Kamar");
            System.out.println("3. Lihat File");
            System.out.println("4. GUI");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            menu = input.nextInt();

            if (menu == 1) {
                System.out.print("ID Kamar: ");
                int id = input.nextInt();
                input.nextLine();

                System.out.print("Tipe: ");
                String tipe = input.nextLine();

                System.out.print("Harga: ");
                int harga = input.nextInt();

                Kamar k = new Kamar(id, tipe, harga);
                DataManager.listKamar.add(k);
                FileManager.simpanKamar(k.toString());
            }

            if (menu == 2) {
                System.out.print("Masukkan ID Kamar: ");
                int idCari = input.nextInt();

                Kamar hasil = DataManager.cariKamar(idCari);

                if (hasil != null) {
                    hasil.tampilkanInfo();
                } else {
                    System.out.println("Kamar tidak ditemukan");
                }
            }

            if (menu == 3) {
                FileManager.bacaFile();
            }

            if (menu == 4) {
                HotelGUI.tampil();
            }

        } while (menu != 0);
    }
}
