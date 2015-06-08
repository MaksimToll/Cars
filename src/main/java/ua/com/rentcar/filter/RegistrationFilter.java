package ua.com.rentcar.filter;

import ua.com.rentcar.util.UserValidation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "views/registration.jsp" , initParams = @WebInitParam(name = "NOT_VALID_PAGE", value = "views/notValidData.jsp"))
public class RegistrationFilter implements Filter {
    private String initPath;
    private UserValidation validation;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            initPath = filterConfig.getInitParameter("NOT_VALID_PAGE");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // переход на заданную страницу
        httpResponse.sendRedirect(httpRequest.getContextPath() + initPath);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
    private boolean validationForm(ServletRequest request){
        validation = new UserValidation();
        if(!validation.validateName(request.getParameter("name"))){
            return false;
        }else if(!validation.validateEmail(request.getParameter("email"))){
            return false;
        }else if(!validation.validateEmail(request.getParameter("password"))){
            return false;
        }else {
            return true;
        }
    }
}
