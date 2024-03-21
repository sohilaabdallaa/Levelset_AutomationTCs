package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    String HomePageURL = "https://www.levelset.com/";
    WebDriver driver;
    By getPaidLocator = new By.ByXPath("//a[contains(text(),\"Get paid \")]");
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void navigate()
    {

        driver.get(HomePageURL);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(getPaidLocator));
    }
    public DocumentPage clickGetPaidButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPaidLocator));

        WebElement getPaidButton = driver.findElement(getPaidLocator);

        Actions actions = new Actions(driver);
        actions.doubleClick(getPaidButton).perform();

        return new DocumentPage(driver);
    }

}
