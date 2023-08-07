package SeleniumJavaPOP.Tests;

import SeleniumJavaPOP.Model.User;
import SeleniumJavaPOP.Pages.LogedUserPage;
import SeleniumJavaPOP.Pages.SingUpPage;
import SeleniumJavaPOP.Pages.TopBarMenuPage;
import SeleniumJavaPOP.utils.EmailGenerator;
import SeleniumJavaPOP.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;
import java.util.stream.Collectors;

public class SingUpTest extends BaseTest {

    private static final String firstName = "Maciej";
    private static final String lastName = "klos";
    private static final String phone = "505202303";
    private static final String password = "password";
    private static final String eMail = EmailGenerator.generateRandomEmail();

    private static final Map<String, String> communicateKeyList = Map.of(
            "emptyEmail", "The Email field is required.",
            "password", "The Password field is required.",
            "firstname", "The First name field is required.",
            "fristname", "The Last Name field is required.",
            "invalidEmail", "The Email field must contain a valid email address."
    );

    @Test
    public void singUp() {

        //------------------ Test w wersji page object pattern ------------------//
        TopBarMenuPage topBarMenu = new TopBarMenuPage(driver);
        topBarMenu.openSignUpForm();
        new TopBarMenuPage(driver).openSignUpForm();

        SingUpPage singUp = new SingUpPage(driver);
        singUp.setFirstname(firstName);
        singUp.setLastname(lastName);
        singUp.setEmail(eMail);
        singUp.setPhone(phone);
        singUp.setPassword(password);
        singUp.setConfirmpassword(password);
        singUp.performSingUp();

        new LogedUserPage(driver).checkHeading("Hi, " + firstName + " " + lastName);

    }

    @Test
    public void signUpEmptyForm() {

//        ------------------ Test w wersji page object pattern ------------------//
        TopBarMenuPage topBarMenu = new TopBarMenuPage(driver);
        topBarMenu.openSignUpForm();
        SingUpPage singUp = new SingUpPage(driver);
        singUp.performSingUp();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(singUp.errorList().contains("The Email field is required."));
        softAssert.assertTrue(singUp.errorList().contains("The Password field is required."));
        softAssert.assertTrue(singUp.errorList().contains("The Password field is required."));
        softAssert.assertTrue(singUp.errorList().contains("The First name field is required."));
        softAssert.assertTrue(singUp.errorList().contains("The Last Name field is required."));
        softAssert.assertAll();
    }

    @Test
    public void singUpInvalidEmail() {

        //------------------ Test w wersji page object pattern ------------------//
        TopBarMenuPage topBarMenu = new TopBarMenuPage(driver);
        topBarMenu.openSignUpForm();
        SingUpPage singUp = new SingUpPage(driver);
        singUp.setFirstname(firstName);
        singUp.setLastname(lastName);
        singUp.setEmail("maciej@maciej@gmail.com");
        singUp.setPhone(phone);
        singUp.setPassword(password);
        singUp.setConfirmpassword(password);
        singUp.performSingUp();

        SoftAssert softAssert = new SoftAssert();
        System.out.println(singUp.errorList().stream().collect(Collectors.joining(", ")));
        softAssert.assertTrue(singUp.errorList().contains(communicateKeyList.get("emptyEmail"))
                || singUp.errorList().contains(communicateKeyList.get("invalidEmail")), "The e-mail is OK");
    }

    @Test
    public void singUpshort() {
        //------------------ Test w wersji page object pattern ------------------//

        new TopBarMenuPage(driver).openSignUpForm();
        new SingUpPage(driver).fillSingUpForm(firstName, lastName, phone, eMail, password);
        new LogedUserPage(driver).checkHeading("Hi, " + firstName + " " + lastName);
    }

    @Test
    public void singUpshortUserModel() {

        //------------------ Test w wersji page object pattern ------------------//
        new TopBarMenuPage(driver).openSignUpForm();
        User user = new User();
        user.setFirstName("Maciej");
        user.setLastName("Klos");
        user.setPhone("567678789");
        user.setEmail(eMail);
        user.setPassword("password");
        new SingUpPage(driver).fillSingUpFormUserModel(user);
        new LogedUserPage(driver).checkHeading("Hi, " + user.getFirstName() + " " + user.getLastName());
    }


}
