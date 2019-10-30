package Tests.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class FindElementsTest {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedTitle = driver.getTitle();
        // Step 1. Open inspector in chrome and find locator for the element
        // Step 2. Create object of WebElement
        // Step 3. Use webelement
        WebElement button = driver.findElement(By.id("form_submit"));
        // to click on the element
        button.click();
        BrowserUtils.wait(2);

        //read title again, after clicking
       String actualTitle =  driver.getTitle();
       if(actualTitle.equals(expectedTitle)) {
           System.out.println("Test passed");
       } else {
           System.out.println("Test failed");
           System.out.println("Expected title: "+expectedTitle);
           System.out.println("Actual title: "+actualTitle);
       }
        BrowserUtils.wait(2);
        driver.close();

    }
}
