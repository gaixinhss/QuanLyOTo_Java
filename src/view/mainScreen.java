package view;

import javax.swing.*;

import model.Car;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class mainScreen extends JFrame {
	public mainScreen() {
		JFrame frame = new JFrame(); //JFrame Creation       
        frame.setTitle("Managemant Menu"); //Add the title to frame
        frame.getContentPane().setLayout(null); //Terminates default flow layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate program on close button
        frame.setBounds(100, 200, 1013, 602); //Sets the position of the frame
        
        Container c = frame.getContentPane(); //Gets the content layer

        JLabel lbcar = new JLabel(); //JLabel Creation
        lbcar.setIcon(new ImageIcon("1.jpg")); //Sets the image to be displayed as an icon
        Dimension sizecar = lbcar.getPreferredSize(); //Gets the size of the image
        lbcar.setBounds(30, 130, sizecar.width,sizecar.height); //Sets the location of the image
        c.add(lbcar); //Adds objects to the container
        
       
        
        JLabel lbtour = new JLabel(); //JLabel Creation
        lbtour.setIcon(new ImageIcon("2.jpg")); //Sets the image to be displayed as an icon
        Dimension sizetour = lbtour.getPreferredSize(); //Gets the size of the image
        lbtour.setBounds(350, 130, sizetour.width,sizetour.height); //Sets the location of the image
 
        c.add(lbtour); //Adds objects to the container
        
        JLabel lbInter = new JLabel(); //JLabel Creation
        lbInter.setIcon(new ImageIcon("3.jpg")); //Sets the image to be displayed as an icon
        Dimension size = lbInter.getPreferredSize(); //Gets the size of the image
        lbInter.setBounds(680, 130, size.width,size.height); //Sets the location of the image
 
        c.add(lbInter); //Adds objects to the container
        
        JButton btnCarSc = new JButton("Car");
        btnCarSc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);//tat man hinh hien tai
        		//goi man hinh Car
        		CarSc v = new CarSc();
        		v.setVisible(true);
        	}
        });
        btnCarSc.setForeground(new Color(255, 128, 255));
        btnCarSc.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnCarSc.setBounds(82, 328, 147, 35);
        frame.getContentPane().add(btnCarSc);
        
        JButton btnInterSc = new JButton("Interior");
        btnInterSc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);//tat man hinh hien tai
        		//goi man hinh interior
        		View v = new View();
        		v.setVisible(true);
        	}
        });
        btnInterSc.setForeground(new Color(255, 128, 255));
        btnInterSc.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnInterSc.setBounds(408, 328, 147, 35);
        frame.getContentPane().add(btnInterSc);
        
        JButton btnITourSc = new JButton("Tour");
        btnITourSc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);//tat man hinh hien tai
        		//goi man hinh tour
        		viewS v;
				try {
					v = new viewS();
					v.getFrame().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnITourSc.setForeground(new Color(255, 128, 255));
        btnITourSc.setFont(new Font("Tahoma", Font.BOLD, 22));
        btnITourSc.setBounds(727, 328, 147, 35);
        frame.getContentPane().add(btnITourSc);
        
        JLabel lblNewLabel = new JLabel("Management");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
        lblNewLabel.setBounds(374, 11, 233, 63);
        frame.getContentPane().add(lblNewLabel);
        
        
        JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem itemlogout = new JMenuItem("Log out");
		mnNewMenu.add(itemlogout);
		itemlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);//tat man hinh hien tai
				//goi man hinh co 2 nut dang ki va dang nhap
				Login window= new Login();
				window.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Report");
		menuBar.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.setVisible(false);//tat man hinh hien tai
        		//goi man hinh interior
        		ThongKeView v = new ThongKeView();
        		v.setVisible(true);
        	}
        });
        
        frame.setVisible(true); // Exhibit the frame
        
        frame.setLocationRelativeTo(null);
	}
    public static void main(String[] args) {

        mainScreen fr= new mainScreen();
        //fr.setVisible(true); khong can goi ham nay o main

    }
}