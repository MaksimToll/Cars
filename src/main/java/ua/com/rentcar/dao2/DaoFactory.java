package ua.com.rentcar.dao2;

import ua.com.rentcar.dao2.mysqdao.MysqlDaoFactory;

/**
 * Created by maks on 24.01.2015.
 */
public abstract class DaoFactory {
    public static final int MYSQL =1;
    public static final int MONGODB =2;
    public abstract CarDao getCarDao();
    public abstract  GroupDao getGroupDao();
    public abstract OrderDao getOrdersDao();
    public abstract UserDao getUserDao();
    public static DaoFactory getDaoFactor(int witchDaoFactory){
        switch (witchDaoFactory){
            case  MYSQL:
                return  new MysqlDaoFactory();

            default:
                return null;
        }
    }
}
