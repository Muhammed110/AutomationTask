package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(css = "div.error-message-container")
    private WebElement errorMsg;

    public LoginPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    @Step("Login with username: {user}")
    public InventoryPage loginValid(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginBtn);
        return new InventoryPage(driver, 10);
    }

    @Step("Attempt invalid login with username: {user}")
    public void loginInvalid(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }

    public String getErrorMessage() {
        return getText(errorMsg);
    }
}
