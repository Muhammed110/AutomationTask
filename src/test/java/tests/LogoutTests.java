package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import drivers.DriverFactory;
import utils.ConfigReader;
import org.openqa.selenium.By;

public class LogoutTests extends BaseTest {

    @Test(description = "Verify logout works")
    public void logoutTest() {
        LoginPage login = new LoginPage(DriverFactory.getDriver(),
                Integer.parseInt(ConfigReader.get("timeout")));

        login.loginValid(ConfigReader.get("username"), ConfigReader.get("password"));

        InventoryPage inventory = new InventoryPage(DriverFactory.getDriver(),
                Integer.parseInt(ConfigReader.get("timeout")));
        inventory.logout();

        Assert.assertTrue(
                DriverFactory.getDriver().getCurrentUrl().contains("saucedemo.com/"),
                "Logout failed or user was not redirected correctly"
        );
    }
}
