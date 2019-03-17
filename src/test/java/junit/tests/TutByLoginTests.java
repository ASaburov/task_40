package junit.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.TutByHomePage;
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
        assertEquals("Selenium Test", driver.findElement(USERNAME).getText());
    }

}
