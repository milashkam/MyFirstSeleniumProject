package Tests.day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class CssSelector_practice {
    //Which locator to use?
    //#1 id
    //#2 css
    //#3 xpath
    //## whatever

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/multiple_buttons");

        //let's fin all buttons, and click on them one by one
        // why I put . instead of space? because it's 2 class names .btn.btn-primary
        //in this case, we will find all buttons that have: class="btn btn-primary"
        // or like this [class='btn btn-primary'], no need for .
        //. means class name
        //# means id
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));

        for(WebElement button : buttons){
            button.click();
            BrowserUtils.wait(1);
            //get the message after click
            WebElement message = driver.findElement(By.cssSelector("#result"));
            //print a text of that message
            System.out.println(message.getText());
        }

        WebElement header = driver.findElement(By.cssSelector(".container>h3"));
        System.out.println(header.getText());

        System.out.println(driver.findElement(By.cssSelector(".container>p")).getText() );
        driver.quit();
    }
}
