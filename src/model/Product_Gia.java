package model;

import java.io.Serializable;

public class Product_Gia implements Serializable {
	public static final int PRODUCT_ID = 0;
	public static final String PRODUCT_NAME = "no_name";
	public static final double PRODUCT_PRICE = 0;
	public static final int PRODUCT_TOTAL = 0;
	
	private int product_id;
	private String product_name;
	private double product_price;
	private int product_total;
	
	
	public Product_Gia(int product_id, String product_name, double product_price, int product_total) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_total = product_total;
	}
	public Product_Gia() {
		this(Product_Gia.PRODUCT_ID,Product_Gia.PRODUCT_NAME,Product_Gia.PRODUCT_PRICE,Product_Gia.PRODUCT_TOTAL);
	}
	
	
	public int getProduct_id() {
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
	public void setProduct_id(int product_id) {
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
	
	
	@Override
	public String toString() {
		return product_id+","+product_name+","+product_price+","+product_total;
	}
		
}
