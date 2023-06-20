package model;
import java.io.Serializable;
import java.util.Scanner;
public class Product_DA implements Serializable{
	//constants
	public static final String PRODUCT_ID="NO PRODUCT ID";
	public static final String PRODUCT_NAME="NO PRODUCT NAME";
	public static final double PRODUCT_PRICE=0;
	public static final int PRODUCT_TOTAL=0;
	//classes' variables
	public String product_id;
	public String product_name;
	public double product_price;
	public int product_total;
	
	//contructor methods
	public Product_DA() {
		this(Product_DA.PRODUCT_ID,Product_DA.PRODUCT_NAME,Product_DA.PRODUCT_PRICE,Product_DA.PRODUCT_TOTAL);
	}
	public Product_DA(String product_id,String product_name,double product_price,int product_total) {
		this.product_id=product_id;
		this.product_name=product_name;
		this.product_price=product_price;
		this.product_total=product_total;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public int getProduct_total() {
		return product_total;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public void setProduct_total(int product_total) {
		this.product_total = product_total;
	}
	public void input() {
		Scanner s=new Scanner(System.in);
		System.out.println("Nhap product_id:  ");
		this.product_id=s.nextLine();
		System.out.println("nhap product_name:   ");
		this.product_name=s.nextLine();
		System.out.println("nhap product_price:   ");
		this.product_price=s.nextDouble();
		System.out.println("Nha product_total :   ");
		this.product_total=s.nextInt();
	}
	@Override
	public String toString() {
		return "id=" + product_id + ", name=" + product_name + ", price="
				+ product_price + ", total=" + product_total + "]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product_DA sp1=new Product_DA("pro01","car",200000,100);
		System.out.println(sp1);
	}

}
