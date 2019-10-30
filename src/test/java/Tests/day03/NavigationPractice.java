package Tests.day03;

import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        BrowserUtils.wait(3);

        driver.navigate().to("http://amazon.com");

        // navigate back to google
        driver.navigate().back();

        // move forward to the amazon again
        driver.navigate().forward();

        // to refresh a webpage/website
        driver.navigate().refresh();

        // shutdown or close all tabs
        driver.quit();


    }
}
