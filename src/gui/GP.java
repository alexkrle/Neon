package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GP frame = new GP();
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
	public GP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Ubaci studenta");
		button.setBounds(146, 11, 131, 23);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UbacivanjeStudenta us = new UbacivanjeStudenta();
				us.setVisible(true);
			}
		});
		
		JButton button_1 = new JButton("Izmeni podatke");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IzmenaStudenta is = new IzmenaStudenta();
				is.setVisible(true);
			}
		});
		button_1.setBounds(147, 69, 130, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Prikazi studente");
		button_2.setBounds(146, 157, 131, 23);
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Tabela t = new Tabela();
				t.setVisible(true);
			}
		});
		
		
		JButton button_3 = new JButton("Obrisi studenta");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObrisiStudenta os = new ObrisiStudenta();
				os.setVisible(true);
			}
		});
		button_3.setBounds(146, 215, 131, 23);
		contentPane.add(button_3);
	}
}
