package Tests.Vy_Track;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.Verification;

public class NegativeTestCase {

    public static void main(String[] args) {

        // we are calling driver from the getDriver method.
        WebDriver driver = new BrowserFactory().getDriver("chrome");

        // open the login page of Vy_Track
        driver.get("http://qa2.vytrack.com/user/login");

         driver.findElement(By.name("_username")).sendKeys("storemanager007");

        // I find element from inspect and tell to the driver
        driver.findElement(By.name("_password")).sendKeys("UserUser123");

        // I tell to driver find element sumbit,login button
        driver.findElement(By.id("_submit")).click();

        String expected = "Invalid user name or password.";
        String actual = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div")).getText();

        Verification.verifyEquals(expected, actual);

        driver.quit();
    }
}
