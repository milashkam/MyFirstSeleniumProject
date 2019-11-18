package Tests.day09;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TestNGReview {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
    driver = BrowserFactory.getDriver("chrome");
   // driver.get("");
    }

    @AfterMethod
    public void teardown(){
    driver.quit();

    }

    @Test(description = "Verify title of google.com")
    public void test1(){

       driver.get("https://www.google.com/");
       String expected = "Google";
       String actual = driver.getTitle();
        Assert.assertEquals(expected, actual, "Title is not correct");
    }

    @Test(description = "Verify apple.com title", priority = 1)
    public void test2(){
        driver.get("https://www.apple.com/");
        String expected = "Apple";
        String actual = driver.getTitle();
        Assert.assertEquals(expected, actual, "Title is not correct");
    }

       @DataProvider(name = "testData")
          public static Object[][] testData(){
       // return new Object[][]{{}};
           return new Object[][]{{"https://www.apple.com/", "Apple"}, //1st set of data
                   {"http://google.com", "Google"}     //2nd set of data
           };
       }
    //data provider must return 2d array of Object
    //1st parameter  = 1 object in the inner array, 2nd parameter = 2 object in the inner array
    // url = https://www.apple.com/, title = Apple
    // url = http://google.com, title = Google
    //we can have as many sets of data as we want
    @Test(dataProvider = "testData") // this test will run twice, because we have 2 sets of data
    public void testWithDataProvider(String url, String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }

}
