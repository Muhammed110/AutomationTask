package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeLight;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public InventoryPage(org.openqa.selenium.WebDriver driver, int timeout) {
        super(driver, timeout);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public void addTwoProducts() {
        click(addBackpack);
        click(addBikeLight);
    }

    public String getCartCount() {
        try {
            return getText(cartBadge);
        } catch (Exception e) {
            return "0";
        }
    }

    public CartPage openCart() {
        click(cartIcon);
        return new CartPage(driver, 10);
    }

    public void logout() {
        click(menuButton);
        click(logoutButton);
    }
}
