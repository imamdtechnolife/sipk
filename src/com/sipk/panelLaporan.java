package com.sipk;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.*;
import java.io.*;
import java.sql.*;
import java.awt.Font;
import javax.swing.JLabel;

public class panelLaporan extends JPanel {
	
	private JButton btnLaporanJenisPenyakit; 
	private JButton btnLaporan10JnsPenyakit;
	private JButton btnLaporanRawatJalan;
	private JButton btnLaporanJnsPenyakitGigi;
	private JButton btnLaporanRawatInap;
	
	/**
	 * Create the panel.
	 */
	public panelLaporan() {
		setLayout(null);
		
		btnLaporanJenisPenyakit = new JButton("Macam Penyakit dengan Jumlah Pasien");
		btnLaporanJenisPenyakit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLaporanJenisPenyakit.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		btnLaporanJenisPenyakit.setBounds(128, 83, 671, 86);
		add(btnLaporanJenisPenyakit);
		
		btnLaporan10JnsPenyakit = new JButton("10 Jenis Penyakit dengan Jumlah Pasien Terbanyak");
		btnLaporan10JnsPenyakit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLaporan10JnsPenyakit.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		btnLaporan10JnsPenyakit.setBounds(128, 180, 671, 86);
		add(btnLaporan10JnsPenyakit);
		
		btnLaporanRawatJalan = new JButton("Jumlah Pengunjung dan Kunjungan Rawat Jalan");
		btnLaporanRawatJalan.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLaporanRawatJalan.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		btnLaporanRawatJalan.setBounds(128, 374, 671, 86);
		add(btnLaporanRawatJalan);
		
		btnLaporanRawatInap = new JButton("Jumlah Pasien Rawat Inap");
		btnLaporanRawatInap.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		btnLaporanRawatInap.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLaporanRawatInap.setBounds(128, 471, 671, 86);
		add(btnLaporanRawatInap);
		
		btnLaporanJnsPenyakitGigi = new JButton("10 Jenis Penyakit Gigi dan Mulut dengan Pasien Terbanyak");
		btnLaporanJnsPenyakitGigi.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		btnLaporanJnsPenyakitGigi.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLaporanJnsPenyakitGigi.setBounds(128, 277, 671, 86);
		add(btnLaporanJnsPenyakitGigi);
		
		JLabel lblNewLabel = new JLabel("Laporan Bulanan Pelayanan Kesehatan");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setBounds(47, 24, 540, 33);
		add(lblNewLabel);
		
		penghendel hendel = new penghendel();
		btnLaporanJenisPenyakit.addActionListener(hendel);
		btnLaporanRawatJalan.addActionListener(hendel);
		btnLaporan10JnsPenyakit.addActionListener(hendel);
		btnLaporanJnsPenyakitGigi.addActionListener(hendel);
		btnLaporanRawatInap.addActionListener(hendel);

	}
	
	/**
	 * metode cetak laporan macam penyakit
	 */
	private void printMacamPenyakit()
	{
		try
		{	
			JasperReport ljp = JasperCompileManager.compileReport("C:/Users/user/Dropbox/Eclipse Workbench/sipk/src/com/sipk/Laporan Macam Penyakit.jrxml");
			JasperPrint ljpPrint = JasperFillManager.fillReport(ljp, new HashMap(), new JREmptyDataSource());
			JasperExportManager.exportReportToPdfFile(ljpPrint, "D:/tes.pdf");
			JasperViewer.viewReport(ljpPrint);
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
		try
		{	
			JasperReport ljp = JasperCompileManager.compileReport("C:/Users/user/Dropbox/Eclipse Workbench/sipk/src/com/sipk/Laporan 10 Jenis Penyakit.jrxml");
			JasperPrint ljpPrint = JasperFillManager.fillReport(ljp, new HashMap(), new JREmptyDataSource());
			//JasperExportManager.exportReportToPdfFile(ljpPrint, "D:/tes.pdf");
			JasperViewer.viewReport(ljpPrint);
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
		try
		{	
			JasperReport ljp = JasperCompileManager.compileReport("C:/Users/user/Dropbox/Eclipse Workbench/sipk/src/com/sipk/Laporan 10 Jenis Penyakit Gigi.jrxml");
			JasperPrint ljpPrint = JasperFillManager.fillReport(ljp, new HashMap(), new JREmptyDataSource());
			//JasperExportManager.exportReportToPdfFile(ljpPrint, "D:/tes.pdf");
			JasperViewer.viewReport(ljpPrint);
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
		try
		{	
			JasperReport ljp = JasperCompileManager.compileReport("C:/Users/user/Dropbox/Eclipse Workbench/sipk/src/com/sipk/Laporan Rawat Jalan.jrxml");
			JasperPrint ljpPrint = JasperFillManager.fillReport(ljp, new HashMap(), new JREmptyDataSource());
			//JasperExportManager.exportReportToPdfFile(ljpPrint, "D:/tes.pdf");
			JasperViewer.viewReport(ljpPrint);
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
		try
		{	
			JasperReport ljp = JasperCompileManager.compileReport("C:/Users/user/Dropbox/Eclipse Workbench/sipk/src/com/sipk/Laporan Rawat Inap.jrxml");
			JasperPrint ljpPrint = JasperFillManager.fillReport(ljp, new HashMap(), new JREmptyDataSource());
			//JasperExportManager.exportReportToPdfFile(ljpPrint, "D:/tes.pdf");
			JasperViewer.viewReport(ljpPrint);
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
		}
	}
}
