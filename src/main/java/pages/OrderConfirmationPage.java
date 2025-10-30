package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage {

    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    public OrderConfirmationPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public String getConfirmationMessage() {
        return getText(completeHeader);
    }
}
