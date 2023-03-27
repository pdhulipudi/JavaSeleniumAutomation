package ModulePages;

import io.qameta.allure.Step;
import org.apache.commons.lang.RandomStringUtils;
import org.com.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class McPizza extends CommonUtils {

    By GET_STARTED_BUTTON = By.cssSelector("#avaamo__popup .get-started-link");
    By CUSTOMER_FIRST_NAME = By.cssSelector("#first_name");
    By CUSTOMER_LAST_NAME = By.cssSelector("#last_name");
    By CUSTOMER_EMAIL = By.cssSelector("#email");

    By SUBMIT_BUTTON = By.cssSelector(".send.btn");
    String FRAME_NAME = "avaamoIframe";

    By DEFAULT_CARD_IMAGE = By.cssSelector(".default_card_image");

    By QUERY_TEXT_BOX = By.cssSelector(".combobox-wrapper #queryTextbox");

    By SEND_QUERY_BUTTON = By.cssSelector("[data-ele-name=\"send\"]");

    By VEG_OPTION = By.cssSelector("[aria-label=\"veg\"]");

    By SELECT_TOPPING_TEXT = By.cssSelector("[data-ele-name=\"Select Your topping\"]");
    By TOMATO_TOPPING = By.xpath("//input[@value='tomato_id']");

    By CHEESE_TOPPING = By.xpath("//input[@value='cheese_id']");

    By SUBMIT_TOPPING = By.cssSelector(".btn.default_card_submit");

    By THICK_CRUST = By.cssSelector("[href*='Thick']");
    By THIN_CRUST = By.cssSelector("[href*='Thin']");

    By PIZZA_SIZE_TEXT = By.xpath("//div[text()='Pizza Size']");

    By ORDER_CONFIRM_TEXT = By.xpath("//p[contains(text(), 'Would you like to confirm the order')]");

    By CONFIRM_ORDER_BUTTON = By.cssSelector(".bottom.conversation-form a[aria-label='Yes']");

    By ORDER_PLACED_TEXT = By.xpath("//p[contains(text(), 'CONGRATS ! ORDER PLACED .')]");

    By FEEDBACK_THUMBS_UP = By.cssSelector(".thumbs-up");

    By FEEDBACK_THUMBS_DOWN = By.cssSelector(".thumbs-down");

    By FEEDBACK_CONTAINER = By.cssSelector("#custom_feedback_container .modal-content");

    By SELECT_RATING = By.cssSelector("input[placeholder='Select']");

    By SUBMIT_FEEDBACK_BUTTON = By.cssSelector(".modal-body.feedback-modal-body [aria-label='Submit']");

    By FEEDBACK_TO_IMPROVE = By.cssSelector("[aria-label=\"Feedback to improve\"]");

    By THANK_YOU = By.cssSelector(".thankyou");
    public WebDriver clickGetStarted(){
        waitForElementVisibility(GET_STARTED_BUTTON,5);
        clickElement(GET_STARTED_BUTTON);
        return driver();
    }
    @Step("Fill Customer Details to place order")
    public WebDriver fillCustomerDetails() {
        switchToFrame(FRAME_NAME);
        waitForElementVisibility(CUSTOMER_FIRST_NAME,8);
        sendKeys(CUSTOMER_FIRST_NAME, RandomStringUtils.randomAlphabetic(8));
        sendKeys(CUSTOMER_LAST_NAME, RandomStringUtils.randomAlphabetic(6));
        sendKeys(CUSTOMER_EMAIL, CUSTOMER_EMAIL_VALUE);
        clickElement(SUBMIT_BUTTON);
        waitForElementVisibility(DEFAULT_CARD_IMAGE, 10);
        System.out.println("Customer details have been entered");
        return  driver();
    }
    @Step("Enter Query in the chat option to place order for Pizza")
    public WebDriver sendQuery(String query){
        waitForElementVisibility(DEFAULT_CARD_IMAGE, 15);
        sendKeys(QUERY_TEXT_BOX, query);
        clickElement(SEND_QUERY_BUTTON);
        waitForElementVisibility(VEG_OPTION, 10);
        System.out.println("Entered query in the chat");
        return driver();
    }
    @Step("Select Pizza Veg or Non-Veg")
    public WebDriver selectPizzaType(String type){
        type = type.toLowerCase();
        waitForElementVisibility(VEG_OPTION, 10);
        clickElement(By.cssSelector("[aria-label="+type+"]"));
        System.out.println("Selected Pizza type");
        return driver();
    }
    @Step("Select Topping")
    public WebDriver selectTopping(String topping){
        waitForElementVisibility(SELECT_TOPPING_TEXT, 10);
        clickElement(By.xpath("//span[contains(text(),'"+topping+"')]"));
        clickElement(SUBMIT_TOPPING);
        System.out.println("Selected Topping");
        return driver();
    }
    @Step("Select Thin or Thick Crust")
    public WebDriver selectCrust(String crust){
        waitForElementVisibility(THIN_CRUST, 10);
        if(crust.toLowerCase().equals("thick crust")){
            clickElement(THICK_CRUST);
        }
        else if(crust.toLowerCase().equals("thin crust")){
            clickElement(THIN_CRUST);
        }
        System.out.println("Selcted required Crust");
        return driver();
    }
    @Step("Select Size of the Pizza")
    public WebDriver selectSize(String size){
        waitForElementVisibility(PIZZA_SIZE_TEXT,10);
        clickElement(By.xpath("//a[@aria-label='"+size+"']"));
        System.out.println("Size has been confirmed");
        return driver();
    }

    @Step("Confirm all the entered details and place order")
    public WebDriver confirmTheOrder(){
        waitForElementVisibility(ORDER_CONFIRM_TEXT, 10);
        clickElement(CONFIRM_ORDER_BUTTON);
        waitForElementVisibility(ORDER_PLACED_TEXT, 10);;
        System.out.println("Clicked on confirm order");
        return driver();
    }

    @Step("Provide feedback")
    public WebDriver feedBack(String response, String value){
        if(response.toLowerCase().equals("positive")){
            clickElement(FEEDBACK_THUMBS_UP);
            waitForElementVisibility(FEEDBACK_CONTAINER,10);
            clickElement(SELECT_RATING);
            waitForElementVisibility(By.cssSelector("li[data-idx='"+value+"']"), 10);
            clickElement(By.cssSelector("li[data-idx='"+value+"']"));
            clickElement(SUBMIT_FEEDBACK_BUTTON);
            waitForElementVisibility(THANK_YOU, 10);
            System.out.println("Feedback given successfully");
        }
        else if(response.toLowerCase().equals("negative")){
            clickElement(FEEDBACK_THUMBS_DOWN);
            waitForElementVisibility(FEEDBACK_CONTAINER,10);
            sendKeys(FEEDBACK_TO_IMPROVE, value);
            clickElement(SUBMIT_FEEDBACK_BUTTON);
            waitForElementVisibility(THANK_YOU,10);
            System.out.println("Feedback and improvement text given successfully");
        }
        return driver();
    }

    public boolean verifyThankyouMessage() {
        waitForElementVisibility(THANK_YOU, 10);
        if (isDispalyed(THANK_YOU)) {
            System.out.println("Successfully placed Pizza order");
            return true;
        }
        else
            System.out.println("Pizza order placement failed");
        return false;
    }




}
