package SeleniumJavaPOP.Tests;

import SeleniumJavaPOP.Model.User;
import SeleniumJavaPOP.Pages.LogedUserPage;
import SeleniumJavaPOP.utils.EmailGenerator;
import SeleniumJavaPOP.utils.SeleniumHelper;
import org.testng.annotations.Test;

public class E2ETests extends BaseTest{

    @Test
    public void RegisterAndLogin(){

        User user = new User();
        user.setFirstName("Adam");
        user.setLastName("Pruszko");
        user.setEmail(EmailGenerator.generateRandomEmail());
        user.setPhone("567786767");
        user.setPassword("AdamPruszko");
        SingUpTest SingUp = new SingUpTest();

        LogedUserPage loggedUser = new LogedUserPage(driver);
        loggedUser.checkHeading("Hi, " + user.getFirstName() + " " + user.getLastName());




        SingUp.singUpUserObject(driver,user);

    }
}
