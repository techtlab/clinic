import com.clinic.dao.UserDAO;
import com.clinic.dao.impl.UserDAOImpl;
import com.clinic.domain.User;
import org.junit.Assert;
import org.testng.annotations.Test;

public class UserDAOTest {

    /*private User user;
    private UserDAO userDAO = new UserDAOImpl();


    @Test
    public void testAddNewUser() {
        userDAO.addNewUser("MarkStar","123", (byte)0, "Mark de Volan", "43-54-23", "st.ra, ew, 4, 4");
    }

    @Test(dependsOnMethods = {"testAddNewUser"})
    public void testGetUserByLoginAndPassword() {
        user = userDAO.getUserByLoginAndPassword("MarkStar", "123");
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getLogin(), "MarkStar");
        Assert.assertEquals(user.getPassword(), "123");
    }

    @Test(dependsOnMethods = {"testGetUserByLoginAndPassword"})
    public void testGetUserById() {
        user = userDAO.getUserById(user.getId());
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getLogin(), "MarkStar");
        Assert.assertEquals(user.getPassword(), "123");
    }

    @Test(dependsOnMethods = {"testGetUserById"})
    public void testGetUserByRole() {
        user = userDAO.getUserByRole(user.getRole());
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getLogin(), "MarkStar");
        Assert.assertEquals(user.getPassword(), "123");
    }

    @Test(dependsOnMethods = {"testGetUserByRole"})
    public void testUpdateUserInfoByLogin() {
        userDAO.updateUserInfoByLogin(user.getLogin(), "234", (byte)1, "Alex", "111-11-11", "st.Richi, ew, 4, 4");
    }

    @Test(dependsOnMethods = {"testUpdateUserInfoByLogin"})
    public void testGetUserByLogin() {
        User changingUser = userDAO.getUserByLogin(user.getLogin());
        Assert.assertNotEquals(changingUser.getPassword(), user.getPassword());
        Assert.assertNotEquals(changingUser.getRole(), user.getRole());
        Assert.assertNotEquals(changingUser.getName(), user.getName());
        Assert.assertNotEquals(changingUser.getPhone(), user.getPhone());
        Assert.assertNotEquals(changingUser.getAddress(), user.getAddress());
    }

    @Test(dependsOnMethods = {"testGetUserByLogin"})
    public void testDeleteUser() {
        userDAO.deleteUser("MarkStar");
        User dUser = userDAO.getUserByLogin(user.getLogin());
        Assert.assertNull(dUser);
    }

    @Test(dependsOnMethods = {"testGetUserByLoginAndPassword"})
    public void testAddDisease(){
        user = userDAO.getUserByLoginAndPassword("MarkStar", "123");
        Assert.assertNotNull(user);

        int beforeCount = user.getDiseases().size();
        userDAO.addDisease("now", "descr", 0, user);

        user = userDAO.getUserByLoginAndPassword("MarkStar", "123");
        Assert.assertNotNull(user);
        int afterCount = user.getDiseases().size();

        Assert.assertNotEquals(beforeCount, afterCount);
    }

    @Test(dependsOnMethods = {"testAddDisease"})
    public void testGetDiseaseListByUser(){
        user = userDAO.getUserById(3);
        List<Disease> diseaseList = userDAO.getDiseaseListByUser(user);
        System.out.println("size " + diseaseList.size());
    }*/
}
