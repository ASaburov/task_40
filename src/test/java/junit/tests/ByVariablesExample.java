package junit.tests;

import org.openqa.selenium.By;

public class ByVariablesExample {
    private static final By CLASS_NAME = By.className("uname");
    private static final By NAME = By.name("uname");
    private static final By ID = By.id("uname");
    private static final By TAG_NAME = By.tagName("uname");
    private static final By LINK_TEXT = By.linkText("uname");
    private static final By PARTIAL_LINK = By.partialLinkText("uname");
    private static final By CSS_SELECTOR = By.cssSelector("div.main");
    private static final By X_PATH = By.xpath("//tag");

}
