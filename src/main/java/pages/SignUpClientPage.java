package pages;


import exeption.NoElementFound;
import util.WebDriverWrapper;

public class SignUpClientPage extends Page{

    public SignUpClientPage(WebDriverWrapper webDriverWrapper) {
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

    public void fillDriverLicenceNumber(String value) {
        try {
            webElementsActions.insertValueAndClear("DriverLicenceField",value);
            LOGGER.info("Inserted driver licence number to DriverLicenceNumberField: "+value );
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void fillFirstNameField(String value) {
        try {
            webElementsActions.insertValueAndClear("FirstNameField",value);
            LOGGER.info("Inserted First Name to FirstNameField: "+value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void fillSecondNameField(String value) {
        try {
            webElementsActions.insertValueAndClear("SecondNameField",value);
            LOGGER.info("Inserted Second Name to SecondNameFoeld: "+value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void fillPhoneNumberField(String value) {
        try {
            webElementsActions.insertValueAndClear("PhoneNumberField",value);
            LOGGER.info("Inserted Phone Number to PhoneNumberField: "+value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

    }

    public void fillDLNumberField(String value) {
        try {
            webElementsActions.insertValueAndClear("DLNumberField",value);
            LOGGER.info("Inserted Driver Licence Number to DLNumberField: "+value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void pressSubmitButton() {
        try {
            webElementsActions.clickButton("SubmitSignUpButton");
            LOGGER.info("submitt button on SignUp page pressed!!!!");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }
}
