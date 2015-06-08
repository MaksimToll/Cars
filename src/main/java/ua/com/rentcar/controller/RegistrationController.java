package ua.com.rentcar.controller;

import org.apache.log4j.Logger;
import ua.com.rentcar.dao2.DaoFactory;
import ua.com.rentcar.dao2.UserDao;
import ua.com.rentcar.entity.User;
import ua.com.rentcar.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by maks on 28.01.2015.
 */
@WebServlet("/views/registration" )
public class RegistrationController extends HttpServlet {
    private final Logger logger = Logger.getLogger(RegistrationController.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if(registrationUser(request, response)){
            response.sendRedirect("/views/registrationSuccess.jsp");
        }else {
            response.sendRedirect("/views/registration.jsp");
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        registrationUser(request, response);
    }

    private boolean registrationUser(HttpServletRequest request, HttpServletResponse response) {

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setLogin(request.getParameter("login"));
        user.setPhone("phone");
        user.setPassport(request.getParameter("passport"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));

        RegistrationService registrationService = new RegistrationService(); // TODO Посмотреть как сделать сервисы сиглтонами (что бы не создавать каждый раз новый) и имеет ли это смысл
        return registrationService.registrationUser(user);

    }
}
