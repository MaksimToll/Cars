package ua.com.rentcar.filter;

import ua.com.rentcar.util.UserValidator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebFilter("/views/registration")
public class RegistrationValidationFilter implements Filter {
    private UserValidator userValidator;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        userValidator = new UserValidator();//TODO  может лучше сделать этот класс статическим?
        if(userValidator.validateLogin(servletRequest.getParameter("login"))){
            RequestDispatcher rd=servletRequest.getRequestDispatcher("registration.jsp");
            rd.include(servletRequest, servletResponse);
            filterChain.doFilter(servletRequest,servletResponse);

        }else{
            System.out.println("problem with login--------------");
        }
    }

    @Override
    public void destroy() {

    }
}
