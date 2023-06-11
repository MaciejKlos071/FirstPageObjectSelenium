package SeleniumJavaPOP.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SingUpPage {

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastname;

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "email")
    private WebElement eMail;


    @FindBy(name = "confirmpassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//h3[@class = 'RTL']")
    private WebElement heading;


    @FindBy(xpath = "//li[@id='li_myaccount']")
    private List<WebElement> singUpTopBarElement;

    @FindBy(xpath = "//a[text() = '  Sign Up']")
    private List<WebElement> singUpTopBarListElement;

    @FindBy(xpath = "//button[contains(@class, 'signupbtn') ]")
    private WebElement singUpRegisterButton;

    private final WebDriver driver;

    // --------------- Inicjalizacja zmiennych @FindBy za pomocą page object factory ----------------------- //
    public SingUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }
    public void  waitForElementVisible(WebElement elementToWait){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elementToWait));

    }
    public void clickElement(WebElement elementToClick){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
        elementToClick.click();

    }


    public void setFirstname(String firstUserName) {
        waitForElementVisible(firstName);
        firstName.sendKeys(firstUserName);
    }

    public void setLastname(String lastUsername) {
        waitForElementVisible(lastname);
        lastname.sendKeys(lastUsername);
    }
    public void setEmail(String userEmail) {
        waitForElementVisible(eMail);
        eMail.sendKeys(userEmail);
    }
    public void setPhone(String userPhone) {
        waitForElementVisible(phone);
        phone.sendKeys(userPhone);
    }

    public void setPassword(String userPassword) {
        waitForElementVisible(password);
        password.sendKeys(userPassword);
    }

    public void setConfirmpassword(String confirmUserpassword) {
        waitForElementVisible(confirmPassword);
        confirmPassword.sendKeys(confirmUserpassword + Keys.TAB);
    }


    public void performSingUp(){
        clickElement(singUpRegisterButton);
    }

    public void performSingUpTopBar(){
        singUpTopBarElement.stream().filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);
    }
    public void singUpTopBarListElement(){
        waitForElementVisible(singUpTopBarListElement.get(1));
        clickElement(singUpTopBarListElement.get(1));
    }

    public void checkHeading(String expectedHeading){
        waitForElementVisible(heading);
        Assert.assertTrue(heading.getText().contains(expectedHeading),"Heading"+expectedHeading+" correct");

    }
}
