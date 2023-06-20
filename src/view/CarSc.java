package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller_Car;
import model.Car;
import model.CarImpl;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JComboBox;

public class CarSc extends JFrame {

	public static CarSc getFrame() {
		return frame;
	}

	public static void setFrame(CarSc frame) {
		CarSc.frame = frame;
	}
	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtTotal;
	private JTextField txtDungtich;
	private JTextField txtSochongoi;
	private JTextField txtColor;
	private JTable table;
	public CarImpl lst1= new CarImpl();
	public static CarSc frame ;
	public JComboBox<String> comboBoxSort;
	public JComboBox<String> comboBoxSearch;
	private JButton btnSearchprice;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarSc frame= new CarSc();
					frame.setVisible(true);
					frame.ShowAll();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CarSc() {
		//Ä‘á»�c file "DSCar.bin"
		//lst1.readFile();
		//ShowAll();
		
		ActionListener act=new Controller_Car(this);
		setTitle("Car Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//thanh menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem itemMenuTrangChu = new JMenuItem("Trang chủ");
		menuBar.add(itemMenuTrangChu);
		itemMenuTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen login = new mainScreen();
				setVisible(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Car Management");
		lblNewLabel.setBounds(341, 11, 238, 71);
		lblNewLabel.setForeground(new Color(255, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product_ID");
		lblNewLabel_1.setBounds(46, 99, 115, 33);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product_Name");
		lblNewLabel_1_1.setBounds(46, 143, 115, 33);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Product_Price");
		lblNewLabel_1_1_1.setBounds(46, 198, 115, 33);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Product_Total");
		lblNewLabel_1_1_1_1.setBounds(46, 248, 115, 33);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Color");
		lblNewLabel_1_2.setBounds(436, 99, 150, 33);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Number Of Seats");
		lblNewLabel_1_2_1.setBounds(436, 143, 150, 33);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Cylinder Capacity");
		lblNewLabel_1_2_1_1.setBounds(436, 198, 150, 33);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1_2_1_1);
		
		
		
		JButton btnThem = new JButton("Add");
		btnThem.addActionListener(act);
		
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(10, 542, 109, 34);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("Update");
		btnSua.addActionListener(act);
		
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(129, 542, 109, 34);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Delete");
		btnXoa.addActionListener(act);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(248, 542, 109, 34);
		contentPane.add(btnXoa);
		
		JButton btnSearch = new JButton("Search By Name");
		btnSearch.addActionListener(act);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBounds(370, 542, 183, 34);
		contentPane.add(btnSearch);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(act);
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnView.setBounds(788, 542, 109, 34);
		contentPane.add(btnView);
		
		JButton btnSearchByPrice;
		btnSearchprice = new JButton("Search By Price");
		btnSearchprice.addActionListener(act);
		btnSearchprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchprice.setBounds(571, 542, 183, 34);
		contentPane.add(btnSearchprice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 300, 854, 228);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Product ID", "Product Name", "Product Total", "Product Price", "Color", "Cylinder Capacity", "Number Of Seats"
			}
		));
		scrollPane.setViewportView(table);
		
		txtID = new JTextField();
		txtID.setBounds(171, 101, 183, 33);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(171, 143, 183, 33);
		contentPane.add(txtName);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(171, 198, 183, 33);
		contentPane.add(txtPrice);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(171, 248, 183, 33);
		contentPane.add(txtTotal);
		
		txtDungtich = new JTextField();
		txtDungtich.setColumns(10);
		txtDungtich.setBounds(596, 200, 183, 33);
		contentPane.add(txtDungtich);
		
		txtSochongoi = new JTextField();
		txtSochongoi.setColumns(10);
		txtSochongoi.setBounds(596, 143, 183, 33);
		contentPane.add(txtSochongoi);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(596, 99, 183, 33);
		contentPane.add(txtColor);
		//Combo box Sort
		comboBoxSort = new JComboBox<String>();
		comboBoxSort.addItem("Price");
		comboBoxSort.addItem("Number Of Seats");
		comboBoxSort.setBounds(596, 250, 183, 33);
		comboBoxSort.addItemListener(new ItemListener() {
			@Override
            public void itemStateChanged(ItemEvent e) {
				if (e.getSource() == comboBoxSort) {
                    if(comboBoxSort.getSelectedItem().equals("Price")) {
                    	try {
            				SortByPrice();
            			} catch (IOException e1) {
            				// TODO Auto-generated catch block
            				e1.printStackTrace();
            			}
                    }else if(comboBoxSort.getSelectedItem().equals("Number Of Seats")) {
                    	try {
                    		SortByNumberOfSeats();
                    	}catch(IOException e1) {
                    		e1.printStackTrace();
                    	}           	
                    };
				}
			}
		});
		contentPane.add(comboBoxSort);
		
		
		
		JLabel txtsort = new JLabel("Sort By");
		txtsort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtsort.setBounds(436, 248, 66, 33);
		contentPane.add(txtsort);
		
		try {
			ShowAll();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setLocationRelativeTo(null);
		
	}
	public void ClearAll() {
		txtID.setText("");
		txtName.setText("");
		txtPrice.setText("");
		txtTotal.setText("");
		txtColor.setText("");
		txtDungtich.setText("");
		txtSochongoi.setText("");
	}
	public void ShowAll() throws IOException{
		lst1.readFile();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Car c : lst1.getLst()) {
			model.addRow(new Object[] {
					c.getProduct_id(),c.getProduct_name(),c.getProduct_total(),c.getProduct_price(),c.getColor(),c.getDungtich(),c.getSochongoi()
			});
		}
	}
	public void AddCarbtn() throws IOException{
		lst1.readFile();
		if(txtID.getText().length()<=0) {
			JOptionPane.showMessageDialog(null, "Nhập Product Id!!");
		}else if(txtName.getText().length()<=0) {
			JOptionPane.showMessageDialog(null, "Nhập Product Name!!");
		}else if(txtPrice.getText().length()<=0) {
			JOptionPane.showMessageDialog(null, "Nhập Product Price!!");
		}else if(txtTotal.getText().length()<=0) {
			JOptionPane.showMessageDialog(null, "Nhập Product Total!!");
		}else if(txtColor.getText().length()<=0) {
			JOptionPane.showMessageDialog(null, "Nhập Color!!");
		}else if(txtDungtich.getText().length()<=0) {
			JOptionPane.showMessageDialog(null, "Nhập Dung tích!!");
		}
		else if(txtSochongoi.getText().length()<=0) {
			JOptionPane.showMessageDialog(null, "Nhập số chỗ ngồi!!");
		}
		else {
			Car c= new Car();
			c.product_id=txtID.getText();
			c.product_name=txtName.getText();
			c.product_price=Double.parseDouble(txtPrice.getText());
			c.product_total=Integer.parseInt(txtTotal.getText());
			c.color=txtColor.getText();
			c.dungtich=Double.parseDouble(txtDungtich.getText());
			c.sochongoi=Integer.parseInt(txtSochongoi.getText());
			for(Car i:lst1.getLst()) {
				if(i.product_id.equalsIgnoreCase(c.product_id)) {
					JOptionPane.showMessageDialog(null, "Đã tồn tại Product ID");
					return;
				}
			}
			lst1.addCar(c);
			ShowAll();
			ClearAll();
			JOptionPane.showMessageDialog(null, "Thêm thành công!");
	}
	}
	public void UpdateCarbtn() throws IOException{
		lst1.readFile();
		if(txtID.getText().length()<=0) {
			JOptionPane.showMessageDialog(null, "Nhập Product Id!!");
		}
		else {
			String temp= txtID.getText();
			int index=-1;
			Car c= new Car();
			c.product_id=txtID.getText();
			c.product_name=txtName.getText();
			c.product_price=Float.parseFloat(txtPrice.getText());
			c.product_total=Integer.parseInt(txtTotal.getText());
			c.color=txtColor.getText();
			c.dungtich=Float.parseFloat(txtDungtich.getText());
			c.sochongoi=Integer.parseInt(txtSochongoi.getText());
			Boolean check=lst1.editCar(c);
			if(check) {
				JOptionPane.showMessageDialog(null, "Sửa thành công!");
				ShowAll();
				ClearAll();
			}
			else {
				JOptionPane.showMessageDialog(null, "Product Id không tồn tại!");
			}
		}
	}
	public void DeleteCarbtn()throws IOException {
		lst1.readFile();
		if(txtID.getText().length()<=0) {
			JOptionPane.showMessageDialog(null, "Nhập Product Id!!");
		}
		else {
			String temp=txtID.getText();
			for(Car i:lst1.getLst()) {
				if(i.product_id.equalsIgnoreCase(temp)) {
					lst1.delCar(i);
					JOptionPane.showMessageDialog(null, "Xóa thành công!");
					ShowAll();
					ClearAll();
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Product Id không tồn tại!");
			return;
		}
	}
	public void SearchByNamebtn() throws IOException{
		if(txtName.getText().length()<=0) {
			JOptionPane.showMessageDialog(null, "Nhập Product Name!!");
		}else {
			List<Car> find=lst1.searchCar(txtName.getText());
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (Car c : find) {
				model.addRow(new Object[] {
						c.getProduct_id(),c.getProduct_name(),c.getProduct_total(),c.getProduct_price(),c.getColor(),c.getDungtich(),c.getSochongoi()
				});
			}
		}
	}
	public void SearchByPricebtn() throws IOException{
		if(txtPrice.getText().length()<=0) {
			JOptionPane.showMessageDialog(null, "Nhập Price!");
		}else {
			String str=txtPrice.getText();
			Double temp=Double.valueOf(str);
			List<Car> find=lst1.searchCar(temp);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (Car c : find) {
				model.addRow(new Object[] {
						c.getProduct_id(),c.getProduct_name(),c.getProduct_total(),c.getProduct_price(),c.getColor(),c.getDungtich(),c.getSochongoi()
				});
			}
		}
	}
	public void SortByPrice() throws IOException{
		List<Car> carsort=lst1.sortedCar(0.0);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Car c : carsort) {
			model.addRow(new Object[] {
					c.getProduct_id(),c.getProduct_name(),c.getProduct_total(),c.getProduct_price(),c.getColor(),c.getDungtich(),c.getSochongoi()
			});
		}
	}
	public void SortByNumberOfSeats() throws IOException{
		List<Car> carsort=lst1.sortedCar(0);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Car c : carsort) {
			model.addRow(new Object[] {
					c.getProduct_id(),c.getProduct_name(),c.getProduct_total(),c.getProduct_price(),c.getColor(),c.getDungtich(),c.getSochongoi()
			});
		}
	}
}


