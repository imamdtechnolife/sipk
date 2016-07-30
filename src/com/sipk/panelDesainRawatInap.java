package com.sipk;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import org.freixas.jcalendar.JCalendarCombo;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelDesainRawatInap extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public panelDesainRawatInap() {
		setLayout(null);
	
		JPanel i = new JPanel();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1338, 501);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Input Rawat Inap", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 5, 796, 482);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(28, 25, 546, 392);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kode Rawat Jalan : ");
		lblNewLabel.setBounds(0, 2, 274, 22);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(272, 2, 274, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNoRm = new JLabel("No. RM :");
		lblNoRm.setBounds(0, 24, 274, 22);
		panel_2.add(lblNoRm);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(272, 25, 274, 22);
		panel_2.add(textField_1);
		
		JLabel lblNamaPenderita = new JLabel("Nama Penderita :");
		lblNamaPenderita.setBounds(0, 48, 274, 22);
		panel_2.add(lblNamaPenderita);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(272, 49, 274, 22);
		panel_2.add(textField_2);
		
		JLabel lblUmur = new JLabel("Umur :");
		lblUmur.setBounds(0, 72, 274, 22);
		panel_2.add(lblUmur);
		
		JLabel lblAlamat = new JLabel("Alamat :");
		lblAlamat.setBounds(0, 96, 274, 22);
		panel_2.add(lblAlamat);
		
		JLabel lblStatusPernikahan = new JLabel("Status Pernikahan");
		lblStatusPernikahan.setBounds(0, 119, 274, 22);
		panel_2.add(lblStatusPernikahan);
		
		JLabel lblStatusPasien = new JLabel("Status Pasien : ");
		lblStatusPasien.setBounds(0, 143, 274, 22);
		panel_2.add(lblStatusPasien);
		
		JLabel lblTanggalMasuk = new JLabel("Tanggal Masuk :");
		lblTanggalMasuk.setBounds(0, 167, 274, 22);
		panel_2.add(lblTanggalMasuk);
		
		JLabel lblTanggalKeluar = new JLabel("Tanggal Keluar :");
		lblTanggalKeluar.setBounds(0, 190, 274, 22);
		panel_2.add(lblTanggalKeluar);
		
		JLabel lblLama = new JLabel("Lama :");
		lblLama.setBounds(0, 214, 274, 22);
		panel_2.add(lblLama);
		
		JLabel lblRuangan = new JLabel("Ruangan :");
		lblRuangan.setBounds(0, 238, 274, 22);
		panel_2.add(lblRuangan);
		
		JLabel lblPoli = new JLabel("Poli :");
		lblPoli.setBounds(0, 261, 274, 22);
		panel_2.add(lblPoli);
		
		JLabel lblDokter = new JLabel("Dokter :");
		lblDokter.setBounds(0, 285, 274, 22);
		panel_2.add(lblDokter);
		
		JLabel lblDiagnosa = new JLabel("Diagnosa :");
		lblDiagnosa.setBounds(0, 309, 274, 22);
		panel_2.add(lblDiagnosa);
		
		JLabel lblNoIcd = new JLabel("No. ICD-10 :");
		lblNoIcd.setBounds(0, 332, 274, 22);
		panel_2.add(lblNoIcd);
		
		JLabel lblKeterangan = new JLabel("Keterangan :");
		lblKeterangan.setBounds(0, 359, 274, 22);
		panel_2.add(lblKeterangan);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(272, 73, 274, 22);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(272, 97, 274, 22);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(272, 333, 274, 22);
		panel_2.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(272, 360, 274, 22);
		panel_2.add(textField_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(272, 120, 274, 20);
		panel_2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(272, 144, 274, 20);
		panel_2.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(272, 239, 274, 20);
		panel_2.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(272, 262, 274, 20);
		panel_2.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(272, 286, 274, 20);
		panel_2.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(272, 310, 274, 20);
		panel_2.add(comboBox_5);
		
		JCalendarCombo calendarCombo = new JCalendarCombo();
		calendarCombo.setBounds(272, 168, 274, 20);
		panel_2.add(calendarCombo);
		
		JCalendarCombo calendarCombo_1 = new JCalendarCombo();
		calendarCombo_1.setBounds(272, 191, 274, 20);
		panel_2.add(calendarCombo_1);
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setBounds(272, 223, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Simpan");
		btnNewButton.setIcon(new ImageIcon(panelDesainRawatInap.class.getResource("/com/sipk/Image/Simpan.png")));
		btnNewButton.setBounds(584, 211, 95, 33);
		panel_1.add(btnNewButton);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.setIcon(new ImageIcon(panelDesainRawatInap.class.getResource("/com/sipk/Image/Batal.png")));
		btnBatal.setBounds(689, 211, 95, 33);
		panel_1.add(btnBatal);
		
		JPanel ii = new JPanel();
		tabbedPane.addTab("Pasien Rawat Inap", null, ii, null);
		ii.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1313, 197);
		ii.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Kode RI", "No. RM", "Nama Penderita", "Umur", "Alamat", "Status Nikah", "Status Pasien", "Tanggal Masuk", "Ruang Perawatan", "Poli", "Dokter", "Diagnosa", "Ketarangan"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(98);
		table.getColumnModel().getColumn(7).setPreferredWidth(93);
		table.getColumnModel().getColumn(8).setPreferredWidth(99);
		scrollPane.setViewportView(table);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(20, 219, 99, 20);
		comboBox_6.addItem("-- Pilih Poli --");
		ii.add(comboBox_6);
		
		JLabel lblNewLabel_2 = new JLabel("Pasien Anggota");
		lblNewLabel_2.setBounds(129, 222, 89, 14);
		ii.add(lblNewLabel_2);
		
		JLabel lblPasienPns = new JLabel("Pasien PNS");
		lblPasienPns.setBounds(251, 222, 60, 14);
		ii.add(lblPasienPns);
		
		JLabel lblPasienSiswaDikbang = new JLabel("Pasien Siswa DIKBANG");
		lblPasienSiswaDikbang.setBounds(351, 222, 132, 14);
		ii.add(lblPasienSiswaDikbang);
		
		JLabel lblPasienSiswaDiktuk = new JLabel("Pasien Siswa DIKTUK");
		lblPasienSiswaDiktuk.setBounds(505, 222, 132, 14);
		ii.add(lblPasienSiswaDiktuk);
		
		JLabel lblPasienTahanan = new JLabel("Pasien Mandiri");
		lblPasienTahanan.setBounds(805, 222, 77, 14);
		ii.add(lblPasienTahanan);
		
		JLabel lblPasienMandiri = new JLabel("Pasien Purnawirawan");
		lblPasienMandiri.setBounds(1038, 222, 132, 14);
		ii.add(lblPasienMandiri);
		
		JLabel lblPasienMandiri_1 = new JLabel("Pasien Tahanan");
		lblPasienMandiri_1.setBounds(660, 222, 77, 14);
		ii.add(lblPasienMandiri_1);
		
		JLabel lblPasienBpjs = new JLabel("Pasien BPJS");
		lblPasienBpjs.setBounds(926, 222, 60, 14);
		ii.add(lblPasienBpjs);
		
		textField_7 = new JTextField();
		textField_7.setBounds(211, 219, 32, 20);
		ii.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(309, 219, 32, 20);
		ii.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(466, 219, 32, 20);
		ii.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(618, 219, 32, 20);
		ii.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(747, 219, 32, 20);
		ii.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(884, 219, 32, 20);
		ii.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(1148, 219, 32, 20);
		ii.add(textField_13);
		
		JButton btnSimpanHp = new JButton("Simpan HP");
		btnSimpanHp.setIcon(new ImageIcon(panelDesainRawatInap.class.getResource("/com/sipk/Image/Total.png")));
		btnSimpanHp.setBounds(1190, 213, 119, 33);
		ii.add(btnSimpanHp);
		
		JButton btnNewButton_1 = new JButton("Ubah");
		btnNewButton_1.setIcon(new ImageIcon(panelDesainRawatInap.class.getResource("/com/sipk/Image/Ubah.png")));
		btnNewButton_1.setBounds(269, 259, 89, 33);
		ii.add(btnNewButton_1);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.setIcon(new ImageIcon(panelDesainRawatInap.class.getResource("/com/sipk/Image/Hapus.png")));
		btnHapus.setBounds(365, 259, 99, 33);
		ii.add(btnHapus);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setIcon(new ImageIcon(panelDesainRawatInap.class.getResource("/com/sipk/Image/Refresh.png")));
		btnRefresh.setBounds(475, 259, 99, 33);
		ii.add(btnRefresh);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(996, 219, 32, 20);
		ii.add(textField_14);
		
		JPanel iii = new JPanel();
		tabbedPane.addTab("Pasien Keluar", null, iii, null);
		iii.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 1313, 451);
		iii.add(scrollPane_1);
		
		table_1 = new JTable(
		new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Kode RI", "No. RM", "Nama Penderita", "Umur", "Alamat", "Status Nikah", "Status Pasien", "Tanggal Masuk", "Ruang Perawatan", "Poli", "Dokter", "Diagnosa", "Ketarangan"
				}
			));
			table.getColumnModel().getColumn(2).setPreferredWidth(98);
			table.getColumnModel().getColumn(7).setPreferredWidth(93);
			table.getColumnModel().getColumn(8).setPreferredWidth(99);
		scrollPane_1.setViewportView(table_1);

	}
}
