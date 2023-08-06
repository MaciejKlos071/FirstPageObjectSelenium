package SeleniumJavaPOP.Pages;

import SeleniumJavaPOP.Model.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SingUpPage {

    // --------------- Selektory elementów na stronie ----------------------- //
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

    @FindBy(xpath = "//div[@class='alert alert-danger']//p")
    private List<WebElement> errorList;


    @FindBy(xpath = "//button[contains(@class, 'signupbtn') ]")
    private WebElement singUpRegisterButton;

    private final WebDriver driver;

    // --------------- Inicjalizacja zmiennych @FindBy za pomocą page object factory ----------------------- //
    public SingUpPage(WebDriver driver) {
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


    public void performSingUp() {
        clickElement(singUpRegisterButton);
    }

    public SingUpPage performSingUpSamePage() {
        clickElement(singUpRegisterButton);
        return this;
    }

    public List<String> errorList() {
        List<String> errors = errorList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return errors;
    }

    public void fillSingUpForm(String fName, String lName, String phoneNum, String eMail, String password) {
        setFirstname(fName);
        setLastname(lName);
        setPhone(phoneNum);
        setEmail(eMail);
        setPassword(password);
        setConfirmpassword(password);
        performSingUp();
    }

    public void fillSingUpFormUserModel(User user) {
        setFirstname(user.getFirstName());
        setLastname(user.getLastName());
        setPhone(user.getPhone());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setConfirmpassword(user.getPassword());
        performSingUp();
    }

}
