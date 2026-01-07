package utils;

import javax.swing.*;

public class Validator {

    public static boolean kosong(String... data) {
        for (String s : data) {
            if (s.trim().isEmpty()) return true;
        }
        return false;
    }

    public static int toInt(String value, String pesan) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, pesan);
            throw e;
        }
    }
}
