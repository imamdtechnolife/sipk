package com.sipk;

import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.freixas.jcalendar.JCalendarCombo;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import java.awt.EventQueue;

public class kelas_utama {
	public static void main(String[]args)
	{	
		EventQueue.invokeLater(new Runnable()
		{
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.generalNoTranslucencyShadow;
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					UIManager.put("RootPane.setupButtonVisible", false);
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tema : "+ex.getMessage(),"Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
					}
					
				
				//	halaman_utama objk = new halaman_utama();
				//	objk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//	objk.setSize(906,666);
				//	objk.setVisible(true);
				//	objk.setLocationRelativeTo(null);
				
				hal_utama frame = new hal_utama();
				frame.setVisible(true);
			}
		}
				);
		
		
		
		
	}
}
