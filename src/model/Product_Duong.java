package model;

import java.io.Serializable;

public class Product_Duong implements Serializable {
	/* Update 30/11/2022
	 * Author Vuong Tung Duong
	 */
	
	private static final long serialVersionUID = 3L;
	
	//Constants
	public static final int ID=0;
	public static final String NAME="No name";
	public static final double PRICE=0;
	public static final byte TOTAL=(byte)0;
	
	//Properties
	private int Id;
	private String Name;
	private double Price;
	private byte Total;
	
	//Constructor no parameter
	public Product_Duong() {
		this(Product_Duong.ID, Product_Duong.NAME, Product_Duong.PRICE, Product_Duong.TOTAL);
	}
	
	//Constructor has parameter
	public Product_Duong(int id, String name, double price, byte total) {
		this.Id=id;
		this.Name=name;
		this.Price=price;
		this.Total=total;
	}
	
	//Getters
	public int getId() {
		return this.Id;
	}
	public String getName() {
		return this.Name;
	}
	public double getPrice() {
		return this.Price;
	}
	public byte getTotal() {
		return this.Total;
	}
	
	//Setters
	public void setId(int id) {
		this.Id=id;
	}
	public void setName(String name) {
		this.Name=name;
	}
	public void setPrice(double price) {
		this.Price=price;
	}
	public void setTotal(byte total) {
		this.Total=total;
	}
	
	//This method is used to toString a Product
	public String toString() {
		return "Product [Id= "+Id+", Name= "+Name+", Price= "+Price+", Total= "+Total+"]";
	}
}
