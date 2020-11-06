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
        // forceClick("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

	public ContextMenuPage clickContextMenu() {
        clickLink("Context Menu");
		return new ContextMenuPage(driver);
    }
    
    public WysiwygEditorPage clickWysiwygEditor(){
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public FramesPage clickFramesPage(){
        clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScroll(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    private void clickLink(String linkText){
        // driver.findElement(By.linkText(linkText)).click();
        WebElement ele = driver.findElement(By.linkText(linkText));
        try {
            ele.click();
        } catch (Exception ElementNotInteractableException) {
            // old style
            // JavascriptExecutor executor = (JavascriptExecutor)driver;
            // executor.executeScript("arguments[0].click();", ele);

            // new style
            ((JavascriptExecutor)driver).executeScript("arguments[0].click()", ele);
        }
        
    }
    /**
     * FORCE CLICK HAHA
     * @param linkText
     */
    // private void forceClick(String linkText){
    //     WebElement ele = driver.findElement(By.linkText(linkText));
    //     JavascriptExecutor executor = (JavascriptExecutor)driver;
    //     executor.executeScript("arguments[0].click();", ele);
    // }

    public void scrollDownToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
