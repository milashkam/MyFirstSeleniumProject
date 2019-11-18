package Tests.day07;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsTest {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");

    }


    @BeforeMethod
    public void setup(){

        System.out.println("Before I will start");
    }

    @AfterMethod
    public void teardown(){

        System.out.println("After Method");
    }


    @Test
    public void test1(){
        System.out.println("Test 1.!");
        Assert.assertTrue(5 == 5);
    }

    @Test
    public void test2(){
        System.out.println("Test 2.!");
    }

    @Test
    public void test3(){
        System.out.println("Test 3.!");
    }
}
