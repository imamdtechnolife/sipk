package com.sipk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Font;
public class hal_utama extends JFrame {

	private JPanel contentPane;
	private JButton btnDaftarPenyakit;
	private JPanel panel;
	
	/**
	 * Launch the application.
	 */
	
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hal_utama frame = new hal_utama();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public hal_utama() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1094, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 64, 1058, 43);
		contentPane.add(toolBar);
		
		JButton btnDaftarPasien = new JButton("Daftar Pasien");
		btnDaftarPasien.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/Batal.png")));
		toolBar.add(btnDaftarPasien);
		
		btnDaftarPenyakit = new JButton("Daftar Penyakit");
		btnDaftarPenyakit.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/Hapus.png")));
		toolBar.add(btnDaftarPenyakit);
		
		JButton btnDokter = new JButton("Dokter");
		btnDokter.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/Laporan.png")));
		toolBar.add(btnDokter);
		
		JButton btnRawatJalan = new JButton("Rawat Jalan");
		btnRawatJalan.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/Tambah.png")));
		toolBar.add(btnRawatJalan);
		
		JButton btnRawatInap = new JButton("Rawat Inap");
		btnRawatInap.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/Ubah.png")));
		toolBar.add(btnRawatInap);
		
		JButton btnLaporan = new JButton("Laporan");
		btnLaporan.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/address-book-new.png")));
		toolBar.add(btnLaporan);
		
		JLabel lblSistemInformasiPelayanan = new JLabel("  Sistem Informasi Pelayanan Kesehatan Rumah Sakit Bhayangkara Mataram");
		lblSistemInformasiPelayanan.setFont(new Font("Verdana", Font.BOLD, 24));
		lblSistemInformasiPelayanan.setBounds(10, 21, 1058, 32);
		contentPane.add(lblSistemInformasiPelayanan);
		
		panel = new JPanel();
		panel.setBounds(10, 118, 1058, 666);
		contentPane.add(panel);
		
		penghendel hendel = new penghendel();
		btnDaftarPenyakit.addActionListener(hendel);

	}
	
	public class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnDaftarPenyakit)
			{
				jenis_penyakit obj = new jenis_penyakit();
				panel.add(obj);
			}
			
		}
	}
}
