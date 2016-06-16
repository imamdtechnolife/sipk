package com.sipk;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;

import java.io.*;
 
public class jenis_penyakit extends JPanel {

	 JPanel panel_inputJP = new JPanel();
	 JLabel lblnoDTD = new JLabel("No. DTD : ");
	 JLabel lblkoma_noDTD = new JLabel("       Koma : ");
	 JLabel lblnoDTDasli = new JLabel("No. DTD (asli)");
	 JLabel txtRekap_noDTD = new JLabel();
	 JLabel komDTD = new JLabel();
	 JRadioButton satu = new JRadioButton("1");
	 JRadioButton dua = new JRadioButton("2");
	 JRadioButton tiga = new JRadioButton("3");
	 JRadioButton empat = new JRadioButton("4");
	 JRadioButton lima = new JRadioButton("5");
	 JRadioButton enam = new JRadioButton("6");
	 JRadioButton tujuh = new JRadioButton("7");
	 JRadioButton delapan = new JRadioButton("8");
	 JRadioButton sembilan = new JRadioButton("9");
	 JRadioButton nol = new JRadioButton("0");
	 JRadioButton kosongDTD = new JRadioButton("(Kosong)");
	 JPanel panel_kosong1 = new JPanel();
	 JPanel panel_daftarTerperinci1 = new JPanel();
	 JPanel panel_daftarTerperinci2 = new JPanel();
	 JPanel panel_macamPenyakit = new JPanel();
	 JComboBox combo_noDTD = new JComboBox();
	 JComboBox combo_noDT1 = new JComboBox();
	 JComboBox combo_noDT2 = new JComboBox();
	 JComboBox combo_hurufDT1 = new JComboBox();
	 JComboBox combo_hurufDT2 = new JComboBox();
	 JTextField txtDT2 = new JTextField(5);
	 JRadioButton DT1_satu = new JRadioButton("1");
	 JRadioButton DT1_dua = new JRadioButton("2");
	 JRadioButton DT1_tiga = new JRadioButton("3");
	 JRadioButton DT1_empat = new JRadioButton("4");
	 JRadioButton DT1_lima = new JRadioButton("5");
	 JRadioButton DT1_enam = new JRadioButton("6");
	 JRadioButton DT1_tujuh = new JRadioButton("7");
	 JRadioButton DT1_delapan = new JRadioButton("8");
	 JRadioButton DT1_sembilan = new JRadioButton("9");
	 JRadioButton DT1_kosong = new JRadioButton("(Kosong)");
	 JRadioButton DT1_nol = new JRadioButton("0");
	 JRadioButton DT2_satu = new JRadioButton("1");
	 JRadioButton DT2_dua = new JRadioButton("2");
	 JRadioButton DT2_tiga = new JRadioButton("3");
	 JRadioButton DT2_empat = new JRadioButton("4");
	 JRadioButton DT2_lima = new JRadioButton("5");
	 JRadioButton DT2_enam = new JRadioButton("6");
	 JRadioButton DT2_tujuh = new JRadioButton("7");
	 JRadioButton DT2_delapan = new JRadioButton("8");
	 JRadioButton DT2_sembilan = new JRadioButton("9");
	 JRadioButton DT2_nol = new JRadioButton("0");
	 JRadioButton DT2_kosong = new JRadioButton("(kosong)");
	 JTextField txtRekapDT = new JTextField(5);
	 JLabel hurufDT1 = new JLabel();
	 JLabel angkaDT1 = new JLabel();
	 JLabel komaDT1 = new JLabel();
	 JLabel lblKodeHurufDT1 = new JLabel("Kode Huruf : ");
	 JLabel lblKodeHurufDT2 = new JLabel("Kode Huruf : ");
	 JLabel lblKodeKomaDT1 = new JLabel("Kode Koma : ");
	 JLabel lblKodeKomaDT2 = new JLabel("Kode Koma : ");
	 JLabel lblKodeAngkaDT1 = new JLabel("      Kode Angka : ");
	 JLabel lblKodeAngkaDT2 = new JLabel("      Kode Angka : ");
	 JTextArea txtAreaMacamPenyakit = new JTextArea(2,150);
	 JScrollPane scrolltxtarea = new JScrollPane(txtAreaMacamPenyakit);
	 JButton btnTambah = new JButton("Tambah");
	 JButton btnSimpan = new JButton("Simpan");
	 JButton btnBatal = new JButton("Batal");
	 JButton btnUbah = new JButton("Ubah");
	 JButton btnHapus = new JButton("Hapus");
	 JButton btnCari = new JButton("Cari");
	 JButton btnRefresh = new JButton("Refresh");
	 JButton btnTotalJP = new JButton("Total");
	 JButton btnReport = new JButton("Cetak");
	 String fieldJP[] = {"No. DTD", "No. Daftar Terperinci (ICD-10)","Macam Penyakit"};
	 DefaultTableModel modelTabelJP = new DefaultTableModel(null,fieldJP);
	 JTable tabelJP = new JTable();
	 JScrollPane scroll = new JScrollPane();
	 JTabbedPane tab = new JTabbedPane();
	//Container konten = getContentPane();
	 Font fontJudul = new Font("Bookman Old Style", Font.BOLD, 20);
	 JLabel judulJP = new JLabel("Jenis Penyakit");
	 ButtonGroup grupDTD = new ButtonGroup();
	 ButtonGroup grupDT1 = new ButtonGroup();
	 ButtonGroup grupDT2 = new ButtonGroup();
	private Connection connect;
	private Statement state;
	private ResultSet result;
	private JLabel rekapDTD = new JLabel();
	 JTextField txtPencarianMP = new JTextField(15);
	 JPanel panelPencarianMP = new JPanel();
	 JPanel panelTombolEkstra = new JPanel();
	 JButton btnSampai = new JButton("Sampai");
	 JButton btnDan = new JButton("Dan");
	 JTextField rekapDT2 = new JTextField("Rekap DT2");
	 JLabel hurufDT2 = new JLabel();
	 JLabel angkaDT2 = new JLabel();
	 JLabel komaDT2 = new JLabel();
	boolean i;
	 JPanel panelRincian = new JPanel();
	 JPanel panelDT22 = new JPanel();
	 JPanel panelGabungDT2 = new JPanel();
	 JComboBox comboSampaiDan = new JComboBox();
	 JLabel rekapDT = new JLabel();
		
	public jenis_penyakit()
	{
		//super("Jenis Penyakit");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(jenis_penyakit.class.getResource("Image/address-book-new.png")));
		
		//no. DTD
		panel_inputJP.setLayout(new FlowLayout());
		panel_inputJP.setBorder(BorderFactory.createTitledBorder("Input No. DTD"));
		panel_inputJP.add(lblnoDTD);
		for(int i = 0 ;i<1000;i++)
		{
			combo_noDTD.addItem(i);
		}
		
		combo_noDTD.addItemListener(new ItemListener()
				{

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				int i = combo_noDTD.getSelectedIndex();
				
				if(i<10)
				{
				String im = String.format("00%s", combo_noDTD.getSelectedObjects());
				
				txtRekap_noDTD.setText(im);
				}
				else if(i<100)
				{
					String im = String.format("0%s", combo_noDTD.getSelectedObjects());
					
					txtRekap_noDTD.setText(im);
				}else
				{
					String im = String.format("%s", combo_noDTD.getSelectedObjects());
					
					txtRekap_noDTD.setText(im);
				}
			}
				});
		
		hendling hendler = new hendling();
		nol.addItemListener(hendler);
		satu.addItemListener(hendler);
		dua.addItemListener(hendler);
		tiga.addItemListener(hendler);
		empat.addItemListener(hendler);
		lima.addItemListener(hendler);
		enam.addItemListener(hendler);
		tujuh.addItemListener(hendler);
		delapan.addItemListener(hendler);
		sembilan.addItemListener(hendler);
		kosongDTD.addItemListener(hendler);
		
		
		panel_inputJP.add(combo_noDTD);
		panel_inputJP.add(lblkoma_noDTD);
		panel_inputJP.add(nol);
		panel_inputJP.add(satu);
		panel_inputJP.add(dua);
		panel_inputJP.add(tiga);
		panel_inputJP.add(empat);
		panel_inputJP.add(lima);
		panel_inputJP.add(enam);
		panel_inputJP.add(tujuh);
		panel_inputJP.add(delapan);
		panel_inputJP.add(sembilan);
		panel_inputJP.add(kosongDTD);
		grupDTD.add(nol);
		grupDTD.add(satu);
		grupDTD.add(dua);
		grupDTD.add(tiga);
		grupDTD.add(empat);
		grupDTD.add(lima);
		grupDTD.add(enam);
		grupDTD.add(tujuh);
		grupDTD.add(delapan);
		grupDTD.add(sembilan);
		grupDTD.add(kosongDTD);
		
		//Daftar Terperinci tunggal (ICD - 10)
		panel_daftarTerperinci1.setLayout(new FlowLayout());
		panel_daftarTerperinci1.add(lblKodeHurufDT1);
		for(int i=0;i<1000;i++)
		{
			combo_noDT1.addItem(i);
		}
		
		combo_noDT1.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				int i = combo_noDT1.getSelectedIndex();
				
				if(i<10)
				{
				String im = String.format("0%s", combo_noDT1.getSelectedObjects());
				angkaDT1.setText(im);
				}
				else
				{
					String im = String.format("%s", combo_noDT1.getSelectedObjects());
					angkaDT1.setText(im);
				}
			
		}
		}
				);
		
		combo_hurufDT1.addItem("A");
		combo_hurufDT1.addItem("B");
		combo_hurufDT1.addItem("C");
		combo_hurufDT1.addItem("D");
		combo_hurufDT1.addItem("E");
		combo_hurufDT1.addItem("F");
		combo_hurufDT1.addItem("G");
		combo_hurufDT1.addItem("H");
		combo_hurufDT1.addItem("I");
		combo_hurufDT1.addItem("J");
		combo_hurufDT1.addItem("K");
		combo_hurufDT1.addItem("L");
		combo_hurufDT1.addItem("M");
		combo_hurufDT1.addItem("N");
		combo_hurufDT1.addItem("O");
		combo_hurufDT1.addItem("P");
		combo_hurufDT1.addItem("Q");
		combo_hurufDT1.addItem("R");
		combo_hurufDT1.addItem("S");
		combo_hurufDT1.addItem("T");
		combo_hurufDT1.addItem("U");
		combo_hurufDT1.addItem("V");
		combo_hurufDT1.addItem("W");
		combo_hurufDT1.addItem("X");
		combo_hurufDT1.addItem("Y");
		combo_hurufDT1.addItem("Z");
		
		combo_hurufDT1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{		
				hurufDT1.setText((String) combo_hurufDT1.getSelectedItem());	
			}
		}
				);
		
		panel_daftarTerperinci1.add(combo_hurufDT1);
		panel_daftarTerperinci1.add(lblKodeAngkaDT1);
		panel_daftarTerperinci1.add(combo_noDT1);
		
		JPanel panel_DT11 = new JPanel();
		panel_DT11.setLayout(new FlowLayout());
		panel_DT11.add(lblKodeKomaDT1);
		panel_DT11.add(DT1_nol);
		panel_DT11.add(DT1_satu);
		panel_DT11.add(DT1_dua);
		panel_DT11.add(DT1_tiga);
		panel_DT11.add(DT1_empat);
		panel_DT11.add(DT1_lima);
		panel_DT11.add(DT1_enam);
		panel_DT11.add(DT1_tujuh);
		panel_DT11.add(DT1_delapan);
		panel_DT11.add(DT1_sembilan);
		panel_DT11.add(DT1_kosong);
		
		comboSampaiDan.addItem("Sampai");
		comboSampaiDan.addItem("Dan");
		
		comboSampaiDan.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				int o = comboSampaiDan.getSelectedIndex();
				
				if(0==1)
				{
					i = true;
				}
				else
				{
					i = false;
				}
			}
		}
				);
	
		grupDT1.add(DT1_nol);
		grupDT1.add(DT1_satu);
		grupDT1.add(DT1_dua);
		grupDT1.add(DT1_tiga);
		grupDT1.add(DT1_empat);
		grupDT1.add(DT1_lima);
		grupDT1.add(DT1_enam);
		grupDT1.add(DT1_tujuh);
		grupDT1.add(DT1_delapan);
		grupDT1.add(DT1_sembilan);
		grupDT1.add(DT1_kosong);
		
		itemComboDT1 objComboDT1 = new itemComboDT1();
		DT1_nol.addItemListener(objComboDT1);
		DT1_satu.addItemListener(objComboDT1);
		DT1_dua.addItemListener(objComboDT1);
		DT1_tiga.addItemListener(objComboDT1);
		DT1_empat.addItemListener(objComboDT1);
		DT1_lima.addItemListener(objComboDT1);
		DT1_enam.addItemListener(objComboDT1);
		DT1_tujuh.addItemListener(objComboDT1);
		DT1_delapan.addItemListener(objComboDT1);
		DT1_sembilan.addItemListener(objComboDT1);
		DT1_kosong.addItemListener(objComboDT1);
		
		JPanel panelGabungDT1 = new JPanel();
		panelGabungDT1.setBorder(BorderFactory.createTitledBorder("Daftar Terperinci"));
		panelGabungDT1.setLayout(new GridLayout(2,1));
		panelGabungDT1.add(panel_daftarTerperinci1);
		panelGabungDT1.add(panel_DT11);
	
		
		//Daftar Terperinci panjang (ICD - 10)
		panel_daftarTerperinci2.setLayout(new FlowLayout());
		panel_daftarTerperinci2.add(lblKodeHurufDT2);
		
		combo_noDT2.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				int i = combo_noDT2.getSelectedIndex();
				
				if(i<10)
				{
				String im = String.format("0%s", combo_noDT2.getSelectedObjects());
				angkaDT2.setText(im);
				}
				else
				{
					String im = String.format("%s", combo_noDT2.getSelectedObjects());
					angkaDT2.setText(im);
				}
			}	
		}
				);
		
		combo_hurufDT2.addItem("A");
		combo_hurufDT2.addItem("B");
		combo_hurufDT2.addItem("C");
		combo_hurufDT2.addItem("D");
		combo_hurufDT2.addItem("E");
		combo_hurufDT2.addItem("F");
		combo_hurufDT2.addItem("G");
		combo_hurufDT2.addItem("H");
		combo_hurufDT2.addItem("I");
		combo_hurufDT2.addItem("J");
		combo_hurufDT2.addItem("K");
		combo_hurufDT2.addItem("L");
		combo_hurufDT2.addItem("M");
		combo_hurufDT2.addItem("N");
		combo_hurufDT2.addItem("O");
		combo_hurufDT2.addItem("P");
		combo_hurufDT2.addItem("Q");
		combo_hurufDT2.addItem("R");
		combo_hurufDT2.addItem("S");
		combo_hurufDT2.addItem("T");
		combo_hurufDT2.addItem("U");
		combo_hurufDT2.addItem("V");
		combo_hurufDT2.addItem("W");
		combo_hurufDT2.addItem("X");
		combo_hurufDT2.addItem("Y");
		combo_hurufDT2.addItem("Z");
		
		combo_hurufDT2.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				hurufDT2.setText((String) combo_hurufDT2.getSelectedItem());
			}
		}
				);
		
		for(int i = 0; i<1000; i++)
		{
			combo_noDT2.addItem(i);
		}
		
		panel_daftarTerperinci2.add(combo_hurufDT2);		
		panel_daftarTerperinci2.add(lblKodeAngkaDT2);
		panel_daftarTerperinci2.add(combo_noDT2);
		
		panelDT22.setLayout(new FlowLayout());
		panelDT22.add(lblKodeKomaDT2);
		panelDT22.add(DT2_nol);
		panelDT22.add(DT2_satu);
		panelDT22.add(DT2_dua);
		panelDT22.add(DT2_tiga);
		panelDT22.add(DT2_empat);
		panelDT22.add(DT2_lima);
		panelDT22.add(DT2_enam);
		panelDT22.add(DT2_tujuh);
		panelDT22.add(DT2_delapan);
		panelDT22.add(DT2_sembilan);
		panelDT22.add(DT2_kosong);
		grupDT2.add(DT2_nol);
		grupDT2.add(DT2_satu);
		grupDT2.add(DT2_dua);
		grupDT2.add(DT2_tiga);
		grupDT2.add(DT2_empat);
		grupDT2.add(DT2_lima);
		grupDT2.add(DT2_enam);
		grupDT2.add(DT2_tujuh);
		grupDT2.add(DT2_delapan);
		grupDT2.add(DT2_sembilan);
		grupDT2.add(DT2_kosong);
		
		combo_noDT2.setEnabled(false);
		combo_hurufDT2.setEnabled(false);
		DT2_nol.setEnabled(false);
		DT2_satu.setEnabled(false);
		DT2_dua.setEnabled(false);
		DT2_tiga.setEnabled(false);
		DT2_empat.setEnabled(false);
		DT2_lima.setEnabled(false);
		DT2_enam.setEnabled(false);
		DT2_tujuh.setEnabled(false);
		DT2_delapan.setEnabled(false);
		DT2_sembilan.setEnabled(false);
		DT2_kosong.setEnabled(false);
		
		itemComboDT2 hendelDT2 = new itemComboDT2();
		DT2_nol.addItemListener(hendelDT2);
		DT2_satu.addItemListener(hendelDT2);
		DT2_dua.addItemListener(hendelDT2);
		DT2_tiga.addItemListener(hendelDT2);
		DT2_empat.addItemListener(hendelDT2);
		DT2_lima.addItemListener(hendelDT2);
		DT2_enam.addItemListener(hendelDT2);
		DT2_tujuh.addItemListener(hendelDT2);
		DT2_delapan.addItemListener(hendelDT2);
		DT2_sembilan.addItemListener(hendelDT2);
		DT2_kosong.addItemListener(hendelDT2);
		
		panelGabungDT2.setLayout(new GridLayout(2,1));
		panelGabungDT2.setBorder(BorderFactory.createTitledBorder("Daftar Terperinci Lanjutan"));
		panelGabungDT2.add(panel_daftarTerperinci2);
		panelGabungDT2.add(panelDT22);
		
		
		//Macam Penyakit
		panel_macamPenyakit.setLayout(new FlowLayout());
		panel_macamPenyakit.setBorder(BorderFactory.createTitledBorder("Macam Penyakit"));
		panel_macamPenyakit.add(scrolltxtarea);
		
		//Tombol Ekstra
		panelTombolEkstra.setLayout(new FlowLayout());
		panelTombolEkstra.add(btnReport);
		panelTombolEkstra.add(btnTotalJP);
		panelTombolEkstra.add(btnRefresh);
		
		//Pencarian macam penyakit
		JPanel panelPencarian = new JPanel();
		panelPencarian.setLayout(new FlowLayout());
		panelPencarian.add(txtPencarianMP);
		panelPencarian.add(btnCari);
		
		//Tombol Ekstra dan pencarian
		JPanel panelEP = new JPanel();
		panelEP.setLayout(new GridLayout(2,0));
		panelEP.setBorder(BorderFactory.createTitledBorder("Ekstra"));
		panelEP.add(panelTombolEkstra);
		panelEP.add(panelPencarian);
		
		
		//Tombol Utama
		JPanel panelTombolUtama = new JPanel();
		panelTombolUtama.setBorder(BorderFactory.createTitledBorder("Tombol Aksi"));
		panelTombolUtama.add(btnTambah);
		panelTombolUtama.add(btnSimpan);
		panelTombolUtama.add(btnBatal);
		panelTombolUtama.add(btnUbah);
		panelTombolUtama.add(btnHapus);
		
		JPanel panelGroupTombol = new JPanel(new GridLayout(1,2));
		panelGroupTombol.add(panelTombolUtama);
		panelGroupTombol.add(panelEP);
		
		
		//Tabel Jenis Penyakit
		tabelJP.setModel(modelTabelJP);
		tabelJP.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tabelJP.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				tambah();
				ambilJP();
				
			}
		}
				);
		
		scroll.getViewport().add(tabelJP);
		JPanel panelTabelJP = new JPanel();
		panelTabelJP.setLayout(new BorderLayout());
		panelTabelJP.add(scroll);
		
		JPanel panelDT = new JPanel();
		panelDT.setLayout(new GridLayout(1,2));
		panelDT.add(panelGabungDT1);
		panelDT.add(panelGabungDT2);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,1));
		panel1.add(panel_inputJP);
		panel1.add(panelDT);
		panel1.add(panel_macamPenyakit);
		panel1.add(panelGroupTombol);
		
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		panel3.add(panel1);
		panel3.add(panelTabelJP);

		
		tab.addTab("Jenis Penyakit",panel3);
		//tab.addTab("Laporan Jenis Penyakit",panelTabelJP );
		
		//konten.add(tab);
		add(tab);
		
		penghendel hendel = new penghendel();
		btnBatal.addActionListener(hendel);
		btnCari.addActionListener(hendel);
		btnHapus.addActionListener(hendel);
		btnRefresh.addActionListener(hendel);
		btnReport.addActionListener(hendel);
		btnSimpan.addActionListener(hendel);
		btnTambah.addActionListener(hendel);
		btnTotalJP.addActionListener(hendel);
		btnUbah.addActionListener(hendel);
		btnSampai.addActionListener(hendel);
		btnDan.addActionListener(hendel);
		
		tampilTabelJP();
		kembali();
		
	}
	
	private class itemComboDT2 implements ItemListener
	{
		public void itemStateChanged(ItemEvent e)
		{
			if(e.getSource()==DT2_nol)
			{
				
				komaDT2.setText(".0");
				
		
			}
			else if(e.getSource()==DT2_satu)
			{
				komaDT2.setText(".1");
				
				
			}
			else if(e.getSource()==DT2_dua)
			{
				komaDT2.setText(".2");
				
				
			}
			else if(e.getSource()==DT2_tiga)
			{
				komaDT2.setText(".3");
				
				
			}
			else if(e.getSource()==DT2_empat)
			{
				komaDT2.setText(".4");
				
			
			}
			else if(e.getSource()==DT2_lima)
			{
				komaDT2.setText(".5");
				
				
			}
			else if(e.getSource()==DT2_enam)
			{
				komaDT2.setText(".6");
				
				
			}
			else if(e.getSource()==DT2_tujuh)
			{
				komaDT2.setText(".7");
			
		
			}
			else if(e.getSource()==DT2_delapan)
			{
				komaDT2.setText(".8");
				
			
			}
			else if(e.getSource()==DT2_sembilan)
			{
				komaDT2.setText(".9");
				
				
			}
			else if(e.getSource()==DT2_kosong)
			{
				komaDT2.setText("");
			}
		}
	}
	
	private class itemComboDT1 implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==DT1_nol)
			{
				
				komaDT1.setText(".0");
				
		
			}
			else if(e.getSource()==DT1_satu)
			{
				komaDT1.setText(".1");
				
				
			}
			else if(e.getSource()==DT1_dua)
			{
				komaDT1.setText(".2");
				
				
			}
			else if(e.getSource()==DT1_tiga)
			{
				komaDT1.setText(".3");
				
				
			}
			else if(e.getSource()==DT1_empat)
			{
				komaDT1.setText(".4");
				
			
			}
			else if(e.getSource()==DT1_lima)
			{
				komaDT1.setText(".5");
				
				
			}
			else if(e.getSource()==DT1_enam)
			{
				komaDT1.setText(".6");
				
				
			}
			else if(e.getSource()==DT1_tujuh)
			{
				komaDT1.setText(".7");
			
		
			}
			else if(e.getSource()==DT1_delapan)
			{
				komaDT1.setText(".8");
				
			
			}
			else if(e.getSource()==DT1_sembilan)
			{
				komaDT1.setText(".9");
				
				
			}
			else if(e.getSource()==DT1_kosong)
			{
				komaDT1.setText("");
			}
		}
		
	}
	
	
	
	private class hendling implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
			
			if(e.getSource()==nol)
			{
				
				komDTD.setText(".0");
				
		
			}
			else if(e.getSource()==satu)
			{
				komDTD.setText(".1");
				
				
			}
			else if(e.getSource()==dua)
			{
				komDTD.setText(".2");
				
				
			}
			else if(e.getSource()==tiga)
			{
				komDTD.setText(".3");
				
				
			}
			else if(e.getSource()==empat)
			{
				komDTD.setText(".4");
				
			
			}
			else if(e.getSource()==lima)
			{
				komDTD.setText(".5");
				
				
			}
			else if(e.getSource()==enam)
			{
				komDTD.setText(".6");
				
				
			}
			else if(e.getSource()==tujuh)
			{
				komDTD.setText(".7");
			
		
			}
			else if(e.getSource()==delapan)
			{
				komDTD.setText(".8");
				
			
			}
			else if(e.getSource()==sembilan)
			{
				komDTD.setText(".9");
				
				
			}
			else if(e.getSource()==kosongDTD)
			{
				 komDTD.setText("");
			}
		}
		
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
				btnUbah.setEnabled(false);
				btnHapus.setEnabled(false);
				btnReport.setEnabled(false);
				btnTotalJP.setEnabled(false);
				btnRefresh.setEnabled(false);
				combo_noDTD.setEnabled(true);
				combo_hurufDT1.setEnabled(true);
				combo_noDT1.setEnabled(true);
				comboSampaiDan.setEnabled(true);
				txtAreaMacamPenyakit.setEditable(true);
				tabelJP.setEnabled(false);
				DT1_nol.setEnabled(true);
				DT1_satu.setEnabled(true);
				DT1_dua.setEnabled(true);
				DT1_tiga.setEnabled(true);
				DT1_empat.setEnabled(true);
				DT1_lima.setEnabled(true);
				DT1_enam.setEnabled(true);
				DT1_tujuh.setEnabled(true);
				DT1_delapan.setEnabled(true);
				DT1_sembilan.setEnabled(true);
				DT1_kosong.setEnabled(true);
				DT2_nol.setEnabled(true);
				DT2_satu.setEnabled(true);
				DT2_dua.setEnabled(true);
				DT2_tiga.setEnabled(true);
				DT2_empat.setEnabled(true);
				DT2_lima.setEnabled(true);
				DT2_enam.setEnabled(true);
				DT2_tujuh.setEnabled(true);
				DT2_delapan.setEnabled(true);
				DT2_sembilan.setEnabled(true);
				DT2_kosong.setEnabled(true);
				nol.setEnabled(true);
				satu.setEnabled(true);
				dua.setEnabled(true);
				tiga.setEnabled(true);
				empat.setEnabled(true);
				lima.setEnabled(true);
				enam.setEnabled(true);
				tujuh.setEnabled(true);
				delapan.setEnabled(true);
				sembilan.setEnabled(true);
				kosongDTD.setEnabled(true);
	
			}
			else if(e.getSource()==btnSimpan)
			{
				try
				{
					connect = konek_database.getKonekDB();
					PreparedStatement ps = connect.prepareStatement("insert into jenis_penyakit (no_dtd,no_daftar_terperinci,macam_penyakit) values(?,?,?)");
					
					String io = txtRekap_noDTD.getText() + komDTD.getText();
					
					
					if(i=true)
					{
						String ia = hurufDT1.getText() + angkaDT1.getText() + komaDT1.getText() + " - " + hurufDT2.getText() + angkaDT2.getText() + komaDT2.getText();
						
						ps.setString(1, io);
						ps.setString(2, ia);
						ps.setString(3, txtAreaMacamPenyakit.getText());
						ps.executeUpdate();
					}
					else
					{
						String iu = hurufDT1.getText() + angkaDT1.getText() + komaDT1.getText() + " , " + hurufDT2.getText() + angkaDT2.getText() + komaDT2.getText();
						ps.setString(1, io);
						ps.setString(2, iu);
						ps.setString(3, txtAreaMacamPenyakit.getText());
						ps.executeUpdate();
					
					}
					
					JOptionPane.showMessageDialog(null, "Data berhasil tersimpan");
					tampilTabelJP();
					kembali();
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol simpan : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			else if(e.getSource()==btnBatal)
			{
				kembali();
			}
			else if(e.getSource()==btnUbah)
			{
				String ia = hurufDT1.getText() + angkaDT1.getText() + komaDT1.getText();
				try
				{
				connect = konek_database.getKonekDB();
				PreparedStatement ps = connect.prepareStatement("update jenis_penyakit set no_daftar_terperinci=?, macam_penyakit=? where no_dtd=?");
				
				ps.setString(1, ia);
				ps.setString(2, txtAreaMacamPenyakit.getText());
				ps.setString(3, rekapDTD.getText());
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Data berhasil diubah");
				tampilTabelJP();
				kembali();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada tombol ubah"+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource()==btnHapus)
			{
				try
				{
				connect = konek_database.getKonekDB();
				PreparedStatement ps = connect.prepareStatement("delete from jenis_penyakit where no_DTD=?");
				
				ps.setString(1, rekapDTD.getText());
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
				tampilTabelJP();
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol hapus"+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource()==btnReport)
			{
				FileOutputStream file = null;
				try
				{
					connect = konek_database.getKonekDB();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol cetak : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
				
				JasperReportBuilder report = DynamicReports.report();
				report.columns(Columns.column("No. DTD","no_dtd", DataTypes.stringType()),
						Columns.column("No. Daftar Terperinci","nama_daftar_terperinci", DataTypes.stringType()),
						Columns.column("Macam Penyakit","macam_penyakit", DataTypes.stringType())
						);
				report.title(
						Components.text("List Jenis Penyakit")
						.setHorizontalAlignment(HorizontalAlignment.CENTER))
						.pageFooter(Components.pageXofY())
						.setDataSource("select no_dtd, no_daftar_terperinci, macam_penyakit from jenis_penyakit",konek_database.getKonekDB());
						
				try
				{
					report.show();	
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada pembuatan report: "+ex.getMessage(),"Pesan Error",JOptionPane.INFORMATION_MESSAGE);
				}finally
				{
					
				}
			}
			else if(e.getSource()==btnTotalJP)
			{
				try{
				connect = konek_database.getKonekDB();
				state = connect.createStatement();
				result = state.executeQuery("select count(*) from jenis_penyakit");
				
				while(result.next())
				{
					Object obj[] = new Object[1];
					obj[0] = result.getInt(1);
					
					JOptionPane.showMessageDialog(null,  obj, "Total data jenis penyakit yang sudah masuk",JOptionPane.INFORMATION_MESSAGE);
				}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol total : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(e.getSource()==btnRefresh)
			{
				kembali();
			}
			else if(e.getSource()==btnSampai)
			{
				dttambahan();
				i = true;
			}
			else if(e.getSource()==btnDan)
			{
				dttambahan();
				i = false;
			}
			else if(e.getSource()==btnCari)
			{
				modelTabelJP.getDataVector().removeAllElements();
				
				try
				{
				connect = konek_database.getKonekDB();
				state = connect.createStatement();
				result = state.executeQuery("select * from jenis_penyakit where macam_penyakit like '%"+txtPencarianMP.getText()+"%'");
				
				while(result.next())
				{
					Object obj[] = new Object[3];
					obj[0] = result.getString(1);
					obj[1] = result.getString(2);
					obj[2] = result.getString(3);
					
					modelTabelJP.addRow(obj);
				}
				
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol cari : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		}
		
	}
	
	public void dttambahan()
	{
		combo_hurufDT2.setEnabled(true);
		combo_noDT2.setEnabled(true);
		DT2_nol.setEnabled(true);
		DT2_satu.setEnabled(true);
		DT2_dua.setEnabled(true);
		DT2_tiga.setEnabled(true);
		DT2_empat.setEnabled(true);
		DT2_lima.setEnabled(true);
		DT2_enam.setEnabled(true);
		DT2_tujuh.setEnabled(true);
		DT2_delapan.setEnabled(true);
		DT2_sembilan.setEnabled(true);
		DT2_kosong.setEnabled(true);
	}
	
	public void tampilTabelJP()
	{
		modelTabelJP.getDataVector().removeAllElements();
		modelTabelJP.fireTableDataChanged();
		try
		{
			connect = konek_database.getKonekDB();
			state = connect.createStatement();
			result = state.executeQuery("select * from jenis_penyakit");
			
			while(result.next())
			{
				Object obj[] = new Object[3];
				obj[0] = result.getString(1);
				obj[1] = result.getString(2);
				obj[2] = result.getString(3);
				
				modelTabelJP.addRow(obj);
			}
			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "terjadi kesalahan pada tampil tabel : "+ex.getMessage());
		}
	}
	
	public void kembali()
	{
		btnTambah.setEnabled(true);
		btnSimpan.setEnabled(false);
		btnBatal.setEnabled(false);
		btnUbah.setEnabled(false);
		btnHapus.setEnabled(false);
		btnReport.setEnabled(true);
		btnTotalJP.setEnabled(true);
		btnRefresh.setEnabled(true);
		combo_noDTD.setEnabled(false);
		combo_hurufDT1.setEnabled(false);
		combo_noDT1.setEnabled(false);
		comboSampaiDan.setEnabled(false);
		txtAreaMacamPenyakit.setEditable(false);
		txtAreaMacamPenyakit.setText("");
		tabelJP.setEnabled(true);
		DT1_nol.setEnabled(false);
		DT1_satu.setEnabled(false);
		DT1_dua.setEnabled(false);
		DT1_tiga.setEnabled(false);
		DT1_empat.setEnabled(false);
		DT1_lima.setEnabled(false);
		DT1_enam.setEnabled(false);
		DT1_tujuh.setEnabled(false);
		DT1_delapan.setEnabled(false);
		DT1_sembilan.setEnabled(false);
		DT1_kosong.setEnabled(false);
		DT2_nol.setEnabled(false);
		DT2_satu.setEnabled(false);
		DT2_dua.setEnabled(false);
		DT2_tiga.setEnabled(false);
		DT2_empat.setEnabled(false);
		DT2_lima.setEnabled(false);
		DT2_enam.setEnabled(false);
		DT2_tujuh.setEnabled(false);
		DT2_delapan.setEnabled(false);
		DT2_sembilan.setEnabled(false);
		DT2_kosong.setEnabled(false);
		nol.setEnabled(false);
		satu.setEnabled(false);
		dua.setEnabled(false);
		tiga.setEnabled(false);
		empat.setEnabled(false);
		lima.setEnabled(false);
		enam.setEnabled(false);
		tujuh.setEnabled(false);
		delapan.setEnabled(false);
		sembilan.setEnabled(false);
		kosongDTD.setEnabled(false);
		combo_noDTD.setInheritsPopupMenu(false);
		grupDTD.setSelected(null, false);
	}
	
	public void ambilJP()
	{
		int i = tabelJP.getSelectedRow();

		
		if(i==-1)
		{
			return;
		}
		
		String ambilNoDTD = (String) modelTabelJP.getValueAt(i, 0);
		rekapDTD.setText(ambilNoDTD);
		
		String ambilNoDT = (String) modelTabelJP.getValueAt(i, 1);
		rekapDT.setText(ambilNoDT);
				
		String ambilMacamPenyakit = (String) modelTabelJP.getValueAt(i, 2);
		txtAreaMacamPenyakit.setText(ambilMacamPenyakit);
		
				
	}
	
	public void tambah()
	{
		btnTambah.setEnabled(false);
		btnSimpan.setEnabled(false);
		btnBatal.setEnabled(false);
		btnUbah.setEnabled(true);
		btnHapus.setEnabled(true);
		btnReport.setEnabled(false);
		btnTotalJP.setEnabled(false);
		btnRefresh.setEnabled(true);
		combo_noDTD.setEnabled(true);
		combo_hurufDT1.setEnabled(true);
		combo_noDT1.setEnabled(true);
		comboSampaiDan.setEnabled(true);
		txtAreaMacamPenyakit.setEditable(true);
		txtAreaMacamPenyakit.setText("");
		tabelJP.setEnabled(true);
		DT1_nol.setEnabled(true);
		DT1_satu.setEnabled(true);
		DT1_dua.setEnabled(true);
		DT1_tiga.setEnabled(true);
		DT1_empat.setEnabled(true);
		DT1_lima.setEnabled(true);
		DT1_enam.setEnabled(true);
		DT1_tujuh.setEnabled(true);
		DT1_delapan.setEnabled(true);
		DT1_sembilan.setEnabled(true);
		DT1_kosong.setEnabled(true);
		DT2_nol.setEnabled(true);
		DT2_satu.setEnabled(true);
		DT2_dua.setEnabled(true);
		DT2_tiga.setEnabled(true);
		DT2_empat.setEnabled(true);
		DT2_lima.setEnabled(true);
		DT2_enam.setEnabled(true);
		DT2_tujuh.setEnabled(true);
		DT2_delapan.setEnabled(true);
		DT2_sembilan.setEnabled(true);
		DT2_kosong.setEnabled(true);
		nol.setEnabled(true);
		satu.setEnabled(true);
		dua.setEnabled(true);
		tiga.setEnabled(true);
		empat.setEnabled(true);
		lima.setEnabled(true);
		enam.setEnabled(true);
		tujuh.setEnabled(true);
		delapan.setEnabled(true);
		sembilan.setEnabled(true);
		kosongDTD.setEnabled(true);
	}
}
