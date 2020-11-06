package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.Keys;
// import org.openqa.selenium.interactions.Actions;

public class KeyPressesPage {

    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterText(String text){
        driver.findElement(inputField).sendKeys(text);
    }

    public void enterPi(){
        //Actions action = new Actions(driver);
        //action.keyDown(Keys.ALT, Keys.NUMPAD2)
        enterText("\u03C0" + "=3.14");
        //enterText(Keys.ALT, "227");
        // enterText(Keys.chord(Keys.ALT, "2") + "=3.14");
    }

    public String getResult(){
        return driver.findElement(resultText).getText();
    }
}
