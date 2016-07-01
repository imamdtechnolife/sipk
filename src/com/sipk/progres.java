package com.sipk;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
//import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class progres extends JFrame {

	private JPanel contentPane;
	private Timer time;
	private int waktu = 0;

	public progres() {
		super("Mohon tunggu sebentar... ");
		setBounds(100, 100, 450, 64);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		contentPane.add(progressBar, BorderLayout.SOUTH);
		
		time = new Timer(100, new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						waktu++;
						progressBar.setValue(waktu);
						if(progressBar.getPercentComplete()==1)
						{
							time.stop();
							setVisible(false);
						}
						
					}
				});
		time.start();
		
	}
}
