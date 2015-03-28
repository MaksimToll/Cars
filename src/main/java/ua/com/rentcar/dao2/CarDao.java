package ua.com.rentcar.dao2;

import ua.com.rentcar.entity.Car;

import java.util.Collection;
import java.util.List;

/**
 * Created by maks on 24.01.2015.
 */
public interface CarDao {
    public int insertCar(Car car);
    public boolean deleteCar(int id);
    public Car findCar(int id);
    public Car findCar(String name);
    public Car updateCar(Car car);
    public List<Car> getAllCar();
}
