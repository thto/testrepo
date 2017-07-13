import com.t_systems_mms.basics.HibernateUtil;
import com.t_systems_mms.basics.LandSpracheBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by admin on 12.07.2017.
 */
public class LandSpracheHibernateTest {

    @Test
    public void laenderTest() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        LandSpracheBean landSpracheBean = new LandSpracheBean();
        landSpracheBean.setId(1);
        landSpracheBean.setLand("Italien");
        landSpracheBean.setSprache("italienisch");
        session.save(landSpracheBean);
        session.getTransaction().commit();
        System.out.println("nach Italien: \n" + session.createCriteria(LandSpracheBean.class).list());

        session.beginTransaction();
        LandSpracheBean landSpracheBean2 = new LandSpracheBean();
        landSpracheBean2.setId(2);
        landSpracheBean2.setLand("Frankreich");
        landSpracheBean2.setSprache("franzoesisch");
        session.save(landSpracheBean2);
        session.getTransaction().commit();
        System.out.println("nach Frankreich: \n" + session.createCriteria(LandSpracheBean.class).list());

        session.beginTransaction();
        session.delete(landSpracheBean);
        session.getTransaction().commit();
        System.out.println("nach delete Italien: \n" + session.createCriteria(LandSpracheBean.class).list());

        session.close();
        /*
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
        */
    }
}
