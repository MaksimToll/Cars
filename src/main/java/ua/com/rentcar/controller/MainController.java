package ua.com.rentcar.controller;

import org.apache.log4j.Logger;
import ua.com.rentcar.dao2.CarDao;
import ua.com.rentcar.dao2.DaoFactory;
import ua.com.rentcar.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 */
@WebServlet("/index.jsp")
public class MainController extends HttpServlet {
    final static Logger  logger = Logger.getLogger(MainController.class.getName());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        DaoFactory mysqlDao = DaoFactory.getDaoFactor(DaoFactory.MYSQL); // TODO переделать на уровень сервисов.
        CarDao carDao = mysqlDao.getCarDao();
        List<Car> cars ;
        cars=  carDao.getAllCar();
        logger.info(cars.size());
        request.setAttribute("cars", cars);
        try {
            request.getRequestDispatcher("views/allCars.jsp").forward(request, response);
        } catch (ServletException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
