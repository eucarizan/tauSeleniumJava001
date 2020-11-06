package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    
    private WebDriver driver;
    protected JavascriptExecutor js = (JavascriptExecutor) driver;
    
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        // driver.findElement(formAuthenticationLink).click();
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }
    private void clickLink(String linkText){
        WebElement ele = driver.findElement(By.linkText(linkText));
        try {
            ele.click();
        } catch (Exception ElementNotInteractableException) {
            scrollDownToElement(ele);
            ele.click();
        }
        
    }

    public void scrollDownToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
