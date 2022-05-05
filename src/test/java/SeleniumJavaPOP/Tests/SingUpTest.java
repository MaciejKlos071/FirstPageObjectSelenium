package SeleniumJavaPOP.Tests;

import SeleniumJavaPOP.Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class SingUpTest extends BaseTest {

    @Test
    public void singUp(){

        String lastName = "Byk";
        int randomNumber = (int) (Math.random() *1000);
        String eMail = "maciej.klos" + randomNumber +"@gmail.com";

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
        WebElement heading = driver.findElement(By.xpath("//h3[@class = 'RTL'"));
        Assert.assertTrue(heading.getText().contains(lastName));

    }
    public void signUpEmptyForm(){


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
    public void singUpInvalidEmail(){

        String lastName = "Byk";
        int randomNumber = (int) (Math.random() *1000);
        String eMail = "maciej.klos" + randomNumber;

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
