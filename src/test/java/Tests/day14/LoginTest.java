package Tests.day14;

import Tests.TestBase;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import javax.security.auth.login.Configuration;


public class LoginTest extends TestBase {

  //  @Ignore
    @Test
    public void test1(){

        // read url value from the properties file
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);

        BrowserUtils.wait(2);
        Driver.close();
    }

    @Test
    public void test2(){
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
    }
}
