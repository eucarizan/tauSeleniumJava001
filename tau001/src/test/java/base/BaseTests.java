package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.HomePage;

public class BaseTests {

    private WebDriver driver;
    // private String url = "https://the-internet.herokuapp.com";
    // Run D:\SampleApps\the-internet-master
    private String lurl = "http://127.0.0.1:9292/";
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tau001/rss/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(lurl);
        // driver.get(url);
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
