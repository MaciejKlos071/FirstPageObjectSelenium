package SeleniumJavaPOP.Tests;

import SeleniumJavaPOP.utils.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentSparkReporter sparkReporter;
    protected static ExtentReports extentReports;

    @BeforeSuite
    public void beforeSuite(){
        sparkReporter = new ExtentSparkReporter("index.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    @AfterSuite
    public void afterSuite(){
        extentReports.flush();

    }

    @BeforeMethod
    public void setup() throws IOException {
        System.out.println("TEST START");

        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
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

