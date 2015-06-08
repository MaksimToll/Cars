package ua.com.rentcar.exeption;

import java.sql.SQLException;

/**
 * Created by maks on 21.01.2015.
 */
public class PersistException extends Exception {
    public PersistException(SQLException e) {

    }

    public PersistException() {

    }

    public PersistException(String s) {

    }
}
