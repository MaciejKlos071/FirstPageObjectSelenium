package SeleniumJavaPOP.Tests;

import SeleniumJavaPOP.Pages.LogedUserPage;
import SeleniumJavaPOP.Pages.LoginPage;
import SeleniumJavaPOP.Pages.TopBarMenuPage;
import SeleniumJavaPOP.utils.EmailGenerator;
import SeleniumJavaPOP.utils.SeleniumHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class LogInTest extends BaseTest {

    private static final String eMail = "AutomatyzacjaTest@gmail.com";
    private static final String password = "AutomatyzacjaTest";

    @Test
    public void logIn() throws IOException {
        ExtentTest test = extentReports.createTest("Search Hotel Test");

        new TopBarMenuPage(driver).openLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginMail(eMail);
        loginPage.setPassword(password);
        loginPage.selectCheckBoxRememberMe();
        loginPage.performLogInButton();
        new LogedUserPage(driver).checkHeading("Hi, " + "maciej" + " " + "maciej");
        test.log(Status.PASS,"login done", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void loginAllert(){
        new TopBarMenuPage(driver).openLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginMail("invalidEmail");
        loginPage.setPassword("invalidPassword");
        loginPage.selectCheckBoxRememberMe();
        loginPage.performLogInButton();
        Assert.assertEquals(loginPage.errorList().get(0), "Invalid Email or Password");

    }
    @Test
    public void loginInvalidPassword(){
        new TopBarMenuPage(driver).openLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginMail(eMail);
        loginPage.setPassword("invalidPassword");
        loginPage.selectCheckBoxRememberMe();
        loginPage.performLogInButton();
        Assert.assertEquals(loginPage.errorList().get(0), "Invalid Email or Password");

    }

}
