package com.sipk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class daftar_pasien extends JFrame {

	private JPanel contentPane;
	private JTextField txtNama;
	private JTextField txtUmur;
	private JTextField txtNoUrut;
	private JTextField txtNoCM;
	private JTextField txtKeterangan;

	/**
	 * Launch the application.
	 */
	
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					daftar_pasien frame = new daftar_pasien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	**/

	/**
	 * Create the frame.
	 */
	public daftar_pasien() {
		
		setBounds(100, 100, 828, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Form Input", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(39, 53, 733, 340);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNamaPasien = new JLabel("Nama");
		lblNamaPasien.setBounds(22, 57, 46, 14);
		panel.add(lblNamaPasien);
		
		JLabel lblUmur = new JLabel("Umur");
		lblUmur.setBounds(22, 82, 46, 14);
		panel.add(lblUmur);
		
		JLabel lblNoUrut = new JLabel("No. Urut");
		lblNoUrut.setBounds(22, 25, 46, 14);
		panel.add(lblNoUrut);
		
		JLabel lblNoCM = new JLabel("No. CM");
		lblNoCM.setBounds(448, 25, 46, 14);
		panel.add(lblNoCM);
		
		JLabel lblJenisKelamin = new JLabel("Jenis Kelamin");
		lblJenisKelamin.setBounds(22, 107, 90, 14);
		panel.add(lblJenisKelamin);
		
		JLabel lblPangkat = new JLabel("Pangkat");
		lblPangkat.setBounds(22, 136, 90, 14);
		panel.add(lblPangkat);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(22, 161, 90, 14);
		panel.add(lblStatus);
		
		JLabel lblBagianYangDikunjungi = new JLabel("Bagian Yang Dikunjungi");
		lblBagianYangDikunjungi.setBounds(22, 269, 111, 14);
		panel.add(lblBagianYangDikunjungi);
		
		JLabel lblDiagnosa = new JLabel("Diagnosa");
		lblDiagnosa.setBounds(385, 57, 90, 14);
		panel.add(lblDiagnosa);
		
		JLabel lblKeterangan = new JLabel("Keterangan");
		lblKeterangan.setBounds(386, 158, 66, 14);
		panel.add(lblKeterangan);
		
		txtNama = new JTextField();
		txtNama.setBounds(142, 54, 184, 20);
		panel.add(txtNama);
		txtNama.setColumns(10);
		
		txtUmur = new JTextField();
		txtUmur.setColumns(10);
		txtUmur.setBounds(142, 79, 49, 20);
		panel.add(txtUmur);
		
		JRadioButton rdbtnPria = new JRadioButton("Pria");
		rdbtnPria.setBounds(140, 103, 75, 23);
		panel.add(rdbtnPria);
		
		JRadioButton rdbtnWanita = new JRadioButton("Wanita");
		rdbtnWanita.setBounds(228, 103, 90, 23);
		panel.add(rdbtnWanita);
		
		JLabel lblTh = new JLabel("Th");
		lblTh.setBounds(199, 82, 46, 14);
		panel.add(lblTh);
		
		JComboBox comboPangkat = new JComboBox();
		comboPangkat.setBounds(142, 133, 103, 20);
		panel.add(comboPangkat);
		
		JLabel lblKesatuan = new JLabel("Kesatuan");
		lblKesatuan.setBounds(22, 291, 111, 14);
		panel.add(lblKesatuan);
		
		JRadioButton rdbtnAngkatanSendiri = new JRadioButton("Angkatan Sendiri");
		rdbtnAngkatanSendiri.setBounds(140, 157, 123, 23);
		panel.add(rdbtnAngkatanSendiri);
		
		JRadioButton rdbtnAngkatanLain = new JRadioButton("Angkatan Lain");
		rdbtnAngkatanLain.setBounds(140, 183, 123, 23);
		panel.add(rdbtnAngkatanLain);
		
		JRadioButton rdbtnPurnawirawan = new JRadioButton("Purnawirawan");
		rdbtnPurnawirawan.setBounds(140, 210, 123, 23);
		panel.add(rdbtnPurnawirawan);
		
		JRadioButton rdbtnUmum = new JRadioButton("Umum");
		rdbtnUmum.setBounds(139, 242, 123, 23);
		panel.add(rdbtnUmum);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(142, 266, 103, 20);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(142, 288, 103, 20);
		panel.add(comboBox_1);
		
		txtNoUrut = new JTextField();
		txtNoUrut.setColumns(10);
		txtNoUrut.setBounds(142, 22, 49, 20);
		panel.add(txtNoUrut);
		
		txtNoCM = new JTextField();
		txtNoCM.setColumns(10);
		txtNoCM.setBounds(522, 22, 90, 20);
		panel.add(txtNoCM);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(458, 82, 233, 69);
		panel.add(textPane);
		
		txtKeterangan = new JTextField();
		txtKeterangan.setColumns(10);
		txtKeterangan.setBounds(462, 158, 184, 20);
		panel.add(txtKeterangan);
		
		JRadioButton rdbtnBaru = new JRadioButton("Baru");
		rdbtnBaru.setBounds(458, 48, 86, 23);
		panel.add(rdbtnBaru);
		
		JRadioButton rdbtnUlangan = new JRadioButton("Ulangan");
		rdbtnUlangan.setBounds(546, 49, 100, 23);
		panel.add(rdbtnUlangan);
		
		JButton btnTambah = new JButton("Tambah");
		btnTambah.setBounds(541, 287, 89, 23);
		panel.add(btnTambah);
		
		JLabel lblJudul = new JLabel("Daftar Pasien");
		lblJudul.setBounds(339, 11, 175, 31);
		contentPane.add(lblJudul);
		
		JTabbedPane tabInput = new JTabbedPane(JTabbedPane.TOP);
		tabInput.setBounds(376, 100, -287, -36);
		contentPane.add(tabInput);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, txtNoUrut, txtNama, txtUmur, rdbtnPria, rdbtnWanita, comboPangkat, rdbtnAngkatanSendiri, rdbtnAngkatanLain, rdbtnPurnawirawan, rdbtnUmum, comboBox, comboBox_1, rdbtnBaru, rdbtnUlangan, textPane, txtKeterangan, panel, btnTambah, lblNamaPasien, lblUmur, lblNoUrut, lblNoCM, lblJenisKelamin, lblPangkat, lblStatus, lblBagianYangDikunjungi, lblDiagnosa, lblKeterangan, lblTh, lblKesatuan, txtNoCM, lblJudul, tabInput}));
	}
}
