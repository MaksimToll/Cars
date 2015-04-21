package ua.com.rentcar.controller;

import org.apache.log4j.Logger;
import ua.com.rentcar.dao2.DaoFactory;
import ua.com.rentcar.dao2.UserDao;
import ua.com.rentcar.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by maks on 28.01.2015.
 */
@WebServlet("/views/registration" )
public class RgistrationController extends HttpServlet {
    private final Logger logger = Logger.getLogger(RgistrationController.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {

        DaoFactory mysqlDao = DaoFactory.getDaoFactor(DaoFactory.MYSQL);// TODO создать на слое сервисов
        UserDao userDao = mysqlDao.getUserDao();
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setLogin(request.getParameter("login"));
        user.setPhone("phone");
        user.setPassport(request.getParameter("passport"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        userDao.insertUser(user);
        logger.info(user);

    }
}
