import com.clinic.dao.DiseaseDAO;
import com.clinic.dao.SeanceDAO;
import com.clinic.dao.UserDAO;
import com.clinic.dao.impl.DiseaseDAOImpl;
import com.clinic.dao.impl.SeanceDAOImpl;
import com.clinic.dao.impl.UserDAOImpl;
import com.clinic.domain.Disease;
import com.clinic.domain.Seance;
import com.clinic.domain.User;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

public class SeanceDAOTest {

    /*SeanceDAO seanceDAO = new SeanceDAOImpl();
    DiseaseDAO diseaseDAO = new DiseaseDAOImpl();
    UserDAO userDAO = new UserDAOImpl();

    User user;
    Disease disease;
    Seance seance;

    @BeforeClass
    public void init() {
        userDAO.addNewUser("MarkStar","123", (byte)0, "Mark de Volan", "43-54-23", "st.ra, ew, 4, 4");

        user = userDAO.getUserByLoginAndPassword("MarkStar", "123");
        userDAO.addDisease("na", "des", 1, user);

        disease = (userDAO.getDiseaseListByUser(user)).get(0);
        diseaseDAO.addSeance(new Date(4323), "desc", disease);

        seance = (diseaseDAO.getSeanceListByDisease(disease)).get(0);
    }

    @AfterClass
    public void remove(){
        diseaseDAO.deleteDisease(disease.getId());
        userDAO.deleteUser(user.getLogin());
    }

    @Test
    public void testGetSeanceById() {
        Seance seance = seanceDAO.getSeanceById(this.seance.getId());
        Assert.assertNotNull(seance);
    }

    @Test(dependsOnMethods = "testGetSeanceById")
    public void testUpdateSeance() {
        seanceDAO.updateSeance(new Date(4323), "desc2", seance.getId());
        Seance upSeance = (diseaseDAO.getSeanceListByDisease(disease)).get(0);
        Assert.assertNotEquals(upSeance.getDescription(), seance.getDescription());
    }

    @Test(dependsOnMethods = "testUpdateSeance")
    public void testDeleteSeance() {
        seanceDAO.deleteSeance(this.seance.getId());
        Seance seance = seanceDAO.getSeanceById(this.seance.getId());
        Assert.assertNull(seance);
    }*/

}
