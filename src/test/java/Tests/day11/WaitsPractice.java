package Tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;

public class WaitsPractice {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test1(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Dynamic Loading")).click();

        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.tagName("button")).click();

        System.out.println( driver.findElement(By.id("finish")).getText() );

    }

    @Test
    public void test2(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1")).click();
        driver.findElement(By.tagName("button")).click();

        WebElement userNameBoxInput = driver.findElement(By.id("username"));
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOf(userNameBoxInput));
        userNameBoxInput.sendKeys("tomsmith");

        //if  I can use it again for password
        //  wait.until(ExpectedConditions.visibilityOf(passwordBoxInput));
        driver.findElement(By.id("pwd")).sendKeys("SuperSecretPassword");
       // driver.findElement(By.cssSelector("[type=\"checkbox\"]")).click();

        WebElement submit = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        WebElement message = driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();

        Assert.assertEquals(expectedMessage, actualMessage, "message text is wrong");

    }

    @Test
    public void test3(){

        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        //wait until overlay screen disappear
        //otherwise, we will have issue to click or enter the text
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));

        WebElement userNameInputBox = driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        userNameInputBox.sendKeys("tomsmith");
        WebElement passwordInputBox = driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");
        //this is a webelement that represents submit button
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        //wait, within 10 seconds, until that button is available for click
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
        WebElement message = driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test(description = "Fluent wait example")
    public void test4() {
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.tagName("button")).click();
        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class);
        WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("finish"));
            }
        });
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
