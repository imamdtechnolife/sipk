package com.sipk;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class panelPemeriksaan extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelPemeriksaan() {
		setLayout(new GridLayout(0,1));	
		setVisible(true);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1058, 750);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lblResumeRawatJalan = new JLabel("Resume Rawat Jalan");
		lblResumeRawatJalan.setBounds(50, 30, 162, 14);
		panel.add(lblResumeRawatJalan);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(50, 78, 84, 14);
		panel.add(lblNama);
		
		JLabel lblUmur = new JLabel("Umur");
		lblUmur.setBounds(50, 103, 84, 14);
		panel.add(lblUmur);
		
		JLabel lblJenisKelamin = new JLabel("Jenis Kelamin");
		lblJenisKelamin.setBounds(50, 128, 84, 14);
		panel.add(lblJenisKelamin);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setBounds(50, 153, 84, 14);
		panel.add(lblAlamat);
		
		JLabel lblPangkat = new JLabel("Pangkat");
		lblPangkat.setBounds(50, 181, 84, 14);
		panel.add(lblPangkat);
		
		JLabel lblNoRm = new JLabel("No. RM");
		lblNoRm.setBounds(400, 78, 84, 14);
		panel.add(lblNoRm);
		
		JLabel lblRuangan = new JLabel("Ruangan");
		lblRuangan.setBounds(400, 103, 84, 14);
		panel.add(lblRuangan);
		
		JLabel lblTglMasuk = new JLabel("Tgl. Masuk");
		lblTglMasuk.setBounds(400, 128, 84, 14);
		panel.add(lblTglMasuk);
		
		JLabel lblKeluar = new JLabel("Tgl. Keluar");
		lblKeluar.setBounds(400, 153, 84, 14);
		panel.add(lblKeluar);
		
		JLabel lblDokter = new JLabel("Dokter");
		lblDokter.setBounds(400, 181, 84, 14);
		panel.add(lblDokter);
		
		JLabel lblDiagnosaPrimer = new JLabel("Diagnosa Primer");
		lblDiagnosaPrimer.setBounds(50, 225, 84, 14);
		panel.add(lblDiagnosaPrimer);
		
		JLabel lblDiagnosaSekunder = new JLabel("Diagnosa Sekunder :");
		lblDiagnosaSekunder.setBounds(50, 259, 117, 14);
		panel.add(lblDiagnosaSekunder);
		
		JLabel label = new JLabel("1.");
		label.setBounds(181, 283, 18, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setBounds(181, 308, 18, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setBounds(181, 333, 18, 14);
		panel.add(label_2);
		
		JLabel lblProsedur = new JLabel("Prosedur :");
		lblProsedur.setBounds(50, 377, 78, 14);
		panel.add(lblProsedur);
		
		JLabel label_3 = new JLabel("1.");
		label_3.setBounds(135, 397, 18, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("2.");
		label_4.setBounds(135, 422, 18, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("3.");
		label_5.setBounds(135, 447, 18, 14);
		panel.add(label_5);
		
		JLabel lblRingkasanRiwayatPenemuan = new JLabel("Ringkasan riwayat penemuan fisik penting :");
		lblRingkasanRiwayatPenemuan.setBounds(50, 492, 223, 14);
		panel.add(lblRingkasanRiwayatPenemuan);
		
		JLabel lblRiwayatAnamneses = new JLabel("Riwayat ( anamneses ) :");
		lblRiwayatAnamneses.setBounds(76, 517, 223, 14);
		panel.add(lblRiwayatAnamneses);
		
		JLabel lblPemeriksaanFisik = new JLabel("Pemeriksaan Fisik :");
		lblPemeriksaanFisik.setBounds(76, 550, 223, 14);
		panel.add(lblPemeriksaanFisik);
		
		JLabel lblHasilHasil = new JLabel("Hasil - hasil laboratorium, rontegen dan konsultasi (yang penting) :");
		lblHasilHasil.setBounds(50, 591, 325, 14);
		panel.add(lblHasilHasil);
		
		JLabel lblPerkembanganSelamaPerawatan = new JLabel("Perkembangan selama perawatan / dengan komplikasi (jika ada) :");
		lblPerkembanganSelamaPerawatan.setBounds(50, 629, 325, 14);
		panel.add(lblPerkembanganSelamaPerawatan);
		
		JLabel lblKeadaanPasienPengobatan = new JLabel("Keadaan pasien, pengobatan, kesimpulan pada saat keluar dari rumah sakit dan diagnose :");
		lblKeadaanPasienPengobatan.setBounds(50, 669, 443, 14);
		panel.add(lblKeadaanPasienPengobatan);
		
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.getViewport().add(panel);
		tabbedPane.addTab("Resume Rawat Jalan", null, scrollPanel, null);

	}
}
