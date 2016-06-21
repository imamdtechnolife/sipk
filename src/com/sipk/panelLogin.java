package com.sipk;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class panelLogin extends JPanel {
	private JButton btnMasuk;
	pasien_rawat_inap objP = new pasien_rawat_inap();
	


	/**
	 * Create the panel.
	 */
	public panelLogin() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(panelLogin.class.getResource("/com/sipk/Image/home-panel.png")));
		lblNewLabel.setBounds(0, 0, 1196, 584);
		add(lblNewLabel);

	}
}
