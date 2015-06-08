package ua.com.rentcar.dao2;

import ua.com.rentcar.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by maks on 28.01.2015.
 */
public interface UserDao {
    public int insertUser(User user) throws SQLException;
    public boolean deleteUser(int id);
    public User findUser(int id);
    public User findUser(String name);
    public List<User> getAll();
    public boolean checkUserByLogin(String login);
    public boolean checkUserByEmail(String email);
}
