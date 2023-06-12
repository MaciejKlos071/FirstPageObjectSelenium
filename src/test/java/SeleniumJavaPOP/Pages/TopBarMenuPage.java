package SeleniumJavaPOP.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TopBarMenuPage {

    // --------------- Selektory elementów na stronie ----------------------- //
    @FindBy(xpath = "//li[@id='li_myaccount']")
    private List<WebElement> singUpTopBarElement;

    @FindBy(xpath = "//a[text() = '  Sign Up']")
    private List<WebElement> singUpTopBarListElement;

    private final WebDriver driver;

    // --------------- Inicjalizacja zmiennych @FindBy za pomocą page object factory ----------------------- //
    public TopBarMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // --------------- Dodatkowe metody pomocnicze ----------------------- //
    public void waitForElementVisible(WebElement elementToWait) {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elementToWait));
    }

    public void clickElement(WebElement elementToClick) {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
        elementToClick.click();
    }

    // --------------- Metody na stronie ----------------------- //
    private void performSingUpTopBar() {
        singUpTopBarElement.stream().filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);
    }

    private void singUpTopBarListElement() {
        waitForElementVisible(singUpTopBarListElement.get(1));
        clickElement(singUpTopBarListElement.get(1));
    }

    public void openSignUpForm() {
        performSingUpTopBar();
        singUpTopBarListElement();
    }

}
