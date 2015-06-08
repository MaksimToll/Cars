package ua.com.rentcar.service;

import org.apache.log4j.Logger;
import ua.com.rentcar.dao2.DaoFactory;
import ua.com.rentcar.dao2.UserDao;
import ua.com.rentcar.entity.User;

import java.sql.SQLException;

public class RegistrationService {
    private  DaoFactory mysqlDao = DaoFactory.getDaoFactor(DaoFactory.MYSQL);// TODO Избавиться от выбора типа базы данных в сервисах
    UserDao userDao = mysqlDao.getUserDao();
    private final Logger logger = Logger.getLogger(RegistrationService.class);

    public boolean registrationUser(User user){
        try {
            userDao.insertUser(user);
            logger.info(user);
            return true;

        } catch (SQLException e) {
            logger.error(e+" n/ <--------- Can`t add user to database ------------->");
            return false;
        }
    }
    /**
     * check exist user in database or not. Verification field login and email //TODO можливо додати номер телефону чи паспорту
     * @return true if user with login or email exist in database, else return false
     * */
    private boolean checkUserInDb(User userFromClient){
        boolean userByLogin = userDao.checkUserByLogin(userFromClient.getLogin()); // find user in db use login user from client;
        boolean userByEmail = userDao.checkUserByEmail(userFromClient.getEmail()); // find user in db use login user from client;
        if(userByEmail && userByLogin){
            return false;
        }else{
            return true;
        }
    }

}
