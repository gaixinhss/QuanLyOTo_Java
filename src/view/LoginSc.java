//package BTL;
package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
public class LoginSc extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JPasswordField txtpass;
	public static LoginSc frame = new LoginSc();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//LoginSc frame = new LoginSc();
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
	public LoginSc() {
		setTitle("LOG IN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setForeground(new Color(255, 128, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(217, 122, 100, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 128, 255));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblPassword.setBounds(217, 191, 121, 36);
		contentPane.add(lblPassword);
		
		txtname = new JTextField();
		txtname.setBounds(393, 122, 220, 36);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(393, 191, 220, 36);
		contentPane.add(txtpass);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.setForeground(new Color(255, 128, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnNewButton.setBounds(313, 275, 154, 43);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String name= txtname.getText();
				String pass=String.valueOf(txtpass.getPassword());
				try {
					if(checkLogIn(name, pass)) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								setVisible(false);
								mainScreen window = new mainScreen();
							}
						});
					}
					else JOptionPane.showMessageDialog(null,"Tài khoản mật khẩu không tồn tại!");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(293, 32, 208, 50);
		contentPane.add(lblNewLabel_1);
		
		setLocationRelativeTo(null);
	}
	//ghi acc new vÃ o file
	public boolean addLogIn(String name, String pass) throws IOException {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("account.bin");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(name);
			oos.writeObject(pass);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(fos!=null) {
				fos.close();
			}
			if(oos!=null) {
				oos.close();
			}
		}
		return true;
	}
	//Kiem tra thÃ´ng tin Ä‘Äƒng nháº­p
	public boolean checkLogIn(String name, String pass) throws IOException {
		String nameLogIn="", passLogIn="";
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("account.bin");
			ois = new ObjectInputStream(fis);
			nameLogIn=(String)ois.readObject();
			passLogIn=(String)ois.readObject();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(fis!=null) {
				fis.close();
			}
			if(ois!=null) {
				ois.close();
			}
		}
		if(nameLogIn.equals(name)&&passLogIn.equals(pass)) {
			return true;
			}
		else return false;
		}
	}

