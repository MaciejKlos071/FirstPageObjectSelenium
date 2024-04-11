package SeleniumJavaPOP.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;

public class DriverFactory {
    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        DriverFactory.driver = driver;
    }

    public static WebDriver getDriver() throws IOException {
        String browser = PropertiesLoader.loadPropertier("browser.name");
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.out.println("FireFox setup");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser name: " + browser);
            }
        }
        return driver;
    }
}
//    public static WebDriver getDriver(){
//        if (driver==null){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//
//        }
//        return driver;
//    }
//}