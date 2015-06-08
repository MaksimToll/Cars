package ua.com.rentcar.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fagim on 20.04.15.
 */
@WebServlet("/registration")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*super.doPost(request, response);*/
        response.sendRedirect("/views/registration.jsp");
//        request.getRequestDispatcher().s;
    }
}
