package org.com;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CommonUtils extends BasePage{

    public WebDriver launchBrowser(UserInformation userInformation){
        System.out.println("Browser is: "+ userInformation.getBrowser());
        if(userInformation.getBrowser().equals("chrome"))
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver.set(new ChromeDriver(options));
        driver().manage().window().maximize();
        //WebDriver driver = new ChromeDriver();
        return driver();
    }

    public WebElement findElement(By element){
         return driver().findElement(element);
    }

    public WebDriver clickElement(By element) {
        driver().findElement(element).click();
        return driver();
    }

    public WebDriver sendKeys(By element, String text) {
        driver().findElement(element).sendKeys(text);
        return driver();
    }

    public WebDriver waitForElementVisibility(By elementBy, int sec) {
        wait = new WebDriverWait(driver(), sec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        return driver();
    }

    public String getText(By elementBy){
        waitForElementVisibility(elementBy, 5);
        String str = driver().findElement(elementBy).getText();
        return str;
    }

    public WebDriver switchToFrame(String frame) {
        driver().switchTo().frame(frame);
        return driver();
    }

    public boolean isDispalyed(By elementBy) {
        boolean result = driver().findElement(elementBy).isDisplayed();
        return result;
    }

    public InputStream getScreenshot() throws IOException {
        BufferedImage Img = Shutterbug.shootPage(driver()).getImage();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(Img, "png", os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        return is;
    }

}
