import ModulePages.HomePage;
import ModulePages.McPizza;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.com.CommonUtils;
import org.com.UserInformation;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.IOException;

public class testPizzaShoppe extends CommonUtils {

    @BeforeTest
    public void objectCreation() throws IOException {
        userInformation = new UserInformation();
        homePage = new HomePage();
        mcPizza = new McPizza();
    }
    @Test()
    @Description("Testcase to place an order for Veg Pizza and positive feedback")
    public void testVegPizza()  {
        homePage.navigateToChatWindow(userInformation);
        homePage.clickChatIcon();
        mcPizza.clickGetStarted();
        mcPizza.fillCustomerDetails();
        mcPizza.sendQuery(userInformation.getChatQuery());
        mcPizza.selectPizzaType(userInformation.getPizzaType());
        mcPizza.selectTopping(userInformation.getTopping());
        mcPizza.selectCrust(userInformation.getCrust());
        mcPizza.selectSize(userInformation.getSize());
        mcPizza.confirmTheOrder();
        mcPizza.feedBack(userInformation.getFeedback(), userInformation.getRating());
        Assert.assertTrue(mcPizza.verifyThankyouMessage(), "Order failed");
    }

    @Test()
    @Description("Testcase to place an order for Non-Veg Pizza and negative feedback")
    public void testNonVegPizza()  {
        userInformation.setPizzaType("non-veg");
        userInformation.setTopping("bacon");
        userInformation.setFeedback("negative");
        homePage.navigateToChatWindow(userInformation);
        homePage.clickChatIcon();
        mcPizza.clickGetStarted();
        mcPizza.fillCustomerDetails();
        mcPizza.sendQuery(userInformation.getChatQuery());
        mcPizza.selectPizzaType(userInformation.getPizzaType());
        mcPizza.selectTopping(userInformation.getTopping());
        mcPizza.selectCrust(userInformation.getCrust());
        mcPizza.selectSize(userInformation.getSize());
        mcPizza.confirmTheOrder();
        mcPizza.feedBack(userInformation.getFeedback(), userInformation.getImprovement());
        Assert.assertTrue(mcPizza.verifyThankyouMessage(), "Order failed");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment("Failed ScreenShot for:" + result.getName() + "is: ", getScreenshot());
            driver().quit();
            driver.remove();
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            driver().quit();
            driver.remove();
        }
    }
}
