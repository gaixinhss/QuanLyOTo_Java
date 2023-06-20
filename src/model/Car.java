package model;

import java.io.Serializable;
import java.util.Scanner;

public class Car extends Product_DA implements Serializable{
	
	//constants
	public static final String COLOR="NO COLOR";
	public static final int SOCHONGOI=0;
	public static final double DUNGTICH=0;
	
	//car's properties
	public  String color;
	public int sochongoi;
	public double dungtich;
	
	//contructor methods
	public Car() {
		this(Car.PRODUCT_ID,Car.PRODUCT_NAME,Car.PRODUCT_PRICE,Car.PRODUCT_TOTAL,Car.COLOR,Car.SOCHONGOI,Car.DUNGTICH);
	}
	public Car(String product_id,String product_name,double product_price,int product_total,String color,int sochongoi,double dungtich) {
		super(product_id,product_name,product_price,product_total);
		this.color=color;
		this.sochongoi=sochongoi;
		this.dungtich=dungtich;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getSochongoi() {
		return sochongoi;
	}
	public void setSochongoi(int sochongoi) {
		this.sochongoi = sochongoi;
	}
	public double getDungtich() {
		return dungtich;
	}
	public void setDungtich(double dungtich) {
		this.dungtich = dungtich;
	}
	public void input() {
		Scanner s= new Scanner(System.in);
		super.input();
		s.nextLine();//xoa bo dem scanner
		System.out.println("nhap color :   ");
		this.color=s.nextLine();
		System.out.println("nhap so cho ngoi   ");
		this.sochongoi=s.nextInt();
		System.out.println("nhap dung tich :  ");
		this.dungtich=s.nextDouble();
		
	}
	@Override
	public String toString() {
		return "Car ["+super.toString()+"color=" + color + ", sochongoi=" + sochongoi + ", dungtich=" + dungtich + "]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car xe1=new Car("sp1","Car 1",20000,10,"red",16,4.8);
		System.out.println(xe1);
	}

}
