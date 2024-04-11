package SeleniumJavaPOP.Pages;

import SeleniumJavaPOP.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LogedUserPage extends SeleniumHelper{

    @FindBy(xpath = "")
    private WebElement element;

    @FindBy(xpath = "")
    private WebElement element2;

    @FindBy(xpath = "")
    private WebElement element3;

    @FindBy(xpath = "//h3[@class = 'RTL']")
    private WebElement heading;

    private final WebDriver driver;

    // --------------- Inicjalizacja zmiennych @FindBy za pomocą page object factory ----------------------- //
    public LogedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    // --------------- Metody na stronie ----------------------- //
    public void checkHeading(String expectedHeading) {
        wairForElementToVisible(driver, heading);
        Assert.assertTrue(heading.getText().contains(expectedHeading), "Heading" + expectedHeading + " correct");

    }

}
