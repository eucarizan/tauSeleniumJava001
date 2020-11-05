package base;

import java.util.stream.BaseStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.HomePage;

public class BaseTests {
    
    private WebDriver driver;
    private String url = "https://the-internet.herokuapp.com";
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "tau001/rss/chromedriver.exe"); 
        driver = new ChromeDriver();
        driver.get(url);
        
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
