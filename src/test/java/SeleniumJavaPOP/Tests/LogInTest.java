package SeleniumJavaPOP.Tests;

import SeleniumJavaPOP.Pages.LogedUserPage;
import SeleniumJavaPOP.Pages.LoginPage;
import SeleniumJavaPOP.Pages.TopBarMenuPage;
import SeleniumJavaPOP.utils.EmailGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class LogInTest extends BaseTest {

    private static final String eMail = "AutomatyzacjaTest@gmail.com";
    private static final String password = "AutomatyzacjaTest";

    @Test
    public void logIn() {

        TopBarMenuPage topBarMenuPage = new TopBarMenuPage(driver);
        new TopBarMenuPage(driver).openLoginPage();
        WebElement eMailInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement checkBoxRemmember = driver.findElement(By.xpath("//input[@name='remember']"));
        WebElement logInButton = driver.findElement(By.xpath("//button[@TYPE = 'submit'][text() = 'Login']"));
        eMailInput.sendKeys(eMail);
        passwordInput.sendKeys(password);
        // Sprawdź czy checkbox jest zaznaczony
        if (checkBoxRemmember.isSelected()) {
            System.out.println("Checkbox jest zaznaczony!");
        } else {
            System.out.println("Checkbox nie jest zaznaczony!");
            checkBoxRemmember.click();
        }
        logInButton.click();
        new LogedUserPage(driver).checkHeading("Hi, " + "maciej" + " " + "maciej");
    }

    // logIn Test Refactored extended by POP
    @Test
    public void logInPoP(){
        new TopBarMenuPage(driver).openLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginMail("invalidEmail");
        loginPage.setPassword("invalidPassword");
        loginPage.selectCheckBoxRememberMe();
        loginPage.performLogInButton();
        Assert.assertEquals(loginPage.errorList().get(0), "Invalid Email or Password");

    }


}
