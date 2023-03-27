package ModulePages;

import org.com.CommonUtils;
import org.com.UserInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.sun.activation.registries.LogSupport.log;


public class HomePage extends CommonUtils {

    By CHAT_ICON = By.cssSelector(".avm-bot-icon.bot-avatar-outline.animated");
    By WELCOME_TO_PIZZA_WINDOW = By.cssSelector(".avm-bot-welcome-notification.animated.fadeInUp");
    By WELCOME_NOTIFICATION_MESSAGE = By.cssSelector(".avm-welcome-notification-message");


    public WebDriver navigateToChatWindow(UserInformation userInformation) {
        launchBrowser(userInformation);
        driver().navigate().to(userInformation.getUrl());
        waitForElementVisibility(WELCOME_TO_PIZZA_WINDOW, 5);
        System.out.println(getText(WELCOME_NOTIFICATION_MESSAGE));
        if(getText(WELCOME_NOTIFICATION_MESSAGE).equals("Welcome to Pizza Shoppe"))
            System.out.println("Home page displayed successfully");
        return driver();
    }

    public WebDriver clickChatIcon(){
        waitForElementVisibility(CHAT_ICON, 10);
        clickElement(CHAT_ICON);
        return driver();
    }
}
