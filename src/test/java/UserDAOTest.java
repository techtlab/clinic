import com.clinic.dao.UserDAO;
import com.clinic.model.User;
import org.junit.gen5.api.Assertions;
import org.junit.gen5.api.Test;

public class UserDAOTest {

    @Test
    public void testGetUserById() {
        User user = UserDAO.getUserById(1);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getLogin(), "Mark");
        Assertions.assertEquals(user.getPassword(), "123");
    }

}
