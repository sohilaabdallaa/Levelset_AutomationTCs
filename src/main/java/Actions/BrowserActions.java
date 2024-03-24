package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions {
    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static void init(BrowserType browser) {
        try {
            switch (browser) {
                case chrome:
                    drivers.set(new ChromeDriver());
                    break;

                case firefox:
                    drivers.set(new FirefoxDriver());
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("Error in creating WebDriver");
        }
    }
    public enum BrowserType{
        chrome,
        firefox
    }
    public static void quitDriver(){
        drivers.get().quit();
    }
}
