package tests.indexPageTests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import tests.Fixture;

public class LoginTests extends Fixture {
    private static final Logger LOGGER = Logger.getLogger(LoginTests.class);


    @Test
    public void test1_positiveLogin(){

        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToLoginPage();
        carServStation.clientLoginPage.fillEmailField("tokar.andrii@gmail.com");
        carServStation.clientLoginPage.fillPasswordfield("tokar1");
        carServStation.clientLoginPage.fillDriverLicenceNumber("123890");
        carServStation.clientLoginPage.pressLoginButton();


    }

    @Test
    public void test2_negativeLogin() {
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToLoginPage();
        carServStation.clientLoginPage.fillEmailField("tokar@gmail.com");
        carServStation.clientLoginPage.fillPasswordfield("tokar2");
        carServStation.clientLoginPage.fillDriverLicenceNumber("123891");
        carServStation.clientLoginPage.pressLoginButton();
        //Assert.assertTrue(ellos.loginPage.isErrorShown("ErrorMess"), "Incorrect login to the system with fake log/pass");
    }

    @Test
    public void test3_blankEmailField() {
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToLoginPage();
        carServStation.clientLoginPage.fillEmailField("");
        carServStation.clientLoginPage.fillPasswordfield("tokar2");
        carServStation.clientLoginPage.fillDriverLicenceNumber("123891");
        carServStation.clientLoginPage.pressLoginButton();
    }

    @Test
    public void test4_blankPasswordField() {
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToLoginPage();
        carServStation.clientLoginPage.fillEmailField("tokar.andrii@gmail.com");
        carServStation.clientLoginPage.fillPasswordfield("");
        carServStation.clientLoginPage.fillDriverLicenceNumber("123890");
        carServStation.clientLoginPage.pressLoginButton();
    }
    @Test
    public void test5_blankDriverLicenceNumberField() {
        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToLoginPage();
        carServStation.clientLoginPage.fillEmailField("tokar.andrii@gmail.com");
        carServStation.clientLoginPage.fillPasswordfield("tokar1");
        carServStation.clientLoginPage.fillDriverLicenceNumber("");
        carServStation.clientLoginPage.pressLoginButton();
    }

    @Test
    public void test6_blankAllFields() {carServStation.mainPage.openPage();
        carServStation.mainPage.switchToLoginPage();
        carServStation.clientLoginPage.fillEmailField("");
        carServStation.clientLoginPage.fillPasswordfield("");
        carServStation.clientLoginPage.fillDriverLicenceNumber("");
        carServStation.clientLoginPage.pressLoginButton();

    }



}
