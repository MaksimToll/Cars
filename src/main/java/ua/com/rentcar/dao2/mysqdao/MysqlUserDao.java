package ua.com.rentcar.dao2.mysqdao;

import org.apache.log4j.Logger;
import ua.com.rentcar.dao2.UserDao;
import ua.com.rentcar.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by maks on 28.01.2015.
 */
public class MysqlUserDao implements UserDao {
    private final Logger logger = Logger.getLogger(UserDao.class);
    PreparedStatement statement = null;
    private Connection connection=null;
    private String getLastInsertId = "SELECT LAST_INSERT_ID();";
    private String insertSqlQuery = "INSERT INTO users"
            + "(avatar, email, passport, login, password, lastLogin, name) VALUES"
            + "(?, ?, ?, ?, ?, ?, ?)";
    private String selectSqlQuery = "Select id, avatar, email, passport, login, password, lastLogin, name FROM users ";
    private String selectUser = "SELECT * FROM carrenta.users WHERE name=?;";
    public MysqlUserDao(Connection connection) {
        this.connection =connection;
    }

    @Override
    public int insertUser(User user) {
        int res =0;
        try {
            statement = connection.prepareStatement(insertSqlQuery);
            statement.setString(1,user.getAvatar());
            statement.setString(2,user.getEmail());
            statement.setString(3, user.getPassport());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            statement.setTimestamp(6, getCurrentTimeStamp());
            statement.setString(7, user.getName());
            statement.executeUpdate();
            logger.info("insert user");
            /*statement.clearParameters();
            ResultSet rs =statement.executeQuery(selectSqlQuery+getLastInsertId);
            if(rs.next()){
                res = rs.getInt("id");
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public User findUser(int id) {
        return null;
    }

    @Override
    public User findUser(String name) {
        PreparedStatement statement = null;
        User user = new User();
        try {
            statement = connection.prepareStatement(selectUser);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setAvatar(resultSet.getString("avatar"));
            user.setEmail(resultSet.getString("passport"));
            user.setEnabled(resultSet.getInt("enabled"));
            user.setPassword(resultSet.getString("password"));
            user.setLastLogin(resultSet.getTimestamp("lastLogin"));
            user.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
    private static java.sql.Timestamp getCurrentTimeStamp() { //TODO move in util

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }
}
