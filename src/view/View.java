package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller_Interior;
import model.DanhSach;
import model.Interior;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private DanhSach danhsach;

	public JPanel contentPane;
	private JTextField textFieldTimTen;
	private JLabel lbID;
	private JTextField textFieldID;
	private JLabel lbName;
	private JTextField textFieldName;
	private JLabel lbPrice;
	private JTextField textFieldPrice;
	private JLabel lbTotal;
	private JTextField textFieldTotal;
	private JLabel lbWeight;
	private JTextField textFieldWeight;
	private JLabel lbColor;
	private JTextField textFieldColor;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnSapXep;
	private JButton btnUpdate;
	private JLabel lbTimGia;
	private JTextField textFieldTimGia;
	private JScrollPane scrollPane;
	private JTable table;
	private JMenuItem mntmNewMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		danhsach = new DanhSach();
		ActionListener act = new Controller_Interior(this);

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
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbTimTen = new JLabel("Tên Sản Phẩm");
		lbTimTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbTimTen.setBounds(21, 10, 136, 32);
		contentPane.add(lbTimTen);

		textFieldTimTen = new JTextField();
		textFieldTimTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTimTen.setBounds(167, 14, 96, 30);
		contentPane.add(textFieldTimTen);
		textFieldTimTen.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTimKiem.setBounds(668, 10, 104, 33);
		btnTimKiem.addActionListener(act);
		contentPane.add(btnTimKiem);

		lbID = new JLabel("Mã sản phẩm (int)");
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbID.setBounds(48, 335, 215, 32);
		contentPane.add(lbID);

		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldID.setColumns(10);
		textFieldID.setBounds(289, 339, 96, 30);
		contentPane.add(textFieldID);

		lbName = new JLabel("Tên sản phẩm (String)");
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbName.setBounds(48, 375, 215, 32);
		contentPane.add(lbName);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldName.setColumns(10);
		textFieldName.setBounds(289, 379, 96, 30);
		contentPane.add(textFieldName);

		lbPrice = new JLabel("Giá sản phẩm (Double)");
		lbPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbPrice.setBounds(48, 420, 215, 32);
		contentPane.add(lbPrice);

		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(289, 424, 96, 30);
		contentPane.add(textFieldPrice);

		lbTotal = new JLabel("Số lượng sản phẩm (int)");
		lbTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbTotal.setBounds(450, 335, 272, 32);
		contentPane.add(lbTotal);

		textFieldTotal = new JTextField();
		textFieldTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(752, 341, 96, 30);
		contentPane.add(textFieldTotal);

		lbWeight = new JLabel("Cân nặng sản phẩm (Double)");
		lbWeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbWeight.setBounds(450, 375, 272, 32);
		contentPane.add(lbWeight);

		textFieldWeight = new JTextField();
		textFieldWeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldWeight.setColumns(10);
		textFieldWeight.setBounds(752, 380, 96, 30);
		contentPane.add(textFieldWeight);

		lbColor = new JLabel("Màu sản phẩm (String)");
		lbColor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbColor.setBounds(450, 420, 272, 32);
		contentPane.add(lbColor);

		textFieldColor = new JTextField();
		textFieldColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldColor.setColumns(10);
		textFieldColor.setBounds(752, 422, 96, 30);
		contentPane.add(textFieldColor);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBounds(96, 484, 104, 33);
		btnThem.addActionListener(act);
		contentPane.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSua.setBounds(233, 484, 104, 33);
		btnSua.addActionListener(act);
		contentPane.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa.setBounds(373, 484, 104, 33);
		btnXoa.addActionListener(act);
		contentPane.add(btnXoa);

		btnSapXep = new JButton("Sắp xếp");
		btnSapXep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSapXep.setBounds(525, 484, 136, 33);
		btnSapXep.addActionListener(act);
		contentPane.add(btnSapXep);

		btnUpdate = new JButton("Cập nhật");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(680, 484, 126, 33);
		btnUpdate.addActionListener(act);
		contentPane.add(btnUpdate);

		lbTimGia = new JLabel("Giá Sản Phẩm");
		lbTimGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbTimGia.setBounds(331, 10, 131, 32);
		contentPane.add(lbTimGia);

		textFieldTimGia = new JTextField();
		textFieldTimGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTimGia.setColumns(10);
		textFieldTimGia.setBounds(472, 14, 96, 30);
		contentPane.add(textFieldTimGia);

		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "mã SP", "Tên SP", "Giá SP", "Số lượng SP", "Cân nặng SP", "Màu SP" }));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(0, 0, 1, 1);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 88, 884, 235);
		contentPane.add(scrollPane);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(act);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuyTim.setBounds(780, 9, 104, 33);
		contentPane.add(btnHuyTim);

		JLabel lblNewLabel = new JLabel("Danh sách sản phẩm");
		lblNewLabel.setForeground(new Color(255, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 52, 204, 26);
		contentPane.add(lblNewLabel);

		khoiPhucTable();
		setLocationRelativeTo(null);
	}

	public boolean kTraID(int id) {
		for (Interior i : danhsach.getListInterior()) {
			if (i.getProduct_id() == id)
				return false;
		}
		return true;
	}

	public Interior layGiaTri() {
		int id = Integer.valueOf(textFieldID.getText());
		String name = textFieldName.getText();
		double price = Double.valueOf(textFieldPrice.getText());
		int total = Integer.valueOf(textFieldTotal.getText());
		double weight = Double.valueOf(textFieldWeight.getText());
		String color = textFieldColor.getText();

		Interior i = new Interior(id, name, price, total, weight, color);

		return i;
	}

	public Interior sanPhamDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int id = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String name = model_table.getValueAt(i_row, 1) + "";
		double price = Double.valueOf(model_table.getValueAt(i_row, 2) + "");
		int total = Integer.valueOf(model_table.getValueAt(i_row, 3) + "");
		double weight = Double.valueOf(model_table.getValueAt(i_row, 4) + "");
		String color = model_table.getValueAt(i_row, 5) + "";

		Interior i = new Interior(id, name, price, total, weight, color);

		return i;
	}

	public void xoaTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		while (true) {
			int leng = model_table.getRowCount();
			if (leng == 0)
				break;
			else
				model_table.removeRow(0);
		}
	}

	public void khoiPhucTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		xoaTable();
		for (Interior i : this.danhsach.getListInterior()) {
			model_table.addRow(new Object[] { i.getProduct_id() + "", i.getProduct_name(), i.getProduct_price() + "",
					i.getProduct_total() + "", i.getWeight() + "", i.getColor() });
		}
	}

	public void huyTimView() {
		khoiPhucTable();

		this.textFieldTimTen.setText("");
		this.textFieldTimGia.setText("");
	}

	public void xoaFormView() {
		this.textFieldID.setText("");
		this.textFieldName.setText("");
		this.textFieldPrice.setText("");
		this.textFieldTotal.setText("");
		this.textFieldWeight.setText("");
		this.textFieldColor.setText("");
	}

	public void themSanPhamView() {
		if (this.textFieldID.getText().length() <= 0||
			this.textFieldName.getText().length()<=0||
			this.textFieldPrice.getText().length()<=0||
			this.textFieldTotal.getText().length()<=0||
			this.textFieldWeight.getText().length()<=0||
			this.textFieldColor.getText().length()<=0) {
			
			JOptionPane.showMessageDialog(this, "Điền đầy đủ thông tin!");
		} else {
			Interior i = layGiaTri();
			if (!kTraID(i.getProduct_id()))
				JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại");
			else {
				this.danhsach.addInterior(i);
				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
				model_table.addRow(new Object[] { i.getProduct_id() + "", i.getProduct_name(),
						i.getProduct_price() + "", i.getProduct_total() + "", i.getWeight() + "", i.getColor() });

				xoaFormView();
			}
		}
	}

	public void suaSanPhamView() {

		Interior i = sanPhamDangChon();

		this.textFieldID.setText(i.getProduct_id() + "");
		this.textFieldName.setText(i.getProduct_name());
		this.textFieldPrice.setText(i.getProduct_price() + "");
		this.textFieldTotal.setText(i.getProduct_total() + "");
		this.textFieldWeight.setText(i.getWeight() + "");
		this.textFieldColor.setText(i.getColor());
	}

	public void capNhatThongTinSanPham() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();

		String id = this.textFieldID.getText() + "";
		String name = this.textFieldName.getText() + "";
		String price = this.textFieldPrice.getText() + "";
		String toTal = this.textFieldTotal.getText() + "";
		String weight = this.textFieldWeight.getText() + "";
		String color = this.textFieldColor.getText() + "";

		for (int x = 0; x < danhsach.getListInterior().size(); x++) {
			String idInTable = model_table.getValueAt(x, 0) + "";
			if (id.equals(idInTable)) {
				model_table.setValueAt(idInTable, x, 0);
				model_table.setValueAt(name, x, 1);
				model_table.setValueAt(price, x, 2);
				model_table.setValueAt(toTal, x, 3);
				model_table.setValueAt(weight, x, 4);
				model_table.setValueAt(color, x, 5);

				this.danhsach.editInterior(layGiaTri());
			}
		}

		xoaFormView();
	}

	public void xoaSanPhamView() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?");
		if (luaChon == JOptionPane.YES_OPTION) {

			Interior i = sanPhamDangChon();
			danhsach.delInterior(i);
			model_table.removeRow(i_row);
		}
	}

	public void sapXepView() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();

		xoaTable();
		for (Interior i : this.danhsach.sortedInterior(1.0)) {
			model_table.addRow(new Object[] { i.getProduct_id() + "", i.getProduct_name(), i.getProduct_price() + "",
					i.getProduct_total() + "", i.getWeight() + "", i.getColor() });
		}
	}

	public void timKiemView() {
		khoiPhucTable();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();

		String ten = this.textFieldTimTen.getText() + "";
		String gia = this.textFieldTimGia.getText() + "";

		Set<Integer> dsIDSP = new TreeSet<Integer>();

		if (this.textFieldTimTen.getText().length() > 0) {
			for (int i = 0; i < danhsach.getListInterior().size(); i++) {
				String tenIntable = danhsach.getListInterior().get(i).getProduct_name();
				String id = danhsach.getListInterior().get(i).getProduct_id() + "";
				if (!ten.equalsIgnoreCase(tenIntable))
					dsIDSP.add(Integer.valueOf(id));
			}
		}
		if (this.textFieldTimGia.getText().length() > 0) {
			double x = Double.valueOf(gia);
			for (int i = 0; i < danhsach.getListInterior().size(); i++) {
				String giaIntable = danhsach.getListInterior().get(i).getProduct_price() + "";
				double y = Double.valueOf(giaIntable);
				String id = model_table.getValueAt(i, 0) + "";
				if (x != y)
					dsIDSP.add(Integer.valueOf(id));
			}
		}
		
		for (Integer id : dsIDSP) {
			int leng = model_table.getRowCount();
			for (int i = 0; i < leng; i++) {
				String idInTable = model_table.getValueAt(i, 0) + "";
				if (id.equals(Integer.valueOf(idInTable))) {
					try {
						model_table.removeRow(i);
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}

	}
}
