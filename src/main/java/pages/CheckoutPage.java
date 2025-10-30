package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public CheckoutPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public void fillInformation(String fName, String lName, String pCode) {
        type(firstName, fName);
        type(lastName, lName);
        type(postalCode, pCode);
        click(continueBtn);
    }

    public OrderConfirmationPage finishCheckout() {
        click(finishBtn);
        return new OrderConfirmationPage(driver, 10);
    }
}
