package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.CarServStation;
import util.PropertyLoader;
import util.WebDriverFactory;
import util.WebDriverWrapper;

import java.util.concurrent.TimeUnit;

public class Fixture {

    public static WebDriverWrapper webDriverWrapper;
    public static CarServStation carServStation;

    private static final Logger LOGGER = Logger.getLogger(Fixture.class);

    //private static final String implWait = PropertyLoader.loadProperty("wait.timeout");

    @BeforeSuite(alwaysRun = true)
    @Parameters({ "browser" })
    public void setEnv(String browser){
        webDriverWrapper = WebDriverFactory.initDriver(browser);
        webDriverWrapper.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //webDriverWrapper.manage().timeouts().implicitlyWait(Long.parseLong(implWait), TimeUnit.SECONDS);

        try {
            carServStation = new CarServStation(webDriverWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("Start Test Suite executions");
    }

    @AfterSuite
    public void resetEnv(){
        webDriverWrapper.quit();
        LOGGER.info("Test Suite executions completed");
    }

}
