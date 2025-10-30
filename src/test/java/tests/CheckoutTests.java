package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import drivers.DriverFactory;
import utils.ConfigReader;

public class CheckoutTests extends BaseTest {

    @Test(description = "Complete checkout flow and verify order confirmation")
    public void checkoutFlow() {
        LoginPage login = new LoginPage(DriverFactory.getDriver(), Integer.parseInt(ConfigReader.get("timeout")));
        InventoryPage inventory = login.loginValid(ConfigReader.get("username"), ConfigReader.get("password"));
        inventory.addTwoProducts();
        CartPage cart = inventory.openCart();
        CheckoutPage checkout = cart.proceedToCheckout();
        checkout.fillInformation("John", "Doe", "12345");
        OrderConfirmationPage confirmation = checkout.finishCheckout();
        Assert.assertTrue(confirmation.getConfirmationMessage().toLowerCase().contains("thank you"));
    }
}
