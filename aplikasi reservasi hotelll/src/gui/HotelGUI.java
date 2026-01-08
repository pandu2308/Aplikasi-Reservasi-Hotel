package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class HotelGUI extends JFrame {

    public HotelGUI() {
        setTitle("Aplikasi Reservasi Hotel");
        setSize(1000, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Pelayan", panelData("pelayan.txt"));
        tabbedPane.addTab("Tamu", panelData("tamu.txt"));
        tabbedPane.addTab("Kamar", panelData("kamar.txt"));
        tabbedPane.addTab("Reservasi", panelReservasi());

        add(tabbedPane);
    }

    // ================= PANEL DATA (PEL. TAMU, KAMAR) =================
    private JPanel panelData(String namaFile) {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JTextField f1 = new JTextField();
        JTextField f2 = new JTextField();
        JTextField f3 = new JTextField();
        JTextField f4 = new JTextField();

        JPanel form = new JPanel(new GridLayout(4,2,5,5));
        form.add(new JLabel("ID"));
        form.add(f1);
        form.add(new JLabel("Nama / Tipe"));
        form.add(f2);
        form.add(new JLabel("Alamat / Harga"));
        form.add(f3);
        form.add(new JLabel("No HP"));
        form.add(f4);

        DefaultTableModel model = new DefaultTableModel(
                new String[]{"ID","Nama/Tipe","Alamat/Harga","No HP"},0
        );
        JTable table = new JTable(model);

        loadDariFile(model, namaFile);

        // === SEARCH ===
        JTextField cari = new JTextField(15);
        JButton btnCari = new JButton("Cari");

        JPanel cariPanel = new JPanel();
        cariPanel.add(new JLabel("Cari ID/Nama:"));
        cariPanel.add(cari);
        cariPanel.add(btnCari);

        btnCari.addActionListener(e -> {
            boolean ketemu = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                String id = model.getValueAt(i,0).toString().toLowerCase();
                String nama = model.getValueAt(i,1).toString().toLowerCase();

                if (id.contains(cari.getText().toLowerCase())
                        || nama.contains(cari.getText().toLowerCase())) {
                    ketemu = true;
                    JOptionPane.showMessageDialog(this,
                            "Data ditemukan di baris ke-" + (i+1));
                    break;
                }
            }
            if (!ketemu) {
                JOptionPane.showMessageDialog(this,"Data tidak ditemukan");
            }
        });

        // === BUTTON ===
        JButton simpan = new JButton("Simpan");
        JButton saveFile = new JButton("Simpan ke File");

        simpan.addActionListener(e -> {
            try {
                if (f1.getText().isEmpty() || f2.getText().isEmpty()) {
                    throw new IllegalArgumentException();
                }

                model.addRow(new Object[]{
                        f1.getText(), f2.getText(), f3.getText(), f4.getText()
                });

                f1.setText(""); f2.setText(""); f3.setText(""); f4.setText("");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this,"Input wajib diisi");
            }
        });

        saveFile.addActionListener(e ->
                simpanKeFile(model, namaFile)
        );

        JPanel btnPanel = new JPanel();
        btnPanel.add(simpan);
        btnPanel.add(saveFile);

        panel.add(cariPanel, BorderLayout.NORTH);
        panel.add(form, BorderLayout.WEST);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);

        return panel;
    }

    // ================= PANEL RESERVASI =================
    private JPanel panelReservasi() {
        JPanel panel = new JPanel(new GridLayout(4,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JTextField malam = new JTextField();
        JTextField diskon = new JTextField();

        panel.add(new JLabel("Jumlah Malam"));
        panel.add(malam);
        panel.add(new JLabel("Diskon (%)"));
        panel.add(diskon);

        JButton hitung = new JButton("Hitung Total");
        panel.add(new JLabel());
        panel.add(hitung);

        hitung.addActionListener(e -> {
            try {
                int m = Integer.parseInt(malam.getText());
                int d = Integer.parseInt(diskon.getText());

                if (m <= 0 || d < 0 || d > 100) {
                    throw new IllegalArgumentException();
                }

                int total = m * 300000;
                total -= total * d / 100;

                JOptionPane.showMessageDialog(this,
                        "Total Bayar: " + total);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,"Input harus angka");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this,"Nilai tidak valid");
            }
        });

        return panel;
    }

    // ================= FILE HANDLING =================
    private void simpanKeFile(DefaultTableModel model, String namaFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    bw.write(model.getValueAt(i,j).toString() + ";");
                }
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this,"Data tersimpan ke file");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"Gagal menyimpan file");
        }
    }

    private void loadDariFile(DefaultTableModel model, String namaFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                model.addRow(line.split(";"));
            }
        } catch (IOException e) {
            // file belum ada → aman
        }
    }
}
