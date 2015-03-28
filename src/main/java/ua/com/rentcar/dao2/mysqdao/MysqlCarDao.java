package ua.com.rentcar.dao2.mysqdao;

import ua.com.rentcar.dao2.CarDao;
import ua.com.rentcar.entity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by maks on 24.01.2015.
 */
public class MysqlCarDao implements CarDao {
    private Connection connection ;

    public MysqlCarDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insertCar(Car car) {
        return 0;
    }

    @Override
    public boolean deleteCar(int id) {
        String sql = "DELETE cars WHERE id =?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeQuery();
            return true; // Преределать ...
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Car findCar(int id) {
        Car car=null;
        String sql = "SELECT * FROM carrenta.cars WHERE id=?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            car = new Car();
            car.setId(resultSet.getInt("id")); // TODO make builder for car
            car.setImage(resultSet.getString("image"));
            car.setGroup(resultSet.getInt("group"));
            car.setEnabled(resultSet.getInt("enabled"));
            car.setNumber(resultSet.getString("number"));
            car.setName(resultSet.getString("name"));
            car.setMarka(resultSet.getString("marka"));
            car.setLastUpdate(resultSet.getTimestamp("last_used"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public Car findCar(String name) {
        Car car=null;
        String sql = "SELECT * FROM carrenta.cars WHERE name=?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            car = new Car();
            car.setId(resultSet.getInt("id")); // TODO make builder for car
            car.setImage(resultSet.getString("image"));
            car.setGroup(resultSet.getInt("group"));
            car.setEnabled(resultSet.getInt("enabled"));
            car.setNumber(resultSet.getString("number"));
            car.setName(resultSet.getString("name"));
            car.setMarka(resultSet.getString("marka"));
            car.setLastUpdate(resultSet.getTimestamp("last_used"));
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public Car updateCar(Car car) {
        return null;
    }

    @Override
    public List<Car> getAllCar() {
        String sql = "SELECT * FROM carrenta.cars ;";
        List<Car> result = new ArrayList<>();
        try {
            PreparedStatement statement =connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Car car = new Car();
                car.setId(rs.getInt("id")); // TODO make builder for car
                car.setImage(rs.getString("image"));
                car.setGroup(rs.getInt("group"));
                car.setEnabled(rs.getInt("enabled"));
                car.setNumber(rs.getString("number"));
                car.setName(rs.getString("name"));
                car.setMarka(rs.getString("marka"));
                car.setLastUpdate(rs.getTimestamp("last_used"));
                result.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
