package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import view.CarSc;

public class Controller_Car implements ActionListener{
	public CarSc fr;
	public Controller_Car(CarSc fr) {
		this.fr=fr;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String luaChon = e.getActionCommand();
		if(luaChon.equals("Add")) {
			try {
				this.fr.AddCarbtn();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(luaChon.equals("Update"))
			try {
			this.fr.UpdateCarbtn();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}else if(luaChon.equals("Delete"))
			try {
			this.fr.DeleteCarbtn();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		else if(luaChon.equals("View"))
			try {
				this.fr.ShowAll();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(luaChon.equals("Search By Name"))
			try {
				this.fr.SearchByNamebtn();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		else if(luaChon.equals("Search By Price"))
			try {
				this.fr.SearchByPricebtn();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
}
//		
//		
//		else if(luaChon.equals("Sort By Number Of Seats"))
//			try {
//				this.view.sortByPriceView();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		else if(luaChon.equals("Search By Name"))
//			this.view.displayView();
//		
//	}


