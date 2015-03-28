package ua.com.rentcar.util;

/**
 * Created by maks on 05.03.2015.
 */
public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "12345";
    public static boolean checkLogin(String enterLogin, String enterPass) {
        return ADMIN_LOGIN.equals(enterLogin) &&
                ADMIN_PASS.equals(enterPass);
    }
}