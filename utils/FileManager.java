package utils;

import java.io.*;

public class FileManager {

    public static void simpanKamar(String data) {
        try {
            FileWriter fw = new FileWriter("kamar.txt", true);
            fw.write(data + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Gagal simpan file");
        }
    }

    public static void bacaFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("kamar.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("File belum ada");
        }
    }
}
