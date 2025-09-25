package com.demowebshop.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import com.demowebshop.utils.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    String testEmail = getTestData();

    @Test(priority = 1)
    public void newUserRegistrationPositiveTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegisterForm(new User()
                .setFirstName(UserData.firstNAME)
                .setLastName(UserData.lastNAME)
                .setEmail(testEmail)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSuccessMessagePresent());
    }

    @Test(dataProvider = "addNewUser", dataProviderClass = Data.class, priority = 3)
    public void newMultipleUserRegistrationPositiveTest(
            String firstName,
            String lastName,
            String email,
            String password
    ) {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegisterForm(new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSuccessMessagePresent());
    }

    @Test(dataProvider = "addNewUserWithCSV", dataProviderClass = Data.class, priority = 2)
    public void newMultipleUserRegistrationWithCSVPositiveTest(User user) {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegisterForm(user);
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSuccessMessagePresent());
    }

    @Test(priority = 2)
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegisterForm(new User()
                .setFirstName(UserData.firstNAME)
                .setLastName(UserData.lastNAME)
                .setEmail(testEmail)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isUnsuccessMessagePresent());
    }
}
