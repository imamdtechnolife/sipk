package com.sipk;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class panelLogin extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnMasuk;
	pasien_rawat_inap objP = new pasien_rawat_inap();
	


	/**
	 * Create the panel.
	 */
	public panelLogin() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(219, 112, 221, 177);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 45, 67, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 78, 67, 14);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(87, 42, 113, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(87, 75, 113, 20);
		panel.add(passwordField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(74, 11, 60, 20);
		panel.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("warning!");
		lblNewLabel.setBounds(87, 152, 46, 14);
		panel.add(lblNewLabel);
		
		JButton btnMasuk = new JButton("Masuk");
		btnMasuk.setBounds(87, 118, 73, 23);
		panel.add(btnMasuk);
		
		penghendel hendel = new penghendel();
		btnMasuk.addActionListener(hendel);

	}
	

	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnMasuk)
			{
				
				hal_utama objLuar = new hal_utama();
				objLuar.btnBersalin.setEnabled(false);
				objLuar.btnDaftarPenyakit.setEnabled(false);
				objLuar.btnDokter.setEnabled(false);
				objLuar.btnBersalin.setEnabled(false);
				objLuar.btnLaporan.setEnabled(false);
				objLuar.btnPembayaran.setEnabled(false);
				objLuar.btnRawatJalan.setEnabled(false);
				objLuar.btnRawatInap.setEnabled(false);
				
			}
			
		}
	}
}
