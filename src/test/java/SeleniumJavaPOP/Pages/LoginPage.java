package SeleniumJavaPOP.Pages;

import SeleniumJavaPOP.utils.SeleniumHelper;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;

import java.util.List;

// --------------- LoginPage class extended by common methods ----------------------- //

public class LoginPage extends SeleniumHelper {


    @FindBy(name = "username")
    private WebElement eMailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@name='remember']")
    private WebElement checkBoxRemember;

    @FindBy(xpath = "//button[@TYPE = 'submit'][text() = 'Login']")
    private WebElement logInButton;

    @FindBy(linkText = "http://www.kurs-selenium.pl/demo/register")
    private WebElement singUpButton;

    @FindBy(partialLinkText = "#ForgetPassword")
    private WebElement ForgetPasswordButton;
    @FindBy(xpath = "//div[@class = 'resultlogin']")
    private List<WebElement> errorList;

    private static final Logger logger = LogManager.getLogger();

    private final WebDriver driver;

    // --------------- Inicjalizacja zmiennych @FindBy za pomocą page object factory ----------------------- //
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    // --------------- Methods for Login Page----------------------- //

    // Field's methods
    public void setLoginMail(String userLoginMail) {
        waitForElementVisible(driver, eMailInput);
        eMailInput.sendKeys(userLoginMail);
        logger.info("Field filled by Login/email ");
    }

    public void setPassword(String userPassword) {
        waitForElementVisible(driver, passwordInput);
        passwordInput.sendKeys(userPassword);
        logger.info("Field filled by password ");
    }

    public void selectCheckBoxRememberMe() {
        if (checkBoxRemember.isSelected()) {
            logger.info("Checkbox is already selected!");
        } else {
            waitForElementVisible(driver, checkBoxRemember);
            checkBoxRemember.click();
            logger.info("Checkbox selected!");
        }
    }
    // buttons methods

    public void performLogInButton() {
        waitForElementVisible(driver, logInButton);
        logInButton.click();
        logger.info("Click on Log in button");
    }

    public List<String> errorList() {
        logger.info("Check for information List");
        return informationList(driver, errorList);
    }
//

}


