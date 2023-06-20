package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Login;
import view.LoginSc;
import view.SignUpSc;
import view.mainScreen;

public class Controller_Login implements ActionListener {
	private Login login;
	private LoginSc loginSc;
	private SignUpSc signUpSc;

	public Controller_Login(LoginSc loginSc) {
		this.loginSc = loginSc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String luaChon = e.getActionCommand();
		if(luaChon.equals("Login")) {
			login.setVisible(false);
			loginSc.setVisible(true);
		}
		else if(luaChon.equals("Create account")) {
			login.setVisible(false);
			signUpSc.setVisible(true);
		}
			
	}

}
