package ua.com.rentcar.dao;


import org.junit.Test;




/**
 * Created by maks on 21.01.2015.
 */
public class MySqlGroupDaoTest {
    @Test
    public void getAllTest(){
        DaoFactory daoFactory = new MySqlDaoFactory();
       /* List<Group> groups;
        try {
            Connection connection =daoFactory.getConnection();
            GroupDAO dao = daoFactory.getGroupDAO(connection);
            groups =dao.getAll();
            for(Group group: groups){
                System.out.println(group);
            }
            Assert.assertNotNull(groups);
            Assert.assertTrue(groups.size()>0);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }
}
