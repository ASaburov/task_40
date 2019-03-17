package junit.tests;

import org.junit.Assert;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TutByHomePage;

import java.util.concurrent.TimeUnit;


public class TutByLoginDdtTest {
    private static final By USERNAME = By.className("uname");
    private static final String CSV_FILE_PATH = "/data.csv";
    private static WebDriver driver;


    @BeforeEach
    public void setUp() {
// Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://tut.by");
        //implicit waiter for WebDriver
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

    @ParameterizedTest
    @CsvFileSource(resources = CSV_FILE_PATH)
    public void loginTest(String login, String password) {
        TutByHomePage homePage = new TutByHomePage(driver);
        homePage.expandEnterPopup();
        homePage.login(login, password);
        //explicit waiter for login test, which will wait until name appears
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
        Assert.assertEquals("Selenium Test", driver.findElement(USERNAME).getText());
    }

}
