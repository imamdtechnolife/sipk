package com.sipk;

/**
 * Project	: Tugas Akhir
 * Title	: Sistem Informasi Pelayanan Kesehatan Berbasis Java dan MySQL Pada Rumah Sakit Bhayangkara Mataram
 * Author	: Imam Afriyadi
 */

/**
 * Frame : Pasien Rawat Inap
 */

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;

import java.text.*;

import org.freixas.jcalendar.*;

import java.util.Date;

public class pasien_rawat_inap extends JFrame{

	/**
	 * inisialisasi
	 * 
	 */
	Font tnr = new Font("Bookman Old Style", Font.ROMAN_BASELINE , 14);
	JLabel lbljudul = new JLabel("PASIEN RAWAT INAP");
	JLabel lbljudul2 = new JLabel("RUMAH SAKIT BHAYANGKARA MATARAM");
	JLabel lblno_reg = new JLabel("No. Reg :");
	JLabel lblnama_penderita = new JLabel("Nama Penderita :");
	JLabel lblumur = new JLabel("Umur :");
	JLabel lblalamat = new JLabel("Alamat :");
	JLabel lblstatus = new JLabel("Status :");
	JLabel lblpekerjaan = new JLabel("Pekerjaan :");
	JLabel lbltanggal_masuk = new JLabel("Tanggal Masuk :");
	JLabel lbltanggal_keluar = new JLabel("Tanggal Keluar :");
	JLabel lbllama = new JLabel("Lama :");
	JLabel lblruang_perawatan = new JLabel("Ruang Perawatan :");
	JLabel lbldiagnosa = new JLabel("Diagnosa :");
	JLabel lblKeterangan = new JLabel("Keterangan :");
	Icon iconTambah = new ImageIcon(getClass().getResource("Image/Tambah.png"));
	JButton btnTambah = new JButton("Tambah", iconTambah);
	Icon iconSimpan = new ImageIcon(getClass().getResource("Image/Simpan.png"));
	JButton btnSimpan = new JButton("Simpan", iconSimpan);
	Icon iconBatal = new ImageIcon(getClass().getResource("Image/Batal.png"));
	JButton btnBatal = new JButton("Batal", iconBatal);
	Icon iconUbah = new ImageIcon(getClass().getResource("Image/Ubah.png"));
	JButton btnUbah = new JButton("Ubah", iconUbah);
	Icon iconHapus = new ImageIcon(getClass().getResource("Image/Hapus.png"));
	JButton btnHapus = new JButton("Hapus", iconHapus);
	Icon iconRefresh = new ImageIcon(getClass().getResource("Image/Refresh.png"));
	JButton btnRefresh1 = new JButton("Refresh", iconRefresh);
	Icon iconRefresh2 = new ImageIcon(getClass().getResource("Image/Refresh.png"));
	JButton btnRefresh2 = new JButton("Refresh", iconRefresh2);
	Icon iconReport = new ImageIcon(getClass().getResource("Image/Laporan.png"));
	JButton btnReport = new JButton("Cetak", iconReport);
	Icon iconTotal = new ImageIcon(getClass().getResource("Image/Total.png"));
	JButton btnTotal = new JButton("Total Data Masuk", iconTotal);
	JTextField txtNoReg = new JTextField(5);
	JTextField txtNamaPenderita = new JTextField();
	JComboBox comboUmur = new JComboBox();
	JTextArea areaAlamat = new JTextArea(1,10);
	JScrollPane scrollAlamat = new JScrollPane(areaAlamat);
	JComboBox comboStatus = new JComboBox();
	JRadioButton radioPns = new JRadioButton("PNS");
	JRadioButton radioWiraswasta = new JRadioButton("Wiraswasta");
	JRadioButton radioPelajar = new JRadioButton("Pelajar");
	JRadioButton radioLainnya = new JRadioButton("Lainnya");
	JCalendarCombo tanggalMasuk = new JCalendarCombo();
	JCalendarCombo tanggalKeluar = new JCalendarCombo();
	JLabel lblResultLama = new JLabel();
	JComboBox comboRuangPerawatan = new JComboBox();
	JTextArea areaDiagnosa = new JTextArea(1,10);
	JScrollPane scrollDiagnosa = new JScrollPane(areaDiagnosa);
	JTextArea areaKeterangan = new JTextArea(1,10);
	JScrollPane scrollKeterangan = new JScrollPane(areaKeterangan);
	JPanel masterRawatInap = new JPanel();
	JPanel masterTombol = new JPanel();
	JScrollPane scrollRawatInap = new JScrollPane();
	JTabbedPane tabRawatInap = new JTabbedPane();
	Container konten = getContentPane();
	JTable tabelPasienRawatInap = new JTable();
	String fieldPasienRawatInap[] = {"No. Reg","Nama Penderita","Umur (Tahun)","Alamat","Status","Pekerjaan","Tanggal Masuk","Tanggal Keluar","Lama (Hari)","Ruang Perawatan","Diagnosa","Keterangan"}; 
	DefaultTableModel modelTabelPasienRawatInap = new DefaultTableModel(null, fieldPasienRawatInap);
	JScrollPane scrollTable = new JScrollPane();
	JPanel masterTabel = new JPanel();
	JPanel masterTombolEkstra = new JPanel();
	JPanel masterResult = new JPanel();
	Connection connect = null;
	Statement state = null;
	ResultSet result = null;
	PreparedStatement ps = null;
	JComboBox kodePenyakit = new JComboBox();
	JLabel blank = new JLabel();
	JButton btnSimpanUbah = new JButton("Simpan", iconSimpan);
	
	
	/**
	 * konstruktor kelas pasien_rawat_inap
	 */
	public pasien_rawat_inap()
	{
		super("Pasien Rawat Inap");
		setIconImage(Toolkit.getDefaultToolkit().getImage(pasien_rawat_inap.class.getResource("Image/address-book-new.png")));
		setLayout(new GridLayout(0,1));
		JPanel panelJudul = new JPanel();
		panelJudul.add(lbljudul);
		panelJudul.add(lbljudul2);
		
		txtNamaPenderita.setFont(tnr);
		comboUmur.setFont(tnr);
		areaAlamat.setFont(tnr);
		comboStatus.setFont(tnr);
		radioPns.setFont(tnr);
		radioWiraswasta.setFont(tnr);
		radioPelajar.setFont(tnr);
		radioLainnya.setFont(tnr);
		tanggalMasuk.setFont(tnr);
		tanggalKeluar.setFont(tnr);
		lblResultLama.setFont(tnr);
		comboRuangPerawatan.setFont(tnr);
		kodePenyakit.setFont(tnr);
		areaDiagnosa.setFont(tnr);
		areaKeterangan.setFont(tnr);
		lblalamat.setFont(tnr);
		lbldiagnosa.setFont(tnr);
		lbljudul.setFont(tnr);
		lbljudul2.setFont(tnr);
		lblKeterangan.setFont(tnr);
		lbllama.setFont(tnr);
		lblnama_penderita.setFont(tnr);
		lblno_reg.setFont(tnr);
		txtNoReg.setFont(tnr);
		lblpekerjaan.setFont(tnr);
		lblruang_perawatan.setFont(tnr);
		lblstatus.setFont(tnr);
		lbltanggal_keluar.setFont(tnr);
		lbltanggal_masuk.setFont(tnr);
		lblumur.setFont(tnr);
		
		
		JPanel groupRBpekerjaan = new JPanel();
		groupRBpekerjaan.add(radioPns);
		groupRBpekerjaan.add(radioWiraswasta);
		groupRBpekerjaan.add(radioPelajar);
		groupRBpekerjaan.add(radioLainnya);
		ButtonGroup RBpekerjaan = new ButtonGroup();
		RBpekerjaan.add(radioPns);
		RBpekerjaan.add(radioWiraswasta);
		RBpekerjaan.add(radioPelajar);
		RBpekerjaan.add(radioLainnya);
		
		masterRawatInap.setBorder(BorderFactory.createTitledBorder("Input Pasien Rawat Inap"));
		masterRawatInap.setLayout(new GridLayout(13,2));
		masterRawatInap.add(lblno_reg);
		masterRawatInap.add(txtNoReg);
		masterRawatInap.add(lblnama_penderita);
		masterRawatInap.add(txtNamaPenderita);
		masterRawatInap.add(lblumur);
		masterRawatInap.add(comboUmur);
		masterRawatInap.add(lblalamat);
		masterRawatInap.add(scrollAlamat);
		masterRawatInap.add(lblstatus);
		masterRawatInap.add(comboStatus);
		masterRawatInap.add(lblpekerjaan);
		/**
		 * block Pekerjaan
		 */
		masterRawatInap.add(groupRBpekerjaan);
		masterRawatInap.add(lbltanggal_masuk);
		/**
		 * blok tanggal masuk
		 */
		tanggalMasuk.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		masterRawatInap.add(tanggalMasuk);
		masterRawatInap.add(lbltanggal_keluar);
		tanggalKeluar.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		masterRawatInap.add(tanggalKeluar);
		 /**
		  * blok tanggal keluar
		  */
		masterRawatInap.add(lbllama);
		masterRawatInap.add(lblResultLama);
		masterRawatInap.add(lblruang_perawatan);
		
		masterRawatInap.add(comboRuangPerawatan);
		masterRawatInap.add(lbldiagnosa);
		masterRawatInap.add(kodePenyakit);
		masterRawatInap.add(blank);
		masterRawatInap.add(scrollDiagnosa);
		masterRawatInap.add(lblKeterangan);
		masterRawatInap.add(scrollKeterangan);
		
		masterTombol.add(btnTambah);
		masterTombol.add(btnSimpan);
		masterTombol.add(btnSimpanUbah);
		masterTombol.add(btnBatal);
		masterTombol.setBorder(BorderFactory.createTitledBorder("Tombol Aksi"));
		
		JPanel pnlGabungInputdanTombolUtm = new JPanel();
		pnlGabungInputdanTombolUtm.setLayout(new FlowLayout());
		//pnlGabungInputdanTombolUtm.add(panelJudul);		
		pnlGabungInputdanTombolUtm.add(masterRawatInap);
		pnlGabungInputdanTombolUtm.add(masterTombol);
		
		tabelPasienRawatInap.setModel(modelTabelPasienRawatInap);
		tabelPasienRawatInap.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollTable.getViewport().add(tabelPasienRawatInap);
		masterTabel.setLayout(new BorderLayout());
		masterTabel.add(scrollTable);
		tabelPasienRawatInap.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				ambilData();
				comboRuangPerawatan.setEnabled(true);
				comboStatus.setEnabled(true);
				comboUmur.setEnabled(true);
				kodePenyakit.setEnabled(true);
				btnUbah.setEnabled(true);
				btnHapus.setEnabled(true);
				btnRefresh1.setEnabled(true);
				btnReport.setEnabled(false);
				btnTotal.setEnabled(false);
			}
		}
				);
		
		masterTombolEkstra.add(btnReport);
		masterTombolEkstra.add(btnTotal);
		masterTombolEkstra.add(btnUbah);
		masterTombolEkstra.add(btnHapus);
		masterTombolEkstra.add(btnRefresh1);
		masterTombolEkstra.setLayout(new FlowLayout());
		masterTombolEkstra.setBorder(BorderFactory.createTitledBorder("Tombol aksi"));
		
		JPanel gabungTabeldanTombolEkstra = new JPanel();
		gabungTabeldanTombolEkstra.add(masterTabel);
		gabungTabeldanTombolEkstra.add(masterTombolEkstra);
		gabungTabeldanTombolEkstra.setLayout(new GridLayout(2,0));
		
		
		tabRawatInap.addTab("Formulir Input", pnlGabungInputdanTombolUtm);
		tabRawatInap.addTab("Result", gabungTabeldanTombolEkstra);
		
		konten.add(tabRawatInap);
		
		penghendel hendelButton = new penghendel();
		btnTambah.addActionListener(hendelButton);
		btnSimpan.addActionListener(hendelButton);
		btnBatal.addActionListener(hendelButton);
		btnTotal.addActionListener(hendelButton);
		btnRefresh1.addActionListener(hendelButton);
		btnUbah.addActionListener(hendelButton);
		btnHapus.addActionListener(hendelButton);
		btnSimpanUbah.addActionListener(hendelButton);
		
		item();
		tampilTabel();
		kembali();
		
	}
	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnTambah)
			{
				btnTambah.setEnabled(false);
				btnSimpan.setEnabled(true);
				btnBatal.setEnabled(true);
				txtNamaPenderita.setEditable(true);
				comboUmur.setEnabled(true);
				areaAlamat.setEditable(true);
				comboStatus.setEnabled(true);
				radioPns.setEnabled(true);
				radioWiraswasta.setEnabled(true);
				radioPelajar.setEnabled(true);
				radioLainnya.setEnabled(true);
				tanggalMasuk.setEnabled(true);
				tanggalKeluar.setEnabled(true);
				lblResultLama.setText("");
				comboRuangPerawatan.setEnabled(true);
				areaDiagnosa.setEditable(true);
				areaKeterangan.setEditable(true);
				txtNamaPenderita.setText("");
				areaAlamat.setText("");
				areaDiagnosa.setText("");
				areaKeterangan.setText("");
				txtNoReg.setEditable(false);
				txtNamaPenderita.requestFocus();
				comboRuangPerawatan.setSelectedIndex(0);
				comboStatus.setSelectedIndex(0);
				comboUmur.setSelectedIndex(0);
				kodePenyakit.setSelectedIndex(0);
				kodePenyakit.setEnabled(true);
				
				
				/**
				 * pembuatan kode otomatis
				 */
				try
				{
					connect = konek_database.getKonekDB();
					state = connect.createStatement();
					result = state.executeQuery("select no_reg from pasien_rawat_inap order by no_reg desc");
					
					if(result.next())
					{
						int i = result.getInt(1) + 1;
						txtNoReg.setText(Integer.toString(i));
					}
					else
					{
						txtNoReg.setText("1");
					}
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada pembuatan kode otomatis : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			else if(e.getSource()==btnSimpan)
			{
				
				/**
				 * Menyimpan data pada RadioButton (Pekerjaan)
				 */
				String im = "";
				
				if(radioPns.isSelected())
				{
					im = "PNS";
				}
				else if(radioWiraswasta.isSelected())
				{
					im = "Wiraswasta";
				}
				else if(radioPelajar.isSelected())
				{
					im = "Pelajar";
				}
				else if(radioPelajar.isSelected())
				{
					im = "Lainnya";
				}
				else
				{
					im = "Kosong";
				}
		
				
				/**
				 * Proses penyimpanan data ke database
				 */
				try
				{
					connect = konek_database.getKonekDB();
					ps = connect.prepareStatement("insert into pasien_rawat_inap (nama_penderita,umur,alamat,sttus,pekerjaan,tanggal_masuk,tanggal_keluar,lama,ruang_perawatan,diagnosa,keterangan) values(?,?,?,?,?,?,?,?,?,?,?)");
					
					ps.setString(1, txtNamaPenderita.getText());
					ps.setInt(2, comboUmur.getSelectedIndex());
					ps.setString(3, areaAlamat.getText());
					ps.setString(4, (String) comboStatus.getSelectedItem());
					ps.setString(5, im);
					ps.setString(6, (String) tanggalMasuk.getSelectedItem());
					ps.setString(7, (String) tanggalKeluar.getSelectedItem());
					ps.setInt(8, Integer.parseInt(lblResultLama.getText()));
					ps.setString(9, (String) comboRuangPerawatan.getSelectedItem());
					ps.setString(10, areaDiagnosa.getText());
					ps.setString(11, areaKeterangan.getText());
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data berhasil tersimpan","Sukses",JOptionPane.INFORMATION_MESSAGE);
					tampilTabel();
					kembali();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol simpan : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource()==btnBatal)
			{
				kembali();
			}
			else if(e.getSource()==btnTotal)
			{
				try{
				connect = konek_database.getKonekDB();
				state = connect.createStatement();
				result = state.executeQuery("select count(*) from pasien_rawat_inap");
				
				while(result.next())
				{
					Object obj[] = new Object[1];
					obj[0] = result.getString(1);
					
					JOptionPane.showMessageDialog(null,obj,"Total data yang sudah masuk",JOptionPane.INFORMATION_MESSAGE);
				}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol total : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource()==btnRefresh1)
			{
				kembali();
			}
			else if(e.getSource()==btnUbah)
			{
				tabRawatInap.setSelectedIndex(0);
				btnTambah.setEnabled(false);
				btnSimpan.setVisible(false);
				btnSimpanUbah.setVisible(true);
				btnBatal.setEnabled(true);
				txtNamaPenderita.setEditable(true);
				areaAlamat.setEditable(true);
				areaKeterangan.setEditable(true);
				tanggalMasuk.setEnabled(true);
				tanggalKeluar.setEnabled(true);
				radioPns.setEnabled(true);
				radioWiraswasta.setEnabled(true);
				radioPelajar.setEnabled(true);
				radioLainnya.setEnabled(true);
			}
				
				
			else if(e.getSource()==btnSimpanUbah)
			{
				String o = "";
				if(radioPns.isSelected())
				{
					o = "PNS";
				}
				else if(radioWiraswasta.isSelected())
				{
					o = "Wiraswasta";
				}
				else if(radioPelajar.isSelected())
				{
					o = "Pelajar";
				}
				else
				{
					o = "Lainnya";
				}
				
				int umur = comboUmur.getSelectedIndex() - 1;
				
				try
				{
					connect = konek_database.getKonekDB();
					ps = connect.prepareStatement("update pasien_rawat_inap set nama_penderita =?, umur=?, alamat=?,sttus=?,pekerjaan=?,tanggal_masuk=?,tanggal_keluar=?,lama=?,ruang_perawatan=?,diagnosa=?,keterangan=? where no_reg = ?");
					
					ps.setString(1, txtNamaPenderita.getText());
					ps.setInt(2, umur);
					ps.setString(3, areaAlamat.getText());
					ps.setString(4, (String) comboStatus.getSelectedItem());
					ps.setString(5, o);
					ps.setString(6, (String) tanggalMasuk.getSelectedItem());
					ps.setString(7, (String) tanggalKeluar.getSelectedItem());
					ps.setInt(8, Integer.parseInt(lblResultLama.getText()));
					ps.setString(9, (String) comboRuangPerawatan.getSelectedItem());
					ps.setString(10, areaDiagnosa.getText());
					ps.setString(11, areaKeterangan.getText());
					ps.setString(12, txtNoReg.getText());
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data berhasil diubah");
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol simpan perubahan : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
				finally
				{
					tampilTabel();
					kembali();
					tabRawatInap.setSelectedIndex(1);
				}
			}
			else if(e.getSource()==btnHapus)
			{
				try
				{
					connect = konek_database.getKonekDB();
					ps = connect.prepareStatement("delete from pasien_rawat_inap where no_reg = ?");
					
					ps.setInt(1, Integer.parseInt(txtNoReg.getText()));
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol hapus : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
				finally
				{
					tampilTabel();
					kembali();
				}
			}
		}
	}
	
	void kembali()
	{
		btnTambah.setEnabled(true);
		btnSimpan.setEnabled(false);
		btnBatal.setEnabled(false);
		txtNamaPenderita.setEditable(false);
		comboUmur.setEnabled(false);
		areaAlamat.setEditable(false);
		comboStatus.setEnabled(false);
		radioPns.setEnabled(false);
		radioWiraswasta.setEnabled(false);
		radioPelajar.setEnabled(false);
		radioLainnya.setEnabled(false);
		tanggalMasuk.setEnabled(false);
		tanggalKeluar.setEnabled(false);
		lblResultLama.setText("");
		comboRuangPerawatan.setEnabled(false);
		areaDiagnosa.setEditable(false);
		areaKeterangan.setEditable(false);
		txtNamaPenderita.setText("");
		areaAlamat.setText("");
		areaDiagnosa.setText("");
		areaKeterangan.setText("");
		txtNoReg.setText("");
		comboRuangPerawatan.setSelectedIndex(0);
		comboStatus.setSelectedIndex(0);
		comboUmur.setSelectedIndex(0);
		kodePenyakit.setSelectedIndex(0);
		kodePenyakit.setEnabled(false);
		txtNoReg.setEditable(false);
		btnUbah.setEnabled(false);
		btnHapus.setEnabled(false);
		btnReport.setEnabled(true);
		btnTotal.setEnabled(true);
		radioPns.setSelected(true);
		btnSimpanUbah.setVisible(false);
		btnRefresh1.setEnabled(false);
		btnSimpan.setVisible(true);
	

	}
	
	void tampilTabel()
	{
		modelTabelPasienRawatInap.getDataVector().removeAllElements();
		modelTabelPasienRawatInap.fireTableDataChanged();
		try
		{
			connect = konek_database.getKonekDB();
			state = connect.createStatement();
			result = state.executeQuery("select * from pasien_rawat_inap");
			
			while(result.next())
			{
				Object obj[] = new Object[12];
				obj[0] = result.getInt(1);
				obj[1] = result.getString(2);
				obj[2] = result.getInt(3);
				obj[3] = result.getString(4);
				obj[4] = result.getString(5);
				obj[5] = result.getString(6);
				obj[6] = result.getDate(7);
				obj[7] = result.getDate(8);
				obj[8] = result.getInt(9);
				obj[9] = result.getString(10);
				obj[10] = result.getString(11);
				obj[11] = result.getString(12);
				
				modelTabelPasienRawatInap.addRow(obj);
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tampil tabel : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	void item()
	{
		comboUmur.addItem("-- Pilih Tahun --");
		for(int i = 0;i<1200;i++)
		{
			comboUmur.addItem(i+" Tahun");
		}
		
		comboRuangPerawatan.addItem("-- Pilih Ruang Perawatan --");
		comboRuangPerawatan.addItem("Melati");
		comboRuangPerawatan.addItem("Mawar");
		comboRuangPerawatan.addItem("Kamboja");
		
		comboStatus.addItem("-- Pilih Status --");
		comboStatus.addItem("Menikah");
		comboStatus.addItem("Lajang");
		
		kodePenyakit.addItem("-- Pilih Kode Penyakit --");
		try
		{
			connect = konek_database.getKonekDB();
			state = connect.createStatement();
			result = state.executeQuery("select no_dtd from jenis_penyakit");
			
			while(result.next())
			{
				String o = result.getString(1);
				kodePenyakit.addItem(o);
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada kode penyakit : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
		}
		
		tanggalKeluar.addDateListener(new DateListener()
		{
			@Override
			public void dateChanged(DateEvent arg0) {
				// TODO Auto-generated method stub
				
				/**
				 * Pembuatan silisih waktu pada Lama (hari)
				 */
				Date tanggal_masuk = tanggalMasuk.getDate();
				Date tanggal_keluar = tanggalKeluar.getDate();
				
				try
				{
					long hariPertama = tanggal_masuk.getTime();
					long hariTerakhir = tanggal_keluar.getTime();
					long selisih = hariTerakhir-hariPertama;
					long lama = selisih / (24*60*60*1000);
					
					lblResultLama.setText(Long.toString(lama));
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada konversi waktu : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		}
		
				);
		

		//pembuatan isi area diagnosa secara otomatis
		kodePenyakit.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{

				if(kodePenyakit.getSelectedIndex()==0)
				{
					return;
				}
				else
				{
			
					String i = (String) kodePenyakit.getSelectedItem();
					try
					{
						connect = konek_database.getKonekDB();
						state = connect.createStatement();
						result = state.executeQuery("select macam_penyakit from jenis_penyakit where no_dtd="+i+"");
						
						if(result.next()){
							String u = result.getString(1);
							areaDiagnosa.setText(u);
						}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Terjadi "
								+ "kesalahan pada kode penyakit: "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
					}
				}
		
			
				
		
			}
			});
		

	}
	
	public void ambilData()
	{
		int i = tabelPasienRawatInap.getSelectedRow();
		
		if(i==-1)
		{
			return;
		}
		
		int ambilNoReg = (int) modelTabelPasienRawatInap.getValueAt(i, 0);
		txtNoReg.setText(""+ambilNoReg);
		
		String ambilNamaPasien = (String) modelTabelPasienRawatInap.getValueAt(i, 1);
		txtNamaPenderita.setText(ambilNamaPasien);
		
		int ambilUmur = (int) modelTabelPasienRawatInap.getValueAt(i, 2);
		comboUmur.setSelectedIndex(ambilUmur+1);
		
		String ambilAlamat = (String) modelTabelPasienRawatInap.getValueAt(i, 3);
		areaAlamat.setText(ambilAlamat);
		
		String ambilStatus = (String) modelTabelPasienRawatInap.getValueAt(i, 4);
		comboStatus.setSelectedItem(ambilStatus);
		
		String ambilPekerjaan = (String) modelTabelPasienRawatInap.getValueAt(i, 5);
		//belum dbuat
		
		Date ambilTanggalMasuk = (Date) modelTabelPasienRawatInap.getValueAt(i, 6);
		tanggalMasuk.setDate(ambilTanggalMasuk);
		
		Date ambilTanggalKeluar = (Date) modelTabelPasienRawatInap.getValueAt(i, 7);
		tanggalKeluar.setDate(ambilTanggalKeluar);
		
		int ambilResultLama = (int) modelTabelPasienRawatInap.getValueAt(i, 8);
		lblResultLama.setText(""+ambilResultLama);
		
		String ambilRuangPerawatan = (String) modelTabelPasienRawatInap.getValueAt(i, 9);
		comboRuangPerawatan.setSelectedItem(ambilRuangPerawatan);
		
		String ambilDiagnosa = (String) modelTabelPasienRawatInap.getValueAt(i, 10);
		areaDiagnosa.setText(ambilDiagnosa);
		
		
		String ambilTindakan = (String) modelTabelPasienRawatInap.getValueAt(i, 11);
		areaKeterangan.setText(ambilTindakan);
	}
	

}
