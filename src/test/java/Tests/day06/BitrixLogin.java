package Tests.day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

public class BitrixLogin {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://login1.nextbasecrm.com/?login=yes");

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("hr46@cybertekschool.com");

       driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");

      // driver.findElement(By.xpath("//input[@value='Log In']")).click();
       driver.findElement(By.xpath("//input[starts-with(@onclick, 'BX')]")).click();

       driver.findElement(By.xpath("//*[contains(@title, 'Activity Stream')]")).click();


    }
}
