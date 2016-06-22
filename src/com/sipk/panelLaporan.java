package com.sipk;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class panelLaporan extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelLaporan() {
		setLayout(null);
		
		JButton btnLaporanJenisPenyakit = new JButton("Laporan Jenis Penyakit per-Bulan");
		btnLaporanJenisPenyakit.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		btnLaporanJenisPenyakit.setBounds(408, 80, 279, 86);
		add(btnLaporanJenisPenyakit);
		
		JButton btnLaporanRawatJalan = new JButton("Laporan Rawat Jalan per-Bulan");
		btnLaporanRawatJalan.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		btnLaporanRawatJalan.setBounds(408, 193, 279, 86);
		add(btnLaporanRawatJalan);
		
		JButton btnLaporanRawatInap = new JButton("Laporan Rawat Inap per-Bulan");
		btnLaporanRawatInap.setIcon(new ImageIcon(panelLaporan.class.getResource("/com/sipk/Image/report.png")));
		btnLaporanRawatInap.setBounds(408, 303, 279, 86);
		add(btnLaporanRawatInap);

	}
}
