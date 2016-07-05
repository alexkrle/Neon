package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.StudentCrud;
import model.Student;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ObrisiStudenta extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObrisiStudenta frame = new ObrisiStudenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ObrisiStudenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(29, 33, 46, 14);
		contentPane.add(lblId);
		
		tfID = new JTextField();
		tfID.setBounds(122, 30, 120, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentCrud sc = new StudentCrud();
				Student s = sc.findStudent(Integer.parseInt(tfID.getText()));
				sc.deleteStudent(s);
			}
		});
		btnObrisi.setBounds(141, 116, 89, 23);
		contentPane.add(btnObrisi);
	}

}
