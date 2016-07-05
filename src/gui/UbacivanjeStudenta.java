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

public class UbacivanjeStudenta extends JFrame {

	private JPanel contentPane;
	private JTextField tfIme;
	private JTextField tfPrezime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UbacivanjeStudenta frame = new UbacivanjeStudenta();
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
	public UbacivanjeStudenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("ime:");
		lblIme.setBounds(39, 40, 46, 14);
		contentPane.add(lblIme);
		
		JLabel lblPrezime = new JLabel("prezime:");
		lblPrezime.setBounds(39, 91, 46, 14);
		contentPane.add(lblPrezime);
		
		tfIme = new JTextField();
		tfIme.setBounds(112, 37, 128, 20);
		contentPane.add(tfIme);
		tfIme.setColumns(10);
		
		tfPrezime = new JTextField();
		tfPrezime.setBounds(112, 88, 128, 20);
		contentPane.add(tfPrezime);
		tfPrezime.setColumns(10);
		
		JButton btnUbaciStudenta = new JButton("Ubaci studenta");
		btnUbaciStudenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student s = new Student();
				s.setIme(tfIme.getText());
				s.setPrezime(tfPrezime.getText());
				StudentCrud sc = new StudentCrud();
				sc.insertStudent(s);
			}
		});
		btnUbaciStudenta.setBounds(309, 227, 115, 23);
		contentPane.add(btnUbaciStudenta);
	}
}
