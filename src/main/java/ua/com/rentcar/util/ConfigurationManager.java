package ua.com.rentcar.util;

/**
 * Created by maks on 10.02.2015.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    /*private final static ResourceBundle resourceBundle =
            ResourceBundle.getBundle("resources.config");
    // класс извлекает информацию из файла Config.properties
    private ConfigurationManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }*/
    private static FileInputStream fis;
    private static Properties properties = new Properties();
    private static String res;
    public  static String getProperty(String message){
        try {
            File file = new File("C:\\Users\\maks\\IdeaProject2\\Cars\\src\\main\\resources\\Config.properties");
            fis =new FileInputStream(file);
            properties.load(fis);
            res = properties.getProperty(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}

