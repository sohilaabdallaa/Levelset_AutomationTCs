import Actions.BrowserActions;
import POM.DocumentPage;
import POM.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v119.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetDocPriceTest {
    @BeforeMethod
    public void setUp(){
        BrowserActions.init(BrowserActions.BrowserType.chrome);
    }

    @Test
    public void validatePrice()
    {
        HomePage homePage = new HomePage();
        homePage.navigation();
        homePage.clickGetPaidButton();
        DocumentPage docmentpage = new DocumentPage();
        docmentpage.getDocumentPrice("Release a Lein");
        Assert.assertTrue(docmentpage.getDocumentPrice("Release a Lein").contains("$149"));
    }
    @AfterMethod
    public void closeDriver(){
        BrowserActions.quitDriver();
    }
}
