package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DocumentPage {
    String DocumentURL = "https://app.levelset.com/wizard/SelectDocument/?_ga=2.250535246.995898022.1710677616-1783884427.1710677615";
    WebDriver driver;
    String docName = "Release a Lien";
    By DocumentNameLocator = new By.ByXPath(String.format("//div[contains(text(),'%s')]",docName));
    By DocumentPriceLocator = new By.ByXPath(String.format("//div[contains(text(),'%s')]/..//div//span[@class=\"price-amount\"]",docName));
    public DocumentPage(WebDriver driver)
    {

        this.driver = driver;
    }
    public void navigate()
    {
        driver.get(DocumentURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(DocumentNameLocator));
    }
    public String getDocumentPrice(String docName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(DocumentNameLocator));
        return driver.findElement(DocumentPriceLocator).getText();

    }
}
