package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.Car;
import model.CarImpl;
import model.DanhSach;
import model.Interior;
import model.ListTour;
import model.Tour;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThongKeView extends JFrame {

	private ArrayList<report> reportList = new ArrayList<report>();
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeView frame = new ThongKeView();
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
	public ThongKeView() {
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
		setTitle("Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel( new Object[][] {},
			new String[] {"STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng"}));
		table.setBounds(0, 0, 1, 1);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(48, 88, 884, 235);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Top 10 Sản phẩm có số lượng lớn nhất");
		lblNewLabel.setForeground(new Color(255, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(48, 38, 444, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Xuất File");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(reportList);
					binaryOutputFileReport();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("loi");
				}
			}
		});
		btnNewButton.setBounds(822, 46, 110, 32);
		contentPane.add(btnNewButton);
		
		updateReportList();
		showTable();
	
		
		setLocationRelativeTo(null);
	}
	public class report implements Serializable{
		private String maSP;
		private String tenSP;
		private int soLuongSP;
		
		public report(String maSP, String tenSP, int soLuongSP) {
			this.maSP=maSP;
			this.tenSP=tenSP;
			this.soLuongSP=soLuongSP;
		}

		public String getMaSP() {
			return maSP;
		}

		public String getTenSP() {
			return tenSP;
		}

		public int getSoLuongSP() {
			return soLuongSP;
		}

		public void setMaSP(String maSP) {
			this.maSP = maSP;
		}

		public void setTenSP(String tenSP) {
			this.tenSP = tenSP;
		}

		public void setSoLuongSP(int soLuongSP) {
			this.soLuongSP = soLuongSP;
		}

		@Override
		public String toString() {
			return "report [maSP=" + maSP + ", tenSP=" + tenSP + ", soLuongSP=" + soLuongSP + "]";
		}
	}

	public void updateReportList() {
		DanhSach listInteriorReport = new DanhSach();
		CarImpl listCarReport = new CarImpl();
		ListTour listTourReport = new ListTour();
		try {
			listCarReport.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			listTourReport.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Interior i : listInteriorReport.getListInterior()) {
			reportList.add(new report(i.getProduct_id()+"", i.getProduct_name(), i.getProduct_total()));
		}
		for (Car c : listCarReport.lst) {
			reportList.add(new report(c.getProduct_id(), c.getProduct_name(), c.getProduct_total()));
		}
		for (Tour t : listTourReport.getListTour()) {
			reportList.add(new report(t.getId()+"", t.getName(), (int)t.getTotal()));
		}
		
		sortedByTotal();
	}
	
	public void binaryOutputFileReport() throws IOException{
		FileOutputStream outFile = new FileOutputStream("report.bin");
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		for (int i=0;i<10;i++) {
			out.writeObject(reportList.get(i));
		}
		
		out.close();
	}
	public void showTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		for(int i=0;i<10;i++) {
			model_table.addRow(new Object[] {(i+1)+"",this.reportList.get(i).maSP,this.reportList.get(i).tenSP,this.reportList.get(i).soLuongSP+""  }); 
		}
	}
	public void sortedByTotal() {
		for (int i=0;i<reportList.size();i++) {
			for(int j=i+1;j<reportList.size();j++) {
				if(reportList.get(i).soLuongSP<reportList.get(j).soLuongSP) {
					report tmp = reportList.get(i);
					reportList.set(i, reportList.get(j));
					reportList.set(j, tmp);
				}
			}
			
		}
	}
}
