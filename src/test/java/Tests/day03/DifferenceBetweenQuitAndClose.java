package Tests.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferenceBetweenQuitAndClose {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(4000); // will pause execution for 4 seconds, millis it's a placeholder
        // driver.close(); will close one tab
        driver.quit(); // will close all tabs



    }
}
