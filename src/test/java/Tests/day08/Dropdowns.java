package Tests.day08;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class Dropdowns {

    private WebDriver driver;

    @AfterMethod
    public void teardown(){

        driver.quit();
    }

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
//        <a href="/checkboxes">Checkboxes</a>
        driver.findElement(By.linkText("Dropdown")).click();
    }
    @Test(description = "Select option 2 from the dropdown")
    public void test1(){

        // to work with select dropdowns, we need to use Select class in Selenium
        //step 1. Find dropdown and create a webelement
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //ste 2. Create a select object
        //select class requires webelemnt object as a parameter
        Select select = new Select(dropdown);
        //to select any option by visible text:
        // also you can select by value or index
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);

        //how to verify that option 2 is selected
        //select.getFirstSelectedOption() - to get selected option
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }

}
