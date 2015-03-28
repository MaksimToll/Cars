package ua.com.rentcar.controller;


import ua.com.rentcar.util.ActionCommand;
import ua.com.rentcar.util.ActionFactory;
import ua.com.rentcar.util.ConfigurationManager;
import ua.com.rentcar.util.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by maks on 30.01.2015.
 */
@WebServlet("/views/controller")    // TODO срочно сделать что би перехватывал все запросы!(плохая идея ибо перехватывает мои форварды внутри логики программы)
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        // определение команды, пришедшей из JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);//TODO Не стоит отпускать гулять по бизнес логике, Использовать util.SessionContext
  /*
     * вызов реализованного метода execute() и передача параметров
     * классу-обработчику конкретной команды
  */
        page = command.execute(request);
        // метод возвращает страницу ответа
        // page = null; // поэксперементировать!
        if (page != null) {
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(page);
            // вызов страницы ответа на запрос
            dispatcher.forward(request, response);
        }else  {
            // установка страницы c cообщением об ошибке
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page );
        }
    }
}
