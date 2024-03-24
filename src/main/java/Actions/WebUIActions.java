package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUIActions {
    public WebDriver driver;
    public WebUIActions(){
        this.driver= BrowserActions.drivers.get();
    }
    // click on any button
    public void doubleClickButton(Locators locator, String selector)
    {
        By by = elementLocatorInit(locator,selector);
        WebElement button = driver.findElement(by);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(by));

        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
    }
    public String getElementText(Locators locator,String selector)
    {
        By by = elementLocatorInit(locator,selector);
        WebElement button = driver.findElement(by);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        return driver.findElement(by).getText();

    }
    // Create By object for FindElementFunction
    private By elementLocatorInit(Locators locator, String selector){
        switch (locator){
            case XPath:
                return new By.ByXPath(selector);
            case id:
                return new By.ById(selector);
            case CSS:
                return new By.ByCssSelector(selector);
            default: return null;
        }
    }
    public enum Locators {
        id,
        XPath,
        CSS
    }
    public void navigateTo(String url,Locators locator,String selector) {
        driver.get(url);
        By b = elementLocatorInit(locator,selector);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(b));
    }

}
