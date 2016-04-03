package pages;

import util.WebDriverWrapper;

public class CarServStation {

    public ClientLoginPage clientLoginPage;
    public MainPage mainPage;


    public CarServStation(WebDriverWrapper webDriverWrapper) {

        mainPage = new MainPage(webDriverWrapper);
        clientLoginPage = new ClientLoginPage(webDriverWrapper);
    }
}
