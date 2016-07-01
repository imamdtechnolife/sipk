package com.sipk;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JList;

public class panelRMRawatJalan extends JPanel {
	private JTextField txtNama;
	private JTextField txtUmur;
	private JTextField txtNoReg;
	private JTextField txtNoRm;
	private JComboBox cmboPoli;
	private JFormattedTextField txtTanggal;
	private JFormattedTextField txtJam;
	private JButton btnCari;
	private JTextArea txtTherapi;
	private JButton btnSimpan;
	private JButton btnBatal;
	Connection konek = null;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnCariIcd10;
	private JButton btnDiagnose;
	private JComboBox cmboMacamPenyakit;
	private JList listPenyakit;
	DefaultListModel listModel;

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
		scrollPane_1.setBounds(384, 245, 397, 124);
		panel.add(scrollPane_1);
		
		txtTherapi = new JTextArea();
		scrollPane_1.setViewportView(txtTherapi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 245, 277, 124);
		panel.add(scrollPane);
		
		listModel = new DefaultListModel();
		listPenyakit = new JList();
		listPenyakit.setModel(listModel);
		scrollPane.setViewportView(listPenyakit);
		
		
		JLabel lblAnamesePemeriksaan = new JLabel("Anamese & Pemeriksaan / Diagnose");
		lblAnamesePemeriksaan.setBounds(62, 213, 264, 29);
		panel.add(lblAnamesePemeriksaan);
		lblAnamesePemeriksaan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JLabel lblTherapi = new JLabel("Therapi");
		lblTherapi.setBounds(384, 220, 93, 14);
		panel.add(lblTherapi);
		lblTherapi.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		//TimeFormat formatJam = new SimpleTimeFormat();
		txtJam = new JFormattedTextField();
		txtJam.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtJam.setBounds(871, 108, 127, 29);
		panel.add(txtJam);
		membuatJam();
		
		JLabel lblJam = new JLabel("Jam");
		lblJam.setBounds(796, 108, 46, 29);
		panel.add(lblJam);
		lblJam.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JLabel lblTanggal_1 = new JLabel("Tanggal");
		lblTanggal_1.setBounds(796, 75, 69, 29);
		panel.add(lblTanggal_1);
		lblTanggal_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		DateFormat format = new SimpleDateFormat("yy-MM-dd");
		DateFormatter df = new DateFormatter(format); 
		txtTanggal = new JFormattedTextField(df);
		txtTanggal.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtTanggal.setBounds(871, 75, 157, 29);
		txtTanggal.setValue(new Date());
		panel.add(txtTanggal);
		
		cmboPoli = new JComboBox();
		cmboPoli.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboPoli.setBounds(137, 142, 171, 29);
		cmboPoli.addItem("-- Pilih Poli --");
		cmboPoli.addItem("Gigi");
		cmboPoli.addItem("Fisiotherapi");
		cmboPoli.addItem("THT");
		cmboPoli.addItem("BKIA");
		cmboPoli.addItem("Bedah");
		panel.add(cmboPoli);
		
		JLabel lblTanggal = new JLabel("Poli");
		lblTanggal.setBounds(62, 142, 46, 29);
		panel.add(lblTanggal);
		lblTanggal.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		btnCari = new JButton("Cari");
		btnCari.setBounds(700, 109, 51, 23);
		panel.add(btnCari);
		
		txtNoRm = new JTextField();
		txtNoRm.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoRm.setBounds(541, 105, 149, 29);
		panel.add(txtNoRm);
		txtNoRm.setColumns(10);
		
		txtNoReg = new JTextField();
		txtNoReg.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoReg.setBounds(541, 75, 149, 29);
		panel.add(txtNoReg);
		txtNoReg.setColumns(10);
		
		JLabel lblNoReg = new JLabel("No. Reg");
		lblNoReg.setBounds(440, 73, 74, 31);
		panel.add(lblNoReg);
		lblNoReg.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JLabel lblNoRm = new JLabel("No. RM");
		lblNoRm.setBounds(440, 112, 80, 22);
		panel.add(lblNoRm);
		lblNoRm.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		txtUmur = new JTextField();
		txtUmur.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtUmur.setBounds(137, 105, 46, 29);
		panel.add(txtUmur);
		txtUmur.setColumns(10);
		
		JLabel lblUmur = new JLabel("Umur");
		lblUmur.setBounds(62, 105, 46, 29);
		panel.add(lblUmur);
		lblUmur.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(62, 73, 46, 31);
		panel.add(lblNama);
		lblNama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		txtNama = new JTextField();
		txtNama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNama.setBounds(137, 75, 259, 29);
		panel.add(txtNama);
		txtNama.setColumns(10);
		
		JLabel lblRekamMedisRawat = new JLabel("Rekam Medis Pasien Rawat Jalan");
		lblRekamMedisRawat.setBounds(25, 11, 465, 33);
		panel.add(lblRekamMedisRawat);
		lblRekamMedisRawat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		
		btnSimpan = new JButton("Simpan");
		btnSimpan.setIcon(new ImageIcon(panelRMRawatJalan.class.getResource("/com/sipk/Image/Simpan.png")));
		btnSimpan.setBounds(810, 273, 104, 39);
		panel.add(btnSimpan);
		
		btnBatal = new JButton("Batal");
		btnBatal.setIcon(new ImageIcon(panelRMRawatJalan.class.getResource("/com/sipk/Image/Batal.png")));
		btnBatal.setBounds(810, 315, 104, 39);
		panel.add(btnBatal);
		
		btnDiagnose = new JButton("Diagnose");
		btnDiagnose.setIcon(new ImageIcon(panelRMRawatJalan.class.getResource("/com/sipk/Image/oke.png")));
		btnDiagnose.setBounds(566, 383, 112, 26);
		panel.add(btnDiagnose);
		
		cmboMacamPenyakit = new JComboBox();
		cmboMacamPenyakit.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		cmboMacamPenyakit.setBounds(72, 380, 471, 29);
		panel.add(cmboMacamPenyakit);
		ambilDataMacamPenyakit();
		
		textField = new JTextField();
		textField.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		textField.setBounds(166, 430, 173, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(166, 470, 86, 29);
		panel.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("No. ICD 10");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNewLabel.setBounds(62, 433, 94, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNoDtd = new JLabel("No. DTD");
		lblNoDtd.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoDtd.setBounds(62, 473, 69, 14);
		panel.add(lblNoDtd);
		
		btnCariIcd10 = new JButton("Cari");
		btnCariIcd10.setIcon(new ImageIcon(panelRMRawatJalan.class.getResource("/com/sipk/Image/Cari.png")));
		btnCariIcd10.setBounds(358, 442, 80, 45);
		panel.add(btnCariIcd10);
		
		penghendel hendel = new penghendel();
		btnCari.addActionListener(hendel);
		btnDiagnose.addActionListener(hendel);
		btnCariIcd10.addActionListener(hendel);
		btnSimpan.addActionListener(hendel);
		btnBatal.addActionListener(hendel);
		
	}
	
	public void membuatJam()
	{
		String nol_jam = "";
		String nol_menit = "";
		String nol_detik = "";
		
		Date date = new Date();
		int j = date.getHours();
		int m = date.getMinutes();
		int d = date.getSeconds();
		
		if(j<=9)
		{
			nol_jam = "0";
		}
		if(m<=9)
		{
			nol_menit = "0";
		}
		if(d<=9)
		{
			nol_detik = "0";
		}
		
		
		String jam =  nol_jam + Integer.toString(j);
		String menit = nol_menit + Integer.toString(m);
		String detik = nol_detik + Integer.toString(d);
		
		String timer = jam+":"+menit+":"+detik;
		txtJam.setText(timer);
	}
	
	private void ambilDataMacamPenyakit() 
	{
		
		String macamPenyakit = "";
		try
		{
		konek = konek_database.getKonekDB();
		Statement state = konek.createStatement();
		ResultSet result = state.executeQuery("select macam_penyakit from macam_penyakit");
		
			while(result.next())
			{
				String daftarPenyakit = result.getString(1);
				
				cmboMacamPenyakit.addItem(daftarPenyakit);
			}
			
			
			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada metode ambildatamacampenyakit : "+ex.getMessage());
		}
		finally
		{
			
		}
	}
	
	public void ambilDataPasien()
	{
		
		String nama = "";
		int umur = 0;
		String no_reg = "";
		try
		{
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select nama,umur,no_reg from pasien where no_rm like  '%"+txtNoRm.getText()+"%'");
			
			
			
			if(result.next())
			{
				nama = result.getString(1);
				 umur = result.getInt(2);
				 no_reg = result.getString(3);
				 
			}
			
			txtNama.setText(nama);
			txtUmur.setText(""+umur);
			txtNoReg.setText(no_reg);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada metode ambil pasien : "+ex.getMessage());
		}
		finally
		{
			
		}
	}
	
	public void simpanDiagnose()
	{
		
			  listModel.addElement(" - "+cmboMacamPenyakit.getSelectedItem());
		
	}
	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnCari)
			{
				ambilDataPasien();
			}
			else if(e.getSource()==btnSimpan)
			{
				
			}
			else if(e.getSource()==btnBatal)
			{
				
			}
			else if(e.getSource()==btnCariIcd10)
			{
				
			}
			else if(e.getSource()==btnDiagnose)
			{
				simpanDiagnose();
			}
				
		}
	}
}
