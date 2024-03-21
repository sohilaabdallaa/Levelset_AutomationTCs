import POM.DocumentPage;
import POM.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class GetDocPriceTest {
    static WebDriver driver;

    @Test
    public void validatePrice()
    {
        driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        DocumentPage docmentpage = new DocumentPage(driver);
        docmentpage = homePage.clickGetPaidButton();

        docmentpage.getDocumentPrice("Release a Lein");

        Assert.assertTrue(docmentpage.getDocumentPrice("Release a Lein").contains("$149"));

    }
    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
