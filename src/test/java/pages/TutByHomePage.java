package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TutByHomePage extends PageObject {

    @FindBy(className = "enter")
    private WebElement enterPopup;

    @FindBy(name = "login")
    private WebElement login;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@class='button auth__enter']")
    private WebElement enterSubmit;

    public TutByHomePage(WebDriver driver) {
        super(driver);
    }

    public void expandEnterPopup(){
        this.enterPopup.click();
    }

    public void login(String login, String password) {
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        this.enterSubmit.click();
    }
}
