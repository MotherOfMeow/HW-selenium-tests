package com.ait.qa65;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    String  testEmail = generateEmail();

    @Test(priority = 1)
    public void newUserRegistrationPositiveTest() {
        clickOnRegistrationLink();
        fillRegisterForm(new User().setFirstName("John").setLastName("Doe").setEmail(testEmail).setPassword("HW123!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSuccessMessagePresent());
    }

    @Test(priority = 2)
    public void existedUserRegistrationNegativeTest() {
        clickOnRegistrationLink();
        fillRegisterForm(new User().setFirstName("John").setLastName("Doe").setEmail(testEmail).setPassword("HW123!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isUnsuccessMessagePresent());
    }

}
