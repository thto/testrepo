import com.t_systems_mms.basics.Rechner;
import com.t_systems_mms.basics.Daytime2;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by admin on 11.07.2017.
 */
public class newFeatureTest {

    @Test
    public void newFeatureTest() {
        Integer one = 1;
        Integer two = 2;
        Rechner rechner = new Rechner();
        Integer actualResult = rechner.add(one, two);
        Integer expectedResult = one + two;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
