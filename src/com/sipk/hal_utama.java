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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
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
	panelLaporan objLaporan = new panelLaporan();
	public JButton btnDokter;
	public JButton btnRawatJalan;
	public JButton btnRawatInap;
	public JButton btnBersalin;
	public JButton btnPengguna;
	public JButton btnPembayaran;
	public JButton btnLaporan;
	JButton btnMasuk;
	private JPanel panelMasuk;
	private JTextField textField;
	private JPasswordField passwordField;
	Connection konek = null;
	JMenuItem penggunaLogout;
	JComboBox comboLevel;
	
	
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
		btnDaftarPasien.setEnabled(false);
		toolBar.add(btnDaftarPasien);
		toolBar.addSeparator();
		
		btnDaftarPenyakit = new JButton("Daftar Penyakit");
		btnDaftarPenyakit.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/d.png")));
		btnDaftarPenyakit.setEnabled(false);
		toolBar.add(btnDaftarPenyakit);
		toolBar.addSeparator();
		
		btnDokter = new JButton("Dokter");
		btnDokter.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/dokter.png")));
		btnDokter.setEnabled(false);
		toolBar.add(btnDokter);
		toolBar.addSeparator();
		
		btnRawatJalan = new JButton("Rawat Jalan");
		btnRawatJalan.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/rawat-jalan.png")));
		btnRawatJalan.setEnabled(false);
		toolBar.add(btnRawatJalan);
		toolBar.addSeparator();
		
		btnRawatInap = new JButton("Rawat Inap");
		btnRawatInap.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/rawat-inap.png")));
		btnRawatInap.setEnabled(false);
		toolBar.add(btnRawatInap);
		toolBar.addSeparator();
		
		btnBersalin = new JButton("Bersalin");
		btnBersalin.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/bersalin.png")));
		btnBersalin.setEnabled(false);
		toolBar.add(btnBersalin);
		toolBar.addSeparator();
		
		btnPembayaran = new JButton("Pembayaran");
		btnPembayaran.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/accessories-calculator.png")));
		btnPembayaran.setEnabled(false);
		toolBar.add(btnPembayaran);
		toolBar.addSeparator();
		
		btnLaporan = new JButton("Laporan");
		btnLaporan.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/laporan-1.png")));
		btnLaporan.setEnabled(false);
		toolBar.add(btnLaporan);
		toolBar.addSeparator();
		
		btnPengguna = new JButton("Pengguna");
		btnPengguna.setIcon(new ImageIcon(hal_utama.class.getResource("/com/sipk/Image/kgpg_identity.png")));
		btnPengguna.setEnabled(false);
		toolBar.add(btnPengguna);
		
		panel = new JPanel();
		panel.setBounds(0, 86, 1192, 577);
		
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		panelMasuk = new JPanel();
		panel.add(panelMasuk, "name_9557694810851");
		panelMasuk.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(566, 189, 46, 14);
		panelMasuk.add(lblLogin);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setBounds(502, 216, 69, 14);
		panelMasuk.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(502, 249, 69, 14);
		panelMasuk.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(586, 214, 116, 20);
		panelMasuk.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(586, 246, 116, 20);
		panelMasuk.add(passwordField);
		
		btnMasuk = new JButton("Masuk");
		btnMasuk.setBounds(550, 325, 89, 23);
		panelMasuk.add(btnMasuk);
		
		JLabel lblLevelUser = new JLabel("Level User");
		lblLevelUser.setBounds(502, 284, 69, 14);
		panelMasuk.add(lblLevelUser);
		
		comboLevel = new JComboBox();
		comboLevel.setBounds(586, 277, 116, 20);
		comboLevel.addItem("-- Pilih Level --");
		comboLevel.addItem("Administrator");
		comboLevel.addItem("Dokter");
		comboLevel.addItem("Perawat");
		comboLevel.addItem("Kasir");
		comboLevel.addItem("Pengolah Data");
		comboLevel.addItem("Manajemen");
		panelMasuk.add(comboLevel);
		
		//menu
		
		JMenu menuPengguna = new JMenu("Pengguna");
		JMenu menuAbout = new JMenu("Tentang");
		
		penggunaLogout = new JMenuItem("Logout");
		
		JMenuItem aboutRM = new JMenuItem("RM. Bhayangkara Mataram");
		JMenuItem aboutDeveloper = new JMenuItem("Pengembang");
		
		menuPengguna.add(penggunaLogout);
		
		menuAbout.add(aboutRM);
		menuAbout.add(aboutDeveloper);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuPengguna);
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
		btnMasuk.addActionListener(hendel);
		penggunaLogout.addActionListener(hendel);


	}
	
	/**
	 * Metode Login
	 */
	public void login()
	{
		try{
			
		String username = textField.getText().toString();
		String password = passwordField.getText().toString();
		String level = comboLevel.getSelectedItem().toString();
			
		konek = konek_database.getKonekDB();
		Statement state = konek.createStatement();
		ResultSet result = state.executeQuery("select username, pass, lvel from akun where username='"+username+"' and pass='"+password+"' and lvel='"+level+"' ");
		
		if(result.next())
		{
			JOptionPane.showMessageDialog(null, "Alhamdulillah Anda berhasil login :)");
			
			if(level == "Administrator")
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(objLogin);
				panel.repaint();
				panel.revalidate();
				
				btnDaftarPasien.setEnabled(true);
				btnPengguna.setEnabled(true);
			}
			else if(level == "Dokter")
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(objLogin);
				panel.repaint();
				panel.revalidate();
				
				btnDokter.setEnabled(true);
				btnRawatInap.setEnabled(true);
				btnRawatJalan.setEnabled(true);
				btnBersalin.setEnabled(true);
				btnPengguna.setEnabled(true);
			}
			else if(level == "Kasir")
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(objLogin);
				panel.repaint();
				panel.revalidate();
				
				btnPembayaran.setEnabled(true);
				btnPengguna.setEnabled(true);
			}
			else if(level == "Manajemen")
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(objLogin);
				panel.repaint();
				panel.revalidate();
				
				btnLaporan.setEnabled(true);
				btnPengguna.setEnabled(true);
			}
			else if(level == "Pengolah Data")
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(objLogin);
				panel.repaint();
				panel.revalidate();
				
				btnLaporan.setEnabled(true);
				btnPengguna.setEnabled(true);
			}
			else if(level == "Perawat")
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(objLogin);
				panel.repaint();
				panel.revalidate();
				
				btnRawatInap.setEnabled(true);
				btnRawatJalan.setEnabled(true);
				btnBersalin.setEnabled(true);
				btnPengguna.setEnabled(true);
			}
			
			
			
		}		
		else
		{
			JOptionPane.showMessageDialog(null, "Username atau Password yang anda masukkan salah");
			JOptionPane.showMessageDialog(null, "silahkan ulangi kembali");
			textField.setText("");
			passwordField.setText("");
			comboLevel.setSelectedIndex(0);
			textField.requestFocus();
		}
		konek.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada kelas login "+ex.getMessage());
		}
		finally
		{
			textField.setText("");
			passwordField.setText("");
		}
	}
	
	/**
	 * Metode me-nonaktifkan menu toolbar
	 */
	private void buttonDisabled()
	{
		btnBersalin.setEnabled(false);
		btnDaftarPasien.setEnabled(false);
		btnDaftarPenyakit.setEnabled(false);
		btnDokter.setEnabled(false);
		btnLaporan.setEnabled(false);
		btnPembayaran.setEnabled(false);
		btnPengguna.setEnabled(false);
		btnRawatInap.setEnabled(false);
		btnRawatJalan.setEnabled(false);
	}

	/**
	 * 
	 * sistem overiding tombol
	 * 
	 * @author Imam Afriyadi
	 *
	 *  
	 */
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
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(objLaporan);
				panel.repaint();
				panel.revalidate();
			}
			else if(e.getSource()==btnMasuk)
			{
				login();
			}
			else if(e.getSource()==penggunaLogout)
			{
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				
				panel.add(panelMasuk);
				panel.repaint();
				panel.revalidate();
				
				buttonDisabled();
			}
	}
}
}