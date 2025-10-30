package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(className = "cart_item")
    private java.util.List<WebElement> cartItems;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public int getCartItemsCount() {
        return cartItems.size();
    }

    public CheckoutPage proceedToCheckout() {
        click(checkoutBtn);
        return new CheckoutPage(driver, 10);
    }
}
