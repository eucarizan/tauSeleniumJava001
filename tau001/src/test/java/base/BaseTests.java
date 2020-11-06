package base;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

// import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import utlis.EventReporter;
import utlis.WindowManager;
import utlis.CookieManager;

public class BaseTests {

    /**
     * rename WebDriver to use WebDriver EventListeners interface
     */
    // private WebDriver driver;
    private EventFiringWebDriver driver;
    private String url = "https://the-internet.herokuapp.com";
    // Run D:\SampleApps\the-internet-master
    // private String lurl = "http://127.0.0.1:9292/";
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tau001/rss/chromedriver.exe");
        // driver = new ChromeDriver();
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        goHome();
        // setCookie();
        // driver.get(lurl);
        // driver.get(url);
        /*
         * try { Thread.sleep(2000); } catch (InterruptedException e) {
         * e.printStackTrace(); }
         */

        // homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get(url);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("tau001\\rss\\screenshots\\" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        // options.setHeadless(true);
        return options;
    }

    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }
   /* 
    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
            .domain("the-internet.herokuapp.com")
            .build();

            driver.manage().addCookie(cookie);
    }
    */
}
