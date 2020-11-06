package contextmenu;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import base.BaseTests;

public class ContextMenuTests extends BaseTests{
    
    @Test
    public void testRightClick(){
        var menuPage = homePage.clickContextMenu();
        menuPage.rightClickInBox();

        String message = menuPage.getPopUpText();
        menuPage.acceptPopUp();
        assertEquals(message, "You selected a context menu", "Popup message incorrect");
    }
}
