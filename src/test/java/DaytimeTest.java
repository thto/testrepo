import com.t_systems_mms.basics.Daytime;
import com.t_systems_mms.basics.Daytime2;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * Created by admin on 11.07.2017.
 */
public class DaytimeTest {
    @Test
    public void daytimeTest() {
        String expectedRecipient = "";
        Daytime2 daytime = new Daytime2();
        daytime.createMessage();

        Calendar currentDate = Calendar.getInstance();
        int hour = currentDate.get(Calendar.HOUR_OF_DAY);

        if (hour <= 10 && hour >= 0) {
            expectedRecipient="Morning";
        }
        else if (hour > 10 && hour < 18) {
            expectedRecipient="Afternoon";
        }
        else if (hour >= 18 && hour <= 23) {
            expectedRecipient="Evening";
        }

        Assert.assertEquals(daytime.logRecipient, expectedRecipient);
    }

    @Test
    public void daytimeNegativeTest() {
        String expectedGreeting = "Hello ";
        Daytime2 daytime = new Daytime2();
        String actualGreeting = daytime.getMessage();
        Assert.assertNotEquals(actualGreeting, expectedGreeting);
    }


}
