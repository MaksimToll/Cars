package ua.com.rentcar.service;

import ua.com.rentcar.util.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maks on 10.02.2015.
 */
public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return "No Command";
    }
}
