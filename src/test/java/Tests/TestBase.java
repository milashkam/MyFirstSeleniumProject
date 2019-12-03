package Tests;

import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import utilities.ConfigurationReader;
        import utilities.Driver;

public abstract class TestBase {

    @BeforeMethod
    public void setup(){
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);
    }

    @AfterMethod
    public void teardown(){
        Driver.close();
    }
}
