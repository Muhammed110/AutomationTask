package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import drivers.DriverFactory;
import utils.ConfigReader;

public class LoginTests extends BaseTest {

    @Test(description = "Verify valid login works")
    public void validLoginTest() {
        LoginPage login = new LoginPage(DriverFactory.getDriver(), Integer.parseInt(ConfigReader.get("timeout")));
        InventoryPage inventory = login.loginValid(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertEquals(inventory.getPageTitle(), "Products");
    }

    @Test(description = "Verify invalid login shows correct error")
    public void invalidLoginTest() {
        LoginPage login = new LoginPage(DriverFactory.getDriver(), Integer.parseInt(ConfigReader.get("timeout")));
        login.loginInvalid("wrongUser", "wrongPass");
        Assert.assertTrue(login.getErrorMessage().toLowerCase().contains("username"));
    }
}
