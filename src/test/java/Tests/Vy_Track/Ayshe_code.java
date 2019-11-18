package Tests.Vy_Track;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;
import utilities.Verification;
import java.util.ArrayList;

public class Ayshe_code {

    /*
   Task case
   •Go to the login page of VyTrack
   •Enter valid credential (can be any role)
   •Click login button
   •Verify that the user login successfully
    */
    public static void main(String[] args) {
        // String array to hold user-names
        String [] userNames = {"user165","user166","user167",
                "storemanager98" , "storemanager99", "storemanager199",
                "salesmanager261", "salesmanager262" };
        loginFunctionality(userNames);
    }
    public static void loginFunctionality(String[] users){

        ArrayList<Boolean> list = new ArrayList<Boolean>();

        for(int i = 0; i < users.length; i++){
            // create  a driver object to get chrome browser
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("https://qa2.vytrack.com/user/login");  // takes to vy_tracking application page
            // locating elements for username and password
            WebElement username = driver.findElement(By.name("_username"));
            username.sendKeys(users[i]);
            WebElement password = driver.findElement(By.name("_password"));
            password.sendKeys("UserUser123");
            // expected result
            String expectedTitle = "Dashboard";
            // find the element for login button
            WebElement loginButton = driver.findElement(By.id("_submit"));
            loginButton.submit();
            BrowserUtils.wait(2);
            // actual result
            String actualTitle = driver.getTitle();
            // call the verify method from the verification class
            list.add(Verification.verify(expectedTitle, actualTitle));
            driver.close(); // close the current page
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(true)) {
                System.out.println(users[i] + " can login");
            }else{
                System.out.println(users[i] + " cannot login");
            }
        }
    }


}
