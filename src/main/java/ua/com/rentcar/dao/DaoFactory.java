package ua.com.rentcar.dao;

import ua.com.rentcar.exeption.PersistException;

/**
 * Created by maks on 24.01.2015.
 */
public interface DaoFactory<Context> {
    public interface DaoCreator<Context> {
        public GenericDao create(Context context);
    }

    /** Возвращает подключение к базе данных */
    public Context getContext() throws PersistException;

    /** Возвращает объект для управления персистентным состоянием объекта */
    public GenericDao getDao(Context context, Class dtoClass) throws PersistException;
}
