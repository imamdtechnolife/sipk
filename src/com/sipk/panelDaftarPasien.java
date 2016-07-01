package com.sipk;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.freixas.jcalendar.JCalendarCombo;
import javax.swing.JRadioButton;

public class panelDaftarPasien extends JPanel {
	private JTextField txtKeterangan;
	private JTextField txtNoUrut;
	private JTextField txtNoCM;
	private JTextField txtNama;
	private JTextField txtUmur;
	private JComboBox cmboJK;
	private JComboBox cmboPangkat;
	private JComboBox cmboSttsPersonil;
	private JComboBox cmboSatuan;
	private JComboBox cmboBagian;
	private JTextArea txtDiagnosa;
	private JTable table;
	private Connection konek;
	private JButton btnSimpan;
	private JButton btnBatal;
	private JCalendarCombo calendarCombo;
	private JCalendarCombo cmboAwal;
	private JCalendarCombo cmboAkhir;
	private JButton btnCariBerdasarTanggal;
	private JTextField textField;
	private JButton btnCariNama;
	private DefaultTableModel modelTabelDaftarKunjungan = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tanggal", "No. Urut", "No. CM", "Nama", "Umur", "Jenis Kelamin", "Pangkat", "Status Personil", "Kesatuan", "Bagian dikunjungi", "Diagnosa", "Keterangan"
			}
		);
	
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
		panelTabelKunjungan.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 118, 1341, 407);
		panelTabelKunjungan.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(modelTabelDaftarKunjungan);
		scrollPane_1.setViewportView(table);
		
		JLabel lblTabelKunjungan = new JLabel("Tabel Kunjungan");
		lblTabelKunjungan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblTabelKunjungan.setBounds(24, 11, 268, 33);
		panelTabelKunjungan.add(lblTabelKunjungan);
		
		cmboAwal = new JCalendarCombo();
		cmboAwal.setBounds(882, 58, 146, 29);
		cmboAwal.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		panelTabelKunjungan.add(cmboAwal);
		
		JLabel lblNewLabel_1 = new JLabel("Sampai");
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(1060, 75, 59, 14);
		panelTabelKunjungan.add(lblNewLabel_1);
		
		cmboAkhir = new JCalendarCombo();
		cmboAkhir.setBounds(1129, 58, 146, 29);
		cmboAkhir.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		panelTabelKunjungan.add(cmboAkhir);
		
		JLabel lblPencarianBerdasarkanTanggal = new JLabel("Pencarian Berdasarkan Tanggal Kunjungan :");
		lblPencarianBerdasarkanTanggal.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblPencarianBerdasarkanTanggal.setBounds(872, 34, 298, 20);
		panelTabelKunjungan.add(lblPencarianBerdasarkanTanggal);
		
		JLabel lbltahunbulantanggal = new JLabel("(Tahun-Bulan-Tanggal)");
		lbltahunbulantanggal.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lbltahunbulantanggal.setBounds(879, 87, 153, 20);
		panelTabelKunjungan.add(lbltahunbulantanggal);
		
		JLabel label = new JLabel("(Tahun-Bulan-Tanggal)");
		label.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		label.setBounds(1122, 87, 153, 20);
		panelTabelKunjungan.add(label);
		
		btnCariBerdasarTanggal = new JButton("");
		btnCariBerdasarTanggal.setIcon(new ImageIcon(panelDaftarPasien.class.getResource("/com/sipk/Image/Cari.png")));
		btnCariBerdasarTanggal.setBounds(1295, 58, 44, 33);
		panelTabelKunjungan.add(btnCariBerdasarTanggal);
		
		textField = new JTextField();
		textField.setToolTipText("Pencarian berdasarkan nama");
		textField.setBounds(588, 87, 173, 20);
		panelTabelKunjungan.add(textField);
		textField.setColumns(10);
		
		JLabel lblNama_1 = new JLabel("Nama");
		lblNama_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		lblNama_1.setBounds(540, 91, 59, 14);
		panelTabelKunjungan.add(lblNama_1);
		
		btnCariNama = new JButton("");
		btnCariNama.setIcon(new ImageIcon(panelDaftarPasien.class.getResource("/com/sipk/Image/Cari.png")));
		btnCariNama.setBounds(777, 74, 44, 33);
		panelTabelKunjungan.add(btnCariNama);
		
		
		JPanel panelDaftarKunjungan = new JPanel();
		tabbedPane.addTab("Daftar Kunjungan", null, panelDaftarKunjungan, null);
		panelDaftarKunjungan.setLayout(null);
		
		JLabel lblDaftarPasien = new JLabel("Daftar Kunjungan");
		lblDaftarPasien.setBounds(24, 11, 265, 33);
		panelDaftarKunjungan.add(lblDaftarPasien);
		lblDaftarPasien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		
		JLabel lblTanggal = new JLabel("Tanggal");
		lblTanggal.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblTanggal.setBounds(47, 108, 88, 20);
		panelDaftarKunjungan.add(lblTanggal);
		
		JLabel lblNoUrut = new JLabel("No. Urut");
		lblNoUrut.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoUrut.setBounds(46, 154, 88, 14);
		panelDaftarKunjungan.add(lblNoUrut);
		
		txtNoUrut = new JTextField();
		txtNoUrut.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoUrut.setBounds(242, 147, 86, 29);
		panelDaftarKunjungan.add(txtNoUrut);
		txtNoUrut.setColumns(10);
		
		JLabel lblNoCm = new JLabel("No. CM");
		lblNoCm.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoCm.setBounds(46, 193, 88, 14);
		panelDaftarKunjungan.add(lblNoCm);
		
		txtNoCM = new JTextField();
		txtNoCM.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNoCM.setBounds(242, 186, 86, 29);
		panelDaftarKunjungan.add(txtNoCM);
		txtNoCM.setColumns(10);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNama.setBounds(46, 234, 46, 14);
		panelDaftarKunjungan.add(lblNama);
		
		txtNama = new JTextField();
		txtNama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtNama.setBounds(242, 227, 284, 29);
		panelDaftarKunjungan.add(txtNama);
		txtNama.setColumns(10);
		
		JLabel lblUmur = new JLabel("Umur");
		lblUmur.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblUmur.setBounds(46, 276, 46, 14);
		panelDaftarKunjungan.add(lblUmur);
		
		txtUmur = new JTextField();
		txtUmur.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtUmur.setBounds(242, 269, 46, 29);
		panelDaftarKunjungan.add(txtUmur);
		txtUmur.setColumns(10);
		
		JLabel lblJenisKelamin = new JLabel("Jenis Kelamin");
		lblJenisKelamin.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblJenisKelamin.setBounds(46, 321, 119, 14);
		panelDaftarKunjungan.add(lblJenisKelamin);
		
		cmboJK = new JComboBox();
		cmboJK.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboJK.setBounds(242, 314, 221, 29);
		cmboJK.addItem("-- Pilih Jenis Kelamin --");
		cmboJK.addItem("Laki-laki");
		cmboJK.addItem("Perempuan");
		panelDaftarKunjungan.add(cmboJK);
		
		JLabel lblPangkat = new JLabel("Pangkat");
		lblPangkat.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblPangkat.setBounds(582, 141, 88, 20);
		panelDaftarKunjungan.add(lblPangkat);
		
		cmboPangkat = new JComboBox();
		cmboPangkat.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboPangkat.setBounds(778, 137, 184, 29);
		panelDaftarKunjungan.add(cmboPangkat);
		//cmboPangkat.setEnabled(false);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblStatus.setBounds(582, 108, 129, 14);
		panelDaftarKunjungan.add(lblStatus);
		
		cmboSttsPersonil = new JComboBox();
		cmboSttsPersonil.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboSttsPersonil.setBounds(776, 101, 186, 29);
		cmboSttsPersonil.addItem("-- Pilih Status --");
		cmboSttsPersonil.addItem("Personil");
		cmboSttsPersonil.addItem("PNS");
		cmboSttsPersonil.addItem("Dikbang");
		cmboSttsPersonil.addItem("Diktuk");
		cmboSttsPersonil.addItem("Tahanan");
		cmboSttsPersonil.addItem("Mandiri");
		cmboSttsPersonil.addItem("BPJS");
		cmboSttsPersonil.addItem("Purnawirawan");
		panelDaftarKunjungan.add(cmboSttsPersonil);
		
		
		JLabel lblSatuan = new JLabel("Satuan");
		lblSatuan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblSatuan.setBounds(582, 184, 88, 14);
		panelDaftarKunjungan.add(lblSatuan);
		
		cmboSatuan = new JComboBox();
		cmboSatuan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboSatuan.setBounds(778, 177, 197, 29);
		cmboSatuan.addItem("-- Pilih Satuan --");
		cmboSatuan.addItem("Polda NTB");
		cmboSatuan.addItem("Luar Polda NTB");
		panelDaftarKunjungan.add(cmboSatuan);
		//cmboSatuan.setEnabled(false);
		
		JLabel lblBagianYangDikunjungi = new JLabel("Bagian Yang dikunjungi");
		lblBagianYangDikunjungi.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblBagianYangDikunjungi.setBounds(582, 220, 186, 20);
		panelDaftarKunjungan.add(lblBagianYangDikunjungi);
		
		cmboBagian = new JComboBox();
		cmboBagian.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cmboBagian.setBounds(778, 217, 197, 29);
		cmboBagian.addItem("-- Pilih Bagian --");
		cmboBagian.addItem("Poli Gigi");
		cmboBagian.addItem("Poli Mata");
		cmboBagian.addItem("Poli Bedah");
		cmboBagian.addItem("Poli Fishioterapi");
		cmboBagian.addItem("Poli BKIA");
		cmboBagian.addItem("Poli Urologi");
		panelDaftarKunjungan.add(cmboBagian);
		
		JLabel lblDiagnosa = new JLabel("Diagnosa");
		lblDiagnosa.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblDiagnosa.setBounds(582, 259, 88, 20);
		panelDaftarKunjungan.add(lblDiagnosa);
		
		JLabel lblKeterangan = new JLabel("Keterangan");
		lblKeterangan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblKeterangan.setBounds(582, 369, 88, 17);
		panelDaftarKunjungan.add(lblKeterangan);
		
		txtKeterangan = new JTextField();
		txtKeterangan.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		txtKeterangan.setBounds(778, 366, 247, 29);
		panelDaftarKunjungan.add(txtKeterangan);
		txtKeterangan.setColumns(10);
		
		btnSimpan = new JButton("Simpan");
		btnSimpan.setBounds(1088, 445, 103, 43);
		panelDaftarKunjungan.add(btnSimpan);
		btnSimpan.setIcon(new ImageIcon(panelDaftarPasien.class.getResource("/com/sipk/Image/Simpan.png")));
		
		btnBatal = new JButton("Batal");
		btnBatal.setBounds(1201, 445, 103, 43);
		panelDaftarKunjungan.add(btnBatal);
		btnBatal.setIcon(new ImageIcon(panelDaftarPasien.class.getResource("/com/sipk/Image/Batal.png")));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(panelDaftarPasien.class.getResource("/com/sipk/Image/b-daftar.png")));
		lblNewLabel.setBounds(1088, 108, 256, 266);
		panelDaftarKunjungan.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(778, 257, 284, 100);
		panelDaftarKunjungan.add(scrollPane);
		
		txtDiagnosa = new JTextArea();
		scrollPane.setViewportView(txtDiagnosa);
		txtDiagnosa.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		calendarCombo = new JCalendarCombo();
		calendarCombo.setBounds(242, 105, 158, 29);
		calendarCombo.setDateFormat(format);
		//calendarCombo.
		panelDaftarKunjungan.add(calendarCombo);
		
		/**
		 * configurasi terbaru
		 */
		txtNoUrut.setEditable(false);
		daftarPangkat();
		buatNoUrutOtomatis();
		jikaPersonilAtauPNS();
		tampilTabelKunjungan();
		
		penghendel hendel = new penghendel();
		btnSimpan.addActionListener(hendel);
		btnBatal.addActionListener(hendel);
		btnCariNama.addActionListener(hendel);
		btnCariBerdasarTanggal.addActionListener(hendel);

	}
	
	private void buatNoUrutOtomatis()
	{
		int noUrut = 0;
		try
		{
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select nomor_urut from pasien_daftar order by nomor_urut desc");
			
			if(result.next())
			{
				noUrut = result.getInt(1) + 1;
				txtNoUrut.setText(""+noUrut);
			}
			else
			{
				txtNoUrut.setText("1");
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada metode buatNoUrutOtomatis : "+ex.getMessage());
		}
		finally
		{
			
		}
		
	}
	
	private void daftarPangkat()
	{
		cmboPangkat.addItem("-- Pilih Pangkat --");
		cmboPangkat.addItem("Bharada");
		cmboPangkat.addItem("Bharatu");
		cmboPangkat.addItem("Bharaka");
		cmboPangkat.addItem("Abripda");
		cmboPangkat.addItem("Abriptu");
		cmboPangkat.addItem("Abrippol");
		cmboPangkat.addItem("Bridpa");
		cmboPangkat.addItem("Briptu");
		cmboPangkat.addItem("Brippol");
		cmboPangkat.addItem("Bripka");
		cmboPangkat.addItem("Aipda");
		cmboPangkat.addItem("Aiptu");
		cmboPangkat.addItem("Ipda");
		cmboPangkat.addItem("Iptu");
		cmboPangkat.addItem("AKP");
		cmboPangkat.addItem("Kompol");
		cmboPangkat.addItem("AKBP");
		cmboPangkat.addItem("Kombes Pol");
		cmboPangkat.addItem("Brigjen Pol");
		cmboPangkat.addItem("Irjen Pol");
		cmboPangkat.addItem("Komjen Pol");
		cmboPangkat.addItem("Jend Pol");
	}
	
	private void bersihKunjungan()
	{
		txtNoCM.setText("");
		txtNama.setText("");
		txtUmur.setText("");
		txtDiagnosa.setText("");
		txtKeterangan.setText("");
		cmboBagian.setSelectedIndex(0);
		cmboJK.setSelectedIndex(0);
		cmboPangkat.setSelectedIndex(0);
		cmboSatuan.setSelectedIndex(0);
		cmboSttsPersonil.setSelectedIndex(0);
		//cmboPangkat.setEnabled(false);
		//cmboSatuan.setEnabled(false);
	}
	
	private void jikaPersonilAtauPNS()
	{
		/**
		 * not finish
		 
		boolean i = (boolean) cmboSttsPersonil.getSelectedItem();
		 if(obj. || obj.equals("PNS"))
		 {
			 cmboPangkat.setEnabled(true);
			 cmboSatuan.setEnabled(true);
		 }
		 else
		 {
			 cmboPangkat.setEnabled(false);
			 cmboSatuan.setEnabled(false);
		 }
		 */
		 
	}
	
	private void simpanKunjungan()
	{
		try
		{
			konek = konek_database.getKonekDB();
			PreparedStatement ps = konek.prepareStatement("insert into pasien_daftar values (?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, (String) calendarCombo.getSelectedItem());
			ps.setInt(2, (int) Integer.parseInt(txtNoUrut.getText()));
			ps.setInt(3, (int) Integer.parseInt(txtNoCM.getText()));
			ps.setString(4, txtNama.getText());
			ps.setInt(5, (int) Integer.parseInt(txtUmur.getText()));
			ps.setString(6, (String) cmboJK.getSelectedItem());
			ps.setString(7, (String) cmboSttsPersonil.getSelectedItem());
			ps.setString(8, (String) cmboPangkat.getSelectedItem());
			ps.setString(9, (String) cmboSatuan.getSelectedItem());
			ps.setString(10, (String) cmboBagian.getSelectedItem());
			ps.setString(11, txtDiagnosa.getText());
			ps.setString(12, txtKeterangan.getText());
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Data berhasil tersimpan!");
			buatNoUrutOtomatis();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada metode simpanKunjungan : "+ex.getMessage());
		}
		finally
		{
			bersihKunjungan();
			tampilTabelKunjungan();
		}
	}
	
	private void tampilTabelKunjungan()
	{
		modelTabelDaftarKunjungan.getDataVector().removeAllElements();
		modelTabelDaftarKunjungan.fireTableDataChanged();
		
		try
		{
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select * from pasien");
			
			while(result.next())
			{
				Object obj[] = new Object[12];
					obj[0] = result.getDate(1); 
					obj[1] = result.getInt(2);
					obj[2] = result.getInt(3);
					obj[3] = result.getString(4);
					obj[4] = result.getInt(5);
					obj[5] = result.getString(6);
					obj[6] = result.getString(7);
					obj[7] = result.getString(8);
					obj[8] = result.getString(9);
					obj[9] = result.getString(10);
					obj[10] = result.getString(11);
					obj[11] = result.getString(12);
					
					modelTabelDaftarKunjungan.addRow(obj);
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada metode tampilTabelKunjungan : "+ex.getMessage());
		}
		finally
		{
			bersihKunjungan();
		}
	}
	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnSimpan)
			{
				simpanKunjungan();
			}
			else if(e.getSource()==btnBatal)
			{
				bersihKunjungan();
			}
		}
	}
}
