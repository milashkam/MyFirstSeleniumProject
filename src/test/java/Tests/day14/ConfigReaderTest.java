package Tests.day14;

import org.testng.Assert;
        import org.testng.annotations.Test;
        import utilities.ConfigurationReader;

public class ConfigReaderTest {

    @Test
    public void test1(){
        String expectedBrowser= "chrome";
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser, expectedBrowser);
        System.out.println(ConfigurationReader.getProperty("url"));

        System.out.println("username: " + ConfigurationReader.getProperty("user_name"));

        System.out.println("password: " + ConfigurationReader.getProperty("password"));

        //  //read value of password property
        //        String password = ConfigurationReader.getProperty("password");
        //        System.out.println("Password: "+password);
    }
}
