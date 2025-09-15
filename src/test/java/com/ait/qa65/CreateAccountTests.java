package com.ait.qa65;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
//        click register
        click(By.cssSelector("a[href=\"/register\"]"));
//        choose female
        click(By.id("gender-female"));
//        fill first name
        type(By.xpath("//*[@id=\"FirstName\"]"), "John");
//        fill last name
        type(By.xpath("//*[@id=\"LastName\"]"), "Doe");
//        fill email
        type(By.xpath("//*[@id=\"Email\"]"), "hw-test-user@gmail.com");
//        fill password
        type(By.name("Password"), "HW123!");
//        confirm password
        type(By.name("ConfirmPassword"), "HW123!");
//        click Register button
        click(By.id("register-button"));
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]")));
    }

    @Test
    public void newUserRegistrationNegativeTest() {
        click(By.cssSelector("a[href=\"/register\"]"));
        click(By.id("gender-female"));
        type(By.xpath("//*[@id=\"FirstName\"]"), "John");
        type(By.xpath("//*[@id=\"LastName\"]"), "Doe");
        type(By.xpath("//*[@id=\"Email\"]"), "hw-test-user@gmail.com");
        type(By.name("Password"), "HW123!");
        type(By.name("ConfirmPassword"), "HW123!");
        click(By.id("register-button"));
        Assert.assertTrue(isElementPresent(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li")));
    }

}
