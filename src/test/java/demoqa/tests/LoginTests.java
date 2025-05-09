package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        new HomePage(app.driver, app.wait)
                .selectFormAuthentication();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(app.driver, app.wait)
                .enterPersonalData("tomsmith", "SuperSecretPassword!")
                .clickOnLoginButton()
                .verifySecureArea();
    }

    @Test(dataProvider = "loginDataPositiveProvider", dataProviderClass = DataProviders.class)
    public void loginProviderPositiveTest(String username, String password) {
        new LoginPage(app.driver, app.wait)
                .enterPersonalData(username, password)
                .clickOnLoginButton()
                .verifyLogoutButtonVisible();
    }


    @Test(dataProvider = "loginDataNegativeProvider", dataProviderClass = DataProviders.class)
    public void loginProviderNegativeTest(String username, String password) {
        new LoginPage(app.driver, app.wait)
                .enterPersonalData(username, password)
                .clickOnLoginButton()
                .verifyLoginButtonVisible();
    }
}