package model;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CarImpl implements CarManager,Serializable {

	//variables
	public ArrayList<Car> lst;
	
	public ArrayList<Car> getLst() {
		return lst;
	}
	public void setLst(ArrayList<Car> lst) {
		this.lst = lst;
	}
	public CarImpl() {
		// TODO Auto-generated constructor stub
		this.lst=new ArrayList<Car>();
	}
	public void Display() {
		for(Car i:lst) {
			System.out.println(i.toString());
		}
	}
	public void OutputList(List<Car>lst) {
		for(Car i:lst) {
			System.out.println(i.toString());
		}
	}
	@Override
	public boolean addCar(Car c) throws IOException {//them 1 phan tử vào danh sách
		for(Car i: lst) {
			if(i.product_id.equalsIgnoreCase(c.product_id)) {
				return false;
			}
			else {
				continue;
			}
		}
		lst.add(c);
		this.writeFile();
		return true;
	}

	@Override
	public boolean editCar(Car c) throws IOException{//sua 1 xe trong hệ thống
		int index=-1;
		for(Car i:lst) {
			if(i.product_id.equalsIgnoreCase(c.product_id)) {
				index=lst.indexOf(i);
			}
			else {
				continue;
			}
		}
		if(index!=-1) {//tìm thấy xe trong hệ thống
			lst.set(index, c);
			this.writeFile();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean delCar(Car c)throws IOException {//xoá 1 thông tin ô tô
		int index=-1;
		for(Car i:lst) {
			if(i.product_id.equalsIgnoreCase(c.product_id)) {
				index=lst.indexOf(i);
			}
			else {
				continue;
			}
		}
		if(index!=-1) {//tìm thấy xe
			lst.remove(index);
			this.writeFile();
			return true;
		}
		else {//không tìm thấy
			return false;
		}
	}

	@Override
	public List<Car> searchCar(String name)throws IOException {// tìm xe theo tên
		this.readFile();
		ArrayList<Car> lst1= new ArrayList<>();
		for(Car i : lst) {
			if(i.product_name.equalsIgnoreCase(name)) {
				lst1.add(i);
			}
		}
		return lst1;
	}
	@Override
	public List<Car> searchCar(Double price) throws IOException{//tìm kiếm theo giá
		this.readFile();
		ArrayList<Car> lst1= new ArrayList<>();
		for(Car i : lst) {
			if(i.product_price==price) {
				lst1.add(i);
			}
		}
		return lst1;
	}
	@Override
	public List<Car> searchCar(int sochongoi)throws IOException {//tìm kiếm theo số chỗ ngồi
		this.readFile();
		ArrayList<Car> lst1= new ArrayList<>();
		for(Car i : lst) {
			if(i.sochongoi==sochongoi) {
				lst1.add(i);
			}
		}
		return lst1;
	}
	@Override
	public List<Car> sortedCar(double Price)throws IOException {//sắp xếp theo giá
		this.readFile();
		for(int i=0;i<lst.size();i++) {
			for(int j=i+1;j<lst.size();j++) {
				if(lst.get(i).product_price<lst.get(j).product_price) {
					Car temp=new Car();
					temp=lst.get(i);
					lst.set(i, lst.get(j));
					lst.set(j, temp);
				}
			}
		}
		this.writeFile();
		return lst;
	}
	@Override
	public List<Car> sortedCar(int sochongoi) throws IOException{// sắp xếp theo số chỗ ngồi
		this.readFile();
		for(int i=0;i<lst.size();i++) {
			for(int j=i+1;j<lst.size();j++) {
				if(lst.get(i).sochongoi<lst.get(j).sochongoi) {
					Car temp=new Car();
					temp=lst.get(i);
					lst.set(i, lst.get(j));
					lst.set(j, temp);
				}
			}
		}
		this.writeFile();
		return lst;
	}
//	public void GhiFile(ArrayList<Car>temp,String filename) {
//		try(FileOutputStream outFile = new FileOutputStream(filename)){
//			ObjectOutputStream out = new ObjectOutputStream(outFile);
//			for(int i =0;i<temp.size();i++) {
//				//out.writeInt(i+1);
//				out.writeObject(temp.get(i));
//				//out.defaultWriteObject();
//			}
//		}
//		catch(IOException e) {
//			System.out.println("Loi khi ghi!");
//		}
//		
//		
//		//out.close();
//	}
	
//----------------
	public void writeFile() throws IOException  {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("DSCar.bin");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		 finally {
			if(fos!=null) {
				fos.close();
			}
			if(oos!=null) {
				oos.close();
			}
		}
		
	}
	
	public void readFile() throws IOException  {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("DSCar.bin");
			ois = new ObjectInputStream(fis);
			CarImpl list = (CarImpl)ois.readObject();
			lst.clear();
			list.getLst().forEach(i->{
				lst.add(i);
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
}
//	public ArrayList<Car> DocFile(String fileName) {
//		ArrayList <Car> lst2= new ArrayList<>();
//		try(FileInputStream inFile = new FileInputStream(fileName)){
//			ObjectInputStream in = new ObjectInputStream(inFile);
//			while(true) {
//            	Car i = (Car)in.readObject();
//            	if(i==null)
//            		break;
//            	else lst2.add(i);
//            }
//		}
//		catch (Exception e) {
//			
//			System.out.println("loi khi doc!");
//		}
//		//in.close();
//		return lst2;
//		
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		CarImpl list=new CarImpl();
//		Car xe1=new Car("sp01","Tesla Model 3",(double)38000.0,10,"red",4,(double)5.8);
//		Car xe2=new Car("sp02","Nissan Leaf",(double)20000.0,99,"red",4,(double)3.0);
//		Car xe3=new Car("sp03","BMW i3",(double)28000.0,80,"red",4,(double)5.0);
//		Car xe4=new Car("sp04","VinFast VF",(double)30000.0,10,"red",8,(double)4.3);
//		Car xe5=new Car("sp05","hyundai Solati",(double)23000.0,121,"red",12,(double)8.0);
//		list.addCar(xe1);
//		list.addCar(xe2);
//		list.addCar(xe3);
//		list.addCar(xe4);
//		list.addCar(xe5);
//		System.out.println("-------------------------------danh sach ban dau --------------------------------");
//		list.Display();
//		System.out.println("truong hop xe ton tai!");
//		if(!list.addCar(xe1)) {
//			System.out.println("xe da ton tai!");
//		};
		// test Sửa thông tin xe
//		System.out.println("------------------------test Sửa thông tin xe----------------------------");
//		Car xe3_sua=new Car("sp03","o to 18 cho",(double)48000.0,30,"red",18,(double)5.0);
//		Car xe4_sua=new Car("sp9999","o to 18 cho",(double)48000.0,30,"red",18,(double)5.0);
//		//TH True
//		if(list.editCar(xe3_sua)) {
//			System.out.println("Sua thanh cong!");
//			list.Display();
//		}
//		else {
//			System.out.println("xe khong ton tai!");
//		}
//		//TH false
//		if(list.editCar(xe4_sua)) {
//			System.out.println("Sua thanh cong!");
//			list.Display();
//		}
//		else {
//			System.out.println("xe khong ton tai!");
//		}
//		//test Xoa xe
//		System.out.println("-------------------------------test Xoa xe-------------------------");
//		Car xe3_xoa=new Car("sp03","o to 18 cho",(double)48000.0,30,"red",18,(double)5.0);
//		Car xe4_xoa=new Car("sp9999","o to 18 cho",(double)48000.0,30,"red",18,(double)5.0);
//		//TH true
//		if(list.delCar(xe3_xoa)) {
//			System.out.println("Xoa thanh cong!");
//			list.Display();
//		}
//		else {
//			System.out.println("xe khong ton tai!");
//		}
//		//th false
//		if(list.delCar(xe4_xoa)) {
//			System.out.println("Xoa thanh cong!");
//			list.Display();
//		}
//		else {
//			System.out.println("xe khong ton tai!");
//		}
		//test tim  theo ten
//		System.out.println("-------------------------------test tim  theo ten-------------------------");
//		//th tim thay
//		list.OutputList(list.searchCar("VinFast VF"));
//		//test tim theo gia
//		System.out.println("-------------------------------test tim theo gia-------------------------");
//		list.OutputList(list.searchCar((double)30000));
//		//test tim theo so cho ngoi
//		System.out.println("-------------------------------test tim theo so cho ngoi------------------------");
//		list.OutputList(list.searchCar(4));
		//test sap xep theo gia
//		System.out.println("-------------------------------test sap xep theo gia------------------------");
//		list.OutputList(list.sortedCar((double)0.0));
//		//test sap xep theo so cho ngoi
//		System.out.println("-------------------------------test sap xep theo so cho ngoi------------------------");
//		list.OutputList(list.sortedCar(0));
//		System.out.println("==================================");
//	}
//}
//		try {
//			list.binaryOutputFile();
//			ArrayList<Car>lst3=list.binaryInputFile("DSCar.bin");
//			for(int i=0;i<lst3.size();i++) {
//				System.out.println(lst3.get(i));
//			}
//		}catch (IOException | ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//list.binaryOutputFile();
//	
//		for(int i=0;i<lst3.size();i++) {
//			System.out.println(lst3.get(i));
//		}
//	}
	

