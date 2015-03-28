package ua.com.rentcar.dao;

import ua.com.rentcar.entity.Car;

import java.util.List;

/**
 * Created by maks on 21.01.2015.
 */
public interface CarDAO {
    public Car create();
    public Car read(int id);
    public void update(Car car);
    public void delete (Car car);
    public List<Car> getAll();
}
