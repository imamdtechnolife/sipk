package com.sipk;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;

public class panelBiayaRJ extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtPoliUmum;
	private JTextField txtIGD;
	private JTextField txtPoliGigi;
	private JTextField txtBKIA;
	private JTextField txtTKD;
	private JTextField txtFisioTerapi;
	private JTextField txtPeriksaDokter;
	private JTextField txtLab;
	private JTextField txtRadiologi;
	private JTextField txtUSG;
	private JTextField txtEKG;
	private JTextField txtBiayaObat;
	private JTextField txtAmbulan_dll;
	

	/**
	 * Create the panel.
	 */
	
	
	public panelBiayaRJ() {
		
		setLayout(new GridLayout(0,1));
		setVisible(true);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		
		JPanel panelBiayaRJ = new JPanel();
		panelBiayaRJ.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Biaya Rawat Jalan");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setBounds(28, 11, 391, 31);
		panelBiayaRJ.add(lblNewLabel);
		
		JLabel lblNamaPasien = new JLabel("Nama Pasien");
		lblNamaPasien.setBounds(74, 89, 91, 14);
		panelBiayaRJ.add(lblNamaPasien);
		
		JLabel lblUmur = new JLabel("Umur");
		lblUmur.setBounds(74, 124, 91, 14);
		panelBiayaRJ.add(lblUmur);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setBounds(74, 163, 91, 14);
		panelBiayaRJ.add(lblAlamat);
		
		JLabel lblNoRm = new JLabel("No. RM");
		lblNoRm.setBounds(459, 89, 91, 14);
		panelBiayaRJ.add(lblNoRm);
		
		JLabel lblPoliTujuan = new JLabel("Poli Tujuan");
		lblPoliTujuan.setBounds(459, 124, 91, 14);
		panelBiayaRJ.add(lblPoliTujuan);
		
		JLabel lblTglBerobat = new JLabel("Tgl. Berobat");
		lblTglBerobat.setBounds(459, 163, 91, 14);
		panelBiayaRJ.add(lblTglBerobat);
		
		textField = new JTextField();
		textField.setBounds(155, 86, 264, 20);
		panelBiayaRJ.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(165, 124, 28, 20);
		panelBiayaRJ.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(155, 158, 264, 59);
		panelBiayaRJ.add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(542, 86, 86, 20);
		panelBiayaRJ.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(542, 121, 28, 20);
		panelBiayaRJ.add(comboBox_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Jenis Pembayaran", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(84, 255, 439, 430);
		panelBiayaRJ.add(panel);
		panel.setLayout(null);
		
		JLabel lblBiayaKarcis = new JLabel("1. Biaya Karcis Rawat Jalan");
		lblBiayaKarcis.setBounds(34, 37, 171, 14);
		panel.add(lblBiayaKarcis);
		
		JLabel lblAPoliUmum = new JLabel("a. Poli Umum");
		lblAPoliUmum.setBounds(44, 62, 171, 14);
		panel.add(lblAPoliUmum);
		
		JLabel lblBIgd = new JLabel("b. IGD");
		lblBIgd.setBounds(44, 98, 171, 14);
		panel.add(lblBIgd);
		
		JLabel lblCPoliGigi = new JLabel("c. Poli Gigi");
		lblCPoliGigi.setBounds(44, 133, 171, 14);
		panel.add(lblCPoliGigi);
		
		JLabel lblDBkia = new JLabel("d. BKIA");
		lblDBkia.setBounds(44, 168, 171, 14);
		panel.add(lblDBkia);
		
		JLabel lblESkd = new JLabel("e. SKD");
		lblESkd.setBounds(44, 205, 171, 14);
		panel.add(lblESkd);
		
		JLabel lblFFisioterapi = new JLabel("f. Fisioterapi");
		lblFFisioterapi.setBounds(44, 243, 171, 14);
		panel.add(lblFFisioterapi);
		
		JLabel lblBiayaTindakan = new JLabel("2. Biaya Tindakan");
		lblBiayaTindakan.setBounds(34, 301, 171, 14);
		panel.add(lblBiayaTindakan);
		
		JLabel lblPemerikasaanDokter = new JLabel("Pemerikasaan Dokter");
		lblPemerikasaanDokter.setBounds(44, 326, 171, 14);
		panel.add(lblPemerikasaanDokter);
		
		txtPoliUmum = new JTextField();
		txtPoliUmum.setBounds(225, 59, 159, 20);
		panel.add(txtPoliUmum);
		txtPoliUmum.setColumns(10);
		
		txtIGD = new JTextField();
		txtIGD.setColumns(10);
		txtIGD.setBounds(225, 95, 159, 20);
		panel.add(txtIGD);
		
		txtPoliGigi = new JTextField();
		txtPoliGigi.setColumns(10);
		txtPoliGigi.setBounds(225, 130, 159, 20);
		panel.add(txtPoliGigi);
		
		txtBKIA = new JTextField();
		txtBKIA.setColumns(10);
		txtBKIA.setBounds(225, 165, 159, 20);
		panel.add(txtBKIA);
		
		txtTKD = new JTextField();
		txtTKD.setColumns(10);
		txtTKD.setBounds(225, 202, 159, 20);
		panel.add(txtTKD);
		
		txtFisioTerapi = new JTextField();
		txtFisioTerapi.setColumns(10);
		txtFisioTerapi.setBounds(225, 240, 159, 20);
		panel.add(txtFisioTerapi);
		
		txtPeriksaDokter = new JTextField();
		txtPeriksaDokter.setColumns(10);
		txtPeriksaDokter.setBounds(225, 323, 159, 20);
		panel.add(txtPeriksaDokter);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Jenis Pembayaran", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(542, 255, 439, 430);
		panelBiayaRJ.add(panel_1);
		
		JLabel lblBiayaPemerikasaan = new JLabel("3. Biaya Pemerikasaan Penunjang");
		lblBiayaPemerikasaan.setBounds(34, 37, 171, 14);
		panel_1.add(lblBiayaPemerikasaan);
		
		JLabel lblALab = new JLabel("a. LAB");
		lblALab.setBounds(44, 62, 171, 14);
		panel_1.add(lblALab);
		
		JLabel lblBRadiologi = new JLabel("b. Radiologi");
		lblBRadiologi.setBounds(44, 98, 171, 14);
		panel_1.add(lblBRadiologi);
		
		JLabel lblUsg = new JLabel("c. USG");
		lblUsg.setBounds(44, 133, 171, 14);
		panel_1.add(lblUsg);
		
		JLabel lblDEkg = new JLabel("d. EKG");
		lblDEkg.setBounds(44, 170, 171, 14);
		panel_1.add(lblDEkg);
		
		JLabel lblBiayaObatobatApotik = new JLabel("4. Biaya Obat-obat apotik");
		lblBiayaObatobatApotik.setBounds(34, 221, 171, 14);
		panel_1.add(lblBiayaObatobatApotik);
		
		JLabel lblAmbulan = new JLabel("5. Ambulan / Lain-lain");
		lblAmbulan.setBounds(34, 264, 171, 14);
		panel_1.add(lblAmbulan);
		
		txtLab = new JTextField();
		txtLab.setColumns(10);
		txtLab.setBounds(197, 59, 159, 20);
		panel_1.add(txtLab);
		
		txtRadiologi = new JTextField();
		txtRadiologi.setColumns(10);
		txtRadiologi.setBounds(197, 95, 159, 20);
		panel_1.add(txtRadiologi);
		
		txtUSG = new JTextField();
		txtUSG.setColumns(10);
		txtUSG.setBounds(197, 130, 159, 20);
		panel_1.add(txtUSG);
		
		txtEKG = new JTextField();
		txtEKG.setColumns(10);
		txtEKG.setBounds(197, 167, 159, 20);
		panel_1.add(txtEKG);
		
		txtBiayaObat = new JTextField();
		txtBiayaObat.setColumns(10);
		txtBiayaObat.setBounds(197, 218, 159, 20);
		panel_1.add(txtBiayaObat);
		
		txtAmbulan_dll = new JTextField();
		txtAmbulan_dll.setColumns(10);
		txtAmbulan_dll.setBounds(197, 261, 159, 20);
		panel_1.add(txtAmbulan_dll);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setBounds(197, 364, 89, 23);
		panel_1.add(btnSimpan);
		
		JButton btnCetak = new JButton("Cetak");
		btnCetak.setBounds(301, 364, 89, 23);
		panel_1.add(btnCetak);
		
		
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setViewportView(panelBiayaRJ);
		
		DateFormat formatTanggal = new SimpleDateFormat("dd/MM/yy");
		DateFormatter df = new DateFormatter(formatTanggal);
		JFormattedTextField formattedTextField = new JFormattedTextField(df);
		formattedTextField.setBounds(542, 160, 86, 20);
		formattedTextField.setValue(new Date());
		
		panelBiayaRJ.add(formattedTextField);
		tabbedPane.addTab("Biaya Rawat Jalan", null, scrollPanel, null);
		
		
		JPanel panelBiayaRI = new JPanel();
		tabbedPane.addTab("Biaya Rawat Inap", null, panelBiayaRI, null);
		panelBiayaRI.setLayout(null);
		
		JPanel panelBiayaB = new JPanel();
		tabbedPane.addTab("Biaya Bersalin", null, panelBiayaB, null);
		panelBiayaB.setLayout(null);
		
		
		add(tabbedPane);
		

	}
}
