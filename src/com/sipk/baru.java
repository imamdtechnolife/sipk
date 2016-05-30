package com.sipk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class baru extends JFrame{

	private JButton mahasiswa = new JButton("Mahasiswa");
	
	public baru()
	{
		super("Imam Afriyadi");
		setLayout(new FlowLayout());
		
		JPanel panelUtama = new JPanel();
		panelUtama.add(mahasiswa);
		
		add(panelUtama);
		
		Penghendel hendel = new Penghendel();
		mahasiswa.addActionListener(hendel);
	}
	
	private class Penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(null, "Nama Saya Imam Afriyadi");
		}
	}
	
	public static void main(String[]args)
	{
		baru obj = new baru();
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
		obj.setSize(300,300);
	}
	
	
	
	
}


