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

public class LogedUserPage {

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

    // --------------- Dodatkowe metody pomocnicze ----------------------- //

    private void waitForElementVisible(WebElement elementToWait) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(elementToWait));

    }

    private void clickElement(WebElement elementToClick) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
        elementToClick.click();

    }

    // --------------- Metody na stronie ----------------------- //

    public void checkHeading(String expectedHeading) {
//        waitForElementVisible(heading);
        SeleniumHelper.wairForElementToVisible(driver, heading);
        Assert.assertTrue(heading.getText().contains(expectedHeading), "Heading" + expectedHeading + " correct");

    }

}
