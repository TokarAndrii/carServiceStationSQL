package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class WebDriverFactory {


    private static final Logger LOGGER = Logger.getLogger(WebDriverFactory.class);
    private static GridInitialization gridInitialization = null;
    public static WebDriver webDriver;


    //browsers constants
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String HTML_UNIT = "htmlunit";


    //platform constans
    public static final String LINUX = "linux";
    public static final String WINDOWS = "windows";


    public static final String browserName = PropertyLoader.loadProperty("browser.name");
    public static final String browserVersion = PropertyLoader.loadProperty("browser.version");
    public static final String platform = PropertyLoader.loadProperty("platform");
    public static final String hub = PropertyLoader.loadProperty("grid2.hub");

    public WebDriverFactory() {
    }

    /**
     * Factory method to return a RemoteWebDriver instance given the url of the
     * Grid hub and a Browser instance.
     * SetUp grid : browserName, browserVersion, platform.
     *
     * @return WebDriver
     * @setBrowserAndVersion
     * @setPlatform
     */

    public static WebDriver getInstance() {
        gridInitialization = new GridInitialization(browserName, browserVersion, platform);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        LOGGER.info(" <--- Start work WebDriver Factory --->");

        setBrowserAndVersion(capabilities);
        LOGGER.info(" <--- Successful set up Browser And Version == " + capabilities + " --->");

        setPlatform(capabilities);
        LOGGER.info(" <--- Successful set up Platform == " + capabilities + " --->");

        webDriver = new RemoteWebDriver(getHubURL(), capabilities);

        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().setSize(new Dimension(1280, 720));
        webDriver.manage().window().maximize();
        LOGGER.info("Screen resolution - " + webDriver.manage().window().getSize());


        return webDriver;
    }

    private static void setPlatform(DesiredCapabilities capabilities) {
        if (LINUX.equalsIgnoreCase(platform)){
            capabilities.setPlatform(Platform.LINUX);
        }
        else if(WINDOWS.equalsIgnoreCase(platform)){
            capabilities.setPlatform(Platform.WINDOWS);
        }
        else {
            capabilities.setPlatform(Platform.ANY);
        }
    }

    private static URL getHubURL() {
        URL hubUrl = null;

        try {
            hubUrl = new URL(hub);
            LOGGER.info("<--- HUBURL ==> " + hub + " --->");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (hubUrl == null) {
            LOGGER.error("HUBURL == null!\n");
            Assert.fail("HUBURL == null!");
            return null;
        } else {
            return hubUrl;
        }
    }

    private static void setBrowserAndVersion(DesiredCapabilities capabilities) {
        if (FIREFOX.equals(browserName)) {
            capabilities.setBrowserName(browserName);
            capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        } else if (CHROME.equals(browserName)) {
            capabilities.setBrowserName(browserName);
            capabilities = new DesiredCapabilities().chrome();
            //System.setProperty("webdriver.chrome.driver", "c:\\Tool\\chromedriver.exe");
            capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
            capabilities.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
        } else if (INTERNET_EXPLORER.equals(browserName)) {
            capabilities.setBrowserName(browserName);
            capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("browserstack.ie.enablePopups", false);

        }

        else if(HTML_UNIT.equals(browserName)){
            capabilities.setBrowserName(browserName);
            capabilities = DesiredCapabilities.htmlUnit();
        }

        if(browserVersion!=null){
            capabilities.setVersion(browserVersion);
            capabilities.setCapability("browser version ",browserVersion);
        }
    }

    public static WebDriverWrapper initDriver(String driverName){
        WebDriverWrapper webDriverWrapper = null;
        if(driverName.equals(FIREFOX)){
            webDriverWrapper = new WebDriverWrapper(new FirefoxDriver());
        }

        else if(webDriverWrapper.equals(CHROME)){
            ChromeOptions chromeOptions = new ChromeOptions();
            webDriverWrapper = new WebDriverWrapper(new ChromeDriver(chromeOptions));
        }
        else {
            Assert.fail("invalid driver name");
        }

        webDriverWrapper.manage().deleteAllCookies();
        webDriverWrapper.manage().window().maximize();
        return webDriverWrapper;
    }
}
