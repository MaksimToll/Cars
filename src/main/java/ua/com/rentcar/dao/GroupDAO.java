package ua.com.rentcar.dao;

import ua.com.rentcar.entity.Group;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by maks on 21.01.2015.
 */
public interface GroupDAO {
    public Group create();
    public Group read(int id) throws SQLException;
    public void update(Group group);
    public void delete(Group group);
    public List<Group> getAll() throws SQLException;
}
