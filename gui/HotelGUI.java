package gui;

import entities.Kamar;
import utils.DataManager;

import javax.swing.*;
import java.awt.*;

public class HotelGUI {

    public static void tampil() {
        JFrame frame = new JFrame("Hotel App");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtCari = new JTextField();
        JTextField txtId = new JTextField();
        JTextField txtTipe = new JTextField();
        JTextField txtHarga = new JTextField();

        txtId.setEditable(false);
        txtTipe.setEditable(false);
        txtHarga.setEditable(false);

        JButton btnCari = new JButton("Cari Kamar");

        btnCari.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtCari.getText());
                Kamar k = DataManager.cariKamar(id);

                if (k != null) {
                    txtId.setText(String.valueOf(k.getId()));
                    txtTipe.setText(k.getTipe());
                    txtHarga.setText(String.valueOf(k.getHarga()));
                } else {
                    JOptionPane.showMessageDialog(frame, "Kamar tidak ditemukan");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "ID harus angka");
            }
        });

        panel.add(new JLabel("Cari ID Kamar"));
        panel.add(txtCari);
        panel.add(new JLabel("ID Kamar"));
        panel.add(txtId);
        panel.add(new JLabel("Tipe"));
        panel.add(txtTipe);
        panel.add(new JLabel("Harga"));
        panel.add(txtHarga);
        panel.add(new JLabel());
        panel.add(btnCari);

        frame.add(panel);
        frame.setVisible(true);
    }
}
