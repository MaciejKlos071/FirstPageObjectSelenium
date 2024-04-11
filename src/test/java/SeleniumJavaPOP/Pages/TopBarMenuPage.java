package SeleniumJavaPOP.Pages;

import SeleniumJavaPOP.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopBarMenuPage extends SeleniumHelper {

    // --------------- Selektory elementów na stronie ----------------------- //
    @FindBy(xpath = "//li[@id='li_myaccount']")
    private List<WebElement> myAccountTopBarlistElement;

    @FindBy(xpath = "//a[text() = '  Sign Up']")
    private List<WebElement> singUpTopBarListElement;

    @FindBy(xpath = "//a[text() = ' Login']")
    private List<WebElement> logInTopBarListElement;

    @FindBy(xpath = "//li/a[@class='dropdown-toggle go-text-right' and @href='javascript:void(0);']")
    private List<WebElement> logedAccountTopBarListElement;

    @FindBy(partialLinkText = "m-hotels")
    private WebElement home;

    private final WebDriver driver;

    // --------------- Inicjalizacja zmiennych @FindBy za pomocą page object factory ----------------------- //
    public TopBarMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // --------------- Metody na stronie ----------------------- //
    private void performMyAccountTopBar() {
        myAccountTopBarlistElement.stream().filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);
    }
    private void performLogedTopBar() {
        logedAccountTopBarListElement.stream().filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);
    }
    private void singUpTopBarListElement() {
//        waitForElementVisible(singUpTopBarListElement.get(1));
        clickElement(driver,singUpTopBarListElement.get(1));
//        clickElement(singUpTopBarListElement.get(1));
    }
    private void openLogInTopBarListElement() {
//        waitForElementVisible(logInTopBarListElement.get(1));
//        clickElement(logInTopBarListElement.get(1));
        clickElement(driver,logInTopBarListElement.get(1));

    }

    public void openSignUpForm() {
        performMyAccountTopBar();
        singUpTopBarListElement();
    }

    public void openLoginPage(){
        performMyAccountTopBar();
        openLogInTopBarListElement();
    }

}
