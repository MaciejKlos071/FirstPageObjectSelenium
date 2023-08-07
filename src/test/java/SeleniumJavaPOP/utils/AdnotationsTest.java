package SeleniumJavaPOP.utils;

import SeleniumJavaPOP.Tests.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

public class AdnotationsTest extends BaseTest {
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    @FindBys({
            @FindBy(tagName = "table"),// W tagu "table" szukane są tagi "Th"
            @FindBy(tagName = "th")    // FindBys zawęża wyszukiwanie
    })
    List<WebElement> elements;
    @FindAll({
            @FindBy(tagName = "table"),// FindAll znajduje wszystkie elementy o podanych
            @FindBy(tagName = "th")    // parametrach wyszukiwania
    })
    List<WebElement> elements2;

    public AdnotationsTest(WebDriver driver) {
        logger.info("Initializing driver.");
        PageFactory.initElements(driver, this);
        logger.info("Driver initialized");
        this.driver = driver;
    }
    @Test
    public void performAction(){
        WebDriverManager.chromedriver().setup();
        driver.get("http://testeroprogramowania.github.io/selenium/");
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText());
        basicPageLink.click();
        System.out.println(elements.size());

        System.out.println(elements2.size());

    }
}
