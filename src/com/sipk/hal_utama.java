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
	private JButton btnDaftarPenyakit;
	private JButton btnDaftarPasien;
	private JPanel panel;
	private JLabel lbl;
	panelUser obj = new panelUser();
	daftar_pasien objD = new daftar_pasien();
	pasien_rawat_inap ii = new pasien_rawat_inap();
	pasien_bersalin objBersalin = new pasien_bersalin();
	private JButton btnDokter;
	private JButton btnRawatJalan;
	private JButton btnRawatInap;
	private JButton btnBersalin;
	private JButton btnPengguna;
	
	
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
		toolBar.setBounds(0, 0, 1192, 65);
		contentPane.add(toolBar);
		
		btnDaftarPasien = new JButton("Daftar Pasien");
		btnDaftarPasien.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/Batal.png")));
		toolBar.add(btnDaftarPasien);
		
		btnDaftarPenyakit = new JButton("Daftar Penyakit");
		btnDaftarPenyakit.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/Hapus.png")));
		toolBar.add(btnDaftarPenyakit);
		
		btnDokter = new JButton("Dokter");
		btnDokter.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/Laporan.png")));
		toolBar.add(btnDokter);
		
		btnRawatJalan = new JButton("Rawat Jalan");
		btnRawatJalan.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/Tambah.png")));
		toolBar.add(btnRawatJalan);
		
		btnRawatInap = new JButton("Rawat Inap");
		btnRawatInap.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/Ubah.png")));
		toolBar.add(btnRawatInap);
		
		btnBersalin = new JButton("Bersalin");
		btnBersalin.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/address-book-new.png")));
		toolBar.add(btnBersalin);
		toolBar.addSeparator();
		
		btnPengguna = new JButton("Pengguna");
		btnPengguna.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/kgpg_identity.png")));
		toolBar.add(btnPengguna);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 64, 1192, 599);
		
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		penghendel hendel = new penghendel();
		btnDaftarPenyakit.addActionListener(hendel);
		btnDaftarPasien.addActionListener(hendel);
		btnBersalin.addActionListener(hendel);
		btnPengguna.addActionListener(hendel);

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
			
			//panel.add(obj);
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
	}
}
}