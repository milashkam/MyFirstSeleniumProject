package Tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class PopUp_practice {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("JavaScript Alerts")).click();
    }

    @Test (description = "Click Ok on popUp ")
    public void test1(){

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        BrowserUtils.wait(2);
        //to deal with popup, we can create object of Alert
        //Switches to the currently active modal dialog
        Alert alert = driver.switchTo().alert();
        alert.accept();
        BrowserUtils.wait(4);
    }

    @Test (description = "Click on Cancel in pop up message")
    public void test2(){
        driver.findElement(By.xpath("//button[2]")).click();
        BrowserUtils.wait(2);

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText() );

        alert.dismiss();
        BrowserUtils.wait(2);

        System.out.println(driver.findElement(By.id("result")).getText() );
    }

    @Test (description = "Click on button 3, enter some text and then click Ok")
    public void test3(){

        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        BrowserUtils.wait(2);

        driver.switchTo().alert().sendKeys("Java is fun!");
        driver.switchTo().alert().accept();
        //to print text of result
        //should be Java is fun!
        System.out.println(driver.findElement(By.id("result")).getText());
        BrowserUtils.wait(4);

    }


    @AfterMethod
    public void teardown(){

        driver.quit();
    }


}
