package ua.com.rentcar.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by maks on 30.01.2015.
 */
public class SessionServletContext {
    public class SessionRequestContent {
        private HashMap<String, Object> requestAttributes;
        private HashMap<String, String[]> requestParameters;
        private HashMap<String, Object> sessionAttributes;
        // конструкторы
        // метод извлечения информации из запроса
        public void extractValues(HttpServletRequest request) {
            // реализация
        }
        // метод добавления в запрос данных для передачи в jsp
        public void insertAttributes(HttpServletRequest request) {
            // реализация
        }
        // some methods
    }
}
