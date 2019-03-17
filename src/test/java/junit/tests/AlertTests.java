package junit.tests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AlertTests {
    private static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";
    private static final String EXPECTED_MESSAGE_ALERT = "You successfuly clicked an alert";
    private static final String EXPECTED_MESSAGE_CONFIRM = "You clicked: Ok";
    private static final String MESSAGE_PROMPT = "Hey, you!";
    private static final String EXPECTED_MESSAGE_PROMPT = "You entered: Hey, you!";

    private static final By PROMPT_BUTTON = By.xpath("//button[text()='Click for JS Prompt']");
    private static final By CONFIRM_BUTTON = By.xpath("//button[text()='Click for JS Confirm']");
    private static final By ALERT_BUTTON = By.xpath("//button[text()='Click for JS Alert']");
    private static final By RESULT_MESSAGE = By.id("result");

    private WebDriver driver;

    @BeforeEach
    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }


    //ALERT TEST
    @Test
    public void alertTest() {
        driver.findElement(ALERT_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actualText = driver.findElement(RESULT_MESSAGE).getText();
        Assert.assertEquals(actualText, EXPECTED_MESSAGE_ALERT);
    }


    //CONFIRM TEST
    @Test
    public void alertTestConfirm() {
        driver.findElement(CONFIRM_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actualText = driver.findElement(RESULT_MESSAGE).getText();
        Assert.assertEquals(actualText, EXPECTED_MESSAGE_CONFIRM);
    }


    //PROMPT TEST
    @Test
    public void alertTestPrompt() {
        driver.findElement(PROMPT_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(MESSAGE_PROMPT);
        alert.accept();
        String actualText = driver.findElement(RESULT_MESSAGE).getText();
        Assert.assertEquals(actualText, EXPECTED_MESSAGE_PROMPT);
    }
}
