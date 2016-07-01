package com.sipk;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import org.freixas.jcalendar.JCalendarCombo;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;

public class panelPasien extends JPanel {
	private JTextField txtNoRM;
	private JTextField txtNoReg;
	private JTextField txtNama;
	private JTextField txtTempatLahir;
	private JTextField txtAgama;
	private JTextField txtSuku;
	private JTextField txtPendidikan;
	private JTextField txtPekerjaan;
	private JTextField txtKelurahan;
	private JTextField txtKecamatan;
	private JTextField txtKabupaten;
	private JTextField txtTelepon;
	private JTextField txtNoKtpsim;
	private JTextField txtAnakke;
	private JTextField txtUmur;
	private JTextField txtNoBpjs;
	private JTextField txtNoRujukan;
	Connection konek = null;
	private JFormattedTextField txtTanggal;
	private JTextArea txtAlamat;
	private JComboBox cmboStatusNikah;
	private JComboBox cmboGolDarah;
	private JButton btnSimpan;
	private JButton btnBatal;
	private JCalendarCombo tanggal; 
	private JCalendarCombo cmboTanggal;
	private JTable table;
	private JTextField textField;
	private DefaultTableModel modelTabelPasien = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No. RM", "No. Reg", "Nama", "Tempat Lahir", "Tanggal Lahir", "Status Nikah", "Agama", "Suku", "Pendidikan", "Pekerjaan", "Alamat", "Kelurahan", "Kecamatan", "Kabupaten", "No. Telpon", "No. KTP / SIM", "Anak-ke", "Umur", "Golongan Darah", "No. BPJS", "No. Rujukan"
			}
		);

	/**
	 * Create the panel.
	 */
	public panelPasien() {
		setLayout(new GridLayout(0,1));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1135, 638);
		add(tabbedPane);
		JPanel panelTabelPasien = new JPanel();
		tabbedPane.addTab("Tabel Rekam Medis Pasien", null, panelTabelPasien, null);
		panelTabelPasien.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 115, 1340, 484);
		panelTabelPasien.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No. RM", "No. Reg", "Nama", "Tempat Lahir", "Tanggal Lahir", "Status Nikah", "Agama", "Suku", "Pendidikan", "Pekerjaan", "Alamat", "Kelurahan", "Kecamatan", "Kabupaten", "No. Telpon", "No. KTP / SIM", "Anak-ke", "Umur", "Golongan Darah", "No. BPJS", "No. Rujukan"
			}
		));
		table.getColumnModel().getColumn(15).setPreferredWidth(123);
		table.getColumnModel().getColumn(18).setPreferredWidth(96);
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Tabel Identitas Utama Pasien");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setBounds(10, 11, 423, 33);
		panelTabelPasien.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(39, 84, 86, 20);
		panelTabelPasien.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cari");
		btnNewButton.setBounds(143, 83, 59, 23);
		panelTabelPasien.add(btnNewButton);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Daftar Rekam Medis Pasien", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblDaftarRekamMedis = new JLabel("Daftar Rekam Medis Pasien");
		lblDaftarRekamMedis.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblDaftarRekamMedis.setBounds(25, 11, 401, 43);
		panel.add(lblDaftarRekamMedis);
		
		JLabel lblNoRm = new JLabel("No. RM");
		lblNoRm.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoRm.setBounds(48, 84, 70, 32);
		panel.add(lblNoRm);
		
		JLabel lblNoReg = new JLabel("No. Reg");
		lblNoReg.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoReg.setBounds(48, 127, 85, 23);
		panel.add(lblNoReg);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNama.setBounds(48, 164, 46, 23);
		panel.add(lblNama);
		
		JLabel lblTempatLahir = new JLabel("Tempat Lahir");
		lblTempatLahir.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblTempatLahir.setBounds(48, 198, 126, 28);
		panel.add(lblTempatLahir);
		
		JLabel lblTanggalLahir = new JLabel("Tanggal Lahir");
		lblTanggalLahir.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblTanggalLahir.setBounds(48, 237, 112, 29);
		panel.add(lblTanggalLahir);
		
		JLabel lblStatusNikah = new JLabel("Status Nikah");
		lblStatusNikah.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblStatusNikah.setBounds(48, 277, 126, 24);
		panel.add(lblStatusNikah);
		
		JLabel lblAgama = new JLabel("Agama");
		lblAgama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAgama.setBounds(48, 312, 126, 25);
		panel.add(lblAgama);
		
		JLabel lblSuku = new JLabel("Suku");
		lblSuku.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblSuku.setBounds(48, 348, 126, 23);
		panel.add(lblSuku);
		
		JLabel lblPendidikan = new JLabel("Pendidikan");
		lblPendidikan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblPendidikan.setBounds(375, 84, 85, 32);
		panel.add(lblPendidikan);
		
		JLabel lblPekerjaan = new JLabel("Pekerjaan");
		lblPekerjaan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblPekerjaan.setBounds(375, 127, 126, 26);
		panel.add(lblPekerjaan);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAlamat.setBounds(375, 164, 85, 23);
		panel.add(lblAlamat);
		
		JLabel lblKelurahan = new JLabel("Kelurahan");
		lblKelurahan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblKelurahan.setBounds(385, 268, 102, 28);
		panel.add(lblKelurahan);
		
		JLabel lblKecamatan = new JLabel("Kecamatan");
		lblKecamatan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblKecamatan.setBounds(385, 307, 102, 29);
		panel.add(lblKecamatan);
		
		JLabel lblKabupaten = new JLabel("Kabupaten");
		lblKabupaten.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblKabupaten.setBounds(385, 347, 85, 24);
		panel.add(lblKabupaten);
		
		JLabel lblNoTelp = new JLabel("Telepon");
		lblNoTelp.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoTelp.setBounds(758, 84, 94, 32);
		panel.add(lblNoTelp);
		
		JLabel lblNoKtp = new JLabel("No. KTP / SIM");
		lblNoKtp.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoKtp.setBounds(758, 120, 112, 33);
		panel.add(lblNoKtp);
		
		JLabel lblAnakKe = new JLabel("Anak Ke");
		lblAnakKe.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAnakKe.setBounds(758, 164, 85, 23);
		panel.add(lblAnakKe);
		
		JLabel lblUmur = new JLabel("Umur");
		lblUmur.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblUmur.setBounds(758, 198, 46, 28);
		panel.add(lblUmur);
		
		JLabel lblGolDarah = new JLabel("Gol. Darah");
		lblGolDarah.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblGolDarah.setBounds(758, 237, 94, 29);
		panel.add(lblGolDarah);
		
		JLabel lblNoBpjs = new JLabel("No. BPJS");
		lblNoBpjs.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoBpjs.setBounds(758, 277, 94, 24);
		panel.add(lblNoBpjs);
		
		JLabel lblNoRujukan = new JLabel("No. Rujukan");
		lblNoRujukan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoRujukan.setBounds(758, 312, 94, 25);
		panel.add(lblNoRujukan);
		
		txtNoRM = new JTextField();
		txtNoRM.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoRM.setBounds(169, 87, 86, 29);
		panel.add(txtNoRM);
		txtNoRM.setColumns(10);
		
		txtNoReg = new JTextField();
		txtNoReg.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoReg.setColumns(10);
		txtNoReg.setBounds(169, 125, 138, 29);
		panel.add(txtNoReg);
		
		txtNama = new JTextField();
		txtNama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNama.setColumns(10);
		txtNama.setBounds(169, 162, 176, 29);
		panel.add(txtNama);
		
		txtTempatLahir = new JTextField();
		txtTempatLahir.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtTempatLahir.setColumns(10);
		txtTempatLahir.setBounds(169, 199, 148, 29);
		panel.add(txtTempatLahir);
		
		txtAgama = new JTextField();
		txtAgama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtAgama.setColumns(10);
		txtAgama.setBounds(169, 315, 101, 29);
		panel.add(txtAgama);
		
		txtSuku = new JTextField();
		txtSuku.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtSuku.setColumns(10);
		txtSuku.setBounds(169, 350, 101, 29);
		panel.add(txtSuku);
		
		txtPendidikan = new JTextField();
		txtPendidikan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtPendidikan.setColumns(10);
		txtPendidikan.setBounds(478, 91, 86, 29);
		panel.add(txtPendidikan);
		
		txtPekerjaan = new JTextField();
		txtPekerjaan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtPekerjaan.setColumns(10);
		txtPekerjaan.setBounds(478, 129, 216, 29);
		panel.add(txtPekerjaan);
		
		txtKelurahan = new JTextField();
		txtKelurahan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtKelurahan.setColumns(10);
		txtKelurahan.setBounds(478, 273, 216, 29);
		panel.add(txtKelurahan);
		
		txtKecamatan = new JTextField();
		txtKecamatan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtKecamatan.setColumns(10);
		txtKecamatan.setBounds(478, 312, 216, 29);
		panel.add(txtKecamatan);
		
		txtKabupaten = new JTextField();
		txtKabupaten.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtKabupaten.setColumns(10);
		txtKabupaten.setBounds(478, 350, 216, 29);
		panel.add(txtKabupaten);
		
		txtTelepon = new JTextField();
		txtTelepon.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtTelepon.setColumns(10);
		txtTelepon.setBounds(872, 87, 138, 29);
		panel.add(txtTelepon);
		
		txtNoKtpsim = new JTextField();
		txtNoKtpsim.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoKtpsim.setColumns(10);
		txtNoKtpsim.setBounds(872, 129, 197, 29);
		panel.add(txtNoKtpsim);
		
		txtAnakke = new JTextField();
		txtAnakke.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtAnakke.setColumns(10);
		txtAnakke.setBounds(872, 162, 46, 29);
		panel.add(txtAnakke);
		
		txtUmur = new JTextField();
		txtUmur.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtUmur.setColumns(10);
		txtUmur.setBounds(872, 199, 46, 29);
		panel.add(txtUmur);
		
		txtNoBpjs = new JTextField();
		txtNoBpjs.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoBpjs.setColumns(10);
		txtNoBpjs.setBounds(872, 276, 216, 29);
		panel.add(txtNoBpjs);
		
		txtNoRujukan = new JTextField();
		txtNoRujukan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoRujukan.setColumns(10);
		txtNoRujukan.setBounds(872, 311, 207, 29);
		panel.add(txtNoRujukan);
		
		cmboStatusNikah = new JComboBox();
		cmboStatusNikah.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboStatusNikah.setBounds(170, 280, 176, 29);
		cmboStatusNikah.addItem("-- Pilih Status --");
		cmboStatusNikah.addItem("Nikah");
		cmboStatusNikah.addItem("Belum Nikah");
		panel.add(cmboStatusNikah);
		
		/**
		tanggal = new JCalendarCombo();
		tanggal.setDateFormat(new SimpleDateFormat("dd/MM/yy"));
		DateFormat format = new SimpleDateFormat("dd/MM/yy");
		DateFormatter memformat = new DateFormatter(format);
		txtTanggal = new JFormattedTextField(memformat);
		txtTanggal.setValue(new Date());
		txtTanggal.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtTanggal.setBounds(168, 237, 102, 29);
		panel.add(tanggal);
		**/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(478, 163, 190, 94);
		panel.add(scrollPane);
		
		txtAlamat = new JTextArea();
		txtAlamat.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(txtAlamat);
		
		cmboGolDarah = new JComboBox();
		cmboGolDarah.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		cmboGolDarah.setBounds(872, 238, 197, 29);
		cmboGolDarah.addItem("-- Pilih Gol. Darah --");
		cmboGolDarah.addItem(" A ");
		cmboGolDarah.addItem(" B ");
		cmboGolDarah.addItem(" O");
		cmboGolDarah.addItem(" AB ");
		panel.add(cmboGolDarah);
		
		btnSimpan = new JButton("Simpan");
		btnSimpan.setIcon(new ImageIcon(panelPasien.class.getResource("/com/sipk/Image/Simpan.png")));
		btnSimpan.setBounds(806, 458, 99, 43);
		panel.add(btnSimpan);
		
		btnBatal = new JButton("Batal");
		btnBatal.setIcon(new ImageIcon(panelPasien.class.getResource("/com/sipk/Image/Batal.png")));
		btnBatal.setBounds(931, 458, 102, 43);
		panel.add(btnBatal);
		
		cmboTanggal = new JCalendarCombo();
		cmboTanggal.setBounds(168, 237, 139, 29);
		cmboTanggal.setDateFormat(new SimpleDateFormat("yy-MM-dd"));
		panel.add(cmboTanggal);
		
		penghendel hendel = new penghendel();
		btnSimpan.addActionListener(hendel);
		btnBatal.addActionListener(hendel);
		
		tampilPasien();
	}
	
	public void simpanPasien()
	{
		try
		{
			konek = konek_database.getKonekDB();
			PreparedStatement ps = konek.prepareStatement("insert into pasien(no_rm,no_reg,nama,tempat_lahir,tanggal_lahir,sttus_nikah,agama,suku,pendidikan,pekerjaan,alamat,kelurahan,kecamatan,kabupaten,no_telp,no_ktp_sim,anak_ke,umur,gol_darah,no_bpjs,no_rujukan) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, txtNoRM.getText());
			ps.setString(2, txtNoReg.getText());
			ps.setString(3, txtNama.getText());
			ps.setString(4, txtTempatLahir.getText());
			ps.setString(5, (String) cmboTanggal.getSelectedItem());
			ps.setString(6, (String) cmboStatusNikah.getSelectedItem());
			ps.setString(7, txtAgama.getText());
			ps.setString(8, txtSuku.getText());
			ps.setString(9, txtPendidikan.getText());
			ps.setString(10, txtPekerjaan.getText());
			ps.setString(11, txtAlamat.getText());
			ps.setString(12, txtKelurahan.getText());
			ps.setString(13, txtKecamatan.getText());
			ps.setString(14, txtKabupaten.getText());
			ps.setString(15, txtTelepon.getText());
			ps.setString(16, txtNoKtpsim.getText());
			ps.setString(17, txtAnakke.getText());
			ps.setInt(18, (int) Integer.parseInt(txtUmur.getText()));
			ps.setString(19, (String) cmboGolDarah.getSelectedItem());
			ps.setString(20, txtNoBpjs.getText());
			ps.setString(21, txtNoReg.getText());
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Data berhasil tersimpan!");
			konek.close();
			ps.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol simpan : "+ex.getMessage());
		}
		finally
		{
			bersihPasien();
			tampilPasien();
		}
	}
	
	private void tampilPasien()
	{
		modelTabelPasien.getDataVector().removeAllElements();
		modelTabelPasien.fireTableDataChanged();
		try
		{
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select * from pasien");
			
			while(result.next())
			{
				Object obj[] = new Object[21];
				obj[0] = result.getString(1);
				obj[1] = result.getString(2);
				obj[2] = result.getString(3);
				obj[3] = result.getString(4);
				obj[4] = result.getDate(5);
				obj[5] = result.getString(6);
				obj[6] = result.getString(7);
				obj[7] = result.getString(8);
				obj[8] = result.getString(9);
				obj[9] = result.getString(10);
				obj[10] = result.getString(11);
				obj[11] = result.getString(12);
				obj[12] = result.getString(13);
				obj[13] = result.getString(14);
				obj[14] = result.getString(15);
				obj[15] = result.getString(16);
				obj[16] = result.getString(17);
				obj[17] = result.getInt(18);
				obj[18] = result.getString(19);
				obj[19] = result.getString(20);
				obj[20] = result.getString(21);
				
				modelTabelPasien.addRow(obj);
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada metode tampil tabel : "+ex.getMessage());
		}
		finally
		{
			bersihPasien();
		}
	}
	
	
	private void bersihPasien()
	{
		txtNoRM.setText("");
		txtNoReg.setText("");
		txtNama.setText("");
		txtTempatLahir.setText("");
		txtAgama.setText("");
		txtSuku.setText("");
		txtPendidikan.setText("");
		txtPekerjaan.setText("");
		txtKelurahan.setText("");
		txtKecamatan.setText("");
		txtKabupaten.setText("");
		txtTelepon.setText("");
		txtNoKtpsim.setText("");
		txtAnakke.setText("");
		txtUmur.setText("");
		txtNoBpjs.setText("");
		txtNoRujukan.setText("");
		txtAlamat.setText("");
		cmboStatusNikah.setSelectedIndex(0);
		cmboGolDarah.setSelectedIndex(0);
	}
	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnSimpan)
			{
				simpanPasien();
				tampilPasien();
			}
			else if(e.getSource()==btnBatal)
			{
				bersihPasien();
			}
		}
	}
}
