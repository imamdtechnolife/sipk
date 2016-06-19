package com.sipk;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.PanelUI;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import java.awt.CardLayout;
public class hal_utama extends JFrame {

	private JPanel contentPane;
	public JButton btnDaftarPenyakit;
	public JButton btnDaftarPasien;
	private JPanel panel;
	private JLabel lbl;
	panelUser obj = new panelUser();
	daftar_pasien objD = new daftar_pasien();
	pasien_rawat_inap ii = new pasien_rawat_inap();
	pasien_bersalin objBersalin = new pasien_bersalin();
	panelBiayaRJ objBiaya = new panelBiayaRJ();
	panelPemeriksaan objPemeriksaan = new panelPemeriksaan();
	jenis_penyakit objPenyakit = new jenis_penyakit();
	panelLogin objLogin = new panelLogin();
	public JButton btnDokter;
	public JButton btnRawatJalan;
	public JButton btnRawatInap;
	public JButton btnBersalin;
	public JButton btnPengguna;
	public JButton btnPembayaran;
	public JButton btnLaporan;
	
	
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
		super("Sistem Informasi Pelayanan Kesehatan Rumah Sakit Bhayangkara Mataram");
		setIconImage(Toolkit.getDefaultToolkit().getImage(hal_utama.class.getResource("image/address-book-new.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1208, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setBounds(0, 22, 1192, 65);
		contentPane.add(toolBar);
		
		btnDaftarPasien = new JButton("Daftar Pasien");
		btnDaftarPasien.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/buku-daftar.png")));
		toolBar.add(btnDaftarPasien);
		toolBar.addSeparator();
		
		btnDaftarPenyakit = new JButton("Daftar Penyakit");
		btnDaftarPenyakit.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/d.png")));
		toolBar.add(btnDaftarPenyakit);
		toolBar.addSeparator();
		
		btnDokter = new JButton("Dokter");
		btnDokter.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/dokter.png")));
		toolBar.add(btnDokter);
		toolBar.addSeparator();
		
		btnRawatJalan = new JButton("Rawat Jalan");
		btnRawatJalan.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/rawat-jalan.png")));
		toolBar.add(btnRawatJalan);
		toolBar.addSeparator();
		
		btnRawatInap = new JButton("Rawat Inap");
		btnRawatInap.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/rawat-inap.png")));
		toolBar.add(btnRawatInap);
		toolBar.addSeparator();
		
		btnBersalin = new JButton("Bersalin");
		btnBersalin.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/bersalin.png")));
		toolBar.add(btnBersalin);
		toolBar.addSeparator();
		
		btnPembayaran = new JButton("Pembayaran");
		btnPembayaran.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/accessories-calculator.png")));
		toolBar.add(btnPembayaran);
		toolBar.addSeparator();
		
		btnLaporan = new JButton("Laporan");
		btnLaporan.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/laporan-1.png")));
		toolBar.add(btnLaporan);
		toolBar.addSeparator();
		
		btnPengguna = new JButton("Pengguna");
		btnPengguna.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/kgpg_identity.png")));
		toolBar.add(btnPengguna);
		
		panel = new JPanel();
		panel.setBounds(0, 86, 1192, 577);
		
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		panel.add(objLogin);
		
		//menu
		
		JMenu menuAbout = new JMenu("About");
		
		JMenuItem aboutRM = new JMenuItem("RM Bhayangkara Mataram");
		JMenuItem aboutDeveloper = new JMenuItem("Developer");
		
		menuAbout.add(aboutRM);
		menuAbout.add(aboutDeveloper);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuAbout);
		menuBar.setBounds(0, 0, 718, 21);
		
		
		contentPane.add(menuBar);
		
		JLabel lblNewLabel = new JLabel("Pengguna");
		lblNewLabel.setBounds(775, 7, 250, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLevel = new JLabel("Level :");
		lblLevel.setBounds(1035, 7, 147, 14);
		contentPane.add(lblLevel);
		
		penghendel hendel = new penghendel();
		btnDaftarPenyakit.addActionListener(hendel);
		btnDaftarPasien.addActionListener(hendel);
		btnBersalin.addActionListener(hendel);
		btnPengguna.addActionListener(hendel);
		btnPembayaran.addActionListener(hendel);
		btnDokter.addActionListener(hendel);
		btnLaporan.addActionListener(hendel);


	}
	
	public class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnDaftarPenyakit)
			{
				
			panel.removeAll();
			panel.repaint();
			panel.revalidate();
			
			panel.add(objPenyakit);
			panel.repaint();
			panel.revalidate();
			
		}
			else if(e.getSource()==btnDaftarPasien)
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(ii);
				panel.repaint();
				panel.revalidate();
			}
			else if(e.getSource()==btnBersalin)
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(objBersalin);
				panel.repaint();
				panel.revalidate();
			}
			else if(e.getSource()==btnPengguna)
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(obj);
				panel.repaint();
				panel.revalidate();
			}
			else if(e.getSource()==btnPembayaran)
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(objBiaya);
				panel.repaint();
				panel.revalidate();
			}
			else if(e.getSource()==btnDokter)
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(objPemeriksaan);
				panel.repaint();
				panel.revalidate();
			}
			else if(e.getSource()==btnLaporan)
			{
				
			}
	}
}
}