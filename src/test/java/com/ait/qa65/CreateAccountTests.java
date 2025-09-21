package com.ait.qa65;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @Test(priority = 1)
    public void newUserRegistrationPositiveTest() {
        clickOnRegistrationLink();
        fillRegisterLoginForm(new User().setFirstName("John").setLastName("Doe").setEmail(generateEmail()).setPassword("HW123!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSuccessMessagePresent());
    }

    @Test(priority = 2)
    public void existedUserRegistrationNegativeTest() {
        clickOnRegistrationLink();
        fillRegisterLoginForm(new User().setFirstName("John").setLastName("Doe").setEmail(generateEmail()).setPassword("HW123!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isUnsuccessMessagePresent());
    }

}
