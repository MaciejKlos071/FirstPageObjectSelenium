package SeleniumJavaPOP.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("TEST START");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

//    @BeforeSuite
//    public void beforeSuit(){
//        System.out.println("Before Suit");
//    }
//    @AfterSuite
//    private void afterSuit(){
//        System.out.println("After suit");
//    }
//
//    @BeforeClass
//    private void beforeClass(){
//        System.out.println("Before Class");
//    }
//
//    @AfterClass
//    private void afterClass(){
//        System.out.println("after Class");
//    }
//
//    @BeforeTest
//    public void beforeTest(){
//        System.out.println("I am running before test");
//    }
//
//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("I am running before method");
//    }
//
//
//    @AfterTest
//    public void aftertTest(){
//        System.out.println("I am running after test");
//    }
//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("I am running after method");
//    }
//}

