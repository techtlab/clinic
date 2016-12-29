import com.clinic.dao.impl.UserDAOImpl;
import com.clinic.model.User;
import org.junit.Assert;
import org.testng.annotations.Test;

public class UserDAOTest {

    private User user;

    @Test
    public void testAddNewUser() {
        UserDAOImpl.addNewUser("MarkStar","123", (byte)0, "Mark de Volan", "43-54-23", "st.ra, ew, 4, 4");
    }

    @Test(dependsOnMethods = {"testAddNewUser"})
    public void testGetUserByLoginAndPassword() {
        user = UserDAOImpl.getUserByLoginAndPassword("MarkStar", "123");
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getLogin(), "MarkStar");
        Assert.assertEquals(user.getPassword(), "123");
    }

    @Test(dependsOnMethods = {"testGetUserByLoginAndPassword"})
    public void testGetUserById() {
        user = UserDAOImpl.getUserById(user.getId());
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getLogin(), "MarkStar");
        Assert.assertEquals(user.getPassword(), "123");
    }

    @Test(dependsOnMethods = {"testGetUserById"})
    public void testGetUserByRole() {
        user = UserDAOImpl.getUserByRole(user.getRole());
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getLogin(), "MarkStar");
        Assert.assertEquals(user.getPassword(), "123");
    }

    @Test(dependsOnMethods = {"testGetUserByRole"})
    public void testUpdateUserInfoByLogin() {
        UserDAOImpl.updateUserInfoByLogin(user.getLogin(), "234", (byte)1, "Alex", "111-11-11", "st.Richi, ew, 4, 4");
    }

    @Test(dependsOnMethods = {"testUpdateUserInfoByLogin"})
    public void testGetUserByLogin() {
        User changingUser = UserDAOImpl.getUserByLogin(user.getLogin());
        Assert.assertNotEquals(changingUser.getPassword(), user.getPassword());
        Assert.assertNotEquals(changingUser.getRole(), user.getRole());
        Assert.assertNotEquals(changingUser.getName(), user.getName());
        Assert.assertNotEquals(changingUser.getPhone(), user.getPhone());
        Assert.assertNotEquals(changingUser.getAddress(), user.getAddress());
    }

    @Test(dependsOnMethods = {"testGetUserByLogin"})
    public void testDeleteUser() {
        UserDAOImpl.deleteUser("MarkStar");
        User dUser = UserDAOImpl.getUserByLogin(user.getLogin());
        Assert.assertNull(dUser);
    }
}
