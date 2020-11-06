package base;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import utlis.WindowManager;

public class BaseTests {

    private WebDriver driver;
    private String url = "https://the-internet.herokuapp.com";
    // Run D:\SampleApps\the-internet-master
    // private String lurl = "http://127.0.0.1:9292/";
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tau001/rss/chromedriver.exe");
        driver = new ChromeDriver();
        // driver.get(lurl);
        driver.get(url);
        /*
         * try { Thread.sleep(2000); } catch (InterruptedException e) {
         * e.printStackTrace(); }
         */

        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void takeScrenshot() {
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File("tau001\\rss\\screenshots\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
