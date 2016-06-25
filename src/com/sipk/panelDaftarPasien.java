package com.sipk;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class panelDaftarPasien extends JPanel {
	private JTextField textField;
	private JTextField txtNoUrut;
	private JTextField txtNoCM;
	private JTextField txtNama;
	private JTextField txtUmur;

	/**
	 * Create the panel.
	 */
	public panelDaftarPasien() {
		setLayout(new GridLayout(0,1));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1074, 704);
		add(tabbedPane);
		
		
		
		JPanel panelTabelKunjungan = new JPanel();
		tabbedPane.addTab("Tabel Kunjungan", null, panelTabelKunjungan, null);
		
		
		JPanel panelDaftarKunjungan = new JPanel();
		JScrollPane scrollDaftarKunjungan = new JScrollPane();
		scrollDaftarKunjungan.setViewportView(panelDaftarKunjungan);
		tabbedPane.addTab("Daftar Kunjungan", null, scrollDaftarKunjungan, null);
		panelDaftarKunjungan.setLayout(null);
		
		JLabel lblDaftarPasien = new JLabel("Daftar Kunjungan");
		lblDaftarPasien.setBounds(47, 29, 265, 33);
		panelDaftarKunjungan.add(lblDaftarPasien);
		lblDaftarPasien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		
		JLabel lblTanggal = new JLabel("Tanggal");
		lblTanggal.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblTanggal.setBounds(117, 94, 88, 20);
		panelDaftarKunjungan.add(lblTanggal);
		
		JFormattedTextField formatTanggal = new JFormattedTextField();
		formatTanggal.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		formatTanggal.setBounds(259, 94, 73, 24);
		panelDaftarKunjungan.add(formatTanggal);
		
		JLabel lblNoUrut = new JLabel("No. Urut");
		lblNoUrut.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoUrut.setBounds(117, 130, 88, 14);
		panelDaftarKunjungan.add(lblNoUrut);
		
		txtNoUrut = new JTextField();
		txtNoUrut.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoUrut.setBounds(259, 127, 86, 24);
		panelDaftarKunjungan.add(txtNoUrut);
		txtNoUrut.setColumns(10);
		
		JLabel lblNoCm = new JLabel("No. CM");
		lblNoCm.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoCm.setBounds(117, 169, 88, 14);
		panelDaftarKunjungan.add(lblNoCm);
		
		txtNoCM = new JTextField();
		txtNoCM.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoCM.setBounds(259, 166, 86, 24);
		panelDaftarKunjungan.add(txtNoCM);
		txtNoCM.setColumns(10);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNama.setBounds(117, 210, 46, 14);
		panelDaftarKunjungan.add(lblNama);
		
		txtNama = new JTextField();
		txtNama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNama.setBounds(259, 207, 192, 24);
		panelDaftarKunjungan.add(txtNama);
		txtNama.setColumns(10);
		
		JLabel lblUmur = new JLabel("Umur");
		lblUmur.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblUmur.setBounds(117, 252, 46, 14);
		panelDaftarKunjungan.add(lblUmur);
		
		txtUmur = new JTextField();
		txtUmur.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtUmur.setBounds(259, 249, 46, 24);
		panelDaftarKunjungan.add(txtUmur);
		txtUmur.setColumns(10);
		
		JLabel lblJenisKelamin = new JLabel("Jenis Kelamin");
		lblJenisKelamin.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblJenisKelamin.setBounds(117, 294, 119, 14);
		panelDaftarKunjungan.add(lblJenisKelamin);
		
		JComboBox cmboJK = new JComboBox();
		cmboJK.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboJK.setBounds(259, 294, 101, 24);
		panelDaftarKunjungan.add(cmboJK);
		
		JLabel lblPangkat = new JLabel("Pangkat");
		lblPangkat.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblPangkat.setBounds(117, 340, 88, 20);
		panelDaftarKunjungan.add(lblPangkat);
		
		JComboBox cmboPangkat = new JComboBox();
		cmboPangkat.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboPangkat.setBounds(259, 340, 129, 24);
		panelDaftarKunjungan.add(cmboPangkat);
		
		JLabel lblStatusPersonil = new JLabel("Status Personil");
		lblStatusPersonil.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblStatusPersonil.setBounds(117, 382, 129, 14);
		panelDaftarKunjungan.add(lblStatusPersonil);
		
		JComboBox cmboSttsPersonil = new JComboBox();
		cmboSttsPersonil.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboSttsPersonil.setBounds(259, 382, 86, 24);
		panelDaftarKunjungan.add(cmboSttsPersonil);
		
		JLabel lblSatuan = new JLabel("Satuan");
		lblSatuan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblSatuan.setBounds(117, 419, 88, 14);
		panelDaftarKunjungan.add(lblSatuan);
		
		JComboBox cmboSatuan = new JComboBox();
		cmboSatuan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboSatuan.setBounds(259, 419, 143, 24);
		panelDaftarKunjungan.add(cmboSatuan);
		
		JLabel lblBagianYangDikunjungi = new JLabel("Bagian Yang dikunjungi");
		lblBagianYangDikunjungi.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblBagianYangDikunjungi.setBounds(117, 456, 119, 20);
		panelDaftarKunjungan.add(lblBagianYangDikunjungi);
		
		JComboBox cmboBagian = new JComboBox();
		cmboBagian.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboBagian.setBounds(259, 453, 101, 24);
		panelDaftarKunjungan.add(cmboBagian);
		
		JLabel lblDiagnosa = new JLabel("Diagnosa");
		lblDiagnosa.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblDiagnosa.setBounds(117, 495, 88, 20);
		panelDaftarKunjungan.add(lblDiagnosa);
		
		JTextArea txtDiagnosa = new JTextArea();
		txtDiagnosa.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtDiagnosa.setBounds(259, 490, 170, 48);
		panelDaftarKunjungan.add(txtDiagnosa);
		
		JLabel lblKeterangan = new JLabel("Keterangan");
		lblKeterangan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblKeterangan.setBounds(117, 559, 88, 17);
		panelDaftarKunjungan.add(lblKeterangan);
		
		textField = new JTextField();
		textField.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		textField.setBounds(259, 556, 129, 24);
		panelDaftarKunjungan.add(textField);
		textField.setColumns(10);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setBounds(634, 466, 103, 33);
		panelDaftarKunjungan.add(btnSimpan);
		btnSimpan.setIcon(new ImageIcon(panelDaftarPasien.class.getResource("/com/sipk/Image/Simpan.png")));
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.setBounds(747, 466, 103, 33);
		panelDaftarKunjungan.add(btnBatal);
		btnBatal.setIcon(new ImageIcon(panelDaftarPasien.class.getResource("/com/sipk/Image/Batal.png")));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(panelDaftarPasien.class.getResource("/com/sipk/Image/b-daftar.png")));
		lblNewLabel.setBounds(612, 130, 305, 266);
		panelDaftarKunjungan.add(lblNewLabel);

	}
}
