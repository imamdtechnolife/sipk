package com.sipk;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.*;
import java.io.*;
import java.sql.*;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelLaporan extends JPanel {
	
	private JButton btnLaporanJenisPenyakit; 
	private JButton btnLaporan10JnsPenyakit;
	private JButton btnLaporanRawatJalan;
	private JButton btnLaporanJnsPenyakitGigi;
	private JButton btnLaporanRawatInap;
	Connection konek = null;
	private JTable table;
	DefaultTableModel modelTabelPengunjung = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Pengunjung", "Anggota", "PNS", "Siswa DIKBANG", "Jumlah", "Siswa DIKTUK", "Tahanan", "Mandiri", "BPJS", "Total"
			}
		);
	private JTable table_1;
	DefaultTableModel modelTabelKunjungan = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Kunjungan", "Anggota", "PNS", "Siswa DIKBANG", "Jumlah", "Siswa DIKTUK", "Tahanan", "Mandiri", "BPJS", "Total"
			}
		);
	private JTable tabelMacamPenyakit;
	DefaultTableModel modelTabelMacamPenyakit = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No. DTD", "No. ICD-10", "Macam Penyakit", "Anggota", "PNS", "Siswa DIKBANG", "Jumlah", "Siswa DIKTUK", "Tahanan", "Mandiri", "BPJS", "Jumlah", "Total"
			}
		);
	private JTable tabel10JnsPenyakit;
	DefaultTableModel modelTabel10MacamPenyakit = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No.", "No. DTD", "No. ICD-10", "Macam Penyakit", "Anggota", "PNS", "Siswa DIKBANG", "Jumlah", "Siswa DIKTUK", "Tahanan", "Mandiri", "BPJS", "Jumlah", "Total"
			}
		);
	private JTable tabel10MacamPenGigi;
	DefaultTableModel modelTabelPenGigiMulut = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No.", "No. DTD", "No. ICD-10", "Macam Penyakit", "Anggota", "PNS", "Siswa DIKBANG", "Jumlah", "Siswa DIKTUK", "Tahanan", "Mandiri", "BPJS", "Jumlah", "Total"
			}
		);
	private JTable tabelRawatInap;
	DefaultTableModel modelTabelRawatInap = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Poliklinik", "JP-Anggota", "HP-Anggota", "JP-PNS", "HP-PNS", "JP-Siswa DIKBANG", "HP-Siswa DIKBANG", "JP-Jumlah", "HP-Jumlah", "JP-Siswa DIKTUK", "HP-Siswa DIKTUK", "JP-Tahanan", "HP-Tahanan", "JP-Mandiri", "HP-Mandiri", "JP-BPJS", "HP-BPJS", "JP-Jumlah", "HP-Jumlah", "JP-Total", "HP-Total"
			}
		);
	private JButton btnReload4;
	private JButton btnReload3;
	private JButton btnReload2;
	private JButton btnReload;
	private JButton btnReload5;
	
	/**
	 * Create the panel.
	 */
	public panelLaporan() {
		setLayout(new GridLayout(0,1));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1096, 584);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		JPanel panelLapKunjungan = new JPanel();
		JPanel panelLap10PenyakitGigiMulut = new JPanel();
		JPanel panelLapRawatInap = new JPanel();
		JPanel panelLapPenyakit = new JPanel();
		tabbedPane.addTab("YANKES-RUMKIT 1", null, panelLapPenyakit, null);
		panelLapPenyakit.setLayout(null);
		
		JLabel lblJdulYankes1 = new JLabel("Laporan Macam Penyakit dengan Jumlah Pasien");
		lblJdulYankes1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblJdulYankes1.setBounds(121, 24, 670, 33);
		panelLapPenyakit.add(lblJdulYankes1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 93, 940, 315);
		panelLapPenyakit.add(scrollPane);
		
		tabelMacamPenyakit = new JTable();
		tabelMacamPenyakit.setModel(modelTabelMacamPenyakit);
		tabelMacamPenyakit.getColumnModel().getColumn(1).setPreferredWidth(115);
		tabelMacamPenyakit.getColumnModel().getColumn(2).setPreferredWidth(199);
		tabelMacamPenyakit.getColumnModel().getColumn(5).setPreferredWidth(129);
		tabelMacamPenyakit.getColumnModel().getColumn(7).setPreferredWidth(129);
		scrollPane.setViewportView(tabelMacamPenyakit);
		
		btnReload = new JButton("Reload");
		btnReload.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/reload.png")));
		btnReload.setBounds(524, 464, 96, 33);
		panelLapPenyakit.add(btnReload);
		JPanel panelLap10Penyakit = new JPanel();
		tabbedPane.addTab("YANKES-RUMKIT 2", null, panelLap10Penyakit, null);
		panelLap10Penyakit.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Laporan 10 Jenis Penyakit dengan Jumlah Pasien Terbanyak");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_1.setBounds(121, 24, 830, 33);
		panelLap10Penyakit.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(145, 93, 940, 315);
		panelLap10Penyakit.add(scrollPane_1);
		
		tabel10JnsPenyakit = new JTable();
		tabel10JnsPenyakit.setModel(modelTabel10MacamPenyakit);
		tabel10JnsPenyakit.getColumnModel().getColumn(0).setPreferredWidth(44);
		tabel10JnsPenyakit.getColumnModel().getColumn(2).setPreferredWidth(90);
		tabel10JnsPenyakit.getColumnModel().getColumn(3).setPreferredWidth(199);
		tabel10JnsPenyakit.getColumnModel().getColumn(6).setPreferredWidth(117);
		tabel10JnsPenyakit.getColumnModel().getColumn(8).setPreferredWidth(113);
		scrollPane_1.setViewportView(tabel10JnsPenyakit);
		
		btnReload2 = new JButton("Reload");
		btnReload2.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/reload.png")));
		btnReload2.setBounds(524, 464, 96, 33);
		panelLap10Penyakit.add(btnReload2);
		tabbedPane.addTab("YANKES-RUMKIT 3", null, panelLap10PenyakitGigiMulut, null);
		panelLap10PenyakitGigiMulut.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(145, 93, 940, 315);
		panelLap10PenyakitGigiMulut.add(scrollPane_2);
		
		tabel10MacamPenGigi = new JTable();
		tabel10MacamPenGigi.setModel(modelTabelPenGigiMulut);
		tabel10MacamPenGigi.getColumnModel().getColumn(0).setPreferredWidth(40);
		tabel10MacamPenGigi.getColumnModel().getColumn(2).setPreferredWidth(90);
		tabel10MacamPenGigi.getColumnModel().getColumn(3).setPreferredWidth(182);
		tabel10MacamPenGigi.getColumnModel().getColumn(6).setPreferredWidth(127);
		tabel10MacamPenGigi.getColumnModel().getColumn(8).setPreferredWidth(126);
		scrollPane_2.setViewportView(tabel10MacamPenGigi);
		
		JLabel lblLaporanMacamPenyakit = new JLabel("Laporan 10 Jenis Penyakit Gigi dan Mulut dengan Jumlah Pasien Terbanyak");
		lblLaporanMacamPenyakit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblLaporanMacamPenyakit.setBounds(121, 24, 1032, 33);
		panelLap10PenyakitGigiMulut.add(lblLaporanMacamPenyakit);
		
		btnReload3 = new JButton("Reload");
		btnReload3.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/reload.png")));
		btnReload3.setBounds(524, 464, 96, 33);
		panelLap10PenyakitGigiMulut.add(btnReload3);
		tabbedPane.addTab("YANKES-RUMKIT 4", null, panelLapKunjungan, null);
		tabbedPane.addTab("YANKES-RUMKIT 5", null, panelLapRawatInap, null);
		panelLapRawatInap.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Laporan Pasien Rawat Inap");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_2.setBounds(121, 24, 411, 33);
		panelLapRawatInap.add(lblNewLabel_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(32, 109, 1280, 280);
		panelLapRawatInap.add(scrollPane_3);
		
		tabelRawatInap = new JTable();
		tabelRawatInap.setModel(modelTabelRawatInap);
		tabelRawatInap.getColumnModel().getColumn(0).setPreferredWidth(158);
		tabelRawatInap.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabelRawatInap.getColumnModel().getColumn(6).setPreferredWidth(106);
		tabelRawatInap.getColumnModel().getColumn(9).setPreferredWidth(94);
		tabelRawatInap.getColumnModel().getColumn(10).setPreferredWidth(96);
		scrollPane_3.setViewportView(tabelRawatInap);
		
		btnReload5 = new JButton("Reload");
		btnReload5.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/reload.png")));
		btnReload5.setBounds(524, 454, 96, 33);
		panelLapRawatInap.add(btnReload5);
		tabbedPane.addTab("Cetak", null, panel, null);
		panelLapKunjungan.setLayout(null);
		
		JScrollPane tabelPengunjung = new JScrollPane();
		tabelPengunjung.setBounds(181, 128, 719, 78);
		panelLapKunjungan.add(tabelPengunjung);
		
		table = new JTable();
		table.setModel(modelTabelPengunjung);
		table.getColumnModel().getColumn(3).setPreferredWidth(96);
		table.getColumnModel().getColumn(5).setPreferredWidth(91);
		tabelPengunjung.setViewportView(table);
		
		JLabel lblLaporanBulanan = new JLabel("Laporan Jumlah Pengunjung dan Kunjungan Rawat Jalan ");
		lblLaporanBulanan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblLaporanBulanan.setBounds(121, 24, 995, 33);
		panelLapKunjungan.add(lblLaporanBulanan);
		
		JScrollPane tabelKunjungan = new JScrollPane();
		tabelKunjungan.setBounds(181, 247, 719, 78);
		panelLapKunjungan.add(tabelKunjungan);
		
		table_1 = new JTable();
		table_1.setModel(modelTabelKunjungan);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(99);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(93);
		tabelKunjungan.setViewportView(table_1);
		
		btnReload4 = new JButton("Reload");
		btnReload4.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/reload.png")));
		btnReload4.setBounds(477, 377, 96, 33);
		panelLapKunjungan.add(btnReload4);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cetak Laporan Pelayanan Kesehatan");
		lblNewLabel.setBounds(24, 11, 542, 33);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		
		btnLaporanJenisPenyakit = new JButton("Macam Penyakit dengan Jumlah Pasien");
		btnLaporanJenisPenyakit.setBounds(186, 55, 671, 86);
		panel.add(btnLaporanJenisPenyakit);
		btnLaporanJenisPenyakit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLaporanJenisPenyakit.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		
		btnLaporan10JnsPenyakit = new JButton("10 Jenis Penyakit dengan Jumlah Pasien Terbanyak");
		btnLaporan10JnsPenyakit.setBounds(186, 152, 671, 86);
		panel.add(btnLaporan10JnsPenyakit);
		btnLaporan10JnsPenyakit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLaporan10JnsPenyakit.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		
		btnLaporanJnsPenyakitGigi = new JButton("10 Jenis Penyakit Gigi dan Mulut dengan Jumlah Pasien Terbanyak");
		btnLaporanJnsPenyakitGigi.setBounds(186, 249, 671, 86);
		panel.add(btnLaporanJnsPenyakitGigi);
		btnLaporanJnsPenyakitGigi.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		btnLaporanJnsPenyakitGigi.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		btnLaporanRawatJalan = new JButton("Jumlah Pengunjung dan Kunjungan Rawat Jalan");
		btnLaporanRawatJalan.setBounds(186, 346, 671, 86);
		panel.add(btnLaporanRawatJalan);
		btnLaporanRawatJalan.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLaporanRawatJalan.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		
		btnLaporanRawatInap = new JButton("Jumlah Pasien Rawat Inap");
		btnLaporanRawatInap.setBounds(186, 443, 671, 86);
		panel.add(btnLaporanRawatInap);
		btnLaporanRawatInap.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		btnLaporanRawatInap.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		penghendel hendel = new penghendel();
		btnLaporanRawatInap.addActionListener(hendel);
		btnLaporanRawatJalan.addActionListener(hendel);
		btnLaporanJnsPenyakitGigi.addActionListener(hendel);
		btnLaporan10JnsPenyakit.addActionListener(hendel);
		btnLaporanJenisPenyakit.addActionListener(hendel);
		btnReload.addActionListener(hendel);
		btnReload2.addActionListener(hendel);
		btnReload3.addActionListener(hendel);
		btnReload4.addActionListener(hendel);
		btnReload5.addActionListener(hendel);

		tampilTabelMacamPenyakit();
		tampilTabel10MacamPenyakit();
		tampilTabel10MacamPenyakitGigi();
		tampilTabelKunjunganPasienPolri();
		tampilTabelKunjunganUlangPasienPolri();
		tampilTabelRawatInap();
	}
	
	/**
	 * metode cetak laporan macam penyakit
	 */
	private void printMacamPenyakit()
	{
		konek = konek_database.getKonekDB();
		try
		{	
			JasperReport ljp = JasperCompileManager.compileReport("C:/Users/HUDA/Documents/My Workspace/sipk/lap_macampenyakit_dan_jumlah.jrxml");
			JasperPrint ljpPrint = JasperFillManager.fillReport(ljp, new HashMap(), konek);
			JasperExportManager.exportReportToPdfFile(ljpPrint, "D:/tes.pdf");
			JasperViewer.viewReport(ljpPrint, false);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol tampil report : "+e.getMessage());
		}
		
	}
	
	/**
	 * metode cetak laporan 10 jenis penyakit terbanyak
	 */
	private void print10JenisPenyakit()
	{
		konek = konek_database.getKonekDB();
		
		try
		{	
			JasperReport ljp = JasperCompileManager.compileReport("C:/Users/HUDA/Documents/My Workspace/sipk/lap_10macampenyakit.jrxml");
			JasperPrint ljpPrint = JasperFillManager.fillReport(ljp, new HashMap(), konek);
			//JasperExportManager.exportReportToPdfFile(ljpPrint, "D:/tes.pdf");
			JasperViewer.viewReport(ljpPrint, false);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol tampil report : "+e.getMessage());
		}
	}
	
	
	/**
	 * metode cetak laporan 10 jenis penyakit gigi terbanyak
	 */
	private void print10JenisPenyakitGigi()
	{
		konek = konek_database.getKonekDB();
		try
		{	
			JasperReport ljp = JasperCompileManager.compileReport("C:/Users/HUDA/Documents/My Workspace/sipk/lap_10macampenyakit_gigidanmulut.jrxml");
			JasperPrint ljpPrint = JasperFillManager.fillReport(ljp, new HashMap(), konek);
			//JasperExportManager.exportReportToPdfFile(ljpPrint, "D:/tes.pdf");
			JasperViewer.viewReport(ljpPrint, false);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol tampil report : "+e.getMessage());
		}
	}
	
	/**
	 * metode cetak laporan rawat jalan
	 */
	private void printRawatJalan()
	{
		konek = konek_database.getKonekDB();
		try
		{	
			JasperReport ljp = JasperCompileManager.compileReport("C:/Users/HUDA/Documents/My Workspace/sipk/Laporan Rawat Jalan.jrxml");
			JasperPrint ljpPrint = JasperFillManager.fillReport(ljp, new HashMap(), konek);
			//JasperExportManager.exportReportToPdfFile(ljpPrint, "D:/tes.pdf");
			JasperViewer.viewReport(ljpPrint, false);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol tampil report : "+e.getMessage());
		}
	}
	
	/**
	 * metode cetak laporan rawat inap
	 */
	private void printRawatInap()
	{
		konek = konek_database.getKonekDB();
		try
		{	
			JasperReport ljp = JasperCompileManager.compileReport("C:/Users/HUDA/Documents/My Workspace/sipk/lap_rawat_inap.jrxml");
			JasperPrint ljpPrint = JasperFillManager.fillReport(ljp, new HashMap(), konek);
			//JasperExportManager.exportReportToPdfFile(ljpPrint, "D:/tes.pdf");
			JasperViewer.viewReport(ljpPrint, false);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol tampil report : "+e.getMessage());
		}
	}
	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnLaporanJenisPenyakit)
			{
				printMacamPenyakit();
			}
			else if(e.getSource()==btnLaporan10JnsPenyakit)
			{
				print10JenisPenyakit();
			}
			else if(e.getSource()==btnLaporanJnsPenyakitGigi)
			{
				print10JenisPenyakitGigi();
			}
			else if (e.getSource()==btnLaporanRawatJalan)
			{
				printRawatJalan();
			}
			else if (e.getSource()==btnLaporanRawatInap)
			{
				printRawatInap();
			}
			else if(e.getSource()==btnReload)
			{
				tampilTabelMacamPenyakit();
			}
			else if(e.getSource()==btnReload2)
			{
				tampilTabel10MacamPenyakit();
			}
			else if(e.getSource()==btnReload3)
			{
				tampilTabel10MacamPenyakitGigi();
			}
			else if(e.getSource()==btnReload4)
			{
				tampilTabelKunjunganPasienPolri();
				tampilTabelKunjunganUlangPasienPolri();
			}
			else if(e.getSource()==btnReload5)
			{
				tampilTabelRawatInap();
			}
		}
	}
	
	private void tampilTabelMacamPenyakit()
	{
		modelTabelMacamPenyakit.getDataVector().removeAllElements();
		modelTabelMacamPenyakit.fireTableDataChanged();
		
		try
		{
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select * from icd10");
			
			while(result.next())
			{
				Object obj[] = new Object[13];
				obj[0] = result.getString(1);
				obj[1] = result.getString(2);
				obj[2] = result.getString(3);
				obj[3] = result.getInt(4);
				obj[4] = result.getInt(5);
				obj[5] = result.getInt(6);
				obj[6] = result.getInt(7);
				obj[7] = result.getInt(8);
				obj[8] = result.getInt(9);
				obj[9] = result.getInt(10);
				obj[10] = result.getInt(11);
				obj[11] = result.getInt(12);
				obj[12] = result.getInt(13);
				
				modelTabelMacamPenyakit.addRow(obj);
			}
			
			konek.close();
			state.close();
			result.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada modul tampilTabelMacamPenyakit : "+ex.getMessage());
		}
	}
	
	private void tampilTabel10MacamPenyakit()
	{
		modelTabel10MacamPenyakit.getDataVector().removeAllElements();
		modelTabel10MacamPenyakit.fireTableDataChanged();
		
		int i = 1;
		try
		{
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select * from icd10 order by jpen_total desc limit 10");
			
			while(result.next())
			{
				Object obj[] = new Object[14];
				obj[0] = i;
				obj[1] = result.getString(1);
				obj[2] = result.getString(2);
				obj[3] = result.getString(3);
				obj[4] = result.getInt(4);
				obj[5] = result.getInt(5);
				obj[6] = result.getInt(6);
				obj[7] = result.getInt(7);
				obj[8] = result.getInt(8);
				obj[9] = result.getInt(9);
				obj[10] = result.getInt(10);
				obj[11] = result.getInt(11);
				obj[12] = result.getInt(12);
				obj[13] = result.getInt(13);
				
				modelTabel10MacamPenyakit.addRow(obj);
				i++;
			}
			
			konek.close();
			state.close();
			result.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada modul tampil10TabelMacamPenyakit : "+ex.getMessage());
		}
	}
	
	private void tampilTabel10MacamPenyakitGigi()
	{
		modelTabelPenGigiMulut.getDataVector().removeAllElements();
		modelTabelPenGigiMulut.fireTableDataChanged();
		int i = 1;
		try
		{
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select * from icd10 where pen_gigidanmulut='Ya' order by jpen_total desc limit 10");
			
			while(result.next())
			{
				Object obj[] = new Object[14];
				obj[0] = i;
				obj[1] = result.getString(1);
				obj[2] = result.getString(2);
				obj[3] = result.getString(3);
				obj[4] = result.getInt(4);
				obj[5] = result.getInt(5);
				obj[6] = result.getInt(6);
				obj[7] = result.getInt(7);
				obj[8] = result.getInt(8);
				obj[9] = result.getInt(9);
				obj[10] = result.getInt(10);
				obj[11] = result.getInt(11);
				obj[12] = result.getInt(12);
				obj[13] = result.getInt(13);
				
				modelTabelPenGigiMulut.addRow(obj);
				i++;
			}
			
			konek.close();
			state.close();
			result.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada modul tampil10TabelMacamPenyakitGigi : "+ex.getMessage());
		}
	}
	
	public void tampilTabelKunjunganPasienPolri()
	{
		modelTabelPengunjung.getDataVector().removeAllElements();
		modelTabelPengunjung.fireTableDataChanged();

		try
		{
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select * from kunjungan_pasien_polri");
			
			while(result.next())
			{
				Object obj[] = new Object[10];
				obj[0] = result.getString(1);
				obj[1] = result.getInt(2);
				obj[2] = result.getInt(3);
				obj[3] = result.getInt(4);
				obj[4] = result.getInt(5);
				obj[5] = result.getInt(6);
				obj[6] = result.getInt(7);
				obj[7] = result.getInt(8);
				obj[8] = result.getInt(9);
				obj[9] = result.getInt(10);
				
				modelTabelPengunjung.addRow(obj);
			}
			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada metode tampilTabelKunjunganPasienPolri : "+ex.getMessage());
		}
		
	}
	
	private void tampilTabelKunjunganUlangPasienPolri()
	{
		modelTabelKunjungan.getDataVector().removeAllElements();
		modelTabelKunjungan.fireTableDataChanged();
		try
		{
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select * from kunjungan_pasien_polri_ulang");
			
			while(result.next())
			{
				Object obj[] = new Object[10];
				obj[0] = result.getString(1);
				obj[1] = result.getInt(2);
				obj[2] = result.getInt(3);
				obj[3] = result.getInt(4);
				obj[4] = result.getInt(5);
				obj[5] = result.getInt(6);
				obj[6] = result.getInt(7);
				obj[7] = result.getInt(8);
				obj[8] = result.getInt(9);
				obj[9] = result.getInt(10);
				
				modelTabelKunjungan.addRow(obj);
			}
			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada metode tampilTabelKunjunganPasienPolri : "+ex.getMessage());
		}
	}
	
	private void tampilTabelRawatInap()
	{
		modelTabelRawatInap.getDataVector().removeAllElements();
		modelTabelRawatInap.fireTableDataChanged();
		try
		{
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select * from rawat_inap");
			
			while(result.next())
			{
				Object obj[] = new Object[21];
				obj[0] = result.getString(1);
				obj[1] = result.getInt(2);
				obj[2] = result.getInt(3);
				obj[3] = result.getInt(4);
				obj[4] = result.getInt(5);
				obj[5] = result.getInt(6);
				obj[6] = result.getInt(7);
				obj[7] = result.getInt(8);
				obj[8] = result.getInt(9);
				obj[9] = result.getInt(10);
				obj[10] = result.getInt(11);
				obj[11] = result.getInt(12);
				obj[12] = result.getInt(13);
				obj[13] = result.getInt(14);
				obj[14] = result.getInt(15);
				obj[15] = result.getInt(16);
				obj[16] = result.getInt(17);
				obj[17] = result.getInt(18);
				obj[18] = result.getInt(19);
				obj[19] = result.getInt(20);
				obj[20] = result.getInt(21);
				
				modelTabelRawatInap.addRow(obj);
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada modul tampilTabelRawatInap : "+ex.getMessage());
		}
	}
}
