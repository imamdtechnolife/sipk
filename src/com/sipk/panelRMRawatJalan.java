package com.sipk;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;

public class panelRMRawatJalan extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public panelRMRawatJalan() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1084, 637);
		add(tabbedPane);
		
		JPanel panelTabelRMRJ = new JPanel();
		JPanel panel = new JPanel();
		tabbedPane.addTab("Rekam Medis Pasien Rawat Jalan", null, panel, null);
		tabbedPane.addTab("Tabel Rekam Medis Pasien Rawat Jalan", null, panelTabelRMRJ, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(384, 317, 306, 124);
		panel.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 317, 277, 124);
		panel.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		JLabel lblAnamesePemeriksaan = new JLabel("Anamese & Pemeriksaan / Diagnose");
		lblAnamesePemeriksaan.setBounds(62, 292, 264, 14);
		panel.add(lblAnamesePemeriksaan);
		lblAnamesePemeriksaan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JLabel lblTherapi = new JLabel("Therapi");
		lblTherapi.setBounds(384, 292, 93, 14);
		panel.add(lblTherapi);
		lblTherapi.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		formattedTextField_1.setBounds(137, 235, 46, 29);
		panel.add(formattedTextField_1);
		
		JLabel lblJam = new JLabel("Jam");
		lblJam.setBounds(62, 235, 46, 29);
		panel.add(lblJam);
		lblJam.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JLabel lblTanggal_1 = new JLabel("Tanggal");
		lblTanggal_1.setBounds(62, 202, 69, 29);
		panel.add(lblTanggal_1);
		lblTanggal_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		formattedTextField.setBounds(137, 202, 157, 29);
		panel.add(formattedTextField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		comboBox.setBounds(137, 142, 171, 29);
		panel.add(comboBox);
		
		JLabel lblTanggal = new JLabel("Poli");
		lblTanggal.setBounds(62, 142, 46, 29);
		panel.add(lblTanggal);
		lblTanggal.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JButton btnCari = new JButton("Cari");
		btnCari.setBounds(700, 109, 51, 23);
		panel.add(btnCari);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		textField_3.setBounds(541, 105, 149, 29);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		textField_2.setBounds(541, 75, 149, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNoReg = new JLabel("No. Reg");
		lblNoReg.setBounds(440, 73, 74, 31);
		panel.add(lblNoReg);
		lblNoReg.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JLabel lblNoRm = new JLabel("No. RM");
		lblNoRm.setBounds(440, 112, 80, 22);
		panel.add(lblNoRm);
		lblNoRm.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		textField_1.setBounds(137, 105, 46, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUmur = new JLabel("Umur");
		lblUmur.setBounds(62, 105, 46, 29);
		panel.add(lblUmur);
		lblUmur.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(62, 73, 46, 31);
		panel.add(lblNama);
		lblNama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		textField.setBounds(137, 75, 259, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblRekamMedisRawat = new JLabel("Rekam Medis Pasien Rawat Jalan");
		lblRekamMedisRawat.setBounds(25, 11, 465, 33);
		panel.add(lblRekamMedisRawat);
		lblRekamMedisRawat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setIcon(new ImageIcon(panelRMRawatJalan.class.getResource("/com/sipk/Image/Simpan.png")));
		btnSimpan.setBounds(711, 346, 104, 39);
		panel.add(btnSimpan);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.setIcon(new ImageIcon(panelRMRawatJalan.class.getResource("/com/sipk/Image/Batal.png")));
		btnBatal.setBounds(711, 388, 104, 39);
		panel.add(btnBatal);

	}
}
