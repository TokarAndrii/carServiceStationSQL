package pages;

import exeption.NoElementFound;
import org.apache.log4j.Logger;
import util.PropertyLoader;
import util.WebDriverWrapper;

/**
 * Created by tokar on 26.03.16.
 */
public class MainPage extends Page {
    public static final String MAIN_PAGE = PropertyLoader.loadProperty("site.url");
    public static final Logger LOGGER = Logger.getLogger(MainPage.class);


    public MainPage(WebDriverWrapper webDriverWrapper) {
        super(webDriverWrapper, MAIN_PAGE);
    }

    public void switchToLoginPage(){
        try {
            webElementsActions.clickLink("LoginLink");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
        LOGGER.info("click on LOginLink");

        try {
            if(webElementsActions.isPresentElement("EmailField")){
                LOGGER.info("Switch to login page was correct!!!");

            }

            else {
                LOGGER.error("Switch to login page was Incorrect!!!");
            }
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }
}
