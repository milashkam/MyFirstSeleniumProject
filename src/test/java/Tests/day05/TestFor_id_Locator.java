package Tests.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

public class TestFor_id_Locator {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button = driver.findElement(By.id("disappearing_button"));

        button.click();

        WebElement result = driver.findElement(By.id("result"));

        System.out.println(result.getText() );

        driver.quit();
    }
}
