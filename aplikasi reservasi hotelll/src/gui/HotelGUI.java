package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HotelGUI extends JFrame {

    public HotelGUI() {
        setTitle("Aplikasi Reservasi Hotel");
        setSize(1000, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Pelayan", panelPelayan());
        tabbedPane.addTab("Tamu", panelTamu());
        tabbedPane.addTab("Kamar", panelKamar());
        tabbedPane.addTab("Reservasi", panelReservasi());

        add(tabbedPane);
    }

    // ================= PANEL PELAYAN =================
    private JPanel panelPelayan() {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel form = formPanel(
                new String[]{"ID","Nama","Alamat","No HP"},
                new JTextField[]{new JTextField(),new JTextField(),
                        new JTextField(),new JTextField()},
                new String[]{"ID","Nama","Alamat","No HP"}
        );

        DefaultTableModel model = tableModel(new String[]{"ID","Nama","Alamat","No HP"});
        JTable table = new JTable(model);

        JButton simpan = new JButton("Simpan");
        simpan.addActionListener(e -> simpanData(form, model));

        panel.add(form, BorderLayout.WEST);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(simpan, BorderLayout.SOUTH);

        return panel;
    }

    // ================= PANEL TAMU =================
    private JPanel panelTamu() {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel form = formPanel(
                new String[]{"ID","Nama","Alamat","No HP"},
                new JTextField[]{new JTextField(),new JTextField(),
                        new JTextField(),new JTextField()},
                new String[]{"ID","Nama","Alamat","No HP"}
        );

        DefaultTableModel model = tableModel(new String[]{"ID","Nama","Alamat","No HP"});
        JTable table = new JTable(model);

        JButton simpan = new JButton("Simpan");
        simpan.addActionListener(e -> simpanData(form, model));

        panel.add(form, BorderLayout.WEST);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(simpan, BorderLayout.SOUTH);

        return panel;
    }

    // ================= PANEL KAMAR =================
    private JPanel panelKamar() {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel form = formPanel(
                new String[]{"ID Kamar","Tipe","Harga"},
                new JTextField[]{new JTextField(),new JTextField(),new JTextField()},
                new String[]{"ID","Tipe","Harga"}
        );

        DefaultTableModel model = tableModel(new String[]{"ID","Tipe","Harga"});
        JTable table = new JTable(model);

        JButton simpan = new JButton("Simpan");
        simpan.addActionListener(e -> simpanData(form, model));

        panel.add(form, BorderLayout.WEST);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(simpan, BorderLayout.SOUTH);

        return panel;
    }

    // ================= PANEL RESERVASI =================
    private JPanel panelReservasi() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField malam = new JTextField();
        JTextField diskon = new JTextField();

        gbc.gridx=0; gbc.gridy=0;
        panel.add(new JLabel("Jumlah Malam"), gbc);
        gbc.gridx=1;
        panel.add(malam, gbc);

        gbc.gridx=0; gbc.gridy=1;
        panel.add(new JLabel("Diskon (%)"), gbc);
        gbc.gridx=1;
        panel.add(diskon, gbc);

        JButton hitung = new JButton("Hitung Total");
        gbc.gridx=1; gbc.gridy=2;
        panel.add(hitung, gbc);

        hitung.addActionListener(e -> {
            try {
                int m = Integer.parseInt(malam.getText());
                int d = Integer.parseInt(diskon.getText());
                int total = (m * 300000);
                total -= total * d / 100;

                JOptionPane.showMessageDialog(this,
                        "Total Bayar: " + total);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Input tidak valid");
            }
        });

        return panel;
    }

    // ================= HELPER =================
    private JPanel formPanel(String[] labels, JTextField[] fields, String[] keys) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setPreferredSize(new Dimension(300,300));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (int i=0;i<labels.length;i++) {
            gbc.gridx=0; gbc.gridy=i;
            panel.add(new JLabel(labels[i]), gbc);
            gbc.gridx=1;
            panel.add(fields[i], gbc);
        }

        panel.putClientProperty("fields", fields);
        return panel;
    }

    private DefaultTableModel tableModel(String[] kolom) {
        return new DefaultTableModel(kolom,0);
    }

    private void simpanData(JPanel form, DefaultTableModel model) {
        JTextField[] fields = (JTextField[]) form.getClientProperty("fields");
        Object[] row = new Object[fields.length];
        for (int i=0;i<fields.length;i++) {
            row[i] = fields[i].getText();
            fields[i].setText("");
        }
        model.addRow(row);
    }
}