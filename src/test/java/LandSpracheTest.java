import com.t_systems_mms.basics.LandSprache;
import com.t_systems_mms.basics.LandSpracheBean;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by admin on 12.07.2017.
 */
public class LandSpracheTest {
    // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JavaTest");

    @Test
    public void laenderTest() {
        LandSprache landSprache = new LandSprache();

        landSprache.create(5, "Spanien", "spanisch");
        landSprache.create(6, "Schweiz", "deutsch");

        landSprache.upate(4, "Schottland", "schottisch");

        landSprache.delete(1);

        // Print all
        List<LandSpracheBean> allBeans = landSprache.readAll();
        if (allBeans != null) {
            for (LandSpracheBean landSpracheBean : allBeans) {
                if (landSpracheBean.getLand().equals("Spanien")) {
                    Assert.assertEquals(landSpracheBean.getSprache(), "spanisch");
                }
                if (landSpracheBean.getId() == 6) {
                    Assert.assertEquals(landSpracheBean.getLand(), "Schweiz");
                    Assert.assertEquals(landSpracheBean.getSprache(), "deutsch");
                }

                System.out.println(landSpracheBean.toString());
            }
        }

        ENTITY_MANAGER_FACTORY.close();
    }
}
