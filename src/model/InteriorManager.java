package model;

import java.util.List;

public interface InteriorManager {
	public boolean addInterior(Interior i);
	public boolean editInterior(Interior i);
	public boolean delInterior(Interior i);
	public List< Interior> searchInterior(String name);
	public List< Interior> searchInterior(double price);
	public List< Interior> searchInterior(double weight,String color);
	public List< Interior> sortedInterior(double price);
}
