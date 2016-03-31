package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTests extends Fixture {
    private static final Logger LOGGER = Logger.getLogger(LoginTests.class);


    @Test
    public void test1_positiveLogin(){

        carServStation.mainPage.openPage();
        carServStation.mainPage.switchToLoginPage();

    }

}
