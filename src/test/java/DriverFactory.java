
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        DriverFactory.driver = driver;
    }
    public static WebDriver getDriver(){
        if (driver==null){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        return driver;
    }
}