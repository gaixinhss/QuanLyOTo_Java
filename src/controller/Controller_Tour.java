package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;

import view.viewS;

public class Controller_Tour implements ActionListener{
	private viewS view;

	public Controller_Tour(viewS view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String luaChon = e.getActionCommand();
		if(luaChon.equals("Add Tour")) {
			try {
				this.view.addTourView();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(luaChon.equals("Edit Tour"))
			try {
				this.view.editTourView();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(luaChon.equals("Delete Tour"))
			try {
				this.view.delTourView();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(luaChon.equals("Delete All"))
			try {
				this.view.deleteAll();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(luaChon.equals("Display Tour"))
			try {
				this.view.displayView();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		else if(luaChon.equals("Search Tour"))
			try {
				this.view.searchTourView();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(luaChon.equals("Random 20 Tour"))
			try {
				this.view.generateListTour();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

}
