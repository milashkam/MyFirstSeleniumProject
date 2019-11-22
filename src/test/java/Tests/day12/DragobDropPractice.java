package Tests.day12;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class DragobDropPractice {

    @Test(description = "Drag and drop example")
    public void test1() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions = new Actions(driver);
        WebElement moon = driver.findElement(By.id("draggable"));
        WebElement earth = driver.findElement(By.id("droptarget"));
        BrowserUtils.wait(3);
        actions.dragAndDrop(moon, earth).perform();
       // actions.dragAndDrop(earth, moon).perform(); bu olmadi
        BrowserUtils.wait(3);

        driver.quit();
    }

}
