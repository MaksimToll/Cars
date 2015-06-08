package ua.com.rentcar;

import ua.com.rentcar.dao2.DaoFactory;
import ua.com.rentcar.dao2.UserDao;
import ua.com.rentcar.entity.User;

import java.sql.SQLException;

/**
 * Created by maks on 28.01.2015.
 */
public class TestJdbc {
    public static void main(String[] args) throws SQLException {
        DaoFactory daoFactory = DaoFactory.getDaoFactor(DaoFactory.MYSQL);
        UserDao userDao =daoFactory.getUserDao();
        User user = new User();
        user.setName("Damask");
        user.setAvatar("asdf");
        user.setEmail("aasdfsd@mail,uis");
        user.setLogin("Hroback");
        user.setPassword("sadfgfdaf23");
        user.setPassport("mt234522");
        int idUser =userDao.insertUser(user);
        System.out.println(idUser);
    }
}
