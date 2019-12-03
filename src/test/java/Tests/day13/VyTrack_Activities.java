package Tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class VyTrack_Activities { // Calender Events test

    /*
    url: https://qa1.vytrack.com/
username: storemanager85
password: UserUser123
###Test case #1
Go to https://qa1.vytrack.com/
Login as a store manager
Navigate to Activities -> Calendar Events
Verify that page subtitle "All Calendar Events" is displayed

     */

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){

        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager55");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
       // driver.findElement(By.id("_submit")).click();

        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        BrowserUtils.wait(3);
        activitiesElement.click();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();
       // BrowserUtils.wait(3);
       WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
       wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test (description = "Verify page subtitle")
    public  void test1(){

        String expectedSubtitle = "All Calendar Events";
        String actualSub = driver.findElement(By.className("oro-subtitle")).getText();
                // .oro-subtitle
        Assert.assertEquals(actualSub, expectedSubtitle,  "Subtitle is wrong");
    }

    @Test(description = "Verify that 'Create Calendar event' button is displayed")
    public void test2(){
        Assert.assertTrue(driver.findElement(By.cssSelector("[title='Create Calendar event']")).isDisplayed());
    }
}
