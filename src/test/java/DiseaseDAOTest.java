import com.clinic.dao.DiseaseDAO;
import com.clinic.dao.impl.DiseaseDAOImpl;
import com.clinic.domain.Disease;
import com.clinic.domain.Seance;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;

public class DiseaseDAOTest {

    /*DiseaseDAO diseaseDAO = new DiseaseDAOImpl();

    @Test
    public void testGetDiseaseById(){
        Disease disease = diseaseDAO.getDiseaseById(1);
        Assert.assertNotNull(disease);
        Assert.assertEquals(disease.getName(), "new");
        Assert.assertEquals(disease.getDescription(), "description");
        Assert.assertEquals(disease.getCured(), 1);

        Assert.assertNotEquals(disease.getSeances().size(), 0);
        System.out.println("size " + disease.getSeances().size());
        List<Seance> seances = diseaseDAO.getSeanceListByDisease(disease);
        System.out.println("size " + seances.size());
    }

    @Test
    public void testUpdateDisease(){
        diseaseDAO.updateDisease("new", "descr", 0, 1);

        Disease disease = diseaseDAO.getDiseaseById(1);
        Assert.assertNotNull(disease);
        Assert.assertEquals(disease.getName(), "new");
        Assert.assertEquals(disease.getDescription(), "descr");
        Assert.assertEquals(disease.getCured(), 0);
    }

    @Test
    public void testDeleteDisease(){
        diseaseDAO.deleteDisease(6);

        Disease disease = diseaseDAO.getDiseaseById(6);
        Assert.assertNull(disease);
    }

    @Test
    public void testAddSeance() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.JANUARY, 1, 10, 12);

        Disease disease = diseaseDAO.getDiseaseById(1);

        diseaseDAO.addSeance(calendar.getTime(), "description", disease);
    }

    @Test
    public void testGetSeanceListByDisease() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.JANUARY, 1, 11, 12, 1);

        SeanceDAOImpl.addSeance(calendar.getTime(), "description", 1);
        SeanceDAOImpl.addSeance(calendar.getTime(), "description", 1);

        List<Seance> seanceList = SeanceDAOImpl.getSeanceListByDiseaseId(1);
        Assert.assertNotNull(seanceList);
        Assert.assertNotEquals(seanceList.size(), 0);
    }*/
}
