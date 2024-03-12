package page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public String loginPageUrl = "https://www.saucedemo.com/";
    public String error_msg = "Epic sadface: Username and password do not match any user in this service";
    public String error_msg2 = "Epic sadface: Username is required";
    public String error_msg3 = "Epic sadface: Password is required";
    public By error_msg_locator = By.tagName("h3");
    public By userNameField = By.id("user-name");
    public By passwordField = By.id("password");
    public By loginButton = By.id("login-button");
    public By userName = By.id("loginUserName");
    public By password = By.className("loginPassword");
    public String getUserName(){
        return getElementText(userName);
    }
    public String getPassword(){
        return getElementText(password);
    }

}
