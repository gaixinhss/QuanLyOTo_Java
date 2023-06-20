package model;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.List;


public class ListTour implements TourManager, Serializable{
	/* Update 9/12/2022
	 * Author Vuong Tung Duong
	 */
	private static final long serialVersionUID = 3L;
	
	private List<Tour> ListTour1;
	public ListTour() {
		this.ListTour1 = new ArrayList<Tour>();
	}
	public List<Tour> getListTour(){
		return ListTour1;
	}
	public void setListTour(List<Tour> list) {
		this.ListTour1 = list;
	}
	public void display() {
			for(Tour x : ListTour1) {
				System.out.println(x.toString());
			}
		}
	
	//This method is used to write file bin
	private void writeFile() throws IOException  {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("Tour.bin");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(fos!=null) {
				fos.close();
			}
			if(oos!=null) {
				oos.close();
			}
		}
		
	}
	
	//This method is used to read file bin
	public void readFile() throws IOException  {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("Tour.bin");
			ois = new ObjectInputStream(fis);
			ListTour list = (ListTour)ois.readObject();
			ListTour1.clear();
			list.getListTour().forEach(i->{
				ListTour1.add(i);
			});
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
		
	}
	
	//This method is used to add a Tour
	@Override
	public boolean addTour(Tour t) throws IOException  {
		for(int i=0; i<ListTour1.size();i++) {
			if((ListTour1.get(i).getId()) == (t.getId())) {
				return false;
			}
		}
		ListTour1.add(t);
		this.writeFile();
		return true;
		

	}
	public int getSize() {
		return ListTour1.size();
	}
	public Tour getTour(int index) {
		return ListTour1.get(index);
	}
	
	//This method is used to edit a Tour
	@Override
	public boolean editTour(Tour t) throws IOException{
		for(int i=0; i<ListTour1.size();i++) {
			if((ListTour1.get(i).getId()) == (t.getId())) {
				ListTour1.set(i, t);
				this.writeFile();
				return true;
			}
			
		}
		return false;
	}
	
	//This method is used to delete a Tour
	@Override
	public boolean delTour(Tour t) throws IOException {
		for(Tour i: ListTour1) {
			if(i.getId()==t.getId()) {
				ListTour1.remove(i);
				this.writeFile();
				return true;
				
			}
		}
		return false;
	}
	
	//Search by name method
	@Override
	public List<Tour> searchTour(String name) {
		List<Tour> result = new ArrayList<>();
		for(Tour x : ListTour1) {
			if(x.getName().contains(name)) {
				result.add(x);
			}
		}
		return result;
	}
	
	//Search by price method
	@Override
	public List<Tour> searchTour(double price) {
		List<Tour> result = new ArrayList<>();
		for(Tour x : ListTour1) {
			if(x.getPrice()==price) {
				result.add(x);
			}
		}
		return result;
	}
	
	//Search by id method
	public Tour searchTourId(int id){
		for(Tour x : ListTour1) {
			if(x.getId()==id) {
				return x;
			}
		}
		return null;
	}
	//Search by day method
	@Override
	public List<Tour> searchTour(byte day) {
		List<Tour> result = new ArrayList<>();
		for(Tour x : ListTour1) {
			if(x.getDay()==day) {
				result.add(x);
			}
		}
		return result;
	}
	
	//Search by tour guide method
	@Override
	public List<Tour> searchTour(boolean tourGuide) {
		List<Tour> result = new ArrayList<>();
		for(Tour x : ListTour1) {
			if((tourGuide&&x.getTourGuide()=="Yes")||(tourGuide==false&&x.getTourGuide()=="No")) {
				result.add(x);
			}
		}
		return result;
	}
	
	//Sort by id
	public List<Tour> sortedTourId() {
		for(int i=0; i<ListTour1.size()-1; i++) {
			for(int j=i+1;j<ListTour1.size();j++ ) {
				if(ListTour1.get(i).getId()>ListTour1.get(j).getId()) {
					Tour tmp = ListTour1.get(i);
					ListTour1.set(i, ListTour1.get(j));
					ListTour1.set(j, tmp);
				}
			}
		}
		return ListTour1;
	}
	//Sort by price method
	@Override
	public List<Tour> sortedTour(double price)  {
		for(int i=0; i<ListTour1.size()-1; i++) {
			for(int j=i+1;j<ListTour1.size();j++ ) {
				if(ListTour1.get(i).getPrice()>ListTour1.get(j).getPrice()) {
					Tour tmp = ListTour1.get(i);
					ListTour1.set(i, ListTour1.get(j));
					ListTour1.set(j, tmp);
				}
			}
		}
		return ListTour1;
	}
	
	//Sort by day method
	@Override
	public List<Tour> sortedTour(byte day) {
		for(int i=0; i<ListTour1.size()-1; i++) {
			for(int j=i+1;j<ListTour1.size();j++ ) {
				if(ListTour1.get(i).getDay()>ListTour1.get(j).getDay()) {
					Tour tmp = ListTour1.get(i);
					ListTour1.set(i, ListTour1.get(j));
					ListTour1.set(j, tmp);
				}
			}
		}
		return ListTour1;
	}
	//Sort by name method
	public List<Tour> sortedTourByName(){
		Collections.sort(ListTour1);
		return ListTour1;
	}
	//This method is used to generate n Tour
	public List<Tour> generateListTour(int n, int soLuong) {
		List<Tour> x = new ArrayList<Tour>();
		String[] locations = {"Phú Quốc", "Nha Trang", "Hội An", "Đà Nẵng", "Hạ Long", "Sài Gòn", "Quảng Bình", "Thanh Hóa", "Cần Thơ",
				"Huế", "Hà Nội", "Vũng Tàu", "Đà Lạt", "Sapa", "Mộc Châu", "Hà Giang", "Ninh Binh", "Tây Ninh", "Quảng Ninh", "Nghệ An"
		};
		int index;
		for(int i = 0; i<n; i++) {
			Tour t = new Tour();
			index = (int)(Math.random()*locations.length);
			t.setLocation(locations[index]);
			t.setId(i+soLuong+1);
			t.setName(locations[index]+" "+(i+soLuong+1));
			t.setPrice((double)((index+1)*0.657));
			index =(int)(Math.random()*7);
			t.setDay((byte)(index+1));
			
			t.setTotal((byte)(index+1));
			index=(int)(Math.random()*2);
			
			if(index==0) {
				t.setTourGuide(false);
			}else {
				t.setTourGuide(true);
			}
			x.add(t);
		}
		return x;
	}
	//This method is used to delete all ò ListTour
	public void delAll() throws IOException {
		ListTour1.removeAll(ListTour1);
		this.writeFile();
	}
}
