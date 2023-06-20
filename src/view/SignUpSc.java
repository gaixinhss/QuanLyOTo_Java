package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignUpSc extends JFrame {

	private JPanel contentPane;
	public  JTextField txtTenNguoiDung;
	public JTextField txtTenTK;
	public JComboBox<Integer> cbbNamSinh;
	private JPasswordField txtMatKhau;
	private JPasswordField txtConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpSc frame = new SignUpSc();
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
	public SignUpSc() throws IOException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 608);
		setTitle("SIGN UP");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTenNguoiDung = new JTextField();
		txtTenNguoiDung.setBounds(425, 143, 237, 39);
		contentPane.add(txtTenNguoiDung);
		txtTenNguoiDung.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setForeground(new Color(255, 128, 192));
		lblNewLabel.setBounds(368, 11, 166, 77);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(188, 260, 203, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Người Dùng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(188, 143, 203, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên Tài Khoản");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_2.setBounds(188, 204, 203, 39);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nhập Lại Mật Khẩu");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_3.setBounds(188, 330, 203, 40);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Năm Sinh");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_3_1.setBounds(188, 398, 203, 37);
		contentPane.add(lblNewLabel_1_3_1);
		
		txtTenTK = new JTextField();
		txtTenTK.setColumns(10);
		txtTenTK.setBounds(425, 204, 237, 39);
		contentPane.add(txtTenTK);
		
		JComboBox<Integer> cbbNamSinh = new JComboBox<Integer>();
		LocalDate localDate = LocalDate.now();
	    int year = localDate.getYear();
		for(int i=1970;i<=year;i++) {
			cbbNamSinh.addItem(i);
		}
		cbbNamSinh.setSelectedIndex(year-1970);
		cbbNamSinh.setBounds(425, 396, 237, 39);
		
		contentPane.add(cbbNamSinh);
		
		JButton btnDangKi = new JButton("Đăng Kí");
		btnDangKi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//khai bao ham time
				LocalDate localDate = LocalDate.now();
				//lay year hiẹn tai
				int year = localDate.getYear();
				//lay nam sinh từ cbb
				int namsinh=(int) cbbNamSinh.getSelectedItem();
			
				
				String name=txtTenTK.getText();
				String pass=String.valueOf(txtMatKhau.getPassword());
				String passConfirm=String.valueOf(txtConfirm.getPassword());
				try {
					if(pass.length()<=0) {
						JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu!");
					}else if(txtTenNguoiDung.getText().length()<=0) {
						JOptionPane.showMessageDialog(null, "Chưa nhập tên người dùng!");
					}else if(txtTenTK.getText().length()<=0) {
						JOptionPane.showMessageDialog(null, "Chưa nhập tên tài khoản!");
					}else if(checkTK(name)==true) {
						JOptionPane.showMessageDialog(null, "Tên tài khoản đã tồn tại!");
					}else if(year-namsinh<18) {
						JOptionPane.showMessageDialog(null, "Bạn chưa đủ 18 tuổi!");
					}else if(pass.equals(passConfirm)==false) {
						JOptionPane.showMessageDialog(null, "Mật Khẩu Chưa Trùng Nhau!");
					}else if(pass.matches("((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@$!%*#?&]).{8,})")==false) {
						JOptionPane.showMessageDialog(null, "Mật Khẩu phải có ít nhất 8 kí tự; bao gồm ký tự đặc biệt, chữ hoa, chữ thường và số!");
					}
					else if(name.matches("[a-z0-9_-]{6,12}$")==false) {
						JOptionPane.showMessageDialog(null,"Tên tài khoản từ 6 đến 12 kí tự, không có kí tự đặc biệt");
					}
					else {
						try {
							writeFile(name,pass);
						} catch (IOException e1) {
								// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"Đăng kí thành công!!");
						Login window=new Login();
						setVisible(false);
						window.setVisible(true);
					}
				}catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnDangKi.setForeground(new Color(255, 128, 192));
		btnDangKi.setFont(new Font("Tahoma", Font.BOLD, 32));
		btnDangKi.setBounds(354, 459, 195, 47);
		contentPane.add(btnDangKi);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(425, 265, 237, 39);
		contentPane.add(txtMatKhau);
		
		txtConfirm = new JPasswordField();
		txtConfirm.setBounds(425, 331, 237, 39);
		contentPane.add(txtConfirm);
		setLocationRelativeTo(null);
		
	}
	public void writeFile(String name,String pass) throws IOException  {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("account.bin");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(name);
			oos.writeObject(pass);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		 finally {
			if(fos!=null) {
				fos.close();
			}
			if(oos!=null) {
				oos.close();
			}
		}
	}
	public boolean checkTK(String name) throws IOException {
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
		if(nameLogIn.equals(name)) {
			return true;
			}
		else return false;
		}
	}
