package alerts;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import base.BaseTests;

public class AlertTests extends BaseTests{
    
    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.getResult(), "You successfuly clicked an alert", "Results text incorrect");
    }
}
