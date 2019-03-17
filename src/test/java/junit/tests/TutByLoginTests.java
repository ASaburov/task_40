package junit.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TutByHomePage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TutByLoginTests {

    private static final String URL = "https://tut.by";
    private static final String LOGIN = "seleniumtests@tut.by";
    private static final String PASSWORD = "123456789zxcvbn";
    private static final By USERNAME = By.className("uname");

    private WebDriver driver;

    @BeforeEach
    public void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(URL);
        //implicit waiter for WebDriver
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    //test log in the app and check whether username appeared in the corresponding field
    @Test
    public void loginProcessTest() {
        TutByHomePage homePage = new TutByHomePage(driver);
        homePage.expandEnterPopup();
        homePage.login(LOGIN, PASSWORD);
        //explicit waiter
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //explicit waiter for login test, which will wait until name appears
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
        assertEquals("Selenium Test", driver.findElement(USERNAME).getText());
    }

}
