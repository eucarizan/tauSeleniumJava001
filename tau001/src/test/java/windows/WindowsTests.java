package windows;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import base.BaseTests;

public class WindowsTests extends BaseTests {
    
    @Test
    public void testWindowTabs(){
        var buttonPage = homePage.clickDynamicLoading().rightClickOnExample2Link();
        getWindowManager().swtichToNewTab();
        assertTrue(buttonPage.isStartButtonDisplayed(), "Start button is not displayed");
    }
}
