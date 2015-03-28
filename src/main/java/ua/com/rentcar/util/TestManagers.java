package ua.com.rentcar.util;

/**
 * Created by maks on 05.03.2015.
 */
public class TestManagers {
    public static void main(String[] args) {
//        String name =MessageManager.getProperty("message.loginerror");
//        System.out.println(name);
        String name2 =ConfigurationManager.getProperty("path.page.index");
        System.out.println(name2);
    }
}
