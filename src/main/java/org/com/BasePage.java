package org.com;

import ModulePages.HomePage;
import ModulePages.McPizza;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
   public HomePage homePage;
   public UserInformation userInformation;

   public McPizza mcPizza;
    public Configuration configuration;
   public WebDriverWait wait;

    public String CUSTOMER_EMAIL_VALUE = "mail-" + RandomStringUtils.randomAlphabetic(7).concat(RandomStringUtils.randomNumeric(3)).toLowerCase() + "@gmail.com";


    public WebDriver driver() {
        return driver.get();
    }
}
