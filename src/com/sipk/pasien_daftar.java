package com.sipk;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;

public class pasien_daftar extends JFrame{
	
	private JLabel lblNama = new JLabel("Nama : ");
	private JTextField txtNama = new JTextField(20);
	private JButton btnSimpan = new JButton("Simpan");
	private JButton btnHapus = new JButton("Hapus");
	private JButton btnUbah = new JButton("Ubah");
	private JButton btnTambah = new JButton("Tambah");
	private JButton btnRefresh = new JButton("");
	private JTable tblPasienDaftar = new JTable();
	String kolomtabel[] = {"Nama","no. kartu"};
	
	private JScrollPane scrollTabel = new JScrollPane();
	private DefaultTableModel modelTblPasienDaftar = new DefaultTableModel(null, kolomtabel);
	private JPanel panelPasienDaftar = new JPanel();
	private JPanel panelTabel = new JPanel();
	Container konten = getContentPane();
	
	Connection konek = konek_database.getKonekDB();
	
	public pasien_daftar()
	{
		super("Pasien Daftar");
		setVisible(true);
		setSize(1058,666);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		panelPasienDaftar.setLayout(new GridLayout(4,4));
		panelPasienDaftar.setBorder(BorderFactory.createTitledBorder("Daftar Pasien"));
		panelPasienDaftar.add(lblNama);
		panelPasienDaftar.add(txtNama);
		panelPasienDaftar.add(btnSimpan);
		
		tblPasienDaftar.setModel(modelTblPasienDaftar);
		scrollTabel.getViewport().add(tblPasienDaftar);
		panelTabel.add(scrollTabel);
		
		konten.add(panelPasienDaftar);
		konten.add(panelTabel);
		
		penghendel hendel = new penghendel();
		btnSimpan.addActionListener(hendel);
	}
	
	public class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				Statement st = konek.createStatement();
				
			}
			catch(Exception ex)
			{
				
			}
		}
	}
}
