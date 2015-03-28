package ua.com.rentcar.dao;

import ua.com.rentcar.exeprion.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by maks on 21.01.2015.
 */
public abstract class AbstractJdbcDao<T extends Identified<PK>, PK extends Integer> implements GenericDao<T, PK> {
    protected AbstractJdbcDao(Connection connection) {
        this.connection = connection;
    }

    private Connection connection;

    public abstract String getSelectQuery();

    public abstract List<T> parseResultSet(ResultSet resultSet) throws PersistException;

    public abstract String getCreateQuery();

    @Override
    public T getByPK(int key) throws PersistException {
        List<T> list;
        String sql = getSelectQuery() + "WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, key);
            ResultSet resultSet = statement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        if (list == null || list.size() == 0) {
            throw new PersistException();
        }
        if (list.size() > 1) {
            throw new PersistException();
        }
        return list.iterator().next();
    }


    @Override
    public List<T> getAll() throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return list;
    }

    public abstract String getUpdateQuery();

    @Override
    public T persist(T object) throws PersistException {
        if (object.getId() != null) {
            throw new PersistException("Object is alredy persist");
        }
        T persistInstance = null;
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            PrepareStatmementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On persist modify then 1 record" + count);
            }
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        sql = getSelectQuery() + " where id = last_insert_id();";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if (list == null || (list.size() != 1)) {
                throw new PersistException("Execute on findByPK new persist data");
            }
            persistInstance = list.iterator().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persistInstance;
    }

    protected abstract void PrepareStatmementForInsert(PreparedStatement statement, T object) throws PersistException;

    @Override
    public void update(T object) throws PersistException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForUpdate(statement, object); // TODO
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On update modify then 1 record: " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T object) throws PersistException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            try {
                statement.setObject(1, object.getId());
            } catch (Exception e) {
                throw new PersistException();
            }
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract String getDeleteQuery();

    public abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws PersistException;

}
