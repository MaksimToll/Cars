package ua.com.rentcar.dao;

//import com.mysql.fabric.xmlrpc.base.Data;
import ua.com.rentcar.entity.Car;
import ua.com.rentcar.exeprion.PersistException;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by maks on 24.01.2015.
 */
public class MySqlCarDao extends AbstractJdbcDao<Car, Integer> {
    protected MySqlCarDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, image, group, enabled, name, marka, last_used,  number FROM carrenta.cars ";
    }

    @Override
    public List<Car> parseResultSet(ResultSet resultSet) throws PersistException {
        LinkedList<Car> cars = new LinkedList<Car>();
        try {
            while (resultSet.next()){
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setImage(resultSet.getString("image"));
                car.setGroup(resultSet.getInt("group"));
                car.setEnabled(resultSet.getInt("enabled"));
                car.setName(resultSet.getString("name"));
                car.setMarka(resultSet.getString("marka"));
                car.setLastUpdate(resultSet.getTimestamp("last_used"));
                car.setNumber(resultSet.getString("number"));
                cars.add(car);
            }


        } catch (SQLException e) {
           throw new PersistException(e);
        }
        return cars;
    }

    @Override
    public String getCreateQuery() {
        return "INSERT into carrenta.cars image, group, enabled, name, marka, last_used, number VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE carrenta.cars SET image=?, group = ? , enabled=?, last_used=?, number =? WHERE id=?;";
    }

    @Override
    protected void PrepareStatmementForInsert(PreparedStatement statement, Car object) throws PersistException {
        Date sqlData = convert(object.getLastUpdate());
        try {
            statement.setString(1, object.getImage());
            statement.setInt(2, object.getGroup());
            statement.setInt(3, object.getEnabled());
            statement.setString(4, object.getName());
            statement.setString(5, object.getMarka());
            statement.setTimestamp(6, object.getLastUpdate());
            statement.setString(7, object.getNumber());

        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    private Date convert(java.util.Date lastUpdate) {
        if(lastUpdate ==null){
            return  null;
        }
        return new Date(lastUpdate.getTime());
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM carrenta.cars WHERE id=?;";
    }

    @Override
    public void prepareStatementForUpdate(PreparedStatement statement, Car object) throws PersistException {
        int id = object.getId();
        try {
            statement.setInt(1, object.getId());
            statement.setString(2, object.getImage());
            statement.setInt(3, object.getGroup());
            statement.setInt(4, object.getEnabled());
            statement.setString(5, object.getName());
            statement.setString(6, object.getMarka());
            statement.setTimestamp(7, object.getLastUpdate());
            statement.setString(8, object.getNumber());

        } catch (SQLException e) {
            throw  new PersistException(e);
        }
    }

    @Override
    public Car create() throws PersistException {
        Car car = new Car();
        return persist(car);
    }
}
