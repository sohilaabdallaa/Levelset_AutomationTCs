package POM;

import Actions.WebUIActions;

public class HomePage {

    String homePageURL = "https://www.levelset.com/";
    String selector = "//a[contains(text(),\"Get paid\")]";
    WebUIActions ui = new WebUIActions();
    public void clickGetPaidButton()
    {
        ui.doubleClickButton(WebUIActions.Locators.XPath,selector);
    }
    public void navigation()
    {
        ui.navigateTo(homePageURL, WebUIActions.Locators.XPath,selector);
    }



}
