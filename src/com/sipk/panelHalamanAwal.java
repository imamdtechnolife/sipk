package com.sipk;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class panelHalamanAwal extends JPanel {
	
	public panelHalamanAwal() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(panelHalamanAwal.class.getResource("/com/sipk/Image/home-panel4.png")));
		lblNewLabel.setBounds(0, 0, 1356, 580);
		add(lblNewLabel);

	}
}
