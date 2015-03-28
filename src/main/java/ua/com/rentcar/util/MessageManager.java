package ua.com.rentcar.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by maks on 10.02.2015.
 */
public class MessageManager {
    private static FileInputStream fis;
    private static Properties properties = new Properties();
    private static String res;
    public  static String getProperty(String message){
        try {
            fis =new FileInputStream("src/main/resources/Message.properties");
            properties.load(fis);
            res = properties.getProperty(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
