package ua.com.rentcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fagim on 21.04.15.
 */
public class UserValidator {
    private Pattern pattern;
    private Matcher matcher;
    //TODO make validation string in properties util
    private static final String PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{4,20})";
    private static final String LOGIN = "^[a-z0-9_-]{3,15}$";
    private static final String phone = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    private static final String EMAIL = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b.";
    private static final String passport  = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    public boolean validatePassword(final String password){
        pattern = Pattern.compile(PASSWORD);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public boolean validateLogin(final String login){
        pattern = Pattern.compile(LOGIN);
        matcher = pattern.matcher(login);
        return matcher.matches();
    }
    public boolean validateEmail(final String email){
        pattern = Pattern.compile(PASSWORD);
        matcher = pattern.matcher(EMAIL);
        return matcher.matches();
    }

}
