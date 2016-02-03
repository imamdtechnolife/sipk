package com.sipk;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendarCombo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class pasien_bersalin extends JFrame{
	JLabel lblNoReg = new JLabel("No. Registrasi");
	JTextField txtNoreg = new JTextField(15);
	JLabel lblNamaPenderita = new JLabel("Nama Penderita");
	JTextField txtNamaPenderita = new JTextField();
	JLabel lblUmur = new JLabel("Umur");
	JComboBox comboUmur = new JComboBox();
	JLabel lblAlamat = new JLabel("Alamat");
	JTextArea areaAlamat = new JTextArea(1,15);
	JLabel lblStatus = new JLabel("Status");
	JComboBox comboStatus = new JComboBox();
	JLabel lblPekerjaan = new JLabel("Pekerjaan");
	JRadioButton radioPNS = new JRadioButton("PNS");
	JRadioButton radioWiraswasta = new JRadioButton("Wiraswasta");
	JRadioButton radioPelajar = new JRadioButton("Pelajar");
	JRadioButton radioLainnya = new JRadioButton("Lainnya");
	JLabel lblTanggalMasuk = new JLabel("Tanggal Masuk");
	JCalendarCombo calTanggalMasuk = new JCalendarCombo();
	JLabel lblTanggalKeluar = new JLabel("Tanggal Keluar");
	JCalendarCombo calTanggalKeluar = new JCalendarCombo();
	JLabel lblLama = new JLabel("Lama (Hari)");
	JLabel lblResultLama = new JLabel();
	JLabel lblRuangPerawatan = new JLabel("Ruang Perawatan");
	JComboBox comboRuangPerawatan = new JComboBox();
	JLabel lblDiagnosa = new JLabel("Diagnosa");
	JComboBox comboKodeDTD = new JComboBox();
	JTextArea areaDiagnosa = new JTextArea();
	JLabel lblTindakan = new JLabel("Tindakan");
	JTextArea areaTindakan = new JTextArea();
	Icon iconTambah = new ImageIcon(getClass().getResource("Image/Tambah.png"));
	Icon iconSimpan = new ImageIcon(getClass().getResource("Image/Simpan.png"));
	Icon iconBatal = new ImageIcon(getClass().getResource("Image/Batal.png"));
	Icon iconReport = new ImageIcon(getClass().getResource("Image/Laporan.png"));
	Icon iconTotal = new ImageIcon(getClass().getResource("Image/Total.png"));
	Icon iconUbah = new ImageIcon(getClass().getResource("Image/Ubah.png"));
	Icon iconHapus = new ImageIcon(getClass().getResource("Image/Hapus.png"));
	Icon iconRefresh = new ImageIcon(getClass().getResource("Image/Refresh.png"));
	Font font = new Font("Bookman Old Style",Font.ROMAN_BASELINE, 14);
	JButton btnTambah = new JButton("Tambah", iconTambah);
	JButton btnSimpan = new JButton("Simpan", iconSimpan);
	JButton btnBatal = new JButton("Batal",iconBatal);
	JPanel masterInput = new JPanel();
	JPanel masterTombol = new JPanel();
	JTabbedPane tab = new JTabbedPane();
	Container konten = getContentPane();
	JLabel blank = new JLabel();
	Connection connect = null;
	Statement state = null;
	ResultSet result = null;
	PreparedStatement ps = null;
	String fieldPasienBersalin[] = {"No. Registrasi","Nama Penderita","Umur","Alamat","Status","Pekerjaan","Tanggal Masuk","Tanggal Keluar","Lama (Hari)","Ruang Perawatan","Diagnosa","Tindakan"};
	DefaultTableModel modelTabelPasienBersalin = new DefaultTableModel(null, fieldPasienBersalin);
	JTable tabelPasienBersalin = new JTable();
	JPanel masterTabel = new JPanel();
	JPanel masterTombolEkstra = new JPanel();
	JButton btnReport = new JButton("Cetak", iconReport);
	JButton btnTotal = new JButton("Total Data",iconTotal);
	JButton btnRefresh = new JButton("Refresh",iconRefresh);
	JButton btnUbah = new JButton("Ubah",iconUbah);
	JButton btnHapus = new JButton("Hapus",iconHapus);
	JButton btnSimpanUbah = new JButton("Simpan", iconSimpan);
	
	public pasien_bersalin()
	{
		super("Pasien Bersalin");
		setIconImage(Toolkit.getDefaultToolkit().getImage(pasien_bersalin.class.getResource("Image/address-book-new.png")));
		setLayout(new GridLayout(0,1));
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		lblAlamat.setFont(font);
		lblDiagnosa.setFont(font);
		lblLama.setFont(font);
		lblNamaPenderita.setFont(font);
		lblNoReg.setFont(font);
		lblPekerjaan.setFont(font);
		lblResultLama.setFont(font);
		lblRuangPerawatan.setFont(font);
		lblStatus.setFont(font);
		lblTanggalKeluar.setFont(font);
		lblTanggalMasuk.setFont(font);
		lblTindakan.setFont(font);
		lblUmur.setFont(font);
		txtNamaPenderita.setFont(font);
		txtNoreg.setFont(font);
		areaAlamat.setFont(font);
		areaDiagnosa.setFont(font);
		areaTindakan.setFont(font);
		calTanggalKeluar.setFont(font);
		calTanggalMasuk.setFont(font);
		comboKodeDTD.setFont(font);
		comboRuangPerawatan.setFont(font);
		comboStatus.setFont(font);
		comboUmur.setFont(font);
		radioLainnya.setFont(font);
		radioPelajar.setFont(font);
		radioPNS.setFont(font);
		radioWiraswasta.setFont(font);
		
		masterInput.setLayout(new GridLayout(13,2));
		masterInput.setBorder(BorderFactory.createTitledBorder("Input Pasien Bersalin"));
		masterInput.add(lblNoReg);
		masterInput.add(txtNoreg);
		masterInput.add(lblNamaPenderita);
		masterInput.add(txtNamaPenderita);
		masterInput.add(lblUmur);
		masterInput.add(comboUmur);
		masterInput.add(lblAlamat);
		JScrollPane scrollAlamat = new JScrollPane();
		scrollAlamat.getViewport().add(areaAlamat);
		masterInput.add(scrollAlamat);
		masterInput.add(lblStatus);
		masterInput.add(comboStatus);
		masterInput.add(lblPekerjaan);
		
		JPanel grupPekerjaan = new JPanel();
		grupPekerjaan.add(radioPNS);
		grupPekerjaan.add(radioWiraswasta);
		grupPekerjaan.add(radioPelajar);
		grupPekerjaan.add(radioLainnya);
		ButtonGroup radioPekerjaan = new ButtonGroup();
		radioPekerjaan.add(radioPNS);
		radioPekerjaan.add(radioWiraswasta);
		radioPekerjaan.add(radioPelajar);
		radioPekerjaan.add(radioLainnya);
		
		masterInput.add(grupPekerjaan);
		masterInput.add(lblTanggalMasuk);
		calTanggalMasuk.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		masterInput.add(calTanggalMasuk);
		masterInput.add(lblTanggalKeluar);
		calTanggalKeluar.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		calTanggalKeluar.addDateListener(new DateListener()
		{

			@Override
			public void dateChanged(DateEvent arg0) {
				// TODO Auto-generated method stub
				
				/**
				 * Pembuatan selisih waktu antara tanggal masuk dan tanggal keluar
				 */
				
				Date tanggalMasuk = calTanggalMasuk.getDate();
				Date tanggalKeluar = calTanggalKeluar.getDate();
				
				try
				{
					long awal = tanggalMasuk.getTime();
					long akhir = tanggalKeluar.getTime();
					long selisih = akhir-awal;
					long hasil = selisih / (24*60*60*1000);
					
					lblResultLama.setText(Long.toString(hasil));
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada pembuatan selisih waktu : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		masterInput.add(calTanggalKeluar);
		masterInput.add(lblLama);
		masterInput.add(lblResultLama);
		masterInput.add(lblRuangPerawatan);
		masterInput.add(comboRuangPerawatan);
		masterInput.add(lblDiagnosa);
		masterInput.add(comboKodeDTD);
		masterInput.add(blank);
		JScrollPane scrollDiagnosa = new JScrollPane(areaDiagnosa);
		masterInput.add(scrollDiagnosa);
		masterInput.add(lblTindakan);
		JScrollPane scrollTindakan = new JScrollPane(areaTindakan);
		masterInput.add(scrollTindakan);
		
		masterTombol.setLayout(new FlowLayout());
		masterTombol.setBorder(BorderFactory.createTitledBorder("TombolAksi"));
		masterTombol.add(btnTambah);
		masterTombol.add(btnSimpan);
		masterTombol.add(btnSimpanUbah);
		masterTombol.add(btnBatal);
		
		JPanel panelGabungInputdanTombol = new JPanel();
		panelGabungInputdanTombol.setLayout(new FlowLayout());
		panelGabungInputdanTombol.add(masterInput);
		panelGabungInputdanTombol.add(masterTombol);
		
		masterTabel.setLayout(new BorderLayout());
		tabelPasienBersalin.setModel(modelTabelPasienBersalin);
		tabelPasienBersalin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollTabel = new JScrollPane();
		scrollTabel.getViewport().add(tabelPasienBersalin);
		masterTabel.add(scrollTabel);
		tabelPasienBersalin.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				ambilData();
				txtNamaPenderita.setEditable(true);
				comboUmur.setEnabled(true);
				areaAlamat.setEditable(true);
				comboStatus.setEnabled(true);
				radioPNS.setEnabled(true);
				radioWiraswasta.setEnabled(true);
				radioPelajar.setEnabled(true);
				radioLainnya.setEnabled(true);
				calTanggalMasuk.setEnabled(true);
				calTanggalKeluar.setEnabled(true);
				comboRuangPerawatan.setEnabled(true);
				comboKodeDTD.setEnabled(true);
				areaDiagnosa.setEditable(true);
				areaTindakan.setEditable(true);
				btnTambah.setEnabled(false);
				btnSimpan.setEnabled(true);
				btnBatal.setEnabled(true);
				btnReport.setEnabled(false);
				btnTotal.setEnabled(false);
				btnUbah.setEnabled(true);
				btnHapus.setEnabled(true);
				btnRefresh.setEnabled(true);
			}
		});
		
		masterTombolEkstra.setLayout(new FlowLayout());
		masterTombolEkstra.setBorder(BorderFactory.createTitledBorder("Tombol Aksi"));
		masterTombolEkstra.add(btnReport);
		masterTombolEkstra.add(btnTotal);
		masterTombolEkstra.add(btnUbah);
		masterTombolEkstra.add(btnHapus);
		masterTombolEkstra.add(btnRefresh);
		
		JPanel panelGabungTabeldanTombol2 = new JPanel();
		panelGabungTabeldanTombol2.setLayout(new GridLayout(0,1));
		panelGabungTabeldanTombol2.add(masterTabel);
		panelGabungTabeldanTombol2.add(masterTombolEkstra);
		
		tab.addTab("Input Pasien Bersalin", panelGabungInputdanTombol);
		tab.addTab("Result", panelGabungTabeldanTombol2);
		konten.add(tab);
		
		penghendel hendel = new penghendel();
		btnTambah.addActionListener(hendel);
		btnSimpan.addActionListener(hendel);
		btnBatal.addActionListener(hendel);
		btnReport.addActionListener(hendel);
		btnTotal.addActionListener(hendel);
		btnUbah.addActionListener(hendel);
		btnHapus.addActionListener(hendel);
		btnRefresh.addActionListener(hendel);
		btnSimpanUbah.addActionListener(hendel);
		
		item();
		defolt();
		tampilTabel();
		
		
	}
	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnTambah)
			{
				
				try
				{
					connect = konek_database.getKonekDB();
					state = connect.createStatement();
					result = state.executeQuery("select no_reg from pasien_bersalin order by no_reg desc");
					
					if(result.next())
					{
						int ko = result.getInt(1) + 1;
						txtNoreg.setText(""+ko);
					}else
					{
						txtNoreg.setText("1");
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada pembuatan no reg otomatis"+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
				
				txtNamaPenderita.requestFocus();
				txtNamaPenderita.setEditable(true);
				comboUmur.setEnabled(true);
				areaAlamat.setEditable(true);
				comboStatus.setEnabled(true);
				radioPNS.setEnabled(true);
				radioWiraswasta.setEnabled(true);
				radioPelajar.setEnabled(true);
				radioLainnya.setEnabled(true);
				calTanggalMasuk.setEnabled(true);
				calTanggalKeluar.setEnabled(true);
				comboRuangPerawatan.setEnabled(true);
				comboKodeDTD.setEnabled(true);
				areaDiagnosa.setEditable(true);
				areaTindakan.setEditable(true);
				btnTambah.setEnabled(false);
				btnSimpan.setEnabled(true);
				btnBatal.setEnabled(true);
				areaDiagnosa.setText("");
				comboKodeDTD.setSelectedIndex(0);
				comboRuangPerawatan.setSelectedIndex(0);
				comboStatus.setSelectedIndex(0);
				comboUmur.setSelectedIndex(0);
					
			}
			else if(e.getSource()==btnSimpan)
			{
				String p = "";
				int i = comboUmur.getSelectedIndex();
				
				if(radioPNS.isSelected())
				{
					p = "PNS";
				}
				else if(radioWiraswasta.isSelected())
				{
					p = "Wiraswasta";
				}
				else if(radioPelajar.isSelected())
				{
					p = "Pelajar";
				}
				else if(radioLainnya.isSelected())
				{
					p = "Lainnya";
				}
				
				try
				{
					connect = konek_database.getKonekDB();
					ps = connect.prepareStatement("insert into pasien_bersalin (nama_penderita,umur,alamat,sttus,pekerjaan,tanggal_masuk,tanggal_keluar,lama,ruang_perawatan,diagnosa,tindakan) values (?,?,?,?,?,?,?,?,?,?,?)");
					
					ps.setString(1, txtNamaPenderita.getText());
					ps.setInt(2, i);
					ps.setString(3, areaAlamat.getText());
					ps.setString(4, (String) comboStatus.getSelectedItem());
					ps.setString(5, p);
					ps.setString(6, (String) calTanggalMasuk.getSelectedItem());
					ps.setString(7, (String) calTanggalKeluar.getSelectedItem());
					ps.setInt(8, Integer.parseInt(lblResultLama.getText()));
					ps.setString(9, (String) comboRuangPerawatan.getSelectedItem());
					ps.setString(10, areaDiagnosa.getText());
					ps.setString(11, areaTindakan.getText());
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data berhasil tersimpan","Sukses",JOptionPane.INFORMATION_MESSAGE);
					tampilTabel();
					defolt();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol simpan"+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource()==btnBatal)
			{
				defolt();
			}
			else if(e.getSource()==btnTotal)
			{
				try
				{
					connect = konek_database.getKonekDB();
					state = connect.createStatement();
					result = state.executeQuery("select count(*) from pasien_bersalin");
					
					while(result.next())
					{
						Object obj[] = new Object[1];
						obj[0] = result.getInt(1);
						
						JOptionPane.showMessageDialog(null, obj, "Total data yang sudah masuk",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol total data : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource()==btnUbah)
			{
				
				btnSimpan.setVisible(false);
				btnSimpanUbah.setVisible(true);
				tab.setSelectedIndex(0);
				
			}
			else if(e.getSource()==btnHapus)
			{
				try
				{
					connect = konek_database.getKonekDB();
					ps = connect.prepareStatement("delete from pasien_bersalin where no_reg=?");
					
					ps.setInt(1, (int) Integer.parseInt( txtNoreg.getText()));
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data berhasil dihapus","Pesan",JOptionPane.INFORMATION_MESSAGE);
					tampilTabel();
					defolt();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol hapus : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			else if(e.getSource()==btnRefresh)
			{
				defolt();
			}
			else if(e.getSource()==btnSimpanUbah)
			{
				int umur = comboUmur.getSelectedIndex() - 1;
				
				String  pekerjaan = "";
				
				if(radioPNS.isSelected())
				{
					pekerjaan = "PNS";
				}
				else if(radioWiraswasta.isSelected())
				{
					pekerjaan = "Wiraswasta";
				}
				else if(radioPelajar.isSelected())
				{
					pekerjaan = "Pelajar";
				}
				else if(radioLainnya.isSelected())
				{
					pekerjaan = "Lainnya";
				}
				try
				{
					connect = konek_database.getKonekDB();
					ps = connect.prepareStatement("update pasien_bersalin set nama_penderita=?, umur=?, alamat=?, sttus=?, pekerjaan=?, tanggal_masuk=?, tanggal_keluar=?, lama=?, ruang_perawatan=?, diagnosa=?, tindakan=? where no_reg=? ");
					
					ps.setString(1, txtNamaPenderita.getText());
					ps.setInt(2, umur);
					ps.setString(3, areaAlamat.getText());
					ps.setString(4, (String) comboStatus.getSelectedItem());
					ps.setString(5, pekerjaan);
					ps.setString(6, (String) calTanggalMasuk.getSelectedItem());
					ps.setString(7, (String) calTanggalKeluar.getSelectedItem());
					ps.setInt(8, (int) Integer.parseInt(lblResultLama.getText()));
					ps.setString(9, (String) comboRuangPerawatan.getSelectedItem());
					ps.setString(10, areaDiagnosa.getText());
					ps.setString(11, areaTindakan.getText());
					ps.setInt(12, (int) Integer.parseInt(txtNoreg.getText()));
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data berhasil diubah","Pesan",JOptionPane.INFORMATION_MESSAGE);
					tampilTabel();
					defolt();
					tab.setSelectedIndex(1);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol ubah simpan : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	public void defolt()
	{
		txtNoreg.setEditable(false);
		txtNamaPenderita.setEditable(false);
		comboUmur.setEnabled(false);
		areaAlamat.setEditable(false);
		comboStatus.setEnabled(false);
		radioPNS.setEnabled(false);
		radioWiraswasta.setEnabled(false);
		radioPelajar.setEnabled(false);
		radioLainnya.setEnabled(false);
		calTanggalMasuk.setEnabled(false);
		calTanggalKeluar.setEnabled(false);
		lblResultLama.setText("");
		comboRuangPerawatan.setEnabled(false);
		comboKodeDTD.setEnabled(false);
		areaDiagnosa.setEditable(false);
		areaTindakan.setEditable(false);
		txtNoreg.setText("");
		txtNamaPenderita.setText("");
		comboKodeDTD.setSelectedIndex(0);
		comboRuangPerawatan.setSelectedIndex(0);
		comboStatus.setSelectedIndex(0);
		comboUmur.setSelectedIndex(0);
		areaAlamat.setText("");
		areaDiagnosa.setText("");
		areaTindakan.setText("");
		btnTambah.setEnabled(true);
		btnSimpan.setEnabled(false);
		btnBatal.setEnabled(false);
		btnReport.setEnabled(true);
		btnTotal.setEnabled(true);
		btnUbah.setEnabled(false);
		btnHapus.setEnabled(false);
		btnRefresh.setEnabled(false);
		radioPNS.setSelected(true);
		btnSimpan.setVisible(true);
		btnSimpanUbah.setVisible(false);
	}
	
	public void item()
	{
		
		comboUmur.addItem("-- Pilih Tahun --");
		for(int i=0;i<1000;i++)
		{
			comboUmur.addItem(i+" Tahun");
		}
		
		comboStatus.addItem("-- Pilih Status --");
		comboStatus.addItem("Ibu Hamil");
		comboStatus.addItem("Ibu Nifas");
		comboStatus.addItem("Bayi");
		comboStatus.addItem("Anak-anak");
		
		comboRuangPerawatan.addItem("-- Pilih Ruang Perawatan --");
		comboRuangPerawatan.addItem("Mawar");
		comboRuangPerawatan.addItem("Melati");
		comboRuangPerawatan.addItem("Kamboja");
		
		comboKodeDTD.addItem("-- Pilih Kode Penyakit --");
		try
		{
			connect = konek_database.getKonekDB();
			state = connect.createStatement();
			result = state.executeQuery("select no_dtd from jenis_penyakit");
			
			while(result.next())
			{
				String k = result.getString(1);
				comboKodeDTD.addItem(k);
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada kode dtd","Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
		}
		
		//pembuatan area diagnosa otomatis
		comboKodeDTD.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				
				if(comboKodeDTD.getSelectedIndex()==0)
				{
					return;
				}
				else
				{
					String ndtd = (String) comboKodeDTD.getSelectedItem();
					try
					{
						connect  = konek_database.getKonekDB();
						state = connect.createStatement();
						result = state.executeQuery("select macam_penyakit from jenis_penyakit where no_dtd="+ndtd+"");
						
						if(result.next())
						{
							String isidiagnosa = result.getString(1);
							areaDiagnosa.setText(isidiagnosa);
						}
						else
						{
							areaDiagnosa.setText("kosong");
						}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada aksi comboDiagnosa"+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}
				);
	}
	
	public void tampilTabel()
	{
		modelTabelPasienBersalin.getDataVector().removeAllElements();
		modelTabelPasienBersalin.fireTableDataChanged();
		try
		{
			connect = konek_database.getKonekDB();
			state = connect.createStatement();
			result = state.executeQuery("select * from pasien_bersalin");
			
			while(result.next())
			{
				Object obj[] = new Object[12];
				obj[0] = result.getInt(1);//no registrasi
				obj[1] = result.getString(2);//nama penderita
				obj[2] = result.getInt(3);//umur
				obj[3] = result.getString(4);//alamat
				obj[4] = result.getString(5);//status
				obj[5] = result.getString(6);//pekerjaan
				obj[6] = result.getDate(7);//tanggal masuk
				obj[7] = result.getDate(8);//tanggal keluar
				obj[8] = result.getInt(9);//lama
				obj[9] = result.getString(10);//ruang perawatan
				obj[10] = result.getString(11);//diagnosa
				obj[11] = result.getString(12);//tindakan
				
				 modelTabelPasienBersalin.addRow(obj);
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tampil tabel","Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void ambilData()
	{
		int i = tabelPasienBersalin.getSelectedRow();
		
		if(i==-1)
		{
			return;
		}
		
		int ambilNoreg = (int) modelTabelPasienBersalin.getValueAt(i, 0);
		txtNoreg.setText(""+ambilNoreg);
		
		String ambilNamaPenderita = (String) modelTabelPasienBersalin.getValueAt(i, 1);
		txtNamaPenderita.setText(ambilNamaPenderita);
		
		int ambilUmur = (int) modelTabelPasienBersalin.getValueAt(i, 2);
		comboUmur.setSelectedIndex(ambilUmur+1);
		
		String ambilAlamat = (String) modelTabelPasienBersalin.getValueAt(i, 3);
		areaAlamat.setText(ambilAlamat);
		
		String ambilStatus = (String) modelTabelPasienBersalin.getValueAt(i, 4);
		comboStatus.setSelectedItem(ambilStatus);
		
		String ambilPekerjaan = (String) modelTabelPasienBersalin.getValueAt(i, 5);
		//kosong
		
		Date ambilTanggalMasuk = (Date) modelTabelPasienBersalin.getValueAt(i, 6);
		calTanggalMasuk.setSelectedItem(ambilTanggalMasuk);
		
		Date ambilTangglKeluar = (Date) modelTabelPasienBersalin.getValueAt(i, 7);
		calTanggalKeluar.setSelectedItem(ambilTangglKeluar);
		
		int ambilLama = (int) modelTabelPasienBersalin.getValueAt(i, 8);
		lblResultLama.setText(""+ambilLama);
		
		String ambilRuangPerawatan = (String) modelTabelPasienBersalin.getValueAt(i, 9);
		comboRuangPerawatan.setSelectedItem(ambilRuangPerawatan);
		
		String ambilDiagnosa = (String) modelTabelPasienBersalin.getValueAt(i, 10);
		areaDiagnosa.setText(ambilDiagnosa);
		
		String ambilTindakan = (String) modelTabelPasienBersalin.getValueAt(i, 11);
		areaTindakan.setText(ambilTindakan);
		
		
		
		
		
	}

}
