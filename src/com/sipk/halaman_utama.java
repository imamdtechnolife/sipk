package com.sipk;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class halaman_utama extends JFrame{

	JMenu Menu = new JMenu("About");
	JMenuItem item1 = new JMenuItem("Developer");
	JMenuItem item2 = new JMenuItem("Rumah Sakit Bhayangkara Mataram");
	JMenuItem item3 = new JMenuItem("Keluar");
	JMenuBar menuBar = new JMenuBar();
	JPanel panelMenu = new JPanel();
	JButton pasien_rawat_inap = new JButton("Pasien Rawat Inap");
	JButton pasien_bersalin = new JButton("Pasien Bersalin");
	JButton jenis_penyakit = new JButton("Jenis Penyakit");
	JButton daftar_pasien = new JButton("Daftar Pasien");
	JPanel panelUtama = new JPanel();
	Container konten = getContentPane();
	JToolBar toolBar = new JToolBar();
	
	public halaman_utama()
	{
		super("Sistem Informasi Pelayanan Kesehatan Rumah Sakit Bhayangkara Mataram");
		setIconImage(Toolkit.getDefaultToolkit().getImage(halaman_utama.class.getResource("Image/address-book-new.png")));
		setLayout(new GridLayout(2,1));
		
		
		JPanel panelTombol = new JPanel();
		panelTombol.setLayout(new FlowLayout());
		panelTombol.add(jenis_penyakit);
		panelTombol.add(pasien_rawat_inap);
		panelTombol.add(pasien_bersalin);
		panelTombol.add(daftar_pasien);
		
		/**
		 * Pembuatan Menu
		 */
		Menu.add(item1);
		Menu.add(item2);
		Menu.addSeparator();
		Menu.add(item3);
		
		menuBar.add(Menu);
		//panelMenu.add(menuBar);
		
		/**
		 * pembuatan toolbar
		 */
		toolBar.setRollover(true);
		toolBar.add(new JButton("imam"));
		toolBar.addSeparator();
		toolBar.add(new JButton("selvi"));
		
		
		panelUtama.setLayout(new BorderLayout());
		//panelUtama.add(panelMenu, BorderLayout.NORTH);
		panelUtama.add(toolBar, BorderLayout.CENTER);
		panelUtama.add(panelTombol, BorderLayout.SOUTH);
		konten.add(menuBar);
		konten.add(panelUtama);
		
		penghendel hendel = new penghendel();
		jenis_penyakit.addActionListener(hendel);
		pasien_rawat_inap.addActionListener(hendel);
		pasien_bersalin.addActionListener(hendel);
		daftar_pasien.addActionListener(hendel);
	}
	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==jenis_penyakit)
			{
				jenis_penyakit frameJP = new jenis_penyakit();
				frameJP.setVisible(true);
				//frameJP.setResizable(true);
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
			else if(e.getSource()==daftar_pasien)
			{
				daftar_pasien pd = new daftar_pasien();
				pd.setVisible(true);
				pd.setLocationRelativeTo(null);
				
			}
		}
	}
}
