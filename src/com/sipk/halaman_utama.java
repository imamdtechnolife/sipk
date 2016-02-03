package com.sipk;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class halaman_utama extends JFrame{

	JButton pasien_rawat_inap = new JButton("Pasien Rawat Inap");
	JButton pasien_bersalin = new JButton("Pasien Bersalin");
	JButton jenis_penyakit = new JButton("Jenis Penyakit");
	
	public halaman_utama()
	{
		super("Sistem Informasi Pelayanan Kesehatan Rumah Sakit Bhayangkara Mataram");
		setIconImage(Toolkit.getDefaultToolkit().getImage(halaman_utama.class.getResource("Image/address-book-new.png")));
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.GRAY);
		
		JPanel panelTombol = new JPanel();
		panelTombol.setLayout(new FlowLayout());
		panelTombol.add(jenis_penyakit);
		panelTombol.add(pasien_rawat_inap);
		panelTombol.add(pasien_bersalin);
		
		add(panelTombol);
		
		penghendel hendel = new penghendel();
		jenis_penyakit.addActionListener(hendel);
		pasien_rawat_inap.addActionListener(hendel);
		pasien_bersalin.addActionListener(hendel);
	}
	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==jenis_penyakit)
			{
				jenis_penyakit frameJP = new jenis_penyakit();
				frameJP.setVisible(true);
				frameJP.setResizable(true);
				frameJP.setSize(1058, 666);
			}
			else if(e.getSource()==pasien_rawat_inap)
			{	
				pasien_rawat_inap obj = new pasien_rawat_inap();
				obj.setVisible(true);
				obj.setSize(1058,666);
				obj.setLocationRelativeTo(null);
			
			}
			else if(e.getSource()==pasien_bersalin)
			{
				pasien_bersalin pb = new pasien_bersalin();
				pb.setVisible(true);
				pb.setSize(1058, 666);
				pb.setLocationRelativeTo(null);
			}
		}
	}
}
