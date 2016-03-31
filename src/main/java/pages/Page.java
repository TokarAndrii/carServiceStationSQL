package pages;

import exeption.NoElementFound;
import org.apache.log4j.Logger;
import org.testng.Assert;
import util.WebDriverWrapper;
import util.WebElementsActions;

public class Page {

    public static final Logger LOGGER = Logger.getLogger(Page.class);
    private String paGe;
    public WebDriverWrapper wdWrapper;
    public WebElementsActions webElementsActions;

    public Page(WebDriverWrapper wdw, String page) {
        wdWrapper = wdw;
        paGe = page;
        webElementsActions = new WebElementsActions(wdw);

    }

    public Page(WebDriverWrapper webDriverWrapper) {
        wdWrapper = webDriverWrapper;
        webElementsActions = new WebElementsActions(webDriverWrapper);
    }

    public boolean openPage() {


        try {
            LOGGER.info("Start open page");
            wdWrapper.get(paGe);
            wdWrapper.getCurrentUrl();
        } catch (Exception e) {
            LOGGER.error("Error in open page!!!\n");
            return false;
        }
        LOGGER.info("Successful open page!!!");
        return true;
    }

    public boolean isOpenPage(String checkLocator) {
        try {
            if (webElementsActions.isPresentElement(checkLocator)) {
                LOGGER.info("Page: Check is page open. " + checkLocator + " is present!");
            } else {
                LOGGER.error("Page: Error with check page!\n");
                Assert.fail("Incorrect swatch");
            }
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
        return false;
    }

    public String getTitle(){
     return    wdWrapper.getTitle();
    }

    public String getCurrentPageURL(){
        return wdWrapper.getCurrentUrl();
    }
    public void deleteAllcookies(){
        wdWrapper.manage().deleteAllCookies();
    }
}
