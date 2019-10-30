package Tests.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

public class ReadAttributesTest {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input = driver.findElement(By.name("email"));

        //to read value of any attribute
        //name="email" name it's an attribute, email it's a value of attribute
        System.out.println(input.getAttribute("pattern"));

        input.sendKeys("random@email.com");
        //how to read entered text?
        //it's gonna be inside value attribute
        System.out.println(input.getAttribute("value"));

        //if button has a type "submit"
        //we can use .submit() method instead of click() as well
        WebElement retrievePasswordButton = driver.findElement(By.name("form_submit"));

        //alternative to click, only if type="submit"
        retrievePasswordButton.submit();
        driver.close();
    }
}
