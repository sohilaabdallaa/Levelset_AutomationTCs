package POM;

import Actions.WebUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DocumentPage {
    String DocumentURL = "https://app.levelset.com/wizard/SelectDocument/?_ga=2.250535246.995898022.1710677616-1783884427.1710677615";
    String docName = "Release a Lien";
    String docNameSelector = String.format("//div[contains(text(),'%s')]",docName);
    String priceSelector = String.format("//div[contains(text(),'%s')]/..//div//span[@class=\"price-amount\"]",docName);

    WebUIActions ui = new WebUIActions();
    public void navigatetion()
    {
        ui.navigateTo(DocumentURL, WebUIActions.Locators.XPath,docNameSelector);
    }
    public String getDocumentPrice(String docName) {
        return ui.getElementText(WebUIActions.Locators.XPath,priceSelector);
    }
}
