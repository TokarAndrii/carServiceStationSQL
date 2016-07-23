package pages;

import exeption.NoElementFound;
import org.apache.log4j.Logger;
import util.PropertyLoader;
import util.WebDriverWrapper;

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

    public void switchToSignUpPage(){
        try {
            webElementsActions.clickButton("RegisteLink");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
        LOGGER.info("click on RegisteLink");

        try {
            if (webElementsActions.isPresentElement("SignUpPageTitle")){
                LOGGER.info("Switch to SignUp client page was correct!!!");

            }
            else {
                LOGGER.info("switch to SignUp client page was Incorrect!!!");
            }
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }
}
