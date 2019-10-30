package Tests.Vy_Track;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class ProjectVy {

    public static void main(String[] args) {

        // we are calling driver from the getDriver method.
        WebDriver driver = new BrowserFactory().getDriver("chrome");

        // open the login page of Vy_Track
        driver.get("http://qa2.vytrack.com/user/login");

        // I find element from inspect and tell to the driver
        WebElement input = driver.findElement(By.name("_username"));

        // I filled username block with storemanager98
        input.sendKeys("storemanager98");

        //
        // I find element from inspect and tell to the driver
        WebElement input2 = driver.findElement(By.name("_password"));

        // I filled password block with UserUser123
        input2.sendKeys("UserUser123");

        // I tell to driver find element sumbit,login button
        WebElement button = driver.findElement(By.id("_submit"));

        // press click
        button.click();

        // wait for 2 sec
        BrowserUtils.wait(2);


        String expect = "Dashboard";

        String actual = driver.getTitle();

        if(actual.contains(expect)){
            System.out.println("passed");
        } else{
            System.out.println("failed");
        }

        driver.close();

    }
}
