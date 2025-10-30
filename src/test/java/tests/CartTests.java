package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import drivers.DriverFactory;
import utils.ConfigReader;

public class CartTests extends BaseTest {

    @Test(description = "Add two products to cart and verify count")
    public void addProductsAndVerifyCart() {
        LoginPage login = new LoginPage(DriverFactory.getDriver(), Integer.parseInt(ConfigReader.get("timeout")));
        InventoryPage inventory = login.loginValid(ConfigReader.get("username"), ConfigReader.get("password"));
        inventory.addTwoProducts();
        Assert.assertEquals(inventory.getCartCount(), "2");
        CartPage cart = inventory.openCart();
        Assert.assertEquals(cart.getCartItemsCount(), 2);
    }
}
