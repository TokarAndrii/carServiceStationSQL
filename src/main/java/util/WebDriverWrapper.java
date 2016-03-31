package util;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class WebDriverWrapper implements WebDriver, TakesScreenshot {
    public static WebDriver webDriver;
    private static final int TIME_TO_WAIT = Integer.parseInt(PropertyLoader.loadProperty("wait.timeout"));

    public WebDriverWrapper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getDriver() {
        return this.webDriver;
    }

    @Override

    public void get(String s) {
        webDriver.get(s);
    }

    @Override
    public String getCurrentUrl() {


        return webDriver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, TIME_TO_WAIT);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));

        return webDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, TIME_TO_WAIT);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));

        return webDriver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        webDriver.close();
    }

    @Override
    public void quit() {
        webDriver.quit();

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return webDriver.navigate();
    }

    @Override
    public Options manage() {
        return webDriver.manage();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {

        if(webDriver instanceof FirefoxDriver){
            return ((FirefoxDriver) webDriver).getScreenshotAs(target);
        }

        else if (webDriver instanceof ChromeDriver){
            return ((ChromeDriver) webDriver).getScreenshotAs(target);
        }

        else if (webDriver instanceof InternetExplorerDriver){
            return ((InternetExplorerDriver) webDriver).getScreenshotAs(target);
        }

        return null;
    }
}
