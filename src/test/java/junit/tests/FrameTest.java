package junit.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameTest {
    private static final String URL = "https://the-internet.herokuapp.com/iframe";
    private static final String FRAME_LOCATOR = "mce_0_ifr";
    private static final String CUSTOM_TEXT_P1 = "Hello";
    private static final String CUSTOM_TEXT_P2 = " world!";
    private static final By ACTIVE_ELEMENT = By.id("tinymce");
    private static final By BOLD_BUTTON = By.xpath("//div//i[@class=\"mce-ico mce-i-bold\"]");
    private WebDriver driver;

    @BeforeEach
    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.get(URL);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void frameTest() {
        driver.switchTo().frame(FRAME_LOCATOR);
        driver.findElement(ACTIVE_ELEMENT).clear();
        driver.findElement(ACTIVE_ELEMENT).sendKeys(CUSTOM_TEXT_P1);
        driver.switchTo().defaultContent();
        driver.findElement(BOLD_BUTTON).click();
        driver.switchTo().frame(FRAME_LOCATOR);
        driver.findElement(ACTIVE_ELEMENT).sendKeys(CUSTOM_TEXT_P2);
        System.out.println(driver.findElement(ACTIVE_ELEMENT).getText());
        assertEquals("Hello\uFEFF world!", driver.findElement(ACTIVE_ELEMENT).getText());
    }
}
