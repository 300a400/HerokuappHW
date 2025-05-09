package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SecurePage extends BasePage {

    public SecurePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "flash")
    WebElement welcome;

    public SecurePage verifySecureArea() {
        Assert.assertTrue(welcome.getText().contains("secure area!"), "Error");
        System.out.println("Successful!");
        return this;
    }

    @FindBy(css = "a[href='/logout']")
    WebElement logoutButton;

    public SecurePage verifyLogoutButtonVisible() {
        Assert.assertTrue(logoutButton.isDisplayed(), "Failed registration...");
        return new SecurePage(driver, wait);
    }

    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement loginButton;

    public LoginPage verifyLoginButtonVisible() {
        Assert.assertTrue(loginButton.isDisplayed(), "Successful registration...");
        return new LoginPage(driver, wait);
    }
}