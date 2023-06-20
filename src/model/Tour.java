package model;

public class Tour extends Product_Duong implements Comparable<Tour> {
	/* Update 30/11/2022
	 * Author Vuong Tung Duong
	 */


	
	//Constants
	public static final String LOCATION="No location";
	public static final byte DAY=0;
	public static final boolean TOURGUIDE=false;
	
	//Properties
	private String Location;
	private byte Day;
	private boolean TourGuide;
	
	//Constructor no parameter
	public Tour() {
		this(Tour.ID,Tour.NAME,Tour.PRICE,Tour.TOTAL,Tour.LOCATION,Tour.DAY,Tour.TOURGUIDE);
	}
	
	//Constructor has parameter
	public Tour(int id, String name, double price, byte total, String location, byte day, boolean tourGuide) {
		super(id, name, price, total);
		this.Location=location;
		this.Day=day;
		this.TourGuide=tourGuide;
	}
	
	//Getters
	public String getLocation() {
		return this.Location;
	}
	public byte getDay() {
		return this.Day;
	}
	public String getTourGuide() {
		if(this.TourGuide) {
			return "Yes";
		}else {
			return "No";
		}
	}
	
	//Setters
	public void setLocation(String location) {
		this.Location=location;
	}
	public void setDay(byte day) {
		this.Day=day;
	}
	public void setTourGuide(boolean tourGuide) {
		this.TourGuide=tourGuide;
	}
	
	//This method is used to toString a Tour
	@Override
	public String toString() {
		return "Tour ["+super.toString()+"-Location= "+Location+", Day= "+Day+", Tour Guide= "+this.getTourGuide()+"]";
	}

	@Override
	public int compareTo(Tour o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
}
