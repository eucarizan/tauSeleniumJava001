package alerts;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import base.BaseTests;

public class FileUploadTests extends BaseTests{
    
    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFiles("C:\\Engg\\tauSeleniumJava001\\tau001\\rss");
        assertEquals(uploadPage.getUploadedFiles(), "chromedriver.exe", "Uploaded files incorrect");
    }
}
