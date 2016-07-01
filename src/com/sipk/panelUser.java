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
	
	JPanel panelUbahPassword = new JPanel();
	JPanel newPanel2 = new JPanel();
	private JTable table;
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
	private JTable tabelUser;
	DefaultTableModel modelTabelUser = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Level", "Nama", "Username", "Password"
			}
		);
	
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
		table_3.setModel(modelTabelUser);
		scrollPane_2.setViewportView(table_3);
		panelDaftarPengguna.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(525, 47, 489, 393);
		panelDaftarPengguna.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNama.setBounds(30, 34, 64, 14);
		panel_2.add(lblNama);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblUsername.setBounds(30, 65, 96, 14);
		panel_2.add(lblUsername);
		
		txtNama = new JTextField();
		txtNama.setBounds(209, 34, 233, 29);
		panel_2.add(txtNama);
		txtNama.setColumns(10);
		
		btnSimpan = new JButton("Simpan");
		btnSimpan.setIcon(new ImageIcon(panelUser.class.getResource("/com/sipk/Image/Simpan.png")));
		btnSimpan.setBounds(155, 336, 105, 33);
		panel_2.add(btnSimpan);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(209, 65, 233, 29);
		panel_2.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblPassword.setBounds(30, 99, 96, 14);
		panel_2.add(lblPassword);
		
		JLabel lblKonfirmasiPassword = new JLabel("Konfirmasi Password");
		lblKonfirmasiPassword.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblKonfirmasiPassword.setBounds(30, 135, 154, 14);
		panel_2.add(lblKonfirmasiPassword);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblLevel.setBounds(30, 169, 105, 14);
		panel_2.add(lblLevel);
		
		JLabel lblNoTelpon = new JLabel("No. Telpon");
		lblNoTelpon.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblNoTelpon.setBounds(30, 201, 105, 14);
		panel_2.add(lblNoTelpon);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblAlamat.setBounds(30, 237, 105, 14);
		panel_2.add(lblAlamat);
		
		cmbLevel = new JComboBox();
		cmbLevel.setBounds(209, 169, 135, 29);
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
		txtNoTelp.setBounds(209, 204, 233, 29);
		panel_2.add(txtNoTelp);
		
		btnBatal = new JButton("Batal");
		btnBatal.setIcon(new ImageIcon(panelUser.class.getResource("/com/sipk/Image/Batal.png")));
		btnBatal.setBounds(280, 336, 105, 33);
		panel_2.add(btnBatal);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(209, 96, 233, 29);
		panel_2.add(txtPassword);
		
		txtCpassword = new JPasswordField();
		txtCpassword.setBounds(209, 131, 233, 29);
		panel_2.add(txtCpassword);
		
		JLabel lblPerhatian = new JLabel("");
		lblPerhatian.setBounds(145, 315, 226, 14);
		panel_2.add(lblPerhatian);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(209, 240, 233, 59);
		panel_2.add(scrollPane_1);
		
		txtAlamat = new JTextArea();
		scrollPane_1.setViewportView(txtAlamat);
		
		JLabel lblDaftarPengguna = new JLabel("Daftar Pengguna");
		lblDaftarPengguna.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblDaftarPengguna.setBounds(24, 11, 245, 33);
		panelDaftarPengguna.add(lblDaftarPengguna);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 75, 455, 404);
		panelDaftarPengguna.add(scrollPane);
		
		tabelUser = new JTable();
		tabelUser.setModel(modelTabelUser);
		scrollPane.setViewportView(tabelUser);
		tabbedPane.addTab("Ubah Password", null, panelUbahPassword, null);
		panelUbahPassword.setLayout(null);
		
		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblUsername_1.setBounds(61, 74, 85, 26);
		panelUbahPassword.add(lblUsername_1);
		
		JLabel lblPasswordBaru = new JLabel("Password Baru");
		lblPasswordBaru.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblPasswordBaru.setBounds(61, 150, 132, 26);
		panelUbahPassword.add(lblPasswordBaru);
		
		txtUsername2 = new JTextField();
		txtUsername2.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		txtUsername2.setBounds(232, 71, 141, 29);
		panelUbahPassword.add(txtUsername2);
		txtUsername2.setColumns(10);
		
		btnUbah = new JButton("Ubah");
		btnUbah.setIcon(new ImageIcon(panelUser.class.getResource("/com/sipk/Image/Ubah.png")));
		btnUbah.setBounds(176, 252, 105, 33);
		panelUbahPassword.add(btnUbah);
		
		passwordLama = new JPasswordField();
		passwordLama.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		passwordLama.setBounds(232, 108, 141, 29);
		panelUbahPassword.add(passwordLama);
		
		passwordBaru = new JPasswordField();
		passwordBaru.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		passwordBaru.setBounds(232, 147, 141, 29);
		panelUbahPassword.add(passwordBaru);
		
		passwordCfmPassBaru = new JPasswordField();
		passwordCfmPassBaru.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		passwordCfmPassBaru.setBounds(232, 190, 141, 29);
		panelUbahPassword.add(passwordCfmPassBaru);
		
		JLabel lblUlangPasswordBaru = new JLabel("Ulang Password Baru");
		lblUlangPasswordBaru.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblUlangPasswordBaru.setBounds(61, 193, 161, 23);
		panelUbahPassword.add(lblUlangPasswordBaru);
		
		JLabel lblPasswordLama = new JLabel("Password Lama");
		lblPasswordLama.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblPasswordLama.setBounds(61, 111, 132, 28);
		panelUbahPassword.add(lblPasswordLama);
		
		JLabel lblUbahPassword = new JLabel("Ubah Password");
		lblUbahPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblUbahPassword.setBounds(24, 11, 254, 36);
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
		
		tampilIsiTabelUser();

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
					tampilIsiTabelUser();
				}
				
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Passoword masih belum sama");
				clear();
			}
		}
		
		
		
	}
	
	public void tampilIsiTabelUser()
	{
		modelTabelUser.getDataVector().removeAllElements();
		modelTabelUser.fireTableDataChanged();
		
		try
		{
			konek = konek_database.getKonekDB();
			Statement state = konek.createStatement();
			ResultSet result = state.executeQuery("select lvel,nama,username,pass from akun");
			
			while(result.next())
			{
				Object obj[] = new Object[4];
				obj[0] = result.getString(1);
				obj[1] = result.getString(2);
				obj[2] = result.getString(3);
				obj[3] = result.getString(4);
				
				modelTabelUser.addRow(obj);
			}
			
			//result.close();
			//state.close();
			//konek.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tampil tabel : "+ex.getMessage());
		}
		finally
		{
			
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
					tampilIsiTabelUser();
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
