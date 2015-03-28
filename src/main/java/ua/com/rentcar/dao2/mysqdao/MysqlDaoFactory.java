package ua.com.rentcar.dao2.mysqdao;

import ua.com.rentcar.dao2.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by maks on 24.01.2015.
 */
public class MysqlDaoFactory extends DaoFactory {
    private static Connection connection ;
    public MysqlDaoFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection=createConnection();
    }

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/carrenta";

    //  Database credentials
    static final String USER = "root";//TODO set it in  .properties file
    static final String PASS = "root";
    public static Connection createConnection(){
        InitialContext cxt = null;
        try {

            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

// Look up our data source
            DataSource ds = (DataSource) envCtx.lookup("jdbc/carrenta");

// Allocate and use a connection from the pool
             connection = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

/*        try {

             connection = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return  connection;
    }
    @Override
    public CarDao getCarDao() {
        return new MysqlCarDao(connection) ;
    }

    @Override
    public GroupDao getGroupDao() {
        return null;
    }

    @Override
    public OrderDao getOrdersDao() {
        return null;
    }

    @Override
    public UserDao getUserDao() {
        return new MysqlUserDao(connection);
    }
}
