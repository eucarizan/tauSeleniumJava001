package javascript;

import org.testng.annotations.Test;
import base.BaseTests;

public class JavaScriptTests extends BaseTests{
    
    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFiftParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
