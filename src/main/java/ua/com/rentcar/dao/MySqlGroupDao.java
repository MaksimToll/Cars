package ua.com.rentcar.dao;

import ua.com.rentcar.entity.Group;
import ua.com.rentcar.exeption.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by maks on 21.01.2015.
 */
public class MySqlGroupDao extends  AbstractJdbcDao<Group,Integer> {
    protected MySqlGroupDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return " SELECT id, name FROM carrenta.group";
    }

    @Override
    public List<Group> parseResultSet(ResultSet resultSet) {
        LinkedList<Group> result = new LinkedList<Group>();
        try{
            while(resultSet.next()){
                PersistGroup group = new PersistGroup();
                group.setId(resultSet.getInt("id"));
                group.setName("name");
                result.add(group);
            }
        } catch (SQLException e) {
            try {
                throw new PersistException(e);
            } catch (PersistException e1) {
                e1.printStackTrace();
            }
        }
        return result;

    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO carrenta.group (name)  VALUES (?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE carrenta.group SET name = ? where id= ?;";
    }

    @Override
    protected void PrepareStatmementForInsert(PreparedStatement statement, Group object) {
        try{
            statement.setString(1, object.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM carrenta.group WHERE id = ?;";
    }

    @Override
    public void prepareStatementForUpdate(PreparedStatement statement, Group object) {
        try {
            statement.setString(1,object.getName());
            statement.setInt(2, object.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Group create() throws PersistException {
        Group g = new Group();
        return persist(g);

    }

    private class PersistGroup extends Group{
        public void setId(int id){
            super.setId(id);
        }
    }
 /*   private final Connection connection;
    public MySqlGroupDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Group create() {
        return null;
    }

    @Override
    public Group read(int id) throws SQLException {
        String sql = "SELECT * FROM carrenta.group WHERE id = ?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1,id);
        ResultSet resultSet = stm.executeQuery();
        resultSet.next();
        Group group = new Group();
        group.setId(resultSet.getInt("id"));
        group.setName(resultSet.getString("name"));
        return group;
    }

    @Override
    public void update(Group group) {

    }

    @Override
    public void delete(Group group) {

    }

    @Override
    public List<Group> getAll() throws SQLException {
        String sql = "SELECT * FROM carrenta.group;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet resultSet = stm.executeQuery();
        List<Group> result = new ArrayList<Group>();
        while (resultSet.next()){
            Group group = new Group();
            group.setId(resultSet.getInt("id"));
            group.setName(resultSet.getString("name"));
            result.add(group);
        }
        return result;
    }*/
}
