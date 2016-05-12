package pages;

import exeption.NoElementFound;
import org.apache.log4j.Logger;
import util.PropertyLoader;
import util.WebDriverWrapper;


public class ClientLoginPage extends Page {

    public static final String CLIENT_LOGIN_PAGE = PropertyLoader.loadProperty("site.url");
    public static final Logger LOGGER = Logger.getLogger(MainPage.class);


    public ClientLoginPage(WebDriverWrapper webDriverWrapper) {
        super(webDriverWrapper);
    }


    public void fillEmailField(String value) {
        try {
            webElementsActions.insertValueAndClear("EmailField", value);
            LOGGER.info("Input to email-field: " + value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void fillPasswordfield(String value) {
        try {
            webElementsActions.insertValueAndClear("PasswordField",value);
            LOGGER.info("input to PassField - " + value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void pressLoginButton() {
        try {
            webElementsActions.clickButton("LoginClientEnterButton");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void switchToMainPage() {
        try {
            webElementsActions.clickLink("LogoOnLoginPage");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

        try {
            if(webElementsActions.isPresentElement("MainPaigeSlider")){}
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void fillDriverLicenceNumber(String value) {
        try {
            webElementsActions.insertValueAndClear("DriverLicenceField",value);
            LOGGER.info("Inserted driver licence number to DriverLicenceNumberField: "+value );
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }
}
