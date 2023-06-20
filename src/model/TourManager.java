package model;

import java.io.IOException;
import java.util.List;

public interface TourManager {
	public boolean addTour(Tour t) throws IOException;
	public boolean editTour(Tour t) throws IOException;
	public boolean delTour(Tour t) throws IOException;
	
	public List<Tour> searchTour(String name);
	public List<Tour> searchTour(double price);
	public List<Tour> searchTour(byte day);
	public List<Tour> searchTour(boolean tourGuide);
	
	public List<Tour> sortedTour(double price);
	public List<Tour> sortedTour(byte day);
	public List<Tour> sortedTourId();
	public List<Tour> sortedTourByName();
	
	public List<Tour> generateListTour(int n, int soLuong);
	public void delAll() throws IOException;
}
