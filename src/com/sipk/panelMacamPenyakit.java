package com.sipk;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;


public class panelMacamPenyakit extends JPanel {
	private JTextField txtDaftarTerperinci;
	private JTable table;
	private JTextField txtNoDtd;
	private JButton btnSimpan;
	private JButton btnBatal;
	private DefaultTableModel modelTabelMacamPenyakit = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No. Daftar Terperinci", "No. DTD", "Macam Penyakit"
			}
		);
	Connection konek = null;
	private JTextArea txtMacamPenyakit;

	/**
	 * Create the panel.
	 */
	public panelMacamPenyakit() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 880, 709);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Macam Penyakit");
		lblNewLabel.setBounds(25, 11, 327, 33);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		
		JLabel lblNoDtd = new JLabel("No. DTD");
		lblNoDtd.setBounds(53, 77, 86, 14);
		panel.add(lblNoDtd);
		lblNoDtd.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JLabel lblNoDaftarTerperinci = new JLabel("No. Daftar Terperinci");
		lblNoDaftarTerperinci.setBounds(52, 114, 156, 30);
		panel.add(lblNoDaftarTerperinci);
		lblNoDaftarTerperinci.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		txtDaftarTerperinci = new JTextField();
		txtDaftarTerperinci.setBounds(231, 117, 86, 29);
		panel.add(txtDaftarTerperinci);
		txtDaftarTerperinci.setColumns(10);
		
		JLabel lblMacamPenyakit = new JLabel("Macam Penyakit");
		lblMacamPenyakit.setBounds(53, 163, 156, 29);
		panel.add(lblMacamPenyakit);
		lblMacamPenyakit.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(231, 170, 267, 85);
		panel.add(scrollPane_1);
		
		txtMacamPenyakit = new JTextArea();
		scrollPane_1.setViewportView(txtMacamPenyakit);
		
		btnSimpan = new JButton("Simpan");
		btnSimpan.setBounds(225, 305, 99, 33);
		panel.add(btnSimpan);
		btnSimpan.setIcon(new ImageIcon(panelMacamPenyakit.class.getResource("/com/sipk/Image/Simpan.png")));
		
		btnBatal = new JButton("Batal");
		btnBatal.setBounds(345, 304, 99, 33);
		panel.add(btnBatal);
		btnBatal.setIcon(new ImageIcon(panelMacamPenyakit.class.getResource("/com/sipk/Image/Batal.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 398, 576, 118);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelTabelMacamPenyakit);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(439);
		scrollPane.setViewportView(table);
		
		txtNoDtd = new JTextField();
		txtNoDtd.setBounds(231, 75, 86, 25);
		panel.add(txtNoDtd);
		txtNoDtd.setColumns(10);
		
		penghendel hendel = new penghendel();
		btnSimpan.addActionListener(hendel);
		
		tampilIsiTabel();

	}
	
	public void simpanMacamPenyakit()
	{
		try
		{
			konek = konek_database.getKonekDB();
			PreparedStatement ps = konek.prepareStatement("insert into macam_penyakit (no_icd10,no_dtd,macam_penyakit) values (?,?,?)");
			ps.setString(1, txtDaftarTerperinci.getText());
			ps.setString(2, txtNoDtd.getText());
			ps.setString(3, txtMacamPenyakit.getText());
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan!");
			ps.close();
			konek.close();
			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada method simpanMacamPenyakit : "+ex.getMessage());
		}
		finally
		{
			bersihMacamPenyakit();
		}
	}
	
	public void bersihMacamPenyakit()
	{
		txtNoDtd.setText("");
		txtDaftarTerperinci.setText("");
		txtMacamPenyakit.setText("");
	}
	
	public void tampilIsiTabel()
	{
		modelTabelMacamPenyakit.getDataVector().removeAllElements();
		modelTabelMacamPenyakit.fireTableDataChanged();
		
		try
		{
		konek = konek_database.getKonekDB();
		Statement state = konek.createStatement();
		ResultSet result = state.executeQuery("select no_icd10,no_dtd,macam_penyakit from macam_penyakit");
		
		while(result.next())
		{
			Object obj[] = new Object[3];
			obj[0] = result.getString(1);
			obj[1] = result.getString(2);
			obj[2] = result.getString(3);
			
			modelTabelMacamPenyakit.addRow(obj);		
		}
		state.close();
		result.close();
		konek.close();
		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tampilTabel : "+ex.getMessage());
		}
		finally
		{
			
		}
	}
	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnSimpan)
			{
				simpanMacamPenyakit();
				tampilIsiTabel();
			}
			else if(e.getSource()==btnBatal)
			{
				bersihMacamPenyakit();
			}
		}
	}
}
