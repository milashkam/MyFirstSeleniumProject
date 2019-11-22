package Tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class FramesPractice {

    private WebDriver driver;


    @BeforeMethod
    public void setup(){

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/frames");
    }

    @Test (description = "iFrame example")
    public void test1(){

     driver.findElement(By.linkText("iFrame")).click();
        //since element inside a frame, element is not visible for selenium
        //without switching to the frame
        //we can switch to frame based on id, name, index(starting from 0), web element
     driver.switchTo().frame("mce_0_ifr");

        WebElement inputArea = driver.findElement(By.id("tinymce"));

        String expectedText= "Your content goes here.";
        String actualText = inputArea.getText();
        Assert.assertEquals(actualText, expectedText);
        BrowserUtils.wait(2);
        inputArea.clear();
        BrowserUtils.wait(6);
        inputArea.sendKeys("Java is fun!");
        //to exit from the frame
        driver.switchTo().defaultContent();


    }
            //in case of nested frames
            //we must switch to first frame --> then again to another frame, that is inside
            // -- html
            // -- frame #1
            // ---- frame #2
    @Test (description = "Nested Frames example")
    public void test2(){
        //it's not switch to frame
        //it's a navigation action
        driver.findElement(By.linkText("Nested Frames")).click();
        //we switch to frame based on webelement
        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));

        //the reason why we are switching here
        //is because content that is inside a frame is not visible for selenium
        //it's like when you are on the first floor
        //trying to find what is on the second floor
        WebElement content = driver.findElement(By.tagName("body"));
        System.out.println(content.getText());
        driver.switchTo().defaultContent();//to exit from all frames, got to first floor
        driver.switchTo().frame("frame-top"); // second floor
        driver.switchTo().frame("frame-left"); // third floor
        System.out.println(driver.findElement(By.tagName("body")).getText());//print text of body

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
