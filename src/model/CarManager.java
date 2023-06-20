package model;
import java.io.IOException;
import java.util.*;
public interface CarManager {
	public boolean addCar(Car c) throws IOException;//thêm một thông tin ô tô vào hệ thống quản lý.
	public boolean editCar(Car c)throws IOException;//sửa thông tin ô tô
	public boolean  delCar(Car c)throws IOException;//xoá ô tô
	public List<Car> searchCar(String name)throws IOException;//tìm kiếm car theo name
	public List<Car> searchCar(Double price)throws IOException;//tìm kiếm theo giá
	public List<Car> searchCar(int sochongoi)throws IOException;//tìm kiếm theo số chỗ ngồi
	public List<Car> sortedCar(int sochongoi)throws IOException;// sắp xếp theo số chỗ ngồi
	public List<Car> sortedCar(double Price)throws IOException;//Sắp xếp thep giá
	
}
