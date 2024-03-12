package testcases;

import org.testng.annotations.Test;
import page.LoginPage;
import page.ProductPage;
import utilities.DataSet;
import utilities.Driver_Setup;

import static org.testng.Assert.assertEquals;

public class TC01LoginTest extends Driver_Setup {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Test(priority = 4, dataProvider = "validCredentials", dataProviderClass = DataSet.class)

    public void testLoginWithValidCredentials(String userName, String password) {
        getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.userNameField, userName);
        loginPage.writeOnElement(loginPage.passwordField, password);
        loginPage.clickOnElement(loginPage.loginButton);
        loginPage.takeScreenShot("test Login With Valid Credentials ");
        assertEquals(getDriver().getCurrentUrl(), productPage.productPageUrl);
    }

    @Test(priority = 0)
    public void testLoginWithInvalidTest() {
        getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.userNameField, "standard_user");
        loginPage.writeOnElement(loginPage.passwordField, "secret_sau");
        loginPage.clickOnElement(loginPage.loginButton);
        loginPage.takeScreenShot("test Login With Invalid Test");
        assertEquals(loginPage.getElementText(loginPage.error_msg_locator), loginPage.error_msg);


    }

    @Test(priority = 1, dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
    public void testLoginWithinValidCredentials(String userName, String password) {
        getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.userNameField, userName);
        loginPage.writeOnElement(loginPage.passwordField, password);
        loginPage.clickOnElement(loginPage.loginButton);
        loginPage.takeScreenShot("test Login With in Valid Credentials");
        assertEquals(loginPage.getElementText(loginPage.error_msg_locator), loginPage.error_msg);
    }

    @Test(priority = 2, dataProvider = "emptyUserName", dataProviderClass = DataSet.class)
    public void testLoginWithemptyUserName(String userName, String password) {
        getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.userNameField, userName);
        loginPage.writeOnElement(loginPage.passwordField, password);
        loginPage.clickOnElement(loginPage.loginButton);
        loginPage.takeScreenShot("test Login With empty UserName ");
        assertEquals(loginPage.getElementText(loginPage.error_msg_locator), loginPage.error_msg2);
    }

    @Test(priority = 3, dataProvider = "emptyPassword", dataProviderClass = DataSet.class)
    public void testLoginWithemptyPassword(String userName, String password) {
        getDriver().get(loginPage.loginPageUrl);
        loginPage.writeOnElement(loginPage.userNameField, userName);
        loginPage.writeOnElement(loginPage.passwordField, password);
        loginPage.clickOnElement(loginPage.loginButton);
        loginPage.takeScreenShot("test Login With empty Password");
        assertEquals(loginPage.getElementText(loginPage.error_msg_locator), loginPage.error_msg3);
    }
}
