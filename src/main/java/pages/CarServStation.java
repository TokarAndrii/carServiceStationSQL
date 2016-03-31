package pages;

import util.WebDriverWrapper;

public class CarServStation {

    public MainPage mainPage;

    public CarServStation(WebDriverWrapper webDriverWrapper) {

        mainPage = new MainPage(webDriverWrapper);
    }
}
