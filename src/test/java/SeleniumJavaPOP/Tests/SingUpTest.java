package SeleniumJavaPOP.Tests;

import SeleniumJavaPOP.Pages.SingUpPage;
import SeleniumJavaPOP.Tests.BaseTest;
import SeleniumJavaPOP.utils.EmailGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SingUpTest extends BaseTest {

    private static final String firstName = "Maciej";
    private static final String lastName = "klos";
    private static final String phone = "505202303";
    private static final String password = "password";
    private static String eMail = EmailGenerator.generateRandomEmail();
    private static final String[] communicate =
            {
                    "The Email field is required.",
                    "The Password field is required.",
                    "The Password field is required.",
                    "The First name field is required.",
                    "The Last Name field is required."
            };
    private static final Map<String, String> communicateKeyList = Map.of(
            "email","The Email field is required.",
            "password","The Password field is required.",
            "firstname","The First name field is required.",
            "fristname","The Last Name field is required."
    );


    @Test
    public void singUp(){
        //------------------ Test w wersji page object pattern ------------------//
        SingUpPage singUp = new SingUpPage(driver);
        singUp.performSingUpTopBar();
        singUp.singUpTopBarListElement();
        singUp.setFirstname(firstName);
        singUp.setLastname(lastName);
        singUp.setEmail(eMail);
        singUp.setPhone(phone);
        singUp.setPassword(password);
        singUp.setConfirmpassword(password);
        singUp.performSingUp();
        singUp.checkHeading(firstName);
        System.out.println("Test passed");

        //----------------------- Test w wersji liniowej --------------------------- //

//        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream().filter(WebElement::isDisplayed)
//                .findFirst().ifPresent(WebElement::click);
//        driver.findElements(By.xpath("//a[text() = '  Sign Up']")).get(1).click();
//        driver.findElement(By.name("firstname")).sendKeys(firstName);
//        driver.findElement(By.name("lastname")).sendKeys(lastName);
//        driver.findElement(By.name("phone")).sendKeys("");
//        driver.findElement(By.name("email")).sendKeys(eMail);
//        driver.findElement(By.name("password")).sendKeys("password");
//        driver.findElement(By.name("confirmpassword")).sendKeys("password"+ Keys.TAB);
//        driver.findElement(By.xpath("//button[contains(@class, 'signupbtn') ]")).click();
//        WebElement heading = driver.findElement(By.xpath("//h3[@class = 'RTL']"));
//        Assert.assertTrue(heading.getText().contains(lastName));

    }
    @Test
    public void signUpEmptyForm(){

        //------------------ Test w wersji page object pattern ------------------//

        //----------------------- Test w wersji liniowej --------------------------- //

        driver.findElements(By.xpath("//li[@id='li_myaccount")).stream().filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[tekst() = '  Sing UP")).get(1).click();
        driver.findElement(By.xpath("//button[contains(@class, 'signupbtn') ]")).click();
        WebElement heading = driver.findElement(By.xpath("//h3[@class = 'RTL'"));

        List<String> errors = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("The Email field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The First name field is required."));
        softAssert.assertTrue(errors.contains("The Last Name field is required."));
        softAssert.assertAll();

    }
    @Test
    public void singUpInvalidEmail(){
        //------------------ Test w wersji page object pattern ------------------//

        //----------------------- Test w wersji liniowej --------------------------- //

        driver.findElements(By.xpath("//li[@id='li_myaccount")).stream().filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[tekst() = '  Sing UP")).get(1).click();
        driver.findElement(By.name("firstname")).sendKeys("Maciej");
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("phone")).sendKeys("123123123");
        driver.findElement(By.name("email")).sendKeys(eMail);
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("confirmpassword")).sendKeys("password");
        driver.findElement(By.xpath("//button[contains(@class, 'signupbtn') ]")).click();

        List<String> errors = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Assert.assertTrue(errors.contains("The Email field is required."));
    }
}
