package Tests.day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;

import java.util.List;

public class warmUpo {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://cybertekschool.com/");
        //how to find all links?
        //every link as a tag name <a>
       List<WebElement> links = driver.findElements(By.xpath("//a"));

        //size of the list = number of links
        // findElement vs findElements
        // in case of find element, if there is no element found, you will exception
        //NoSuchElementException
        // findElement = only 1 webelements
        // findElements = 0 or more elements.
        // if list is empty, that means that element is not there
        // in this way, we can ensure that element doesn't present
        // //a[.='Home'] or //a[text()='Home'] - find link with text name Home

        System.out.println("Number of links: " + links.size() );
        //what if I want to print text of all links, one by one
        //loop through the collection of links

        for(WebElement each : links){
            System.out.println(each.getText());   //print text of every link
        }

        driver.quit();
    }
}
