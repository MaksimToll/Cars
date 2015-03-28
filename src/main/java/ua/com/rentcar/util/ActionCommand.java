package ua.com.rentcar.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maks on 30.01.2015.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);

}
