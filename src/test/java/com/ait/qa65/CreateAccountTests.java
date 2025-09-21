package com.ait.qa65;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    String  testEmail = getTestData();

    @Test(priority = 1)
    public void newUserRegistrationPositiveTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegisterForm(new User().setFirstName("John").setLastName("Doe").setEmail(testEmail).setPassword("HW123!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSuccessMessagePresent());
    }

    @Test(priority = 2)
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegisterForm(new User().setFirstName("John").setLastName("Doe").setEmail(testEmail).setPassword("HW123!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isUnsuccessMessagePresent());
    }

}
