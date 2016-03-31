package util;

import exeption.NoElementFound;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebElementsActions {

    public WebDriver webDriver;
    public static WebDriverWait webDriverWait;

    public static final Logger LOGGER = Logger.getLogger(WebElementsActions.class);

    public WebElementsActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 20);
    }

    public WebElement getElement(String locator) {

        try {
            webDriver.findElements(ConfigData.ui(locator));
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

        return null;
    }

    public List<WebElement> getElements(String elementsLocator) {
        try {
            return webDriver.findElements(ConfigData.ui(elementsLocator));
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            return null;
        }
    }

    //Click batton
    public void clickButton(String buttonLocator) throws NoElementFound {

        webDriver.findElement(ConfigData.ui(buttonLocator)).click();
        LOGGER.info("----Click on button---" + buttonLocator);

    }


    //click link
    public void clickLink(String clickLocator) throws NoElementFound {
        webDriver.findElement(ConfigData.ui(clickLocator)).click();
        LOGGER.info("----Click on link---" + clickLocator);

    }

    //Insert value in text input html field and clean it

    public void insertValueAndClear(String inputLocator, String inputData) throws NoElementFound {
        webDriver.findElement(ConfigData.ui(inputLocator)).clear();
        webDriver.findElement(ConfigData.ui(inputLocator)).sendKeys(inputData);
        LOGGER.info("----Input and clear in----" + inputLocator + " --data: " + inputData);

    }

    //InsertValue in text input html field
    public void insertValue(String inputLocator, String inputData) throws NoElementFound {
        webDriver.findElement(ConfigData.ui(inputLocator)).sendKeys(inputData);
        LOGGER.info("----Input and clear in----" + inputLocator + " --data: " + inputData);
    }


    // * Insert value into text input HTML field and Click ENTER for Field which used "Value" in the xpath expression

    public void insertValueAndClickEnter(String inputLocator, String inputData) throws NoElementFound {
        webDriver.findElement(ConfigData.ui(inputLocator)).clear();
        webDriver.findElement(ConfigData.ui(inputLocator)).sendKeys(inputData);
        webDriver.findElement(ConfigData.ui(inputLocator)).sendKeys(Keys.ENTER);
    }

    //to check that element is present on page.

    public boolean isPresentElement(String elementLocator) throws NoElementFound {
        List<WebElement> webElementList = webDriver.findElements(ConfigData.ui(elementLocator));
        if (webElementList.size() == 0) {
            LOGGER.info("---Element finding failed " + elementLocator + " !!");
            return false;
        } else {
            LOGGER.info("---Element is presernt " + elementLocator + " !!!");
            return true;
        }
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
     * Advantages of this method over isElementPresent(By elementLocator); is that it expects the appearance of an element.
     */
    public boolean waitForElementPresent(String elementLocator) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ConfigData.ui(elementLocator)));
            LOGGER.info("WaitForElement _" + elementLocator + "_ Present");
        } catch (NoElementFound noElementFound) {
            LOGGER.error("Waiting for the appearance of the element _" + elementLocator + "_ was not successful " +
                    "WaitForElement _" + elementLocator + "_ Present");
            noElementFound.printStackTrace();
            return false;
        }
        return true;
    }


    //method for refresh page
    public void refreshPage() {
        webDriver.navigate().refresh();
    }

    //Wait the element on page specified time
    public void waitForElementNotVisible(String elementLocator, int timeInS) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeInS);
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(ConfigData.ui(elementLocator)));
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void pressSpace() {
        try {
            webDriver.findElement(ConfigData.ui("Panties")).sendKeys(Keys.SPACE);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

    }

    // An expectation for checking an element is visible and enabled such that you
    // can click it.
    public boolean waitForElementToBeClickable(String elementLocator) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(ConfigData.ui(elementLocator)));
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            return false;
        }
        return true;
    }

    //This method is used to wait for getting response from all Ajax requests
    public boolean waitForAjaxResponse(int timeoutSeconds) throws InterruptedException {
        if (webDriver instanceof JavascriptExecutor) {
            JavascriptExecutor jsDriver = (JavascriptExecutor) webDriver;

            for (int i = 0; i < timeoutSeconds; i++) {
                Long numberOfConnections = (Long) jsDriver.executeScript("return jQuery.active");
                if (numberOfConnections instanceof Long) {
                    LOGGER.debug("Number of active jQuery Ajax calls is <" + numberOfConnections + ">");

                    if (numberOfConnections == 0)
                        break;
                }
                // stay(1);
            }
            return false;
        } else {
            LOGGER.info("WebElementsActions Driver: <" + webDriver + "> cann't execute JavaScript");
            return false;
        }
    }

}
