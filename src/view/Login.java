package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller_Interior;
import controller.Controller_Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginSc loginSc = new LoginSc();
				loginSc.setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(477, 209, 171, 52);
		contentPane.add(btnLogin);
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SignUpSc signUpSc;
				try {
					signUpSc = new SignUpSc();
					signUpSc.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	
			}
		});
		btnCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreateAccount.setBounds(223, 209, 188, 52);
		contentPane.add(btnCreateAccount);
		
		JLabel lblNewLabel = new JLabel("Quản lý Car, Interior, Tour");
		lblNewLabel.setForeground(new Color(255, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(201, 34, 499, 131);
		contentPane.add(lblNewLabel);
		
		setLocationRelativeTo(null);
	}
}
