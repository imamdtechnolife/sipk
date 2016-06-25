package com.sipk;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class panelPemeriksaan extends JPanel {
	private JTextField txtNama;
	private JTextField txtUmur;
	private JTextField txtDiagnosaSekunder1;
	private JTextField txtDiagnosaSekunder2;
	private JTextField txtDiagnosaSekunder3;
	private JTextField txtProsedur1;
	private JTextField txtProsedur2;
	private JTextField txtProsedur3;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField txtRiwayat;
	private JTextField txtPemeriksaanFisik;
	private JTextField txtIdDokter;
	private JTextField txtNamaDokter;
	private JTextField txtNoTelpDokter;

	/**
	 * Create the panel.
	 */
	public panelPemeriksaan() {
		setLayout(new GridLayout(0,1));	
		setVisible(true);
		
		JTabbedPane tabDokter = new JTabbedPane(JTabbedPane.TOP);
		tabDokter.setBounds(0, 0, 1058, 750);
		add(tabDokter);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JPanel panelDaftarDokter = new JPanel();
		
		JLabel lblResumeRawatJalan = new JLabel("Resume Rawat Jalan");
		lblResumeRawatJalan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblResumeRawatJalan.setBounds(25, 11, 325, 33);
		panel.add(lblResumeRawatJalan);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(50, 78, 84, 14);
		panel.add(lblNama);
		
		JLabel lblUmur = new JLabel("Umur");
		lblUmur.setBounds(50, 103, 84, 14);
		panel.add(lblUmur);
		
		JLabel lblJenisKelamin = new JLabel("Jenis Kelamin");
		lblJenisKelamin.setBounds(50, 128, 84, 14);
		panel.add(lblJenisKelamin);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setBounds(50, 153, 84, 14);
		panel.add(lblAlamat);
		
		JLabel lblPangkat = new JLabel("Pangkat");
		lblPangkat.setBounds(50, 200, 84, 14);
		panel.add(lblPangkat);
		
		JLabel lblNoRm = new JLabel("No. RM");
		lblNoRm.setBounds(400, 78, 84, 14);
		panel.add(lblNoRm);
		
		JLabel lblRuangan = new JLabel("Ruangan");
		lblRuangan.setBounds(400, 103, 84, 14);
		panel.add(lblRuangan);
		
		JLabel lblTglMasuk = new JLabel("Tgl. Masuk");
		lblTglMasuk.setBounds(400, 128, 62, 14);
		panel.add(lblTglMasuk);
		
		JLabel lblKeluar = new JLabel("Tgl. Keluar");
		lblKeluar.setBounds(400, 153, 84, 14);
		panel.add(lblKeluar);
		
		JLabel lblDokter = new JLabel("Dokter");
		lblDokter.setBounds(400, 181, 84, 14);
		panel.add(lblDokter);
		
		JLabel lblDiagnosaPrimer = new JLabel("Diagnosa Primer");
		lblDiagnosaPrimer.setBounds(50, 248, 84, 14);
		panel.add(lblDiagnosaPrimer);
		
		JLabel lblDiagnosaSekunder = new JLabel("Diagnosa Sekunder :");
		lblDiagnosaSekunder.setBounds(50, 306, 117, 14);
		panel.add(lblDiagnosaSekunder);
		
		JLabel label = new JLabel("1.");
		label.setBounds(181, 306, 18, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setBounds(181, 331, 18, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setBounds(181, 356, 18, 14);
		panel.add(label_2);
		
		JLabel lblProsedur = new JLabel("Prosedur :");
		lblProsedur.setBounds(50, 381, 78, 14);
		panel.add(lblProsedur);
		
		JLabel label_3 = new JLabel("1.");
		label_3.setBounds(135, 401, 18, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("2.");
		label_4.setBounds(135, 426, 18, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("3.");
		label_5.setBounds(135, 451, 18, 14);
		panel.add(label_5);
		
		JLabel lblRingkasanRiwayatPenemuan = new JLabel("Ringkasan riwayat penemuan fisik penting :");
		lblRingkasanRiwayatPenemuan.setBounds(401, 251, 223, 14);
		panel.add(lblRingkasanRiwayatPenemuan);
		
		JLabel lblRiwayatAnamneses = new JLabel("Riwayat ( anamneses ) :");
		lblRiwayatAnamneses.setBounds(427, 276, 123, 14);
		panel.add(lblRiwayatAnamneses);
		
		JLabel lblPemeriksaanFisik = new JLabel("Pemeriksaan Fisik :");
		lblPemeriksaanFisik.setBounds(427, 309, 91, 14);
		panel.add(lblPemeriksaanFisik);
		
		JLabel lblHasilHasil = new JLabel("Hasil - hasil laboratorium, rontegen dan konsultasi (yang penting) :");
		lblHasilHasil.setBounds(401, 350, 325, 14);
		panel.add(lblHasilHasil);
		
		JLabel lblPerkembanganSelamaPerawatan = new JLabel("Perkembangan selama perawatan / dengan komplikasi (jika ada) :");
		lblPerkembanganSelamaPerawatan.setBounds(401, 388, 325, 14);
		panel.add(lblPerkembanganSelamaPerawatan);
		
		JLabel lblKeadaanPasienPengobatan = new JLabel("Keadaan pasien, pengobatan, kesimpulan pada saat keluar dari rumah sakit dan diagnose :");
		lblKeadaanPasienPengobatan.setBounds(401, 428, 443, 14);
		panel.add(lblKeadaanPasienPengobatan);
		
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setViewportView(panel);
		
		txtNama = new JTextField();
		txtNama.setBounds(135, 75, 151, 20);
		panel.add(txtNama);
		txtNama.setColumns(10);
		
		txtUmur = new JTextField();
		txtUmur.setColumns(10);
		txtUmur.setBounds(135, 100, 40, 20);
		panel.add(txtUmur);
		
		JComboBox cmbJK = new JComboBox();
		cmbJK.setBounds(135, 125, 90, 20);
		cmbJK.addItem("Laki-laki");
		cmbJK.addItem("Perempuan");
		panel.add(cmbJK);
		
		JTextArea txtAlamat = new JTextArea();
		txtAlamat.setBounds(135, 148, 187, 47);
		panel.add(txtAlamat);
		
		JComboBox cmbPangkat = new JComboBox();
		cmbPangkat.setBounds(135, 197, 90, 20);
		cmbPangkat.addItem("Briptu");
		cmbPangkat.addItem("Bripda");
		panel.add(cmbPangkat);
		
		JTextArea txtDiagnosaPrimer = new JTextArea();
		txtDiagnosaPrimer.setBounds(135, 248, 218, 47);
		panel.add(txtDiagnosaPrimer);
		
		txtDiagnosaSekunder1 = new JTextField();
		txtDiagnosaSekunder1.setBounds(200, 303, 86, 20);
		panel.add(txtDiagnosaSekunder1);
		txtDiagnosaSekunder1.setColumns(10);
		
		txtDiagnosaSekunder2 = new JTextField();
		txtDiagnosaSekunder2.setColumns(10);
		txtDiagnosaSekunder2.setBounds(200, 328, 86, 20);
		panel.add(txtDiagnosaSekunder2);
		
		txtDiagnosaSekunder3 = new JTextField();
		txtDiagnosaSekunder3.setColumns(10);
		txtDiagnosaSekunder3.setBounds(200, 353, 86, 20);
		panel.add(txtDiagnosaSekunder3);
		
		txtProsedur1 = new JTextField();
		txtProsedur1.setBounds(156, 398, 86, 20);
		panel.add(txtProsedur1);
		txtProsedur1.setColumns(10);
		
		txtProsedur2 = new JTextField();
		txtProsedur2.setColumns(10);
		txtProsedur2.setBounds(156, 423, 86, 20);
		panel.add(txtProsedur2);
		
		txtProsedur3 = new JTextField();
		txtProsedur3.setColumns(10);
		txtProsedur3.setBounds(156, 448, 86, 20);
		panel.add(txtProsedur3);
		
		textField_8 = new JTextField();
		textField_8.setBounds(470, 75, 151, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(470, 100, 151, 20);
		comboBox_2.addItem("Ruang Nusa Indah");
		comboBox_2.addItem("Ruang Bougenvil");
		comboBox_2.addItem("Ruang Angsoka");
		comboBox_2.addItem("Ruang Cempaka");
		panel.add(comboBox_2);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(470, 125, 103, 20);
		panel.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(470, 150, 103, 20);
		panel.add(formattedTextField_1);
		
		textField_9 = new JTextField();
		textField_9.setBounds(470, 178, 151, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JTextArea txtHasilLab = new JTextArea();
		txtHasilLab.setBounds(401, 366, 325, 22);
		panel.add(txtHasilLab);
		
		JTextArea txtPerkembangan = new JTextArea();
		txtPerkembangan.setBounds(401, 406, 325, 22);
		panel.add(txtPerkembangan);
		
		JTextArea txtKeadaan = new JTextArea();
		txtKeadaan.setBounds(401, 446, 325, 22);
		panel.add(txtKeadaan);
		
		txtRiwayat = new JTextField();
		txtRiwayat.setBounds(551, 276, 86, 20);
		panel.add(txtRiwayat);
		txtRiwayat.setColumns(10);
		
		txtPemeriksaanFisik = new JTextField();
		txtPemeriksaanFisik.setBounds(532, 306, 86, 20);
		panel.add(txtPemeriksaanFisik);
		txtPemeriksaanFisik.setColumns(10);
		
		JButton btnCari = new JButton("Cari");
		btnCari.setBounds(629, 74, 51, 23);
		panel.add(btnCari);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setIcon(new ImageIcon(panelPemeriksaan.class.getResource("/com/sipk/Image/Simpan.png")));
		btnSimpan.setBounds(498, 554, 103, 42);
		panel.add(btnSimpan);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.setIcon(new ImageIcon(panelPemeriksaan.class.getResource("/com/sipk/Image/Batal.png")));
		btnBatal.setBounds(625, 554, 103, 42);
		panel.add(btnBatal);
		
		JLabel label_6 = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		label_6.setBounds(10, 223, 1031, 14);
		panel.add(label_6);
		tabDokter.addTab("Resume Rawat Jalan", null, scrollPanel, null);
		tabDokter.addTab("Daftar Dokter", null, panelDaftarDokter, null);
		panelDaftarDokter.setLayout(null);
		
		JLabel lblDaftarDokter = new JLabel("Daftar Dokter");
		lblDaftarDokter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblDaftarDokter.setBounds(25, 11, 244, 32);
		panelDaftarDokter.add(lblDaftarDokter);
		
		JLabel lblIdDokter = new JLabel("ID Dokter");
		lblIdDokter.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblIdDokter.setBounds(48, 68, 101, 14);
		panelDaftarDokter.add(lblIdDokter);
		
		JLabel lblNamaDokter = new JLabel("Nama beserta gelar");
		lblNamaDokter.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNamaDokter.setBounds(48, 104, 150, 14);
		panelDaftarDokter.add(lblNamaDokter);
		
		JLabel lblNoTelp = new JLabel("No. Telp / Hp");
		lblNoTelp.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoTelp.setBounds(48, 149, 113, 14);
		panelDaftarDokter.add(lblNoTelp);
		
		JLabel lblAlamat_1 = new JLabel("Alamat");
		lblAlamat_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAlamat_1.setBounds(48, 199, 78, 14);
		panelDaftarDokter.add(lblAlamat_1);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblStatus.setBounds(48, 268, 66, 14);
		panelDaftarDokter.add(lblStatus);
		
		JLabel lblSpesialis = new JLabel("Spesialis");
		lblSpesialis.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblSpesialis.setBounds(48, 316, 113, 14);
		panelDaftarDokter.add(lblSpesialis);
		
		txtIdDokter = new JTextField();
		txtIdDokter.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtIdDokter.setBounds(212, 62, 86, 25);
		panelDaftarDokter.add(txtIdDokter);
		txtIdDokter.setColumns(10);
		
		txtNamaDokter = new JTextField();
		txtNamaDokter.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNamaDokter.setColumns(10);
		txtNamaDokter.setBounds(212, 98, 217, 25);
		panelDaftarDokter.add(txtNamaDokter);
		
		txtNoTelpDokter = new JTextField();
		txtNoTelpDokter.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoTelpDokter.setColumns(10);
		txtNoTelpDokter.setBounds(212, 143, 120, 25);
		panelDaftarDokter.add(txtNoTelpDokter);
		
		JComboBox cmboStatusDokter = new JComboBox();
		cmboStatusDokter.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboStatusDokter.setBounds(212, 262, 66, 25);
		panelDaftarDokter.add(cmboStatusDokter);
		
		JComboBox cmboSpesialisDokter = new JComboBox();
		cmboSpesialisDokter.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboSpesialisDokter.setBounds(212, 310, 148, 25);
		panelDaftarDokter.add(cmboSpesialisDokter);
		
		JButton btnSimpan_1 = new JButton("Simpan");
		btnSimpan_1.setIcon(new ImageIcon(panelPemeriksaan.class.getResource("/com/sipk/Image/Simpan.png")));
		btnSimpan_1.setBounds(499, 402, 101, 32);
		panelDaftarDokter.add(btnSimpan_1);
		
		JButton btnBatal_1 = new JButton("Batal");
		btnBatal_1.setIcon(new ImageIcon(panelPemeriksaan.class.getResource("/com/sipk/Image/Batal.png")));
		btnBatal_1.setBounds(610, 402, 101, 32);
		panelDaftarDokter.add(btnBatal_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(panelPemeriksaan.class.getResource("/com/sipk/Image/b-dokter.png")));
		lblNewLabel.setBounds(475, 62, 244, 345);
		panelDaftarDokter.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(212, 194, 217, 53);
		panelDaftarDokter.add(scrollPane);
		
		JTextArea txtAlamatDokter = new JTextArea();
		txtAlamatDokter.setLocation(212, 0);
		scrollPane.setViewportView(txtAlamatDokter);
		txtAlamatDokter.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

	}
}
