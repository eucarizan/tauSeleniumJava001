package wait;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import base.BaseTests;

public class WaitTests extends BaseTests{
    
    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text incorrect");
    }
}