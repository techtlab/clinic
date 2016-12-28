import com.clinic.dao.impl.UserDAOImpl;
import com.clinic.model.User;
import org.junit.Assert;
import org.junit.Test;

public class UserDAOTest {

    @Test
    public void testGetUserById() {
        User user = UserDAOImpl.getUser(1);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getLogin(), "Mark");
        Assert.assertEquals(user.getPassword(), "123");
    }

    @Test
    public void testGetUserByLoginPassword() {
        User user = UserDAOImpl.getUserByLoginAndPassword("Mark", "123");
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getLogin(), "Mark");
        Assert.assertEquals(user.getPassword(), "123");
    }

}
