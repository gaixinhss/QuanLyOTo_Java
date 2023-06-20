package model;

import java.io.Serializable;

public class Interior extends Product_Gia implements Serializable{
	public static final double WEIGHT = 0;
	public static final String COLOR = "no_color";
	
	private double weight;
	private String color;
	
	public Interior(int product_id, String product_name, double product_price, int product_total, double weight, String color) {
		super(product_id, product_name, product_price, product_total);
		this.weight = weight;
		this.color = color;
	}
	public Interior() {
		this(Product_Gia.PRODUCT_ID,Product_Gia.PRODUCT_NAME,Product_Gia.PRODUCT_PRICE,Product_Gia.PRODUCT_TOTAL,Interior.WEIGHT,Interior.COLOR);
	}
	public double getWeight() {
		return weight;
	}
	public String getColor() {
		return color;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return super.toString() +"-"+ weight+"-"+color;
	}
}
