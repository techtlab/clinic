import com.clinic.dao.impl.UserDAOImpl;
import com.clinic.model.User;
import org.junit.gen5.api.Assertions;
import org.junit.gen5.api.Test;

public class UserDAOTest {



    @Test
    public void testGetUserById() {
        User user = UserDAOImpl.getUser(1);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getLogin(), "Mark");
        Assertions.assertEquals(user.getPassword(), "123");
    }

    @Test
    public void testGetUserByLoginPassword() {
        User user = UserDAOImpl.getUserByLoginAndPassword("Mark", "123");
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getLogin(), "Mark");
        Assertions.assertEquals(user.getPassword(), "123");
    }

}
