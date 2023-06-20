package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Controller_Tour;
import model.ListTour;
import model.Tour;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;

import javax.swing.JPanel;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;


public class viewS extends JFrame {
	/* Update 9/12/2022
	 * Author Vuong Tung Duong
	 */

	private static final long serialVersionUID = 3L;
	
	private JFrame frame;
	private ListTour listTour = new ListTour();
	private int soLuong = 0;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtTotal;
	private JTextField txtLocation;
	private JTextField txtDay;
	private JRadioButton rdbtnYes;
	private JRadioButton rdbtnNo;
	private ButtonGroup btnGroupTourGuide;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNote;
	private JComboBox<String> comboBoxSort;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewS window = new viewS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public viewS() throws IOException {
		
		listTour.readFile();
		ActionListener act = new Controller_Tour(this);
		
		setFrame(new JFrame());
		getFrame().setBounds(200, 100, 900, 700);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setBackground(getForeground());
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem itemMenuTrangChu = new JMenuItem("Trang chủ");
		menuBar.add(itemMenuTrangChu);
		itemMenuTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen login = new mainScreen();
				getFrame().setVisible(false);
			}
		});
		getFrame().setJMenuBar(menuBar);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(10, 80, 100, 35);
		getFrame().getContentPane().add(lblName);
		
		JLabel lblPrice = new JLabel("Price: ");
		lblPrice.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPrice.setBounds(10, 110, 100, 35);
		getFrame().getContentPane().add(lblPrice);
		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotal.setBounds(10, 140, 100, 35);
		getFrame().getContentPane().add(lblTotal);
		
		JLabel lblLocation = new JLabel("Location: ");
		lblLocation.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblLocation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLocation.setBounds(10, 170, 97, 35);
		getFrame().getContentPane().add(lblLocation);
		
		JLabel lblDay = new JLabel("Day: ");
		lblDay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblDay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDay.setBounds(10, 200, 100, 35);
		getFrame().getContentPane().add(lblDay);
		
		JLabel lblTourGuide = new JLabel("Tour Guider: ");
		lblTourGuide.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblTourGuide.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTourGuide.setBounds(10, 230, 100, 35);
		getFrame().getContentPane().add(lblTourGuide);
		
		frame.setLocationRelativeTo(null);
		
		JButton btnAddTour = new JButton("Add Tour");
		btnAddTour.setToolTipText("add a tour to file");
		btnAddTour.setBounds(524, 40, 150, 20);
		btnAddTour.addActionListener(act);
		getFrame().getContentPane().add(btnAddTour);
		
		JButton btnEditTour = new JButton("Edit Tour");
		btnEditTour.setToolTipText("edit a tour by id");
		btnEditTour.setBounds(524, 65, 150, 20);
		btnEditTour.addActionListener(act);
		getFrame().getContentPane().add(btnEditTour);
		
		JButton btnDeleteTour = new JButton("Delete Tour");
		btnDeleteTour.setToolTipText("choose a tour in table to delete");
		btnDeleteTour.setBounds(524, 90, 150, 20);
		btnDeleteTour.addActionListener(act);
		getFrame().getContentPane().add(btnDeleteTour);
		
		JButton btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.setToolTipText("delete all of list tour");
		btnDeleteAll.setBounds(524, 115, 150, 20);
		btnDeleteAll.addActionListener(act);
		frame.getContentPane().add(btnDeleteAll);
		
		JButton btnSearchTour = new JButton("Search Tour");
		btnSearchTour.setToolTipText("search tour by id, name, price, day, tour guide");
		btnSearchTour.setBounds(524, 140, 150, 20);
		btnSearchTour.addActionListener(act);
		getFrame().getContentPane().add(btnSearchTour);
		
		JButton btnDisplayTour = new JButton("Display Tour");
		btnDisplayTour.setToolTipText("display all list tour");
		btnDisplayTour.setBounds(524, 165, 150, 20);
		btnDisplayTour.addActionListener(act);
		getFrame().getContentPane().add(btnDisplayTour);
		

		JButton btnRandomTour = new JButton("Random 20 Tour");
		btnRandomTour.setToolTipText("Generate random 20 tour");
		btnRandomTour.setBounds(524, 190, 150, 20);
		btnRandomTour.addActionListener(act);
		frame.getContentPane().add(btnRandomTour);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setBounds(20, 280, 457, 180);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "NAME", "PRICE (Million VND)", "TOTAL", "LOCATION", "DAY", "TOUR GUIDE" }));
		
		getFrame().getContentPane().add(table);
		scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(240, 240, 240));
		scrollPane.setBounds(10, 307, 745, 222);
		getFrame().getContentPane().add(scrollPane);
		
		JPanel panelLabel = new JPanel();
		panelLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelLabel.setBackground(SystemColor.activeCaption);
		panelLabel.setLayout(null);
		panelLabel.setBounds(10, 40, 97, 237);
		frame.getContentPane().add(panelLabel);
		
		JLabel lblId = new JLabel("Id: ");
		lblId.setBounds(0, 11, 100, 35);
		panelLabel.add(lblId);
		lblId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JPanel panelTextField = new JPanel();
		panelTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTextField.setBackground(SystemColor.activeCaption);
		panelTextField.setLayout(null);
		panelTextField.setBounds(111, 40, 383, 237);
		frame.getContentPane().add(panelTextField);
		
		txtId = new JTextField();
		txtId.setColumns(12);
		txtId.setBounds(10, 15, 360, 20);
		panelTextField.add(txtId);
		
		txtName = new JTextField();
		txtName.setColumns(12);
		txtName.setBounds(10, 45, 360, 20);
		panelTextField.add(txtName);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(12);
		txtPrice.setBounds(10, 75, 360, 20);
		panelTextField.add(txtPrice);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(12);
		txtTotal.setBounds(10, 105, 360, 20);
		panelTextField.add(txtTotal);
		
		txtLocation = new JTextField();
		txtLocation.setColumns(12);
		txtLocation.setBounds(10, 135, 360, 20);
		panelTextField.add(txtLocation);
		
		txtDay = new JTextField();
		txtDay.setColumns(12);
		txtDay.setBounds(10, 165, 360, 20);
		panelTextField.add(txtDay);
		
		rdbtnYes = new JRadioButton("Yes", true);
		rdbtnYes.setBackground(SystemColor.activeCaption);
		rdbtnYes.setForeground(SystemColor.desktop);
		rdbtnYes.setBounds(10, 200, 67, 23);
		panelTextField.add(rdbtnYes);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(SystemColor.activeCaption);
		rdbtnNo.setBounds(90, 200, 67, 23);
		panelTextField.add(rdbtnNo);
		
		btnGroupTourGuide = new ButtonGroup();
		btnGroupTourGuide.add(rdbtnYes);
		btnGroupTourGuide.add(rdbtnNo);
		
		comboBoxSort = new JComboBox<String>();
		comboBoxSort.addItem("id");
		comboBoxSort.addItem("name");
		comboBoxSort.addItem("price");
		comboBoxSort.addItem("day");
		comboBoxSort.setSelectedItem(null);
		comboBoxSort.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBoxSort.setBounds(524, 285, 120, 22);
		comboBoxSort.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == comboBoxSort) {
                    if(comboBoxSort.getSelectedItem().equals("price")) {
                    	try {
            				sortByPriceView();
            			} catch (IOException e1) {
            				// TODO Auto-generated catch block
            				e1.printStackTrace();
            			}
                    }else if(comboBoxSort.getSelectedItem().equals("name")) {
                    	try {
                    		sortByNameView();
                    	}catch(IOException e1) {
                    		e1.printStackTrace();
                    	}
                    	
                    }else if(comboBoxSort.getSelectedItem().equals("id")) {
                    	try {
                    		sortByIdView();
                    	}catch(IOException e1) {
                    		e1.printStackTrace();
                    	}
                    	
                    }else if(comboBoxSort.getSelectedItem().equals("day")) {
                    	try {
                    		sortByDayView();
                    	}catch(IOException e1) {
                    		e1.printStackTrace();
                    	}
                    };
                }
            }
        });
		frame.getContentPane().add(comboBoxSort);
		
		JLabel lblInputField = new JLabel("INPUT FIELD");
		lblInputField.setBounds(10, 16, 290, 22);
		frame.getContentPane().add(lblInputField);
		
		lblNote = new JLabel("");
		lblNote.setBounds(10, 530, 764, 25);
		frame.getContentPane().add(lblNote);
		
		JLabel lblSortBy = new JLabel("Sort by");
		lblSortBy.setBounds(477, 288, 45, 19);
		frame.getContentPane().add(lblSortBy);
		displayView();
		
		setLocationRelativeTo(null);
		
	}
	//This method is used to get value in the fields
	public Tour getValue() {
		int id = Integer.valueOf(txtId.getText());
		String name = txtName.getText();
		double price = Double.valueOf(txtPrice.getText());
		byte total = Byte.valueOf(txtTotal.getText());
		String location = txtLocation.getText();
		byte day = Byte.valueOf(txtDay.getText());
		boolean tourGuide;
		if(rdbtnYes.isSelected()) {
			tourGuide=true;
		} else {
			tourGuide=false;
		}
		Tour t = new Tour(id, name, price, total, location, day, tourGuide);
		return t;
	}
	//This method is used to get a Tour in selected row
	public Tour getSelected() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int id = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String name = model_table.getValueAt(i_row, 1) + "";
		double price = Double.valueOf(model_table.getValueAt(i_row, 2) + "");
		byte total = Byte.valueOf(model_table.getValueAt(i_row, 3) + "");
		String location = model_table.getValueAt(i_row, 4) + "";
		byte day = Byte.valueOf(model_table.getValueAt(i_row, 5) + "");
		boolean tourGuide;
		if(model_table.getValueAt(i_row, 6).equals("Yes")) {
			tourGuide=true;
		}else {
			tourGuide=false;
		}
		Tour t = new Tour(id, name, price, total, location, day, tourGuide);

		return t;
	}
	//This method is used to get value in table now
	public List<Tour> getTable() throws IOException {
		List<Tour> result = new ArrayList<Tour>();
		int rows = table.getRowCount();
		for(int i = 0; i<rows;i++) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int id = Integer.valueOf(model_table.getValueAt(i, 0) + "");
			String name = model_table.getValueAt(i, 1) + "";
			double price = Double.valueOf(model_table.getValueAt(i, 2) + "");
			byte total = Byte.valueOf(model_table.getValueAt(i, 3) + "");
			String location = model_table.getValueAt(i, 4) + "";
			byte day = Byte.valueOf(model_table.getValueAt(i, 5) + "");
			boolean tourGuide;
			if(model_table.getValueAt(i, 6).equals("Yes")) {
				tourGuide=true;
			}else {
				tourGuide=false;
			}
			Tour t = new Tour(id, name, price, total, location, day, tourGuide);
			result.add(t);
		}
		return result;
	}
	//This method is used to reset table
	public void delTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		while (true) {
			int leng = model_table.getRowCount();
			if (leng == 0)
				break;
			else
				model_table.removeRow(0);
		}
	}
	//This method is used to reset all of input fields
	public void delFormView() {
		this.txtId.setText("");
		this.txtName.setText("");
		this.txtPrice.setText("");
		this.txtTotal.setText("");
		this.txtLocation.setText("");
		this.txtDay.setText("");
		this.rdbtnYes.setSelected(true);;
	}
	
	//This method is used to check empty field
		public boolean testField() {
			if(txtId.getText().equals("")||txtName.getText().equals("")||txtPrice.getText().equals("")||txtTotal.getText().equals("")||txtLocation.getText().equals("")||txtDay.getText().equals("")) {
				JOptionPane.showMessageDialog(frame, "Let enter all field!");
				return false;
			}else if(txtId.getText().matches(".*[^0-9]+.*")){
				JOptionPane.showMessageDialog(frame, "Id must be a natural number! Let enter again");
				return false;
			}else if(txtPrice.getText().matches(".*[^0-9.,]+.*")){
				JOptionPane.showMessageDialog(frame, "Price must be a real number! Let enter again");
				return false;
			}
			else if(txtTotal.getText().matches(".*[^0-9]+.*")){
				JOptionPane.showMessageDialog(frame, "Total must be a natural number! Let enter again");
				return false;
			}else if((txtDay.getText().matches("[^0-9]+"))){
				JOptionPane.showMessageDialog(frame, "Day must be a natural number! Let enter again");
				return false;
			}
			return true;
		}
	//This method is used to display a row
	public void displayRow(Tour t) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { t.getId() + "", t.getName()+"", t.getPrice() + "",
				t.getTotal() + "", t.getLocation() + "", t.getDay()+"", t.getTourGuide() });
	}
	//This method is used to add a Tour for button
	public void addTourView() throws IOException {
		listTour.readFile();
		if(testField()) {
			Tour t = getValue();
			if(listTour.addTour(t)==false) {
				JOptionPane.showMessageDialog(frame, "This Id exist!");
			}else {
				listTour.addTour(t);
				displayRow(t);
				soLuong++;
				JOptionPane.showMessageDialog(frame, "Add successful");
				this.lblNote.setText("Add tour successful: "+t.toString());
				delFormView();
			}
		}
	}
	//This method is used to edit a tour by id for button
	public void editTourView() throws IOException{
		listTour.readFile();
		if(testField()) {
			Tour t = getValue();
			if(listTour.editTour(t)==false) {
				JOptionPane.showMessageDialog(frame, "Cannot find this tour's id!");
			}else {
			delTable();
			listTour.editTour(t);
			displayRow(t);
			JOptionPane.showMessageDialog(frame, "Edit successful");
			this.lblNote.setText("Edit tour successful: "+t.toString());
			delFormView();
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Let enter all fields!");
		}
	}
	//This method is used to delete a Tour is checked for button
	public void delTourView() throws IOException{
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		if(table.getSelectedRow()==-1) {
			JOptionPane.showMessageDialog(frame, "Let choose a tour!");
		} else {
			int luaChon = JOptionPane.showConfirmDialog(this, "Are you sure delete?");
			if (luaChon == JOptionPane.YES_OPTION) {
				Tour t = getSelected();
				this.listTour.delTour(t);
				model_table.removeRow(i_row);
				JOptionPane.showMessageDialog(frame, "Delete successful");
				this.lblNote.setText("Delete tour successful: "+t.toString());
				soLuong--;
			}
		}
	}
	//This method is used to sort by price for button
	public void sortByPriceView() throws IOException {
		ListTour result= new ListTour();
		result.setListTour(getTable());
		result.sortedTour((double)1.5);
		delTable();
		for (Tour t : result.getListTour()) {
			displayRow(t);
		}
		this.lblNote.setText("Sorted list tour by Price!");
	}
	//This method is used to sort by Id for comboBox
	public void sortByIdView() throws IOException{
		ListTour result= new ListTour();
		result.setListTour(getTable());
		result.sortedTourId();
		delTable();
		for (Tour t : result.getListTour()) {
			displayRow(t);
		}
		this.lblNote.setText("Sorted list tour by Id!");
	}
	//This method is used to sort by day for button
	public void sortByDayView() throws IOException {
		ListTour result= new ListTour();
		result.setListTour(getTable());
		result.sortedTour((byte)1);
		delTable();
		for (Tour t : result.getListTour()) {
			displayRow(t);
		}
		this.lblNote.setText("Sorted list tour by Day!");
	}
	//This method is used to sort by name for comboBox
	public void sortByNameView() throws IOException {
		ListTour result= new ListTour();
		result.setListTour(getTable());
		result.sortedTourByName();
		delTable();
		for (Tour t : result.getListTour()) {
			displayRow(t);
		}
		this.lblNote.setText("Sorted list tour by Name!");
	}
	//This method is used to display list Tour for button
	public void displayView() throws IOException {
		listTour.readFile();
		delTable();
		for(Tour t : listTour.getListTour()) {
			displayRow(t);
		}
		this.lblNote.setText("Display all of list tour!");
	}
	
	//This method is used to search Tour
	public void searchTourView() throws IOException{
		listTour.readFile();
		delTable();
		if(txtId.getText().equals("")==false) {
			Tour t = listTour.searchTourId(Integer.valueOf(txtId.getText()));
			if(t!=null) {
				displayRow(t);
			} else {
				JOptionPane.showMessageDialog(frame, "Do not find this tour's id!");
			}
		}
		else if(txtName.getText().equals("")==false) {
			List<Tour> result = listTour.searchTour(txtName.getText().trim());
			for(Tour t : result) {
				displayRow(t);
			}
			this.lblNote.setText("Search by name: \""+txtName.getText()+"\"");
		}else if(txtPrice.getText().equals("")==false) {
			List<Tour> result = listTour.searchTour(Double.valueOf(txtPrice.getText()));
			for(Tour t : result) {
				displayRow(t);
			}
			this.lblNote.setText("Search by price: \""+txtPrice.getText()+"\"");
		}else if(txtDay.getText().equals("")==false) {
			List<Tour> result = listTour.searchTour(Byte.valueOf(txtDay.getText()));
			for(Tour t : result) {
				displayRow(t);
			}
			this.lblNote.setText("Search by day: \""+txtDay.getText()+"\"");
		}else {
			List<Tour> result = listTour.searchTour(rdbtnYes.isSelected());
			for(Tour t : result) {
				displayRow(t);
			}
			String yesNo = "Yes";
			if(rdbtnNo.isSelected()) {
				yesNo = "No";
			}
			this.lblNote.setText("Search by tour guide: \""+yesNo+"\"");
		}
	}
	
	//This method is used to generate a List Tour
	public void generateListTour() throws IOException {
		listTour.readFile();
		int soLuongDs = listTour.getSize();
		List<Tour> x1 = listTour.generateListTour(20, soLuongDs);
		for(Tour t : x1) {
			listTour.addTour(t);
			displayRow(t);
			soLuong++;
		}
		JOptionPane.showMessageDialog(frame, "Add successful");
		this.lblNote.setText("Add random 20 tour successful");
		delFormView();
	}
	
	//This method is used to delete all of ListTour
	public void deleteAll() throws IOException {
		listTour.readFile();
		int luaChon = JOptionPane.showConfirmDialog(this, "Are you sure delete all of list tour?");
		if (luaChon == JOptionPane.YES_OPTION) {
		listTour.delAll();
		delTable();
		JOptionPane.showMessageDialog(frame, "Delete successful");
		this.lblNote.setText("Delete all of list tour successful");
		}
	}
}
