package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class DanhSach implements InteriorManager {

	private ArrayList<Interior> listInterior;
	
	public DanhSach() {
		this.listInterior = new ArrayList<Interior>();
		try {
			for (Interior i : this.binaryInputFile("Interior.bin")) {
				this.listInterior.add(i);
			}
		} catch (ClassNotFoundException | IOException e) {
		}
	}
	
	public ArrayList<Interior> getListInterior() {
		return listInterior;
	}
	
	public void setListInterior(ArrayList<Interior> listInterior) {
		this.listInterior = listInterior;
	}
	
	@Override
	public boolean addInterior(Interior i) {
		listInterior.add(i);
		
		try {
			this.binaryOutputFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean editInterior(Interior i) {
		for(int x=0; x<listInterior.size(); x++) {
			if((listInterior.get(x).getProduct_id()) == (i.getProduct_id())) {
				listInterior.set(x, i);
				try {
					this.binaryOutputFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delInterior(Interior i) {
		for (Interior tmp : listInterior) {
			if(tmp.getProduct_id()==i.getProduct_id()) {
				listInterior.remove(tmp);
				
				try {
					this.binaryOutputFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Interior> searchInterior(String name) {
		List<Interior> kq = new ArrayList<Interior>();
		for(Interior i: listInterior) {
			if(i.getProduct_name().equals(name)) {
				kq.add(i);
			}
		}
		return kq;
	}

	@Override
	public List<Interior> searchInterior(double price) {
		List<Interior> kq = new ArrayList<Interior>();
		for(Interior i: listInterior) {
			if(i.getProduct_price()==price) {
				kq.add(i);
			}
		}
		return kq;
	}

	@Override
	public List<Interior> searchInterior(double weight, String color) {
		List<Interior> kq = new ArrayList<Interior>();
		for(Interior i: listInterior) {
			if(i.getColor().equals(color) && i.getWeight() == weight) {
				kq.add(i);
			}
		}
		return kq;
	}

	@Override
	public List<Interior> sortedInterior(double price) {
		ArrayList<Interior> tmp = new ArrayList<Interior>();
		tmp.addAll(listInterior);
		
		Collections.sort(tmp,new sortedByPrice());

		return tmp;
	}
	
	public static void printArrayList(ArrayList<Interior> a) {
		for(Interior i: a) {
			System.out.println(i);
		}
	}
	
	public static void printDanhSach(DanhSach l) {
		printArrayList(l.getListInterior());
	}
	
	public static void printList(List<Interior> l) {
		for(Interior i: l) {
			System.out.println(i);
		}
	}
	
	public void binaryOutputFile() throws IOException{
		FileOutputStream outFile = new FileOutputStream("Interior.bin");
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		for(int i =0;i<this.getListInterior().size();i++) {
			out.writeObject(this.getListInterior().get(i));
		}
		
		out.close();
	}
	public void binaryOutputFileReport(ArrayList<Interior> list) throws IOException{
		FileOutputStream outFile = new FileOutputStream("report.bin");
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		for (Interior interior : list) {
			out.writeObject(interior);
		}
		
		out.close();
	}
	public ArrayList<Interior> binaryInputFile(String fileName)throws IOException, ClassNotFoundException {
		ArrayList <Interior> list= new ArrayList<>();
		try(FileInputStream inFile = new FileInputStream(fileName)){
			ObjectInputStream in = new ObjectInputStream(inFile);
			while(true) {
				Interior i = (Interior)in.readObject();
            	if(i==null)
            		break;
            	list.add(i);
            }
			in.close();
		}
		catch (Exception e) {
		}
		return list;
	}

}

	class sortedByPrice implements Comparator<Interior>{
		public int compare(Interior i1, Interior i2) {
			return (int)(i1.getProduct_price()-i2.getProduct_price());
		}
	}
	
