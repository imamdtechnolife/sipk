package com.sipk;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Font;

public class panelUser extends JPanel {
	String kolom[] = {"username","nama","alamat","no. telp"};
	JPanel panelUbahPassword = new JPanel();
	JPanel newPanel2 = new JPanel();
	private JTable table;
	private JTable table_2;
	private JTextField txtNama;
	private JTable table_3;
	private JTextField txtUsername;
	private JTextField txtNoTelp;
	private JTextField txtUsername2;
	private JButton btnSimpan;
	private JComboBox cmbLevel;
	private JTextArea txtAlamat;
	private JPasswordField txtPassword;
	private JButton btnUbah;
	private JButton btnBatal;
	private JPasswordField txtCpassword;
	Connection konek = null;
	private JPasswordField passwordLama;
	private JPasswordField passwordBaru;
	private JPasswordField passwordCfmPassBaru;
	
	/**
	 * Create the panel.
	 */
	public panelUser() {
		setLayout(new GridLayout(0,1));
		setVisible(true);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		newPanel2.setLayout(null);
		
		JPanel panelDaftarPengguna = new JPanel();
		tabbedPane.addTab("Daftar Pengguna", null, panelDaftarPengguna, null);
		//tabbedPane.addTab("Tes Tes", null, newPanel2, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(42, 36, 324, 123);
		newPanel2.add(scrollPane_2);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"yada yada yada", "bla bla"
			}
		));
		scrollPane_2.setViewportView(table_3);
		panelDaftarPengguna.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(33, 82, 475, 402);
		panelDaftarPengguna.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Level", "Nama"
			}
		));
		scrollPane.setViewportView(table_2);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(538, 86, 408, 393);
		panelDaftarPengguna.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(30, 34, 64, 14);
		panel_2.add(lblNama);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(30, 65, 64, 14);
		panel_2.add(lblUsername);
		
		txtNama = new JTextField();
		txtNama.setBounds(144, 31, 233, 20);
		panel_2.add(txtNama);
		txtNama.setColumns(10);
		
		btnSimpan = new JButton("Simpan");
		btnSimpan.setIcon(new ImageIcon(panelUser.class.getResource("/com/sipk/Image/Simpan.png")));
		btnSimpan.setBounds(155, 336, 105, 33);
		panel_2.add(btnSimpan);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(144, 62, 233, 20);
		panel_2.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 99, 64, 14);
		panel_2.add(lblPassword);
		
		JLabel lblKonfirmasiPassword = new JLabel("Konfirmasi Password");
		lblKonfirmasiPassword.setBounds(30, 135, 105, 14);
		panel_2.add(lblKonfirmasiPassword);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setBounds(30, 169, 105, 14);
		panel_2.add(lblLevel);
		
		JLabel lblNoTelpon = new JLabel("No. Telpon");
		lblNoTelpon.setBounds(30, 201, 105, 14);
		panel_2.add(lblNoTelpon);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setBounds(30, 237, 105, 14);
		panel_2.add(lblAlamat);
		
		cmbLevel = new JComboBox();
		cmbLevel.setBounds(144, 166, 135, 20);
		cmbLevel.addItem("-- Pilih Level --");
		cmbLevel.addItem("Administrator");
		cmbLevel.addItem("Dokter");
		cmbLevel.addItem("Perawat");
		cmbLevel.addItem("Kasir");
		cmbLevel.addItem("Pengolah Data");
		cmbLevel.addItem("Manajemen");
		panel_2.add(cmbLevel);
		
		txtNoTelp = new JTextField();
		txtNoTelp.setColumns(10);
		txtNoTelp.setBounds(144, 198, 233, 20);
		panel_2.add(txtNoTelp);
		
		txtAlamat = new JTextArea();
		txtAlamat.setBounds(145, 232, 232, 73);
		panel_2.add(txtAlamat);
		
		btnBatal = new JButton("Batal");
		btnBatal.setIcon(new ImageIcon(panelUser.class.getResource("/com/sipk/Image/Batal.png")));
		btnBatal.setBounds(280, 336, 96, 33);
		panel_2.add(btnBatal);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(144, 93, 233, 20);
		panel_2.add(txtPassword);
		
		txtCpassword = new JPasswordField();
		txtCpassword.setBounds(144, 132, 233, 20);
		panel_2.add(txtCpassword);
		
		JLabel lblPerhatian = new JLabel("");
		lblPerhatian.setBounds(145, 315, 226, 14);
		panel_2.add(lblPerhatian);
		
		JLabel lblDaftarPengguna = new JLabel("Daftar Pengguna");
		lblDaftarPengguna.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblDaftarPengguna.setBounds(47, 24, 245, 33);
		panelDaftarPengguna.add(lblDaftarPengguna);
		tabbedPane.addTab("Ubah Password", null, panelUbahPassword, null);
		panelUbahPassword.setLayout(null);
		
		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setBounds(61, 74, 85, 14);
		panelUbahPassword.add(lblUsername_1);
		
		JLabel lblPasswordBaru = new JLabel("Password Baru");
		lblPasswordBaru.setBounds(61, 150, 85, 14);
		panelUbahPassword.add(lblPasswordBaru);
		
		txtUsername2 = new JTextField();
		txtUsername2.setBounds(173, 71, 141, 20);
		panelUbahPassword.add(txtUsername2);
		txtUsername2.setColumns(10);
		
		btnUbah = new JButton("Ubah");
		btnUbah.setIcon(new ImageIcon(panelUser.class.getResource("/com/sipk/Image/Ubah.png")));
		btnUbah.setBounds(176, 252, 89, 33);
		panelUbahPassword.add(btnUbah);
		
		passwordLama = new JPasswordField();
		passwordLama.setBounds(173, 108, 141, 20);
		panelUbahPassword.add(passwordLama);
		
		passwordBaru = new JPasswordField();
		passwordBaru.setBounds(173, 147, 141, 20);
		panelUbahPassword.add(passwordBaru);
		
		passwordCfmPassBaru = new JPasswordField();
		passwordCfmPassBaru.setBounds(173, 190, 141, 20);
		panelUbahPassword.add(passwordCfmPassBaru);
		
		JLabel lblUlangPasswordBaru = new JLabel("Ulang Password Baru");
		lblUlangPasswordBaru.setBounds(61, 193, 102, 14);
		panelUbahPassword.add(lblUlangPasswordBaru);
		
		JLabel lblPasswordLama = new JLabel("Password Lama");
		lblPasswordLama.setBounds(61, 111, 85, 14);
		panelUbahPassword.add(lblPasswordLama);
		
		JLabel lblUbahPassword = new JLabel("Ubah Password");
		lblUbahPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblUbahPassword.setBounds(47, 24, 254, 36);
		panelUbahPassword.add(lblUbahPassword);
		
		table = new JTable();
		table.setToolTipText("Daftar Pengguna");
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"nomor identitas", "nama", "Password"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(101);
		
		penghendel hendel = new penghendel();
		btnSimpan.addActionListener(hendel);
		btnBatal.addActionListener(hendel);
		btnUbah.addActionListener(hendel);

	}
	
	private void add()
	{
		
		if(	txtAlamat.getText().equals("") || txtNama.getText().equals("") ||	txtNoTelp.getText().equals("") || txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtCpassword.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Anda belum mengisi semua kolom yang ada.");
			clear();
		}
		else
		{
			if(txtPassword.getText().equals(txtCpassword.getText()))
			{
				try
				{
					char[] pass = txtCpassword.getPassword();
					String sandi = "";
					for(int i=0; i<pass.length; i++)
					{
						sandi = sandi + pass[i];
					}
					
					konek = konek_database.getKonekDB();
					//String query = "insert into akun (nama, username, pass, lvel, no_telp, alamat) values (?,?,?,?,?,?)";
					PreparedStatement ps = konek.prepareStatement("insert into akun (nama, username, pass, lvel, no_telp, alamat) values (?,?,?,?,?,?)");
					
					ps.setString(1, txtNama.getText());
					ps.setString(2, txtUsername.getText());
					ps.setString(3, sandi);
					ps.setString(4, (String) cmbLevel.getSelectedItem());
					ps.setString(5, txtNoTelp.getText());
					ps.setString(6, txtAlamat.getText());
					ps.executeUpdate();
					ps.close();
					
					JOptionPane.showMessageDialog(null, "Username dan Password berhasil tersimpan!", "Pesan",JOptionPane.INFORMATION_MESSAGE);
					konek.close();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol simpan : "+ ex.getMessage(),"Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
				}
				finally
				{
					clear();
				}
				
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Passoword masih belum sama");
				clear();
			}
		}
		
		
		
	}
	
	private void change()
	{
		try
		{
			String username = txtUsername2.getText().toString();
			String password = passwordLama.getText().toString();
				
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select username, pass, lvel from akun where username='"+username+"' and pass='"+password+"' ");
			
			if(result.next())
			{
				if(passwordBaru.getText().equals(passwordCfmPassBaru.getText()))
				{
					try
					{
						konek = konek_database.getKonekDB();
						PreparedStatement ps = konek.prepareStatement("update akun set pass=? where username=?");
						ps.setString(1, passwordCfmPassBaru.getText());
						ps.setString(2, txtUsername2.getText());
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Password Berhasi diubah!","Pesan",JOptionPane.INFORMATION_MESSAGE);
						clear2();
						
						konek.close();
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol simpan : "+ ex.getMessage(),"Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "password baru yang anda masukkan belum sama.");
					clear2();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "username / password lama yang anda masukkan tidak sesuai.");
				clear2();
			}
		}
		catch(Exception ex)
		{
			
		}
		
			
		}
			
			
		
		
		
	
	
	public void clear()
	{
		txtNama.setText("");
		txtUsername.setText("");
		cmbLevel.setSelectedIndex(0);
		txtNoTelp.setText("");
		txtAlamat.setText("");
		txtPassword.setText("");
		txtCpassword.setText("");
	}
	
	public void clear2()
	{
		txtUsername2.setText("");
		passwordLama.setText("");
		passwordBaru.setText("");
		passwordCfmPassBaru.setText("");
	}
	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnSimpan)
			{
				add();
			}
			else if(e.getSource()==btnBatal)
			{
				clear();
			}
			else if(e.getSource()==btnUbah)
			{
				change();
			}
		}
	}
}
