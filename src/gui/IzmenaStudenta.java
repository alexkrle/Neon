package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.StudentCrud;
import model.Student;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzmenaStudenta extends JFrame {

	private JPanel contentPane;
	private JTextField tfIme;
	private JTextField tfPrezime;
	private StudentCrud sc = new StudentCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzmenaStudenta frame = new IzmenaStudenta();
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
	public IzmenaStudenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(45, 28, 121, 20);
		contentPane.add(comboBox);
		List<Student> studenti =  sc.getLista();
		for(Student s : studenti){
			comboBox.addItem(s);
		}
		//budzzzzzzzzzzz
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				tfIme.setText(comboBox.getSelectedItem().toString().substring(0, comboBox.getSelectedItem().toString().lastIndexOf(" ")));
				tfPrezime.setText(comboBox.getSelectedItem().toString().substring(comboBox.getSelectedItem().toString().lastIndexOf(" "), comboBox.getSelectedItem().toString().length()));
			}
		});
		
		
		tfIme = new JTextField();
		tfIme.setBounds(144, 71, 86, 20);
		contentPane.add(tfIme);
		tfIme.setColumns(10);
		tfIme.setText(comboBox.getSelectedItem().toString().substring(0, comboBox.getSelectedItem().toString().lastIndexOf(" ")));
		
		tfPrezime = new JTextField();
		tfPrezime.setBounds(144, 119, 86, 20);
		contentPane.add(tfPrezime);
		tfPrezime.setColumns(10);
		tfPrezime.setText(comboBox.getSelectedItem().toString().substring(comboBox.getSelectedItem().toString().lastIndexOf(" "), comboBox.getSelectedItem().toString().length()));

		JLabel lblIme = new JLabel("ime:");
		lblIme.setBounds(36, 74, 46, 14);
		contentPane.add(lblIme);
		
		JLabel lblPrezime = new JLabel("prezime:");
		lblPrezime.setBounds(36, 122, 46, 14);
		contentPane.add(lblPrezime);
		
		JButton btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student s = (Student) comboBox.getSelectedItem();
				System.out.println(s.getIdStudenta());
				s.setIme(tfIme.getText());
				s.setPrezime(tfPrezime.getText());
				sc.updateStudent(s);
			}
		});
		btnIzmeni.setBounds(283, 192, 89, 23);
		contentPane.add(btnIzmeni);
	}
}
