package ua.com.rentcar.dao;

import ua.com.rentcar.exeprion.PersistException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by maks on 21.01.2015.
 */
/**
 * @param <T> type of persistence object
 * @param  <PK> type of key parameter*/
public interface GenericDao<T, PK extends Serializable> {
    public T create() throws PersistException;
    public T persist(T object) throws SQLException, PersistException;
    public T getByPK(int key) throws SQLException, PersistException;
    public void update(T object) throws SQLException, PersistException;
    public void delete(T object) throws SQLException, PersistException;
    public List<T> getAll() throws SQLException, PersistException;
}
