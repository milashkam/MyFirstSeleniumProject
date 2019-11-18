package Tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.Collections;
import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }

    @Test
    public void test1(){

        driver.findElement(By.linkText("New tab")).click();
        //after 3 seconds, another website will be opened,in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle() );
        Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong");


    }

    @Test (description = "Verify that user successfully changed the tab or new window")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();
        //record id of original window, that we opened initially
        String oldWindow = driver.getWindowHandle();
        BrowserUtils.wait(5);

        //in the selenium every window has an id. That id calls window handle
        //to read window handle we use a method getWindowHandle()
        //after new window was opened, we can get list of all window id's/window handles
        //list - it's a data structure
        //set it's also a data structure, like list, but it doesn't allow duplicates
        //also, you cannot easily access anything from there
        //there is no .get() method
        //that's why, we need to loop through the set, to read a data from there
        //set can store only unique values

        Set<String> windowHandles = driver.getWindowHandles();

       for(String windowHandle : windowHandles){
           if(! windowHandle.equals(oldWindow)){
               driver.switchTo().window(windowHandle);
           }
       }
        System.out.println(driver.getTitle());
       Assert.assertEquals(driver.getTitle(), "Fresh tab", "title is wrong again");

        //comeback to original page
        //we can build a function, that will jump, in between windows
        //based on page title
        String pageTitle = "Practice";
        for (String windowHandle : windowHandles) {
            //keep jumping from window to window
            driver.switchTo().window(windowHandle);
            //once we found page title, of the window that we need
            if(driver.getTitle().equals(pageTitle)){
                //just exit
                //stop jumping
                break;
            }
        }
    }

    @AfterMethod
    public void teardown(){

        driver.quit();
    }


}
