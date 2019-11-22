package Tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class JSExecutorPractice {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = BrowserFactory.getDriver("chrome");

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1(){

        driver.get("https://practice-cybertekschool.herokuapp.com/infinite_scroll");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for(int i=0; i< 10; i++){
            js.executeScript("window.scrollBy(0, 500)");
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(3);

    }

    @Test (description = "Scrolling with JSexecutor to specific element")
    public void test2(){

        driver.get("http://practice.cybertekschool.com/large");

        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtils.wait(3);


    }

@Test (description = "Click with JS executor")
    public void test3(){

    driver.get("http://practice.cybertekschool.com/dynamic_loading");
    WebElement link = driver.findElement(By.partialLinkText("Example 1"));

    BrowserUtils.wait(3);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    js.executeScript("arguments[0].click()", link);
    BrowserUtils.wait(3);
    }

    @Test(description = "Enter text with JS executor")
    public void test4(){

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement name = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.name("wooden_spoon"));

        BrowserUtils.wait(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value', 'John Smith')", name);


        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'someemail@email.com')", email);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].click()", submitButton);
        BrowserUtils.wait(2);
    }

}
