package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View;

public class Controller_Interior implements ActionListener{
	private View view;

	public Controller_Interior(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String luaChon = e.getActionCommand();
		if(luaChon.equals("Thêm")) {
			this.view.themSanPhamView();
		}else if(luaChon.equals("Sửa"))
			this.view.suaSanPhamView();
		else if(luaChon.equals("Xóa"))
			this.view.xoaSanPhamView();
		else if(luaChon.equals("Cập nhật"))
			this.view.capNhatThongTinSanPham();
		else if(luaChon.equals("Sắp xếp"))
			this.view.sapXepView();
		else if(luaChon.equals("Tìm"))
			this.view.timKiemView();
		else if(luaChon.equals("Hủy tìm"))
			this.view.huyTimView();
	}

}
